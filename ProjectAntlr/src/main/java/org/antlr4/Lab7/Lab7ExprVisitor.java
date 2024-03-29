// Generated from /home/rc_marty/6_Semestr/PJP/PjojectAntlr/src/main/antlr4/grammars/Lab7Expr.g4 by ANTLR 4.13.1
package org.antlr4.Lab7;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Lab7ExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Lab7ExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Lab7ExprParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(Lab7ExprParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code par}
	 * labeled alternative in {@link Lab7ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPar(Lab7ExprParser.ParContext ctx);
	/**
	 * Visit a parse tree produced by the {@code add}
	 * labeled alternative in {@link Lab7ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(Lab7ExprParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oct}
	 * labeled alternative in {@link Lab7ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOct(Lab7ExprParser.OctContext ctx);
	/**
	 * Visit a parse tree produced by the {@code hexaim}
	 * labeled alternative in {@link Lab7ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHexaim(Lab7ExprParser.HexaimContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mul}
	 * labeled alternative in {@link Lab7ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul(Lab7ExprParser.MulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int}
	 * labeled alternative in {@link Lab7ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(Lab7ExprParser.IntContext ctx);
}