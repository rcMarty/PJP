// Generated from /home/rc_marty/OneDrive/Dokumenty/_Škola/6_Semestr/PJP/ProjectAntlr/src/main/antlr4/grammars/ProjExpr.g4 by ANTLR 4.13.1
package org.antlr4.projexpr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ProjExprParser}.
 */
public interface ProjExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ProjExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ProjExprParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ProjExprParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code block}
	 * labeled alternative in {@link ProjExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlock(ProjExprParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code block}
	 * labeled alternative in {@link ProjExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlock(ProjExprParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code write}
	 * labeled alternative in {@link ProjExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterWrite(ProjExprParser.WriteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code write}
	 * labeled alternative in {@link ProjExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitWrite(ProjExprParser.WriteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declare}
	 * labeled alternative in {@link ProjExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterDeclare(ProjExprParser.DeclareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declare}
	 * labeled alternative in {@link ProjExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitDeclare(ProjExprParser.DeclareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expression}
	 * labeled alternative in {@link ProjExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ProjExprParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expression}
	 * labeled alternative in {@link ProjExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ProjExprParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code read}
	 * labeled alternative in {@link ProjExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterRead(ProjExprParser.ReadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code read}
	 * labeled alternative in {@link ProjExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitRead(ProjExprParser.ReadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code if}
	 * labeled alternative in {@link ProjExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterIf(ProjExprParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code if}
	 * labeled alternative in {@link ProjExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitIf(ProjExprParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code while}
	 * labeled alternative in {@link ProjExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterWhile(ProjExprParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code while}
	 * labeled alternative in {@link ProjExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitWhile(ProjExprParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code for}
	 * labeled alternative in {@link ProjExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterFor(ProjExprParser.ForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code for}
	 * labeled alternative in {@link ProjExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitFor(ProjExprParser.ForContext ctx);
	/**
	 * Enter a parse tree produced by the {@code empty}
	 * labeled alternative in {@link ProjExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterEmpty(ProjExprParser.EmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code empty}
	 * labeled alternative in {@link ProjExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitEmpty(ProjExprParser.EmptyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjExprParser#writeStat}.
	 * @param ctx the parse tree
	 */
	void enterWriteStat(ProjExprParser.WriteStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjExprParser#writeStat}.
	 * @param ctx the parse tree
	 */
	void exitWriteStat(ProjExprParser.WriteStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjExprParser#readStat}.
	 * @param ctx the parse tree
	 */
	void enterReadStat(ProjExprParser.ReadStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjExprParser#readStat}.
	 * @param ctx the parse tree
	 */
	void exitReadStat(ProjExprParser.ReadStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjExprParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(ProjExprParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjExprParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(ProjExprParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjExprParser#whileStat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(ProjExprParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjExprParser#whileStat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(ProjExprParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjExprParser#forStat}.
	 * @param ctx the parse tree
	 */
	void enterForStat(ProjExprParser.ForStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjExprParser#forStat}.
	 * @param ctx the parse tree
	 */
	void exitForStat(ProjExprParser.ForStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjExprParser#declareStat}.
	 * @param ctx the parse tree
	 */
	void enterDeclareStat(ProjExprParser.DeclareStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjExprParser#declareStat}.
	 * @param ctx the parse tree
	 */
	void exitDeclareStat(ProjExprParser.DeclareStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjExprParser#literals}.
	 * @param ctx the parse tree
	 */
	void enterLiterals(ProjExprParser.LiteralsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjExprParser#literals}.
	 * @param ctx the parse tree
	 */
	void exitLiterals(ProjExprParser.LiteralsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjExprParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(ProjExprParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjExprParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(ProjExprParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negation}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNegation(ProjExprParser.NegationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negation}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNegation(ProjExprParser.NegationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(ProjExprParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(ProjExprParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparison}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterComparison(ProjExprParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparison}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitComparison(ProjExprParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterString(ProjExprParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitString(ProjExprParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bool}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBool(ProjExprParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBool(ProjExprParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicOr}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicOr(ProjExprParser.LogicOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicOr}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicOr(ProjExprParser.LogicOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arithmetic}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic(ProjExprParser.ArithmeticContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arithmetic}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic(ProjExprParser.ArithmeticContext ctx);
	/**
	 * Enter a parse tree produced by the {@code float}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFloat(ProjExprParser.FloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code float}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFloat(ProjExprParser.FloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(ProjExprParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(ProjExprParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicAnd}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicAnd(ProjExprParser.LogicAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicAnd}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicAnd(ProjExprParser.LogicAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code concatenation}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConcatenation(ProjExprParser.ConcatenationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code concatenation}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConcatenation(ProjExprParser.ConcatenationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryMinus}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinus(ProjExprParser.UnaryMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryMinus}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinus(ProjExprParser.UnaryMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relational}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRelational(ProjExprParser.RelationalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relational}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRelational(ProjExprParser.RelationalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterId(ProjExprParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitId(ProjExprParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code modulo}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterModulo(ProjExprParser.ModuloContext ctx);
	/**
	 * Exit a parse tree produced by the {@code modulo}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitModulo(ProjExprParser.ModuloContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAssign(ProjExprParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAssign(ProjExprParser.AssignContext ctx);
}