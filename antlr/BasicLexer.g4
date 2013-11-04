lexer grammar BasicLexer;

@header{
package antlr;
}

// Statements
EQUALS : '=' ;
SKIP : 'skip' ;
READ : 'read' ;
FREE : 'free' ;
RETURN : 'return' ;
EXIT : 'exit' ;
PRINT : 'print' ;
PRINTLN : 'println' ;
IF : 'if' ;
THEN : 'then' ;
ELSE : 'else' ;
ENDIF : 'fi' ;
WHILE : 'while' ;
DO : 'do' ;
DONE : 'done' ;
BEGIN : 'begin' ;
END : 'end' ;
IS : 'is' ;
SEMICOLON : ';' ;

NEWPAIR : 'newpair' ;
CALL : 'call' ;

// Pair Elements
FIRST : 'fst' ;
SECOND : 'snd' ;

// Base Types
INT : 'int' ;
BOOL : 'bool' ;
CHAR : 'char' ;
STRING : 'string' ;

// Pair Type
PAIR : 'pair' ;

// Unary Operators
NOT : '!' ;
LENGTH : 'len' ;
ORD : 'ord' ;
TO_INT : 'toInt' ;

// Binary Operators
MULTIPLY : '*' ;
DIVIDE : '/' ;
MOD : '%' ;
PLUS : '+' ;
MINUS : '-' ;
GREATER : '>' ;
GREATER_EQUAL : '>=' ;
LESS : '<' ;
LESS_EQUAL : '<=' ;
EQUAL : '==' ;
NOT_EQUAL : '!=' ;
AND : '&&' ;
OR : '||' ;

// Identifiers
UNDERSCORE : '_' ;

// Boolean Literals
TRUE : 'true' ;
FALSE : 'false' ;

// Escaped Chars
fragment NUL : '0' ;
fragment BACKSPACE : 'b' ;
fragment TAB : 't' ;
fragment FORM_FEED : 'f' ;
fragment NEWLINE : 'n' ;
fragment CARRIAGE_RETURN : 'r' ;
DOUBLE_QUOTE : '"' ;
SINGLE_QUOTE : '\'' ;
BACKSLASH : '\\' ;

ESCAPED_CHAR : BACKSLASH (NUL | BACKSPACE | TAB | FORM_FEED | CARRIAGE_RETURN | SINGLE_QUOTE | DOUBLE_QUOTE | BACKSLASH ) ;

// Array Literals
OPEN_BRACKET : '[' ;
CLOSE_BRACKET : ']' ;
COMMA : ',' ;

// Pair Literal
NULL : 'null' ;

OPEN_PARENTHESES : '(' ;
CLOSE_PARENTHESES : ')' ;

fragment DIGIT: '0'..'9' ; 
fragment LOWERCASE: ( 'a'..'z' ) ;
fragment UPPERCASE: ( 'A'..'Z' ) ;
INTEGER: DIGIT+ ;

IDENT: ( UNDERSCORE | LOWERCASE | UPPERCASE ) ( UNDERSCORE | LOWERCASE | UPPERCASE | DIGIT )* ;

WHITESPACE : ( '\t' | ' ' | '\r' | '\n' )+ -> skip;

COMMENT: '#' ~[\r\n]* -> skip;

EVERYTHING: ~( '\n' | '\r' ) ;
