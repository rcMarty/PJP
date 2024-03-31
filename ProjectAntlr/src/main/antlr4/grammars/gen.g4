grammar gen;

prog: (stat )+ EOF;

stat: '{' stat* '}'
    |writeStat ';'
    | declareStat ';'
    | assignStat ';'
    | readStat ';'
    | ifStat
    | whileStat
    | ';'
    ;

writeStat: 'write' expr? (',' expr)* ;
readStat: 'read' ID (',' ID)* ;

declareStat: dataType ID (',' ID)* ;
assignStat: ID '=' expr ;

CommentStat: '//' .*? '\n' -> skip;

expr: expr op=('*'|'/'|'%') expr        # arithmetic
    | expr op=('+'|'-') expr            # arithmetic
    | expr op=('<'|'>'|'=='|'!=') expr  # comparison
    | expr op=('&&'|'||') expr          # logic
    | '!' expr                          # logic
    | expr '.' expr                     # concat
    | '(' expr ')'                      # parens
    | ID                                # variable
    | INT                               # int
    | FLOAT                             # float
    | STRING                            # string
    | BOOL                              # bool
    ;

ifStat: 'if' '(' expr ')' stat ('else' stat)? ;

whileStat: 'while' '(' expr ')' stat ;

dataType: 'int'
        | 'float'
        | 'string'
        | 'bool'
        ;

ID : [a-zA-Z][a-zA-Z0-9]* ;
INT : '-'? [0-9]+ ;
FLOAT : '-'? [0-9]+ '.' [0-9]+ ;
STRING : '"' ~'"'* '"';
BOOL : 'true' | 'false';
WS : [ \t\r\n]+ -> skip ;