// Generated from /home/rc_marty/6_Semestr/PJP/PjojectAntlr/src/main/antlr4/grammars/Lab7Expr.g4 by ANTLR 4.13.1
package org.antlr4.Lab7;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Lab7ExprParser}.
 */
public interface Lab7ExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Lab7ExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(Lab7ExprParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link Lab7ExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(Lab7ExprParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code par}
	 * labeled alternative in {@link Lab7ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPar(Lab7ExprParser.ParContext ctx);
	/**
	 * Exit a parse tree produced by the {@code par}
	 * labeled alternative in {@link Lab7ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPar(Lab7ExprParser.ParContext ctx);
	/**
	 * Enter a parse tree produced by the {@code add}
	 * labeled alternative in {@link Lab7ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAdd(Lab7ExprParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code add}
	 * labeled alternative in {@link Lab7ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAdd(Lab7ExprParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code oct}
	 * labeled alternative in {@link Lab7ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOct(Lab7ExprParser.OctContext ctx);
	/**
	 * Exit a parse tree produced by the {@code oct}
	 * labeled alternative in {@link Lab7ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOct(Lab7ExprParser.OctContext ctx);
	/**
	 * Enter a parse tree produced by the {@code hexaim}
	 * labeled alternative in {@link Lab7ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterHexaim(Lab7ExprParser.HexaimContext ctx);
	/**
	 * Exit a parse tree produced by the {@code hexaim}
	 * labeled alternative in {@link Lab7ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitHexaim(Lab7ExprParser.HexaimContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mul}
	 * labeled alternative in {@link Lab7ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMul(Lab7ExprParser.MulContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mul}
	 * labeled alternative in {@link Lab7ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMul(Lab7ExprParser.MulContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link Lab7ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(Lab7ExprParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link Lab7ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(Lab7ExprParser.IntContext ctx);
}