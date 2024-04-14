grammar ProjExpr;

prog: (statement )+ EOF;

writeStat: 'write' expr? (',' expr)* ;
readStat: 'read' ID (',' ID)* ;

ifStat: 'if' '(' condition ')' statement ('else' statement)? ;
whileStat: 'while' '(' condition ')' statement ;
forStat: 'for' '(' expr ';' condition ';' expr ')' statement ;

blockStat: '{' statement* '}' ;

exprStat: expr ;

declareStat: literals ID (',' ID)* ;
literals: 'int'
        | 'float'
        | 'string'
        | 'bool'
        ;

statement
    : blockStat
    | writeStat ';'
    | declareStat ';'
    | exprStat ';'
    | readStat ';'
    | ifStat
    | whileStat
    | forStat
    | ';'
    ;

expr: '-' expr                          # unaryMinus
    | '!' expr                          # negation
    | expr op=('*'|'/') expr            # arithmetic
    | expr '%' expr                     # modulo
    | expr op=('+'|'-') expr            # arithmetic
    | expr '.' expr                     # concatenation
    | expr op=('<'|'>') expr            # relational
    | expr op=('=='|'!=') expr          # comparison
    | expr '&&' expr                    # logicAnd
    | expr '||' expr                    # logicOr
    | '(' expr ')'                      # parens
    | <assoc=right> expr '?' expr ':' expr   # ternary
    | <assoc=right> ID '=' expr         # assign
    | INT                               # int
    | FLOAT                             # float
    | STRING                            # string
    | BOOL                              # bool
    | ID                                # id
    ;


condition: expr ;

INT : [0-9]+ ;
FLOAT : [0-9]+ '.' [0-9]+ ;
STRING : '"' ~'"'* '"';
BOOL : 'true' | 'false';
ID : [a-zA-Z][a-zA-Z0-9]* ;

WS : [ \t\r\n]+ -> skip ;
CommentStat: '//' .*? '\n' -> skip;