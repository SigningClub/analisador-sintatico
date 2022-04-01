grammar Expr;

import CommonLexerRules;

prog : PROGRAM IDENTIFIER PVIG decls cmdComp PONTO | PROGRAM IDENTIFIER PVIG cmdComp PONTO ;

decls: VAR listDecl;
listDecl: declTip | declTip listDecl;
declTip: listId DPONTOS tip PVIG;
listId: IDENTIFIER | IDENTIFIER VIG listId;
tip: INTEGER | BOOLEAN | STRING;

cmdComp: BEGIN listCmd END;
listCmd: cmd | cmd PVIG listCmd;
cmd: cmdIf | cmdWhile | cmdRead | cmdWrite | cmdAtrib | cmdComp;

cmdIf: IF exprr THEN cmd | IF exprr THEN cmd ELSE cmd;

cmdWhile: WHILE exprr DO cmd;

cmdRead: READ ABPAR listId FPAR;
cmdWrite: WRITE ABPAR listW FPAR;
listW: elemW | elemW VIG listW;
elemW: expr | CADEIA;

cmdAtrib: IDENTIFIER ATRIB expr PVIG;

expr: expra
    | exprr
    ;

exprr: exprrf 
    | expra OPREL expr
    ;

expra: exprm 
    | exprm OPAD expr
    ;

exprm: expraf 
    | expraf OPMULT expr
    ;

expraf: IDENTIFIER
    | CTE
    | ABPAR expr FPAR
    | TRUE
    | FALSE
    | OPNEG IDENTIFIER 
    | OPNEG CTE 
    | OPNEG ABPAR expr FPAR 
    | OPNEG TRUE 
    | OPNEG FALSE
    ;

exprrf: IDENTIFIER
    | CTE
    | ABPAR exprr FPAR
    | TRUE
    | FALSE
    | OPNEG IDENTIFIER 
    | OPNEG CTE 
    | OPNEG ABPAR exprr FPAR 
    | OPNEG TRUE 
    | OPNEG FALSE
    ;

