package org.parser.typecheck;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr4.projexpr.ProjExprBaseVisitor;
import org.antlr4.projexpr.ProjExprParser;
import org.parser.errors.TypeErrorLogger;
import org.parser.logging.AnsiiColors;
import org.parser.types.Types;

@Slf4j
public class TypeCheckVisitor extends ProjExprBaseVisitor<Types> {


    private final SymbolTable symbolTable = new SymbolTable();
    @Getter
    private final TypeErrorLogger errorLogger = TypeErrorLogger.getInstance();

    // OPERATOR
    @Override public Types visitLogicAnd(ProjExprParser.LogicAndContext ctx) {
        log.trace("{}Visiting \tlogical "+ AnsiiColors.ANSI_YELLOW +"and"+AnsiiColors.ANSI_RESET, "    ".repeat(ctx.depth()));
        Types left = visit(ctx.expr(0));
        Types right = visit(ctx.expr(1));
        //get  terminal
        //Token token = ctx.
        if (left != Types.BOOL || right != Types.BOOL) {
            errorLogger.addError(ctx, null,"Logical and can only be applied to booleans", TypeErrorLogger.ErrorType.TYPE);
            return Types.ERROR;
        }
        return Types.BOOL;
    }
    @Override public Types visitLogicOr(ProjExprParser.LogicOrContext ctx) {
        log.trace("{}Visiting \tlogical "+ AnsiiColors.ANSI_YELLOW +"or"+AnsiiColors.ANSI_RESET, "    ".repeat(ctx.depth()));
        Types left = visit(ctx.expr(0));
        Types right = visit(ctx.expr(1));
        if (left != Types.BOOL || right != Types.BOOL) {
            errorLogger.addError(ctx,ctx.getStart(), "Logical or can only be applied to booleans", TypeErrorLogger.ErrorType.TYPE);
            return Types.ERROR;
        }
        return Types.BOOL;
    }
    @Override public Types visitNegation(ProjExprParser.NegationContext ctx) {
        log.trace("{}Visiting \tlogic "+ AnsiiColors.ANSI_YELLOW +"negation"+AnsiiColors.ANSI_RESET, "    ".repeat(ctx.depth()));
        Types type = visit(ctx.expr());
        if (type != Types.BOOL) {
            errorLogger.addError(ctx,ctx.getStart(),"Negation can only be applied to booleans", TypeErrorLogger.ErrorType.TYPE);
            return Types.ERROR;
        }
        return Types.BOOL;
    }
    @Override public Types visitUnaryMinus(ProjExprParser.UnaryMinusContext ctx) {
        log.trace("{}Visiting \tarithmetic "+ AnsiiColors.ANSI_YELLOW +"unary minus"+AnsiiColors.ANSI_RESET, "    ".repeat(ctx.depth()));
        Types type = visit(ctx.expr());
        if (type != Types.INT && type != Types.FLOAT) {
            errorLogger.addError(ctx,ctx.getStart(),"Unary minus can only be applied to integers and floats", TypeErrorLogger.ErrorType.TYPE);
            return Types.ERROR;
        }
        return type;
    }
    @Override public Types visitArithmetic(ProjExprParser.ArithmeticContext ctx) {
        log.trace("{}Visiting \toperation "+ AnsiiColors.ANSI_YELLOW +ctx.op.getText()+AnsiiColors.ANSI_RESET, "    ".repeat(ctx.depth()));
        Types left = visit(ctx.expr(0));
        Types right = visit(ctx.expr(1));
        if (left != Types.INT && left != Types.FLOAT) {
            errorLogger.addError(ctx,ctx.getStart(),"Arithmetic operations can only be applied to integers and floats", TypeErrorLogger.ErrorType.TYPE);
            return Types.ERROR;
        }
        if (right != Types.INT && right != Types.FLOAT) {
            errorLogger.addError(ctx,ctx.getStart(),"Arithmetic operations can only be applied to integers and floats", TypeErrorLogger.ErrorType.TYPE);
            return Types.ERROR;
        }
        if (left == Types.FLOAT || right == Types.FLOAT) {
            return Types.FLOAT;
        }
        return Types.INT;
    }
    @Override public Types visitModulo(ProjExprParser.ModuloContext ctx) {
        log.trace("{}Visiting \toperation "+ AnsiiColors.ANSI_YELLOW +"modulo"+AnsiiColors.ANSI_RESET, "    ".repeat(ctx.depth()));
        Types left = visit(ctx.expr(0));
        Types right = visit(ctx.expr(1));
        if (left != Types.INT || right != Types.INT) {
            errorLogger.addError(ctx,ctx.getStart(),"Modulo can only be applied to integers", TypeErrorLogger.ErrorType.TYPE);
            return Types.ERROR;
        }
        return Types.INT;
    }
    @Override public Types visitConcatenation(ProjExprParser.ConcatenationContext ctx) {
        log.trace("{}Visiting \toperation "+ AnsiiColors.ANSI_YELLOW +"concatenation"+AnsiiColors.ANSI_RESET, "    ".repeat(ctx.depth()));
        Types left = visit(ctx.expr(0));
        Types right = visit(ctx.expr(1));
        if (left != Types.STRING || right != Types.STRING) {
            errorLogger.addError(ctx,ctx.getStart(),"Concatenation can only be applied to strings", TypeErrorLogger.ErrorType.TYPE);
            return Types.ERROR;
        }
        return Types.STRING;
    }
    @Override public Types visitComparison(ProjExprParser.ComparisonContext ctx) {
        log.trace("{}Visiting \toperation "+ AnsiiColors.ANSI_YELLOW +ctx.op.getText()+AnsiiColors.ANSI_RESET, "    ".repeat(ctx.depth()));
        Types left = visit(ctx.expr(0));
        Types right = visit(ctx.expr(1));
        if (left != right) {
            errorLogger.addError(ctx,ctx.getStart(),"Comparison operations can only be applied to the same types", TypeErrorLogger.ErrorType.TYPE);
            return Types.ERROR;
        }
        if (left == Types.BOOL) {
            errorLogger.addError(ctx,ctx.getStart(),"Comparison operations can only be applied to integers and floats", TypeErrorLogger.ErrorType.TYPE);
            return Types.ERROR;
        }
        return left;
    }
    @Override public Types visitRelational(ProjExprParser.RelationalContext ctx) {
        log.trace("{}Visiting \toperation "+ AnsiiColors.ANSI_YELLOW +ctx.op.getText()+AnsiiColors.ANSI_RESET, "    ".repeat(ctx.depth()));
        Types left = visit(ctx.expr(0));
        Types right = visit(ctx.expr(1));
        if ((left != Types.INT && left != Types.FLOAT) || (right != Types.INT && right != Types.FLOAT)) {
            errorLogger.addError(ctx,ctx.getStart(),"Relational operations can only be applied to integers and floats", TypeErrorLogger.ErrorType.TYPE);
            return Types.ERROR;
        }
        if (left == Types.FLOAT || right == Types.FLOAT) {
            return Types.FLOAT;
        }
        return Types.INT;
    }
    @Override public Types visitAssign(ProjExprParser.AssignContext ctx) {
        log.trace("{}Visiting \t      "+ AnsiiColors.ANSI_YELLOW +"assigment"+AnsiiColors.ANSI_RESET, "    ".repeat(ctx.depth()));
        String id = ctx.ID().getText();
        Symbol symbol = symbolTable.getSymbol(id).orElse(new Symbol(id, Types.ERROR));
        if (symbol.getType() == Types.ERROR) {
            errorLogger.addError(ctx,ctx.ID().getSymbol(),"Variable " + id + " not declared", TypeErrorLogger.ErrorType.ASSIGN);
            return Types.ERROR;
        }
        Types type = visit(ctx.expr());

        if (symbol.getType() == Types.FLOAT && type == Types.INT) {
            return Types.FLOAT;
        }

        if (symbol.getType() != type) {
            errorLogger.addError(ctx,ctx.getStart(),"Cannot assign " + type + " to " + symbol.getType(), TypeErrorLogger.ErrorType.ASSIGN);
            return Types.ERROR;
        }
        return type;
    }


    // WILL BE USEFULL
    @Override public Types visitCondition(ProjExprParser.ConditionContext ctx) {
        log.trace("{}Visiting \t         "+ AnsiiColors.ANSI_YELLOW +"condition"+AnsiiColors.ANSI_RESET, "    ".repeat(ctx.depth()));
        Types type = visit(ctx.expr());
        if (type != Types.BOOL) {
            errorLogger.addError(ctx,ctx.getStart(),"Condition must be a boolean", TypeErrorLogger.ErrorType.CONDITION);
            return Types.ERROR;
        }
        return type;
    }
    @Override public Types visitDeclareStat(ProjExprParser.DeclareStatContext ctx) {
        log.trace("{}Visiting \t         "+ AnsiiColors.ANSI_YELLOW +"declaration"+AnsiiColors.ANSI_RESET, "    ".repeat(ctx.depth()));
        Types type = Types.valueOf(ctx.literals().getText().toUpperCase());
        ctx.ID().forEach((symbol) -> {
                    if (!symbolTable.addSymbol(new Symbol(symbol.getText(), type)).orElse(false)) {
                        errorLogger.addError(ctx, symbol.getSymbol(), "Variable " + symbol + " already declared", TypeErrorLogger.ErrorType.ASSIGN);
                    }
                });


        return type;
    }
    @Override public Types visitId(ProjExprParser.IdContext ctx) {
        log.trace("{}Visiting \t     "+ AnsiiColors.ANSI_YELLOW +"identifier"+AnsiiColors.ANSI_RESET, "    ".repeat(ctx.depth()));
        TerminalNode idNode = ctx.ID();
        String id = idNode.getText();
        Symbol symbol = symbolTable.getSymbol(id).orElse(new Symbol(id, Types.ERROR));
        if (symbol.getType() == Types.ERROR) {
            errorLogger.addError(ctx,idNode.getSymbol(),"Variable " + id + " not declared", TypeErrorLogger.ErrorType.ASSIGN);
        }
        return symbol.getType();
    }



    // LITERALS
    @Override public Types visitString(ProjExprParser.StringContext ctx) {
        log.trace("{}Visiting \tliteral "+ AnsiiColors.ANSI_YELLOW +"String"+AnsiiColors.ANSI_RESET, "    ".repeat(ctx.depth()));
        return Types.STRING;
    }
    @Override public Types visitBool(ProjExprParser.BoolContext ctx) {
        log.trace("{}Visiting \tliteral "+ AnsiiColors.ANSI_YELLOW +"Boolean"+AnsiiColors.ANSI_RESET, "    ".repeat(ctx.depth()));
        return Types.BOOL;
    }
    @Override public Types visitFloat(ProjExprParser.FloatContext ctx) {
        log.trace("{}Visiting \tliteral "+ AnsiiColors.ANSI_YELLOW +"Float"+AnsiiColors.ANSI_RESET, "    ".repeat(ctx.depth()));
        return Types.FLOAT;
    }
    @Override public Types visitInt(ProjExprParser.IntContext ctx) {
        log.trace("{}Visiting \tliteral "+ AnsiiColors.ANSI_YELLOW +"Integer"+AnsiiColors.ANSI_RESET, "    ".repeat(ctx.depth()));
        return Types.INT;
    }
}
