parser grammar BasicParser;

options {
  tokenVocab=BasicLexer;
}

program : (comment)* BEGIN (comment)* (func)* stat  END (comment)*;

func : type ident OPEN_PARENTHESES (param_list)? CLOSE_PARENTHESES IS stat END ;
 
param_list : param (COMMA param)* ;

param : type ident ;

stat : SKIP
	| type ident EQUALS assign_rhs 
	| assign_lhs EQUALS assign_rhs 
	| READ assign_lhs             
	| FREE expr 
	| RETURN expr
	| EXIT expr
	| PRINT expr
	| PRINTLN expr
	| IF expr THEN stat ELSE stat ENDIF
	| WHILE expr DO stat DONE
	| BEGIN stat END
	| stat SEMICOLON stat
	| comment
	;
	
assign_lhs : ident
	| array_elem
	| pair_elem
	;
	
assign_rhs : expr
	| array_liter
	| NEWPAIR OPEN_PARENTHESES expr COMMA expr CLOSE_PARENTHESES
	| pair_elem
	| CALL ident OPEN_PARENTHESES (arg_list)? CLOSE_PARENTHESES
	;
	
arg_list : expr (COMMA expr)* ;

pair_elem : FIRST expr
	| SECOND expr
	;
	
type : base_type
	| array_type
	| pair_type
	;

base_type : INT
	| BOOL
	| CHAR 
	| STRING
	;
	
array_type : (base_type | pair_type) OPEN_BRACKET CLOSE_BRACKET ;

pair_type : PAIR OPEN_PARENTHESES pair_elem_type COMMA pair_elem_type CLOSE_PARENTHESES ;

pair_elem_type : base_type
	| array_type
	| PAIR
	;
	
expr : int_liter
	| bool_liter
	| char_liter
	| str_liter
	| pair_liter
	| ident
	| array_elem
	| unary_oper expr
	| expr binary_oper expr
	| OPEN_PARENTHESES expr CLOSE_PARENTHESES
	;

expr2 : int_liter
	| bool_liter
	| char_liter
	| str_liter
	| pair_liter
	| ident
	| unary_oper expr2
	| expr2 binary_oper expr2
	| OPEN_PARENTHESES expr2 CLOSE_PARENTHESES
	;

unary_oper : NOT 
	| NEGATE 
	| LENGTH
	| ORD 
	| TO_INT 
	;

binary_oper : PLUS 
	| MINUS 
	| MULTIPLY 
	| DIVIDE 
	| MOD 
	| GREATER 
	| GREATER_EQUAL 
	| LESS 
	| LESS_EQUAL 
	| EQUAL 
	| NOT_EQUAL 
	| AND 
	| OR 
	;

ident : (UNDERSCORE | LOWERCASE_LETTER | UPPERCASE_LETTER) (UNDERSCORE | LOWERCASE_LETTER | UPPERCASE_LETTER | INTEGER)* ;

array_elem : expr2 OPEN_BRACKET expr2 CLOSE_BRACKET ;

int_liter : (int_sign)? INTEGER ;

int_sign : POSITIVE | NEGATIVE ;

bool_liter : TRUE | FALSE ;

char_liter : SINGLE_QUOTE character SINGLE_QUOTE ;

str_liter : DOUBLE_QUOTE (character)* DOUBLE_QUOTE ;

character : ~(BACKSLASH | SINGLE_QUOTE | DOUBLE_QUOTE)
          | '\\' escaped_char ;

escaped_char : NUL 
	| BACKSPACE 
	| TAB 
	| NEWLINE 
	| FORM_FEED 
	| CARRIAGE_RETURN 
	| SINGLE_QUOTE 
	| DOUBLE_QUOTE 
	| BACKSLASH
	;

array_liter : OPEN_BRACKET (expr (COMMA expr)*)? CLOSE_BRACKET ;

pair_liter : NULL ;

comment : HASH ~(EOL)* (EOL);

// EOF indicates that the program must consume to the end of the input.
prog: program EOF ;
