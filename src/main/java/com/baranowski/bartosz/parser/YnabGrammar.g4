grammar YnabGrammar ;
file : row+ EOF;
row : field+NEWLINE+;
field : (STRING| SINGLE_STRING | INT | DATE | CURRENCY)*COLON;
//TOKENS


INT :'-'?[0-9]+(','[0-9]+)?;
//AMMOUNT : '-'?INT+','INT INT ;
DATE : INT*'-' INT* '-' INT*;
STRING: '"' .*? '"';
CURRENCY: [A-Z]+;
SINGLE_STRING: '\'' .*? '\'';
NEWLINE : [\n\r];
COLON : ';';
