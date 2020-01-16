// Generated from C:/Users/BRITENET/Desktop/YnabParser/src/main/java/com/baranowski/bartosz/parser\YnabGrammar.g4 by ANTLR 4.7.2
package com.baranowski.bartosz.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link YnabGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface YnabGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link YnabGrammarParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(YnabGrammarParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link YnabGrammarParser#row}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRow(YnabGrammarParser.RowContext ctx);
	/**
	 * Visit a parse tree produced by {@link YnabGrammarParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(YnabGrammarParser.FieldContext ctx);
}