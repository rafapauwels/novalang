// Generated from NovaLang.g4 by ANTLR 4.9.2
package com.pauwels.parser;

import java.util.ArrayList;
import java.util.Stack;
import com.google.googlejavaformat.java.FormatterException;
import com.pauwels.nova.program.NovaProgram;
import com.pauwels.nova.exception.*;
import com.pauwels.nova.commands.*;
import com.pauwels.nova.data.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NovaLangParser}.
 */
public interface NovaLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NovaLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(NovaLangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link NovaLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(NovaLangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link NovaLangParser#declara}.
	 * @param ctx the parse tree
	 */
	void enterDeclara(NovaLangParser.DeclaraContext ctx);
	/**
	 * Exit a parse tree produced by {@link NovaLangParser#declara}.
	 * @param ctx the parse tree
	 */
	void exitDeclara(NovaLangParser.DeclaraContext ctx);
	/**
	 * Enter a parse tree produced by {@link NovaLangParser#declaraVar}.
	 * @param ctx the parse tree
	 */
	void enterDeclaraVar(NovaLangParser.DeclaraVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link NovaLangParser#declaraVar}.
	 * @param ctx the parse tree
	 */
	void exitDeclaraVar(NovaLangParser.DeclaraVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link NovaLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(NovaLangParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link NovaLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(NovaLangParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link NovaLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(NovaLangParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link NovaLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(NovaLangParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link NovaLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(NovaLangParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link NovaLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(NovaLangParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link NovaLangParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdLeitura(NovaLangParser.CmdLeituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link NovaLangParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdLeitura(NovaLangParser.CmdLeituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link NovaLangParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdEscrita(NovaLangParser.CmdEscritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link NovaLangParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdEscrita(NovaLangParser.CmdEscritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link NovaLangParser#cmdAttrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdAttrib(NovaLangParser.CmdAttribContext ctx);
	/**
	 * Exit a parse tree produced by {@link NovaLangParser#cmdAttrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdAttrib(NovaLangParser.CmdAttribContext ctx);
	/**
	 * Enter a parse tree produced by {@link NovaLangParser#cmdSelecao}.
	 * @param ctx the parse tree
	 */
	void enterCmdSelecao(NovaLangParser.CmdSelecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link NovaLangParser#cmdSelecao}.
	 * @param ctx the parse tree
	 */
	void exitCmdSelecao(NovaLangParser.CmdSelecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link NovaLangParser#cmdRepeticao}.
	 * @param ctx the parse tree
	 */
	void enterCmdRepeticao(NovaLangParser.CmdRepeticaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link NovaLangParser#cmdRepeticao}.
	 * @param ctx the parse tree
	 */
	void exitCmdRepeticao(NovaLangParser.CmdRepeticaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link NovaLangParser#comparacao}.
	 * @param ctx the parse tree
	 */
	void enterComparacao(NovaLangParser.ComparacaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link NovaLangParser#comparacao}.
	 * @param ctx the parse tree
	 */
	void exitComparacao(NovaLangParser.ComparacaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link NovaLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(NovaLangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NovaLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(NovaLangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NovaLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(NovaLangParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link NovaLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(NovaLangParser.TermoContext ctx);
}