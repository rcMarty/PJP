grammar ProjExpr;

prog: (stat )+ EOF;

stat: '{' stat* '}'
    | writeStat ';'
    | declareStat ';'
//    | assignStat ';'
    | expr ';'
    | readStat ';'
    | ifStat
    | whileStat
    | ';'
    ;

writeStat: 'write' expr? (',' expr)* ;
readStat: 'read' ID (',' ID)* ;

assignStat: ID '=' expr ;

declareStat: dataType ID (',' ID)* ;
dataType: 'int'
        | 'float'
        | 'string'
        | 'bool'
        ;

CommentStat: '//' .*? '\n' -> skip;

expr: '-' expr                          # unaryMinus
    | '!' expr                          # negation
    | expr op=('*'|'/'|'%') expr        # arithmetic
    | expr op=('+'|'-'|'.') expr        # arithmetic
    | expr op=('<'|'>') expr            # relational
    | expr op=('=='|'!=') expr          # comparison
    | expr '&&' expr                    # logicAnd
    | expr '||' expr                    # logicOr
    | '(' expr ')'                      # parens
    | ID '=' expr                       # assign
    | ID                                # id
    | INT                               # int
    | FLOAT                             # float
    | STRING                            # string
    | BOOL                              # bool
    ;

ifStat: 'if' '(' expr ')' stat ('else' stat)? ;

whileStat: 'while' '(' expr ')' stat ;

ID : [a-zA-Z][a-zA-Z0-9]* ;
INT : [0-9]+ ;
FLOAT : [0-9]+ '.' [0-9]+ ;
STRING : '"' ~'"'* '"';
BOOL : 'true' | 'false';
WS : [ \t\r\n]+ -> skip ;