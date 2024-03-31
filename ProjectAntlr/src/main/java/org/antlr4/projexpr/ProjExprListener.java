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
	 * Enter a parse tree produced by {@link ProjExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(ProjExprParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(ProjExprParser.StatContext ctx);
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
	 * Enter a parse tree produced by {@link ProjExprParser#assignStat}.
	 * @param ctx the parse tree
	 */
	void enterAssignStat(ProjExprParser.AssignStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjExprParser#assignStat}.
	 * @param ctx the parse tree
	 */
	void exitAssignStat(ProjExprParser.AssignStatContext ctx);
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
	 * Enter a parse tree produced by the {@code variable}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariable(ProjExprParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variable}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariable(ProjExprParser.VariableContext ctx);
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
	 * Enter a parse tree produced by the {@code logic}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogic(ProjExprParser.LogicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logic}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogic(ProjExprParser.LogicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code concat}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConcat(ProjExprParser.ConcatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code concat}
	 * labeled alternative in {@link ProjExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConcat(ProjExprParser.ConcatContext ctx);
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
	 * Enter a parse tree produced by {@link ProjExprParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(ProjExprParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjExprParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(ProjExprParser.DataTypeContext ctx);
}