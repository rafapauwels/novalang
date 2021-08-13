grammar NovaLang;

@header{
import java.util.ArrayList;
import java.util.Stack;
import com.google.googlejavaformat.java.FormatterException;
import com.pauwels.nova.program.NovaProgram;
import com.pauwels.nova.exception.*;
import com.pauwels.nova.commands.*;
import com.pauwels.nova.data.*;
}

@members{
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
    String fonte = program.generate();
    symbolmap.verificaIdsInutilizados();
    return fonte;
}
}

prog : 'programa' declara bloco 'fimprog;'
        {
            program.setSymbolMap(symbolmap);
            program.setCommands(stack.pop());
        };

declara : (declaraVar)+;

declaraVar : tipo ID { symbolmap.insereId(_input.LT(-1).getText(), new NovaVariable(tipo, null)); }
                (VIR ID { symbolmap.insereId(_input.LT(-1).getText(), new NovaVariable(tipo, null)); } )* SC;

tipo : 'numero' { tipo = NovaTypeEnum.NUMBER; }
     | 'texto'  { tipo = NovaTypeEnum.TEXT;   };

bloco : { stack.push(new ArrayList<Command>()); }
        (cmd)+;

cmd : cmdLeitura | cmdEscrita | cmdAttrib | cmdSelecao | cmdRepeticao;

cmdLeitura : 'leia' AP ID
      {
        atualID = _input.LT(-1).getText();
        validaID(atualID);
        symbolmap.idUtilizado(atualID);
      } FP SC
      {
        NovaVariable var = symbolmap.recuperaSymbol(atualID);
        stack.peek().add(new CommandLeituraImpl(atualID, var));
      };

cmdEscrita : 'escreva' AP ID
      {
        atualID = _input.LT(-1).getText();
        validaID(atualID);
        symbolmap.idUtilizado(atualID);
      } FP SC
      {
        stack.peek().add(new CommandEscritaImpl(atualID));
      };

cmdAttrib : ID
      {
        atualID = _input.LT(-1).getText();
        validaID(atualID);
        symbolmap.idUtilizado(atualID);
        tipoVar = symbolmap.recuperaSymbol(atualID).getTipo();
      } ATTR { expr = ""; } expr SC
      {
        stack.peek().add(new CommandAtribuicaoImpl(atualID, expr));
      };

cmdSelecao : 'se'   AP
                    comparacao
                    FP ACH {
                        stack.push(new ArrayList<Command>());
                    }
                    (cmd)+ FCH {
                        seVerdadeiro = stack.pop();
                        seFalso = null;
                    }
                        ('senao' ACH {
                            stack.push(new ArrayList<Command>());
                        } (cmd)+ FCH
                        {
                            seFalso = stack.pop();
                        }
                        )?
                    {
                        stack.peek().add(new CommandDecisaoImpl(decisionExpr, seVerdadeiro, seFalso));
                    };

cmdRepeticao : 'enquanto' AP
                comparacao FP ACH
                 {
                    stack.push(new ArrayList<Command>());
                 }
                 (cmd)+ FCH
                {
                    commands = stack.pop();
                    stack.peek().add(new CommandRepeticaoImpl(decisionExpr, commands));
                };

comparacao : ID
            {
                atualID = _input.LT(-1).getText();
                validaID(atualID);
                symbolmap.idUtilizado(atualID);
                decisionExpr = atualID;
            }
             OPREL { decisionExpr += _input.LT(-1).getText(); }
             (ID | NUMBER) { decisionExpr += _input.LT(-1).getText(); };

expr : termo (OP { expr += _input.LT(-1).getText(); } termo)*;

termo : ID
        {
            validaID(_input.LT(-1).getText());
            expr += _input.LT(-1).getText();
        }
        |
        NUMBER
        {
            checaTipo(tipoVar, NovaTypeEnum.NUMBER);
            expr += _input.LT(-1).getText();
        }
        |
        TEXT
        {
            checaTipo(tipoVar, NovaTypeEnum.TEXT);
            expr += _input.LT(-1).getText();
        }
        ;

AP : '(';
FP : ')';
SC : ';';
OP : '+' | '-' | '*' | '/';
ATTR : '=';
VIR : ',';
ACH : '{';
FCH : '}';
OPREL : '>' | '<' | '>=' | '<=' | '==' | '!=';
ID : [a-z] ([a-z] | [A-Z] | [0-9])*;
NUMBER : [0-9]+ ('.' [0-9]+)?;
TEXT : '"' (.)*? '"';
WS : (' ' | '\t' | '\n' | '\r') -> skip;