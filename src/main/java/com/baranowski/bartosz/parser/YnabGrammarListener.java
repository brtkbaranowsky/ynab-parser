// Generated from C:/Users/BRITENET/Desktop/YnabParser/src/main/java/com/baranowski/bartosz/parser\YnabGrammar.g4 by ANTLR 4.7.2
package com.baranowski.bartosz.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link YnabGrammarParser}.
 */
public interface YnabGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link YnabGrammarParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(YnabGrammarParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link YnabGrammarParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(YnabGrammarParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link YnabGrammarParser#row}.
	 * @param ctx the parse tree
	 */
	void enterRow(YnabGrammarParser.RowContext ctx);
	/**
	 * Exit a parse tree produced by {@link YnabGrammarParser#row}.
	 * @param ctx the parse tree
	 */
	void exitRow(YnabGrammarParser.RowContext ctx);
	/**
	 * Enter a parse tree produced by {@link YnabGrammarParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(YnabGrammarParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link YnabGrammarParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(YnabGrammarParser.FieldContext ctx);
}