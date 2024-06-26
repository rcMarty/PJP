package org.parser.compiler;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr4.projexpr.ProjExprBaseVisitor;
import org.antlr4.projexpr.ProjExprParser;
import org.parser.typecheck.Symbol;
import org.parser.typecheck.SymbolTable;
import org.parser.types.Types;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CompilerVisitor extends ProjExprBaseVisitor<List<Instruction>> {

    private final SymbolTable symbols = new SymbolTable();

    public String getInstructions(List<Instruction> instructions) {
        StringBuilder sb = new StringBuilder();
        for (Instruction instruction : instructions) {
            sb.append(instruction.toInstructions()).append("\n");
        }
        return sb.toString();
    }

    //JUST "HELPERS"
    @Override
    public List<Instruction> visitProg(ProjExprParser.ProgContext ctx) {
        log.trace("{}Visiting \tprog", "    ".repeat(ctx.depth()));
        List<Instruction> instructions = new ArrayList<>();
        for (ProjExprParser.StatementContext stat : ctx.statement()) {
            instructions.addAll(visit(stat));
        }
        return instructions;
    }

    @Override
    public List<Instruction> visitStatement(ProjExprParser.StatementContext ctx) {
        log.trace("{}Visiting \tstatement", "    ".repeat(ctx.depth()));
        return visit(ctx.getChild(0));
    }

    @Override
    public List<Instruction> visitBlockStat(ProjExprParser.BlockStatContext ctx) {
        log.trace("{}Visiting \tblockStat", "    ".repeat(ctx.depth()));
        List<Instruction> instructions = new ArrayList<>();
        for (ProjExprParser.StatementContext stat : ctx.statement()) {
            instructions.addAll(visit(stat));
        }
        return instructions;
    }

    @Override
    public List<Instruction> visitExprStat(ProjExprParser.ExprStatContext ctx) {
        log.trace("{}Visiting \texprStat", "    ".repeat(ctx.depth()));
        List<Instruction> instructions = new ArrayList<>(visit(ctx.expr()));
        instructions.add(Instruction.builder().instruction(InstructionType.POP).build());
        return instructions;
    }


    //IFs and whiles

    @Override
    public List<Instruction> visitIfStat(ProjExprParser.IfStatContext ctx) {
        log.trace("{}Visiting \tifStat", "    ".repeat(ctx.depth()));
        List<Instruction> instructions = new ArrayList<>(visit(ctx.condition()));
        String jmpTrue = LabelGenerator.getLabel("ifTrue");
        String jmpFalse = LabelGenerator.getLabel("ifFalse");
        instructions.add(Instruction.builder().instruction(InstructionType.TJMP).args(jmpTrue).build());
        //instructions.addAll(visit(ctx.statement(0)));
        if (ctx.statement().size() > 1) {
            instructions.addAll(visit(ctx.statement(1)));
        }
        else{// (ctx.statement().size() > 1) {
            instructions.add(Instruction.builder().instruction(InstructionType.JMP).args(jmpFalse).build());
            instructions.add(Instruction.builder().instruction(InstructionType.LABEL).args(jmpTrue).build());
            instructions.addAll(visit(ctx.statement(0)));
            instructions.add(Instruction.builder().instruction(InstructionType.LABEL).args(jmpFalse).build());
            return instructions;
        }
        instructions.add(Instruction.builder().instruction(InstructionType.LABEL).args(jmpTrue).build());
        return instructions;
    }

    @Override
    public List<Instruction> visitWhileStat(ProjExprParser.WhileStatContext ctx) {
        log.trace("{}Visiting \twhileStat", "    ".repeat(ctx.depth()));
        String jmpIf = LabelGenerator.getLabel("whileStart");
        List<Instruction> instructions = new ArrayList<>();
        String jmpEnd = LabelGenerator.getLabel("whileEnd");
        String jmpTrueEnd = LabelGenerator.getLabel("whileTrueEnd");

        instructions.add(Instruction.builder().instruction(InstructionType.LABEL).args(jmpIf).build());
        instructions.addAll(visit(ctx.condition()));

        instructions.add(Instruction.builder().instruction(InstructionType.TJMP).args(jmpEnd).build());
        instructions.add(Instruction.builder().instruction(InstructionType.JMP).args(jmpTrueEnd).build());
        instructions.add(Instruction.builder().instruction(InstructionType.LABEL).args(jmpEnd).build());

        instructions.addAll(visit(ctx.statement()));
        instructions.add(Instruction.builder().instruction(InstructionType.JMP).args(jmpIf).build());
        instructions.add(Instruction.builder().instruction(InstructionType.LABEL).args(jmpTrueEnd).build());

        return instructions;
    }

    @Override
    public List<Instruction> visitForStat(ProjExprParser.ForStatContext ctx) {
        log.trace("{}Visiting \tforStat", "    ".repeat(ctx.depth()));
        List<Instruction> instructions = new ArrayList<>(visit(ctx.expr(0)));
        instructions.add(Instruction.builder().instruction(InstructionType.POP).build());
        String jmpStart = LabelGenerator.getLabel("forStart");
        String jmpEnd = LabelGenerator.getLabel("forEnd");
        instructions.add(Instruction.builder().instruction(InstructionType.LABEL).args(jmpStart).build());
        instructions.addAll(visit(ctx.condition()));
        instructions.add(Instruction.builder().instruction(InstructionType.FJMP).args(jmpEnd).build());
        instructions.addAll(visit(ctx.statement()));
        instructions.addAll(visit(ctx.expr(1)));
        instructions.add(Instruction.builder().instruction(InstructionType.POP).build());
        instructions.add(Instruction.builder().instruction(InstructionType.JMP).args(jmpStart).build());
        instructions.add(Instruction.builder().instruction(InstructionType.LABEL).args(jmpEnd).build());
        return instructions;
    }

    @Override
    public List<Instruction> visitTernary(ProjExprParser.TernaryContext ctx) {
        log.trace("{}Visiting \tternary", "    ".repeat(ctx.depth()));
        List<Instruction> instructions = new ArrayList<>(visit(ctx.expr(0)));


        //check type of expr(1) and expr(2)
        var expr1 = visit(ctx.expr(1));
        var expr2 = visit(ctx.expr(2));

        List<Instruction> tmp1 = new ArrayList<>();
        List<Instruction> tmp2 = new ArrayList<>();

        if (expr1.get(0).getType() != expr2.get(0).getType()) {
            if (expr1.get(0).getType() == Types.INT) {
                tmp1.addAll(expr1);
                tmp1.add(Instruction.builder().instruction(InstructionType.ITOF).build());
                tmp2.addAll(expr2);
            } else {
                tmp1.addAll(expr1);
                tmp2.addAll(expr2);
                tmp2.add(Instruction.builder().instruction(InstructionType.ITOF).build());
            }
        } else {
            tmp1.addAll(expr1);
            tmp2.addAll(expr2);
        }


        String jmpTrue = LabelGenerator.getLabel("ternaryTrue");
        String jmpFalse = LabelGenerator.getLabel("ternaryFalse");
        instructions.add(Instruction.builder().instruction(InstructionType.FJMP).args(jmpTrue).build());
        instructions.addAll(tmp1);
        instructions.add(Instruction.builder().instruction(InstructionType.JMP).args(jmpFalse).build());
        instructions.add(Instruction.builder().instruction(InstructionType.LABEL).args(jmpTrue).build());
        instructions.addAll(tmp2);
        instructions.add(Instruction.builder().instruction(InstructionType.LABEL).args(jmpFalse).build());
        return instructions;
    }

    //VARIABLES

    @Override
    public List<Instruction> visitDeclareStat(ProjExprParser.DeclareStatContext ctx) {
        log.trace("{}Visiting \tdeclareStat", "    ".repeat(ctx.depth()));
        Types type = Types.valueOf(ctx.literals().getText().toUpperCase());
        ctx.ID().forEach(id -> symbols.addSymbol(new Symbol(id.getText(), type)));

        List<Instruction> instructions = new ArrayList<>();
        for (TerminalNode id : ctx.ID()) {
            instructions.add(Instruction.builder().instruction(InstructionType.PUSH).type(type).args(type.getDefaultValue()).build());
            instructions.add(Instruction.builder().instruction(InstructionType.SAVE).args(id.getText()).build());
        }

        return instructions;
    }

    @Override
    public List<Instruction> visitAssign(ProjExprParser.AssignContext ctx) {
        log.trace("{}Visiting \tassign", "    ".repeat(ctx.depth()));
        List<Instruction> instructions = new ArrayList<>(visit(ctx.expr()));
        instructions.add(Instruction.builder().instruction(InstructionType.SAVE).args(ctx.ID().getText()).build());
        symbols.getSymbol(ctx.ID().getText()).get().setValue(ctx.expr().getText());
        instructions.add(Instruction.builder().instruction(InstructionType.LOAD).args(ctx.ID().getText()).build());

        return instructions;
    }

    //IO
    @Override
    public List<Instruction> visitWriteStat(ProjExprParser.WriteStatContext ctx) {
        log.trace("{}Visiting \twriteStat", "    ".repeat(ctx.depth()));
        List<Instruction> instructions = new ArrayList<>();
        for (ProjExprParser.ExprContext expr : ctx.expr().reversed()) {
            instructions.addAll(visit(expr));
        }
        instructions.add(Instruction.builder().instruction(InstructionType.PRINT).args(ctx.expr().size()).build());
        return instructions;
    }

    @Override
    public List<Instruction> visitReadStat(ProjExprParser.ReadStatContext ctx) {
        log.trace("{}Visiting \treadStat", "    ".repeat(ctx.depth()));

        List<Instruction> instructions = new ArrayList<>();
        for (TerminalNode id : ctx.ID()) {
            Types type = symbols.getSymbol(id.getText()).get().getType();
            instructions.add(Instruction.builder().instruction(InstructionType.READ).type(type).build());
            instructions.add(Instruction.builder().instruction(InstructionType.SAVE).args(id.getText()).build());
        }
        return instructions;
    }

    //OPERATORS

    @Override
    public List<Instruction> visitArithmetic(ProjExprParser.ArithmeticContext ctx) {
        log.trace("{}Visiting \tarithmetic {}", "    ".repeat(ctx.depth()), ctx.op.getText());
        List<Instruction> instructions = new ArrayList<>(optionalConvertToFloat(ctx.expr(0), ctx.expr(1)));
        Types left = visit(ctx.expr(0)).getLast().getType();
        Types right = visit(ctx.expr(1)).getLast().getType();
        Types result = left == Types.FLOAT || right == Types.FLOAT ? Types.FLOAT : Types.INT;

        switch (ctx.op.getText()) {
            case "+" -> instructions.add(Instruction.builder().instruction(InstructionType.ADD).type(result).build());
            case "-" -> instructions.add(Instruction.builder().instruction(InstructionType.SUB).type(result).build());
            case "*" -> instructions.add(Instruction.builder().instruction(InstructionType.MUL).type(result).build());
            case "/" -> instructions.add(Instruction.builder().instruction(InstructionType.DIV).type(result).build());
        }
        return instructions;
    }

    @Override
    public List<Instruction> visitModulo(ProjExprParser.ModuloContext ctx) {
        log.trace("{}Visiting \tmodulo", "    ".repeat(ctx.depth()));
        List<Instruction> instructions = new ArrayList<>();
        instructions.addAll(visit(ctx.expr(0)));
        instructions.addAll(visit(ctx.expr(1)));
        instructions.add(Instruction.builder().instruction(InstructionType.MOD).type(Types.INT).build());
        return instructions;
    }

    @Override
    public List<Instruction> visitNegation(ProjExprParser.NegationContext ctx) {
        log.trace("{}Visiting \tnegation", "    ".repeat(ctx.depth()));
        List<Instruction> instructions = new ArrayList<>(visit(ctx.expr()));
        instructions.add(Instruction.builder().instruction(InstructionType.NOT).type(Types.BOOL).build());
        return instructions;
    }

    @Override
    public List<Instruction> visitUnaryMinus(ProjExprParser.UnaryMinusContext ctx) {
        log.trace("{}Visiting \tunaryMinus", "    ".repeat(ctx.depth()));
        List<Instruction> instructions = new ArrayList<>(visit(ctx.expr()));
        Types type = visit(ctx.expr()).getLast().getType();
        instructions.add(Instruction.builder().instruction(InstructionType.UMINUS).type(type).build());
        return instructions;
    }

    @Override
    public List<Instruction> visitConcatenation(ProjExprParser.ConcatenationContext ctx) {
        log.trace("{}Visiting \tconcatenation", "    ".repeat(ctx.depth()));
        List<Instruction> instructions = new ArrayList<>();
        instructions.addAll(visit(ctx.expr(0)));
        instructions.addAll(visit(ctx.expr(1)));
        instructions.add(Instruction.builder().instruction(InstructionType.CONCAT).type(Types.STRING).build());
        return instructions;
    }

    @Override
    public List<Instruction> visitRelational(ProjExprParser.RelationalContext ctx) {
        log.trace("{}Visiting \trelational {}", "    ".repeat(ctx.depth()), ctx.op.getText());
        List<Instruction> instructions = new ArrayList<>(optionalConvertToFloat(ctx.expr(0), ctx.expr(1)));
        Types type1 = visit(ctx.expr(0)).getLast().getType();
        Types type2 = visit(ctx.expr(1)).getLast().getType();
        Types result = type1 == Types.FLOAT || type2 == Types.FLOAT ? Types.FLOAT : Types.INT;


        switch (ctx.op.getText()) {
            case "<" -> instructions.add(Instruction.builder().instruction(InstructionType.LT).type(result).build());
            case ">" -> instructions.add(Instruction.builder().instruction(InstructionType.GT).type(result).build());
        }
        return instructions;
    }

    @Override
    public List<Instruction> visitLogicAnd(ProjExprParser.LogicAndContext ctx) {
        log.trace("{}Visiting \tlogicAnd", "    ".repeat(ctx.depth()));
        List<Instruction> instructions = new ArrayList<>();
        instructions.addAll(visit(ctx.expr(0)));
        instructions.addAll(visit(ctx.expr(1)));
        instructions.add(Instruction.builder().instruction(InstructionType.AND).type(Types.BOOL).build());
        return instructions;
    }

    @Override
    public List<Instruction> visitLogicOr(ProjExprParser.LogicOrContext ctx) {
        log.trace("{}Visiting \tlogicOr", "    ".repeat(ctx.depth()));
        List<Instruction> instructions = new ArrayList<>();
        instructions.addAll(visit(ctx.expr(0)));
        instructions.addAll(visit(ctx.expr(1)));
        instructions.add(Instruction.builder().instruction(InstructionType.OR).type(Types.BOOL).build());
        return instructions;
    }

    @Override
    public List<Instruction> visitComparison(ProjExprParser.ComparisonContext ctx) {
        log.trace("{}Visiting \tcomparison {}", "    ".repeat(ctx.depth()), ctx.op.getText());

        List<Instruction> instructions = new ArrayList<>(optionalConvertToFloat(ctx.expr(0), ctx.expr(1)));
        Types type1 = visit(ctx.expr(0)).getLast().getType();
        Types type2 = visit(ctx.expr(1)).getLast().getType();
        Types type = type1 == Types.FLOAT || type2 == Types.FLOAT ? Types.FLOAT : Types.INT;

        switch (ctx.op.getText()) {
            case "==" -> instructions.add(Instruction.builder().instruction(InstructionType.EQ).build());
            case "!=" -> {
                instructions.add(Instruction.builder().instruction(InstructionType.EQ).type(type).build());
                instructions.add(Instruction.builder().instruction(InstructionType.NOT).type(type).build());
            }
        }
        return instructions;
    }

    @Override
    public List<Instruction> visitParens(ProjExprParser.ParensContext ctx) {
        log.trace("{}Visiting \tparens", "    ".repeat(ctx.depth()));
        return visit(ctx.expr());
    }


    private List<Instruction> optionalConvertToFloat(ProjExprParser.ExprContext expr, ProjExprParser.ExprContext expr2) {
        List<Instruction> instructions = new ArrayList<>();

        Instruction left = visit(expr).getLast();
        Instruction right = visit(expr2).getLast();

        if (left.getType() != right.getType()) {
            if (left.getType() == Types.INT) {
                instructions.addAll(visit(expr));
                instructions.add(Instruction.builder().instruction(InstructionType.ITOF).type(Types.FLOAT).build());
                instructions.addAll(visit(expr2));
            } else if (left.getType() == Types.FLOAT) {
                instructions.addAll(visit(expr));
                instructions.addAll(visit(expr2));
                instructions.add(Instruction.builder().instruction(InstructionType.ITOF).type(Types.FLOAT).build());
            }
        } else {
            instructions.addAll(visit(expr));
            instructions.addAll(visit(expr2));
        }
        return instructions;
    }

    //LITERALS

    @Override
    public List<Instruction> visitString(ProjExprParser.StringContext ctx) {
        log.trace("{}Visiting \tstring", "    ".repeat(ctx.depth()));
        String text = ctx.getText().substring(1, ctx.getText().length() - 1);
        return List.of(Instruction.builder()
                .instruction(InstructionType.PUSH)
                .type(Types.STRING)
                .args(text)
                .build());
    }

    @Override
    public List<Instruction> visitInt(ProjExprParser.IntContext ctx) {
        log.trace("{}Visiting \tint", "    ".repeat(ctx.depth()));
        return List.of(Instruction.builder()
                .instruction(InstructionType.PUSH)
                .type(Types.INT)
                .args(Integer.parseInt(ctx.getText()))
                .build());
    }

    @Override
    public List<Instruction> visitBool(ProjExprParser.BoolContext ctx) {
        log.trace("{}Visiting \tbool", "    ".repeat(ctx.depth()));
        return List.of(Instruction.builder()
                .instruction(InstructionType.PUSH)
                .type(Types.BOOL)
                .args(Boolean.parseBoolean(ctx.getText()))
                .build());
    }

    @Override
    public List<Instruction> visitFloat(ProjExprParser.FloatContext ctx) {
        log.trace("{}Visiting \tfloat", "    ".repeat(ctx.depth()));
        return List.of(Instruction.builder()
                .instruction(InstructionType.PUSH)
                .type(Types.FLOAT)
                .args(Float.parseFloat(ctx.getText()))
                .build());
    }

    @Override
    public List<Instruction> visitId(ProjExprParser.IdContext ctx) {
        log.trace("{}Visiting \tid", "    ".repeat(ctx.depth()));
        Symbol symbol = symbols.getSymbol(ctx.ID().getText()).get();
        return List.of(Instruction.builder()
                .instruction(InstructionType.LOAD)
                .type(symbol.getType())
                .args(ctx.getText())
                .build());
    }
}
