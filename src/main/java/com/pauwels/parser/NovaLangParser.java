// Generated from NovaLang.g4 by ANTLR 4.9.2
package com.pauwels.parser;

import com.google.googlejavaformat.java.FormatterException;
import com.pauwels.nova.commands.*;
import com.pauwels.nova.data.NovaSymbolMap;
import com.pauwels.nova.data.NovaTypeEnum;
import com.pauwels.nova.data.NovaVariable;
import com.pauwels.nova.exception.NovaSemanticException;
import com.pauwels.nova.program.NovaProgram;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class NovaLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		AP=10, FP=11, SC=12, OP=13, ATTR=14, VIR=15, ACH=16, FCH=17, OPREL=18, 
		ID=19, NUMBER=20, TEXT=21, WS=22;
	public static final int
		RULE_prog = 0, RULE_declara = 1, RULE_declaraVar = 2, RULE_tipo = 3, RULE_bloco = 4, 
		RULE_cmd = 5, RULE_cmdLeitura = 6, RULE_cmdEscrita = 7, RULE_cmdAttrib = 8, 
		RULE_cmdSelecao = 9, RULE_cmdRepeticao = 10, RULE_comparacao = 11, RULE_expr = 12, 
		RULE_termo = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "declara", "declaraVar", "tipo", "bloco", "cmd", "cmdLeitura", 
			"cmdEscrita", "cmdAttrib", "cmdSelecao", "cmdRepeticao", "comparacao", 
			"expr", "termo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog;'", "'numero'", "'texto'", "'leia'", "'escreva'", 
			"'se'", "'senao'", "'enquanto'", "'('", "')'", "';'", null, "'='", "','", 
			"'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "AP", "FP", 
			"SC", "OP", "ATTR", "VIR", "ACH", "FCH", "OPREL", "ID", "NUMBER", "TEXT", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "NovaLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	private NovaProgram program = new NovaProgram();
	private NovaSymbolMap symbolmap = new NovaSymbolMap();
	private NovaTypeEnum tipo;

	private NovaTypeEnum tipoVar;

	private String atualID;
	private String expr;
	private String decisionExpr;

	private Stack<ArrayList<Command>> stack = new Stack<ArrayList<Command>>();

	private ArrayList<Command> seVerdadeiro = new ArrayList<>();
	private ArrayList<Command> seFalso = new ArrayList<>();
	private ArrayList<Command> commands = new ArrayList<>();

	private void checaTipo(NovaTypeEnum esperado, NovaTypeEnum recebido) {
	    if (esperado != recebido)
	        throw new NovaSemanticException("Tipos incompatíveis.\n Esperado: " + esperado + "\n Recebido: " + recebido);
	}

	private void validaID(String id) {
	    if (!symbolmap.idExiste(id))
	        throw new NovaSemanticException("Variável " + id + " não declarada");
	}

	public String generate() throws FormatterException {
	    return program.generate();
	}

	public NovaLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public DeclaraContext declara() {
			return getRuleContext(DeclaraContext.class,0);
		}
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NovaLangListener ) ((NovaLangListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NovaLangListener ) ((NovaLangListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(T__0);
			setState(29);
			declara();
			setState(30);
			bloco();
			setState(31);
			match(T__1);

			            program.setSymbolMap(symbolmap);
			            program.setCommands(stack.pop());
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaraContext extends ParserRuleContext {
		public List<DeclaraVarContext> declaraVar() {
			return getRuleContexts(DeclaraVarContext.class);
		}
		public DeclaraVarContext declaraVar(int i) {
			return getRuleContext(DeclaraVarContext.class,i);
		}
		public DeclaraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declara; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NovaLangListener ) ((NovaLangListener)listener).enterDeclara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NovaLangListener ) ((NovaLangListener)listener).exitDeclara(this);
		}
	}

	public final DeclaraContext declara() throws RecognitionException {
		DeclaraContext _localctx = new DeclaraContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(34);
				declaraVar();
				}
				}
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 || _la==T__3 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaraVarContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(NovaLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(NovaLangParser.ID, i);
		}
		public TerminalNode SC() { return getToken(NovaLangParser.SC, 0); }
		public List<TerminalNode> VIR() { return getTokens(NovaLangParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(NovaLangParser.VIR, i);
		}
		public DeclaraVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaraVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NovaLangListener ) ((NovaLangListener)listener).enterDeclaraVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NovaLangListener ) ((NovaLangListener)listener).exitDeclaraVar(this);
		}
	}

	public final DeclaraVarContext declaraVar() throws RecognitionException {
		DeclaraVarContext _localctx = new DeclaraVarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaraVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			tipo();
			setState(40);
			match(ID);
			 symbolmap.insereId(_input.LT(-1).getText(), new NovaVariable(tipo, null)); 
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(42);
				match(VIR);
				setState(43);
				match(ID);
				 symbolmap.insereId(_input.LT(-1).getText(), new NovaVariable(tipo, null)); 
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NovaLangListener ) ((NovaLangListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NovaLangListener ) ((NovaLangListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		try {
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				match(T__2);
				 tipo = NovaTypeEnum.NUMBER; 
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				match(T__3);
				 tipo = NovaTypeEnum.TEXT;   
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NovaLangListener ) ((NovaLangListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NovaLangListener ) ((NovaLangListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 stack.push(new ArrayList<Command>()); 
			setState(60); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(59);
				cmd();
				}
				}
				setState(62); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << ID))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdContext extends ParserRuleContext {
		public CmdLeituraContext cmdLeitura() {
			return getRuleContext(CmdLeituraContext.class,0);
		}
		public CmdEscritaContext cmdEscrita() {
			return getRuleContext(CmdEscritaContext.class,0);
		}
		public CmdAttribContext cmdAttrib() {
			return getRuleContext(CmdAttribContext.class,0);
		}
		public CmdSelecaoContext cmdSelecao() {
			return getRuleContext(CmdSelecaoContext.class,0);
		}
		public CmdRepeticaoContext cmdRepeticao() {
			return getRuleContext(CmdRepeticaoContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NovaLangListener ) ((NovaLangListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NovaLangListener ) ((NovaLangListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmd);
		try {
			setState(69);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				cmdLeitura();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				cmdEscrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				cmdAttrib();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 4);
				{
				setState(67);
				cmdSelecao();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 5);
				{
				setState(68);
				cmdRepeticao();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdLeituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(NovaLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(NovaLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(NovaLangParser.FP, 0); }
		public TerminalNode SC() { return getToken(NovaLangParser.SC, 0); }
		public CmdLeituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdLeitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NovaLangListener ) ((NovaLangListener)listener).enterCmdLeitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NovaLangListener ) ((NovaLangListener)listener).exitCmdLeitura(this);
		}
	}

	public final CmdLeituraContext cmdLeitura() throws RecognitionException {
		CmdLeituraContext _localctx = new CmdLeituraContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdLeitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(T__4);
			setState(72);
			match(AP);
			setState(73);
			match(ID);

			        atualID = _input.LT(-1).getText();
			        validaID(atualID);
			      
			setState(75);
			match(FP);
			setState(76);
			match(SC);

			        NovaVariable var = symbolmap.recuperaSymbol(atualID);
			        stack.peek().add(new CommandLeituraImpl(atualID, var));
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdEscritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(NovaLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(NovaLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(NovaLangParser.FP, 0); }
		public TerminalNode SC() { return getToken(NovaLangParser.SC, 0); }
		public CmdEscritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdEscrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NovaLangListener ) ((NovaLangListener)listener).enterCmdEscrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NovaLangListener ) ((NovaLangListener)listener).exitCmdEscrita(this);
		}
	}

	public final CmdEscritaContext cmdEscrita() throws RecognitionException {
		CmdEscritaContext _localctx = new CmdEscritaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdEscrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(T__5);
			setState(80);
			match(AP);
			setState(81);
			match(ID);

			        atualID = _input.LT(-1).getText();
			        validaID(atualID);
			      
			setState(83);
			match(FP);
			setState(84);
			match(SC);

			        stack.peek().add(new CommandEscritaImpl(atualID));
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdAttribContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(NovaLangParser.ID, 0); }
		public TerminalNode ATTR() { return getToken(NovaLangParser.ATTR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SC() { return getToken(NovaLangParser.SC, 0); }
		public CmdAttribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdAttrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NovaLangListener ) ((NovaLangListener)listener).enterCmdAttrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NovaLangListener ) ((NovaLangListener)listener).exitCmdAttrib(this);
		}
	}

	public final CmdAttribContext cmdAttrib() throws RecognitionException {
		CmdAttribContext _localctx = new CmdAttribContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdAttrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(ID);

			        atualID = _input.LT(-1).getText();
			        validaID(atualID);
			        tipoVar = symbolmap.recuperaSymbol(atualID).getTipo();
			      
			setState(89);
			match(ATTR);
			 expr = ""; 
			setState(91);
			expr();
			setState(92);
			match(SC);

			        stack.peek().add(new CommandAtribuicaoImpl(atualID, expr));
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdSelecaoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(NovaLangParser.AP, 0); }
		public ComparacaoContext comparacao() {
			return getRuleContext(ComparacaoContext.class,0);
		}
		public TerminalNode FP() { return getToken(NovaLangParser.FP, 0); }
		public List<TerminalNode> ACH() { return getTokens(NovaLangParser.ACH); }
		public TerminalNode ACH(int i) {
			return getToken(NovaLangParser.ACH, i);
		}
		public List<TerminalNode> FCH() { return getTokens(NovaLangParser.FCH); }
		public TerminalNode FCH(int i) {
			return getToken(NovaLangParser.FCH, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdSelecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdSelecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NovaLangListener ) ((NovaLangListener)listener).enterCmdSelecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NovaLangListener ) ((NovaLangListener)listener).exitCmdSelecao(this);
		}
	}

	public final CmdSelecaoContext cmdSelecao() throws RecognitionException {
		CmdSelecaoContext _localctx = new CmdSelecaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdSelecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(T__6);
			setState(96);
			match(AP);
			setState(97);
			comparacao();
			setState(98);
			match(FP);
			setState(99);
			match(ACH);

			                        stack.push(new ArrayList<Command>());
			                    
			setState(102); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(101);
				cmd();
				}
				}
				setState(104); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << ID))) != 0) );
			setState(106);
			match(FCH);

			                        seVerdadeiro = stack.pop();
			                        seFalso = null;
			                    
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(108);
				match(T__7);
				setState(109);
				match(ACH);

				                            stack.push(new ArrayList<Command>());
				                        
				setState(112); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(111);
					cmd();
					}
					}
					setState(114); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << ID))) != 0) );
				setState(116);
				match(FCH);

				                            seFalso = stack.pop();
				                        
				}
			}


			                        stack.peek().add(new CommandDecisaoImpl(decisionExpr, seVerdadeiro, seFalso));
			                    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdRepeticaoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(NovaLangParser.AP, 0); }
		public ComparacaoContext comparacao() {
			return getRuleContext(ComparacaoContext.class,0);
		}
		public TerminalNode FP() { return getToken(NovaLangParser.FP, 0); }
		public TerminalNode ACH() { return getToken(NovaLangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(NovaLangParser.FCH, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdRepeticaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdRepeticao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NovaLangListener ) ((NovaLangListener)listener).enterCmdRepeticao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NovaLangListener ) ((NovaLangListener)listener).exitCmdRepeticao(this);
		}
	}

	public final CmdRepeticaoContext cmdRepeticao() throws RecognitionException {
		CmdRepeticaoContext _localctx = new CmdRepeticaoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdRepeticao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(T__8);
			setState(124);
			match(AP);
			setState(125);
			comparacao();
			setState(126);
			match(FP);
			setState(127);
			match(ACH);

			                    stack.push(new ArrayList<Command>());
			                 
			setState(130); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(129);
				cmd();
				}
				}
				setState(132); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << ID))) != 0) );
			setState(134);
			match(FCH);

			                    commands = stack.pop();
			                    stack.peek().add(new CommandRepeticaoImpl(decisionExpr, commands));
			                
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparacaoContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(NovaLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(NovaLangParser.ID, i);
		}
		public TerminalNode OPREL() { return getToken(NovaLangParser.OPREL, 0); }
		public TerminalNode NUMBER() { return getToken(NovaLangParser.NUMBER, 0); }
		public ComparacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparacao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NovaLangListener ) ((NovaLangListener)listener).enterComparacao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NovaLangListener ) ((NovaLangListener)listener).exitComparacao(this);
		}
	}

	public final ComparacaoContext comparacao() throws RecognitionException {
		ComparacaoContext _localctx = new ComparacaoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_comparacao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(ID);

			                atualID = _input.LT(-1).getText();
			                validaID(atualID);
			                decisionExpr = atualID;
			            
			setState(139);
			match(OPREL);
			 decisionExpr += _input.LT(-1).getText(); 
			setState(141);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			 decisionExpr += _input.LT(-1).getText(); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> OP() { return getTokens(NovaLangParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(NovaLangParser.OP, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NovaLangListener ) ((NovaLangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NovaLangListener ) ((NovaLangListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			termo();
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(145);
				match(OP);
				 expr += _input.LT(-1).getText(); 
				setState(147);
				termo();
				}
				}
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(NovaLangParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(NovaLangParser.NUMBER, 0); }
		public TerminalNode TEXT() { return getToken(NovaLangParser.TEXT, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NovaLangListener ) ((NovaLangListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NovaLangListener ) ((NovaLangListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_termo);
		try {
			setState(159);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				match(ID);

				            validaID(_input.LT(-1).getText());
				            expr += _input.LT(-1).getText();
				        
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				match(NUMBER);

				            checaTipo(tipoVar, NovaTypeEnum.NUMBER);
				            expr += _input.LT(-1).getText();
				        
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 3);
				{
				setState(157);
				match(TEXT);

				            checaTipo(tipoVar, NovaTypeEnum.TEXT);
				            expr += _input.LT(-1).getText();
				        
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\30\u00a4\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\6\3&\n\3\r\3\16\3\'\3\4\3\4\3\4\3\4\3\4\3\4\7\4\60\n\4\f\4\16\4\63\13"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5;\n\5\3\6\3\6\6\6?\n\6\r\6\16\6@\3\7\3\7"+
		"\3\7\3\7\3\7\5\7H\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\6\13i\n\13\r\13\16\13j\3\13\3\13\3\13\3\13\3\13\3\13\6\13"+
		"s\n\13\r\13\16\13t\3\13\3\13\3\13\5\13z\n\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\6\f\u0085\n\f\r\f\16\f\u0086\3\f\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\16\3\16\3\16\3\16\7\16\u0097\n\16\f\16\16\16\u009a\13\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00a2\n\17\3\17\2\2\20\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\2\3\3\2\25\26\2\u00a4\2\36\3\2\2\2\4%\3\2\2\2"+
		"\6)\3\2\2\2\b:\3\2\2\2\n<\3\2\2\2\fG\3\2\2\2\16I\3\2\2\2\20Q\3\2\2\2\22"+
		"Y\3\2\2\2\24a\3\2\2\2\26}\3\2\2\2\30\u008b\3\2\2\2\32\u0092\3\2\2\2\34"+
		"\u00a1\3\2\2\2\36\37\7\3\2\2\37 \5\4\3\2 !\5\n\6\2!\"\7\4\2\2\"#\b\2\1"+
		"\2#\3\3\2\2\2$&\5\6\4\2%$\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\5"+
		"\3\2\2\2)*\5\b\5\2*+\7\25\2\2+\61\b\4\1\2,-\7\21\2\2-.\7\25\2\2.\60\b"+
		"\4\1\2/,\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\64\3\2\2\2"+
		"\63\61\3\2\2\2\64\65\7\16\2\2\65\7\3\2\2\2\66\67\7\5\2\2\67;\b\5\1\28"+
		"9\7\6\2\29;\b\5\1\2:\66\3\2\2\2:8\3\2\2\2;\t\3\2\2\2<>\b\6\1\2=?\5\f\7"+
		"\2>=\3\2\2\2?@\3\2\2\2@>\3\2\2\2@A\3\2\2\2A\13\3\2\2\2BH\5\16\b\2CH\5"+
		"\20\t\2DH\5\22\n\2EH\5\24\13\2FH\5\26\f\2GB\3\2\2\2GC\3\2\2\2GD\3\2\2"+
		"\2GE\3\2\2\2GF\3\2\2\2H\r\3\2\2\2IJ\7\7\2\2JK\7\f\2\2KL\7\25\2\2LM\b\b"+
		"\1\2MN\7\r\2\2NO\7\16\2\2OP\b\b\1\2P\17\3\2\2\2QR\7\b\2\2RS\7\f\2\2ST"+
		"\7\25\2\2TU\b\t\1\2UV\7\r\2\2VW\7\16\2\2WX\b\t\1\2X\21\3\2\2\2YZ\7\25"+
		"\2\2Z[\b\n\1\2[\\\7\20\2\2\\]\b\n\1\2]^\5\32\16\2^_\7\16\2\2_`\b\n\1\2"+
		"`\23\3\2\2\2ab\7\t\2\2bc\7\f\2\2cd\5\30\r\2de\7\r\2\2ef\7\22\2\2fh\b\13"+
		"\1\2gi\5\f\7\2hg\3\2\2\2ij\3\2\2\2jh\3\2\2\2jk\3\2\2\2kl\3\2\2\2lm\7\23"+
		"\2\2my\b\13\1\2no\7\n\2\2op\7\22\2\2pr\b\13\1\2qs\5\f\7\2rq\3\2\2\2st"+
		"\3\2\2\2tr\3\2\2\2tu\3\2\2\2uv\3\2\2\2vw\7\23\2\2wx\b\13\1\2xz\3\2\2\2"+
		"yn\3\2\2\2yz\3\2\2\2z{\3\2\2\2{|\b\13\1\2|\25\3\2\2\2}~\7\13\2\2~\177"+
		"\7\f\2\2\177\u0080\5\30\r\2\u0080\u0081\7\r\2\2\u0081\u0082\7\22\2\2\u0082"+
		"\u0084\b\f\1\2\u0083\u0085\5\f\7\2\u0084\u0083\3\2\2\2\u0085\u0086\3\2"+
		"\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"\u0089\7\23\2\2\u0089\u008a\b\f\1\2\u008a\27\3\2\2\2\u008b\u008c\7\25"+
		"\2\2\u008c\u008d\b\r\1\2\u008d\u008e\7\24\2\2\u008e\u008f\b\r\1\2\u008f"+
		"\u0090\t\2\2\2\u0090\u0091\b\r\1\2\u0091\31\3\2\2\2\u0092\u0098\5\34\17"+
		"\2\u0093\u0094\7\17\2\2\u0094\u0095\b\16\1\2\u0095\u0097\5\34\17\2\u0096"+
		"\u0093\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2"+
		"\2\2\u0099\33\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009c\7\25\2\2\u009c\u00a2"+
		"\b\17\1\2\u009d\u009e\7\26\2\2\u009e\u00a2\b\17\1\2\u009f\u00a0\7\27\2"+
		"\2\u00a0\u00a2\b\17\1\2\u00a1\u009b\3\2\2\2\u00a1\u009d\3\2\2\2\u00a1"+
		"\u009f\3\2\2\2\u00a2\35\3\2\2\2\r\'\61:@Gjty\u0086\u0098\u00a1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}