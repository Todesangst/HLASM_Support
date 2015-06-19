
package com.HLASMplugin;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.HLASMplugin.psi.HLASMTypes;
import com.intellij.psi.TokenType;

%%

%class HLASMLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%column
%eof{  return;
%eof}

%{
      StringBuffer string = new StringBuffer();

      private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
      }
      private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
      }
%}

CRLF= \n|\r|\r\n
WHITE_SPACE=[\ \t\f]
VALUE_CHARACTER=[a-zA-Z0-9@$#_+-,=*()'/&]
STAR="*"
COMMA = ","

%state COMMENT
%state COMMENT_CONTINUE
%%

<YYINITIAL> {STAR}                                          { string.setLength(0) ; yybegin(COMMENT) }

<COMMENT> {

{VALUE_CHARACTER}                                           { if (yycolumn<72) {
                                                                string.append( yytext() ));
                                                            }
                                                            else {
                                                                yybegin(COMMENT_CONTINUE)
                                                            }
                                                            }
}
<COMMENT_CONTINUE> {

{VALUE_CHARACTER}                                           { if (yycolumn>72) or (yycolumn<16){
                                                                return TokenType.BAD_CHARACTER;
                                                            }
                                                            else{
                                                                string.append( yytext() ));
                                                                yybegin(COMMENT);
                                                            }
                                                            }

{WHITE_SPACE}                                               {  yybegin(YYINITIAL);
                                                               return symbol(HLASMTypes.COMMENT, string.toString());
                                                            }
}

{CRLF}                                                     { yybegin(YYINITIAL); return HLASMTypes.CRLF; }

{WHITE_SPACE}+                                              { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
