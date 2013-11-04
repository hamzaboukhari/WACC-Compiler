parser grammar BasicParser;

options {
  tokenVocab=BasicLexer;
}

program : BEGIN (func)* stat END ;

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
	;
	
assign_lhs : ident
	| expr OPEN_BRACKET expr CLOSE_BRACKET
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
	| expr OPEN_BRACKET expr CLOSE_BRACKET
	| unary_oper expr
	| expr binary_oper expr
	| OPEN_PARENTHESES expr CLOSE_PARENTHESES
	;

unary_oper : NOT 
	| MINUS 
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
	
ident : IDENT ;

int_liter : (int_sign)? INTEGER ;

int_sign : PLUS | MINUS ;

bool_liter : TRUE | FALSE ;

char_liter : SINGLE_QUOTE character SINGLE_QUOTE ;

str_liter : DOUBLE_QUOTE (character)* DOUBLE_QUOTE ;

character : ~(BACKSLASH | SINGLE_QUOTE | DOUBLE_QUOTE)
          |  ESCAPED_CHAR ;

array_liter : OPEN_BRACKET (expr (COMMA expr)*)? CLOSE_BRACKET ;

pair_liter : NULL ;

// EOF indicates that the program must consume to the end of the input.
prog: program EOF ;
