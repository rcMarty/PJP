// Generated from /home/rc_marty/OneDrive/Dokumenty/_Škola/6_Semestr/PJP/ProjectAntlr/src/main/antlr4/grammars/ProjExpr.g4 by ANTLR 4.13.1
package org.antlr4.projexpr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ProjExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface ProjExprVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link ProjExprParser#prog}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitProg(ProjExprParser.ProgContext ctx);

    /**
     * Visit a parse tree produced by {@link ProjExprParser#writeStat}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitWriteStat(ProjExprParser.WriteStatContext ctx);

    /**
     * Visit a parse tree produced by {@link ProjExprParser#readStat}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitReadStat(ProjExprParser.ReadStatContext ctx);

    /**
     * Visit a parse tree produced by {@link ProjExprParser#ifStat}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIfStat(ProjExprParser.IfStatContext ctx);

    /**
     * Visit a parse tree produced by {@link ProjExprParser#whileStat}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitWhileStat(ProjExprParser.WhileStatContext ctx);

    /**
     * Visit a parse tree produced by {@link ProjExprParser#forStat}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitForStat(ProjExprParser.ForStatContext ctx);

    /**
     * Visit a parse tree produced by {@link ProjExprParser#blockStat}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBlockStat(ProjExprParser.BlockStatContext ctx);

    /**
     * Visit a parse tree produced by {@link ProjExprParser#exprStat}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprStat(ProjExprParser.ExprStatContext ctx);

    /**
     * Visit a parse tree produced by {@link ProjExprParser#declareStat}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDeclareStat(ProjExprParser.DeclareStatContext ctx);

    /**
     * Visit a parse tree produced by {@link ProjExprParser#literals}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLiterals(ProjExprParser.LiteralsContext ctx);

    /**
     * Visit a parse tree produced by {@link ProjExprParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStatement(ProjExprParser.StatementContext ctx);

    /**
     * Visit a parse tree produced by the {@code negation}
     * labeled alternative in {@link ProjExprParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNegation(ProjExprParser.NegationContext ctx);

    /**
     * Visit a parse tree produced by the {@code parens}
     * labeled alternative in {@link ProjExprParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitParens(ProjExprParser.ParensContext ctx);

    /**
     * Visit a parse tree produced by the {@code comparison}
     * labeled alternative in {@link ProjExprParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitComparison(ProjExprParser.ComparisonContext ctx);

    /**
     * Visit a parse tree produced by the {@code string}
     * labeled alternative in {@link ProjExprParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitString(ProjExprParser.StringContext ctx);

    /**
     * Visit a parse tree produced by the {@code bool}
     * labeled alternative in {@link ProjExprParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBool(ProjExprParser.BoolContext ctx);

    /**
     * Visit a parse tree produced by the {@code logicOr}
     * labeled alternative in {@link ProjExprParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLogicOr(ProjExprParser.LogicOrContext ctx);

    /**
     * Visit a parse tree produced by the {@code arithmetic}
     * labeled alternative in {@link ProjExprParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitArithmetic(ProjExprParser.ArithmeticContext ctx);

    /**
     * Visit a parse tree produced by the {@code float}
     * labeled alternative in {@link ProjExprParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFloat(ProjExprParser.FloatContext ctx);

    /**
     * Visit a parse tree produced by the {@code int}
     * labeled alternative in {@link ProjExprParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitInt(ProjExprParser.IntContext ctx);

    /**
     * Visit a parse tree produced by the {@code logicAnd}
     * labeled alternative in {@link ProjExprParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLogicAnd(ProjExprParser.LogicAndContext ctx);

    /**
     * Visit a parse tree produced by the {@code concatenation}
     * labeled alternative in {@link ProjExprParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitConcatenation(ProjExprParser.ConcatenationContext ctx);

    /**
     * Visit a parse tree produced by the {@code unaryMinus}
     * labeled alternative in {@link ProjExprParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUnaryMinus(ProjExprParser.UnaryMinusContext ctx);

    /**
     * Visit a parse tree produced by the {@code relational}
     * labeled alternative in {@link ProjExprParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRelational(ProjExprParser.RelationalContext ctx);

    /**
     * Visit a parse tree produced by the {@code id}
     * labeled alternative in {@link ProjExprParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitId(ProjExprParser.IdContext ctx);

    /**
     * Visit a parse tree produced by the {@code modulo}
     * labeled alternative in {@link ProjExprParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitModulo(ProjExprParser.ModuloContext ctx);

    /**
     * Visit a parse tree produced by the {@code ternary}
     * labeled alternative in {@link ProjExprParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTernary(ProjExprParser.TernaryContext ctx);

    /**
     * Visit a parse tree produced by the {@code assign}
     * labeled alternative in {@link ProjExprParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAssign(ProjExprParser.AssignContext ctx);

    /**
     * Visit a parse tree produced by {@link ProjExprParser#condition}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCondition(ProjExprParser.ConditionContext ctx);
}