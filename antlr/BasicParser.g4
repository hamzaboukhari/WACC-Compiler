parser grammar BasicParser;

options {
  tokenVocab=BasicLexer;
}

expr: expr binary_oper expr
| INTEGER
| OPEN_PARENTHESES expr CLOSE_PARENTHESES
;

unary_oper : NOT | NEGATE | LENGTH | ORD | TO_INT ;

binary_oper : PLUS | MINUS | MULTIPLY | DIVIDE | MOD | GREATER | GREATER_EQUAL | LESS | LESS_EQUAL | EQUAL | NOT_EQUAL | AND | OR ;

ident : (UNDERSCORE | LOWERCASE_LETTER | UPPERCASE_LETTER) (UNDERSCORE | LOWERCASE_LETTER | UPPERCASE_LETTER | DIGIT)* ;

array_elem : expr OPEN_BRACKET expr CLOSE_BRACKET ;

int_liter : (intSign)? (digit)+

digit : DIGIT

int_sign : POSITIVE | NEGATIVE ;

bool_liter : TRUE | FALSE ;

char_liter : SINGLE_QUOTE character SINGLE_QUOTE

str_liter : DOUBLE_QUOTE (character)* DOUBLE_QUOTE

character :

escaped_char : NUL | BACKSPACE | TAB | NEWLINE | FORM_FEED | CARRIAGE_RETURN | SINGLE_QUOTE | DOUBLE_QUOTE | BACKSLASH

array_liter : OPEN_BRACKET (expr (COMMA expr)*)? CLOSE_BRACKET

pair_liter : NULL ;

comment : HASH 

// EOF indicates that the program must consume to the end of the input.
prog: (expr)*  EOF ;
