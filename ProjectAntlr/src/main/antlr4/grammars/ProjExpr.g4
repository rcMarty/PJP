grammar ProjExpr;

prog: (stat )+ EOF;

stat: '{' stat* '}'     # block
    | writeStat ';'     # write
    | declareStat ';'   # declare
    | expr ';'          # expression
    | readStat ';'      # read
    | ifStat            # if
    | whileStat         # while
    | forStat           # for
    | ';'               # empty
    ;

writeStat: 'write' expr? (',' expr)* ;
readStat: 'read' ID (',' ID)* ;

ifStat: 'if' '(' condition ')' stat ('else' stat)? ;
whileStat: 'while' '(' condition ')' stat ;
forStat: 'for' '(' expr ';' condition ';' expr ')' stat ;

declareStat: literals ID (',' ID)* ;
literals: 'int'
        | 'float'
        | 'string'
        | 'bool'
        ;

condition: expr ;


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
    | ID '=' expr                       # assign
    | INT                               # int
    | FLOAT                             # float
    | STRING                            # string
    | BOOL                              # bool
    | ID                                # id
    ;


INT : [0-9]+ ;
FLOAT : [0-9]+ '.' [0-9]+ ;
STRING : '"' ~'"'* '"';
BOOL : 'true' | 'false';
ID : [a-zA-Z][a-zA-Z0-9]* ;

WS : [ \t\r\n]+ -> skip ;
CommentStat: '//' .*? '\n' -> skip;