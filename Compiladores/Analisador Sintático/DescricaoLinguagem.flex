
/* 
 * Especificação léxica da Linguagem MiniC
 *
 */

%%

%class AnalisadorLexico
%unicode
%line
%type Token

%{
    private Token token(int tipo) {
        
      return new Token(type);
        
    }

    private Token token(int tipo, Object valor) {
	
	  return new Token(tipo, valor);
	
    }

%}

letra  = [A-Za-z]
digito = [0-9]
escape = [\r \n \t \\]
id  = ( {letra} | _ )( {letra} | {digito} )*
literalNumerico = digito+
literalChar = '( escape | letra | digito )'
literalString = "( letra | escape | digito )*"
Espaco = [ \r\n\t\f]

%%

"char"             { return token( Token.CHAR ); }
"else"             { return token( Token.ELSE ); }
"false"            { return token( Token.FALSE ); }
"if"               { return token( Token.IF ); }
"int"              { return token(Token.INT); }
"main"             { return token( Token.MAIN ); }
"out"              { return token( Token.OUT ); }
"printf"           { return token( Token.PRINTF ); }
"return"           { return token( Token.RETURN ); }
"static"           { return token( Token.STATIC ); }
"void"             { return token( Token.VOID );  }
"while"            { return token( Token.WHILE ); }

"<"                { return token(Token.RELOP, Token.LT); }
"<="               { return token(Token.RELOP, Token.LE); }
">"                { return token(Token.RELOP, Token.GT); }
">="               { return token(Token.RELOP, Token.GE); }
"!="               { return token(Token.RELOP, Token.NE); }
"=="               { return token(Token.RELOP, Token.EQ); }

"="                { return token(Token.AT, Token.ATR); }

"+"                { return token(Token.OP, Token.AD); }
"-"                { return token(Token.OP, Token.SUB); }
"*"                { return token(Token.OP, Token.MUL); }
"/"                { return token(Token.OP, Token.DIV); }

"&&"               { return token(Token.LOG, Token.AND); }
"||"               { return token(Token.LOG, Token.OR); }
"!"                { return token(Token.LOG, Token.NOT); }

"("               { return token(Token.PONTUACAO, Token.AP); }
")"               { return token(Token.PONTUACAO, Token.FP); }
"{"               { return token(Token.PONTUACAO, Token.AC); }
"}"               { return token(Token.PONTUACAO, Token.FC); }
";"               { return token(Token.PONTUACAO, Token.PV); }
","               { return token(Token.PONTUACAO, Token.VG); }

{id}               { return token(Token.ID, yytext()); }
{literalNumerico}  { return token(Token.LITERALNUMERICO, Integer.parseInt(yytext())); }
{literalString}    { return token(Token.LITERALSTRING, yytext()); }
{literalChar}      { return token(Token.LITERALCHAR, yytext()); }


{Espaco}             { /* ignora espacos */ }

/* caractere nao reconhecido: erro */
.|\n                 { throw new Error("Caracter ilegal: <" + yytext() + ">"); }
