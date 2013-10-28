lexer grammar BasicLexer;

//Statements
EQUALS: '=' ;
SKIP: 'skip' ;
READ: 'read' ;
FREE: 'free' ;
RETURN: 'return' ;
EXIT: 'exit' ;
PRINT: 'print' ;
PRINTLN: 'println' ;
IF: 'if' ;
THEN: 'then' ;
ELSE: 'else' ;
ENDIF: 'fi' ;
WHILE: 'while' ;
DO: 'do' ;
DONE: 'done' ;
BEGIN: 'begin' ;
END: 'end' ;
IS: 'is' ;
SEMICOLON: ';' ;

NEWPAIR: 'newpair' ;
CALL: 'call' ;

//Pair Elements
FIRST: 'fst' ;
SECOND: 'snd' ;

//Base Types
INT: 'int' ;
BOOL: 'bool' ;
CHAR: 'char' ;
STRING: 'string' ;

//Pair Type
PAIR: 'pair' ;

//Unary Operators
NOT: '!' ;
NEGATE: '-' ;
LENGTH: 'len' ;
ORD: 'ord' ;
TO_INT: 'toInt' ;

//Binary Operators
MULTIPLY: '*' ;
DIVIDE: '/' ;
MOD: '%' ;
PLUS: '+' ;
MINUS: '-' ;
GREATER: '>' ;
GREATER_EQUAL: '>=' ;
LESS: '<' ;
LESS_EQUAL: '<=' ;
EQUAL: '==' ;
NOT_EQUAL: '!=' ;
AND: '&&' ;
OR: '||' ;

//Identifiers
UNDERSCORE: '_' ;
LOWERCASE_LETTER: 'a'..'z' ;
UPPERCASE_LETTER: 'A'..'Z' ;

//Integer Signs
NEGATIVE: '-' ;
POSITIVE: '+' ;

//Boolean Literals
TRUE: 'true' ;
FALSE: 'false' ;

//Escaped Chars
NUL: '0' ;
BACKSPACE: 'b' ;
TAB: 't' ;
NEWLINE: 'n' ;
FORM_FEED: 'f' ;
CARRIAGE_RETURN: 'r' ;
DOUBLE_QUOTE: '"' ;
SINGLE_QUOTE: '`' ;
BACKSLASH: '\\' ;

//Array Literals
OPEN_BRACKET: '[' ;
CLOSE_BRACKET: ']' ;
COMMA: ',' ;

//Pair Literal
NULL: 'null' ;

//Comment
HASH: '#' ;

OPEN_PARENTHESES: '(' ;
CLOSE_PARENTHESES: ')' ;


fragment DIGIT: '0'..'9' ; 

INTEGER: DIGIT+ ;





