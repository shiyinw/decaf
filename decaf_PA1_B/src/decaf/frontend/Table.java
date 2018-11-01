/* This is auto-generated source by LL1-Parser-Gen.
 * Specification file: /Users/sherilynw/Desktop/3_1/编译原理/decaf/decaf_PA1_B/src/decaf/frontend/Parser.spec
 * Options: unstrict mode
 * Generated at: Thu Nov 01 23:58:19 CST 2018
 * Please do NOT modify it!
 *
 * Project repository: https://github.com/paulzfm/LL1-Parser-Gen
 * Version: special version for decaf-PA1-B
 * Author: Zhu Fengmin (Paul)
 */

package decaf.frontend;

import decaf.Location;
import decaf.tree.Tree;
import decaf.tree.Tree.*;
import java.util.*;

public class Table
 {
    public static final int eof = -1;
    public static final int eos = 0;
    
    /* tokens and symbols */
    public static final int VOID = 257; //# line 13
    public static final int BOOL = 258; //# line 13
    public static final int INT = 259; //# line 13
    public static final int STRING = 260; //# line 13
    public static final int CLASS = 261; //# line 13
    public static final int NULL = 262; //# line 14
    public static final int EXTENDS = 263; //# line 14
    public static final int THIS = 264; //# line 14
    public static final int WHILE = 265; //# line 14
    public static final int FOR = 266; //# line 14
    public static final int IF = 267; //# line 15
    public static final int ELSE = 268; //# line 15
    public static final int RETURN = 269; //# line 15
    public static final int BREAK = 270; //# line 15
    public static final int NEW = 271; //# line 15
    public static final int PRINT = 272; //# line 16
    public static final int READ_INTEGER = 273; //# line 16
    public static final int READ_LINE = 274; //# line 16
    public static final int LITERAL = 275; //# line 17
    public static final int IDENTIFIER = 276; //# line 18
    public static final int AND = 277; //# line 18
    public static final int OR = 278; //# line 18
    public static final int STATIC = 279; //# line 18
    public static final int INSTANCEOF = 280; //# line 18
    public static final int LESS_EQUAL = 281; //# line 19
    public static final int GREATER_EQUAL = 282; //# line 19
    public static final int EQUAL = 283; //# line 19
    public static final int NOT_EQUAL = 284; //# line 19
    public static final int SCOPY = 285; //# line 22
    public static final int VAR = 286; //# line 22
    public static final int SEALED = 287; //# line 22
    public static final int DIVIDER = 288; //# line 22
    public static final int ARRAY_REPEAT = 289; //# line 23
    public static final int ARRAY_CONCAT = 290; //# line 23
    public static final int DEFAULT = 291; //# line 23
    public static final int IN = 292; //# line 23
    public static final int FOREACH = 293; //# line 23
    
    public static final int VariableDef = 294;
    public static final int ExprT5 = 295;
    public static final int BoundVariable = 296;
    public static final int Oper3 = 297;
    public static final int Oper6 = 298;
    public static final int VariableList = 299;
    public static final int Formals = 300;
    public static final int Oper7 = 301;
    public static final int Expr8 = 302;
    public static final int AfterSimpleTypeExpr = 303;
    public static final int ARRAY = 304;
    public static final int Expr2 = 305;
    public static final int Oper2 = 306;
    public static final int ExprT31 = 307;
    public static final int Expr6 = 308;
    public static final int IfGContent = 309;
    public static final int ExprT32 = 310;
    public static final int BreakStmt = 311;
    public static final int IfContent = 312;
    public static final int ExprT2 = 313;
    public static final int ARRAY2 = 314;
    public static final int Oper31 = 315;
    public static final int StmtList = 316;
    public static final int Constant = 317;
    public static final int SubVariableList = 318;
    public static final int PrintStmt = 319;
    public static final int ForStmt = 320;
    public static final int Expr9 = 321;
    public static final int Expr1 = 322;
    public static final int ForeachStmt = 323;
    public static final int Oper1 = 324;
    public static final int ElseClause = 325;
    public static final int FieldList = 326;
    public static final int IfBranch = 327;
    public static final int SubExprList = 328;
    public static final int Expr31 = 329;
    public static final int AfterParenExpr = 330;
    public static final int ClassDef = 331;
    public static final int ReturnStmt = 332;
    public static final int ExprList = 333;
    public static final int StmtBlock = 334;
    public static final int FunctionField = 335;
    public static final int AfterIdentExpr = 336;
    public static final int Program = 337;
    public static final int Expr = 338;
    public static final int Oper32 = 339;
    public static final int Type = 340;
    public static final int Expr5 = 341;
    public static final int AfterNewExpr = 342;
    public static final int Assignment = 343;
    public static final int ExtendsClause = 344;
    public static final int Oper5 = 345;
    public static final int ArrayType = 346;
    public static final int Expr3 = 347;
    public static final int Actuals = 348;
    public static final int Expr32 = 349;
    public static final int Variable = 350;
    public static final int ExprT3 = 351;
    public static final int Stmt = 352;
    public static final int SimpleStmt = 353;
    public static final int SimpleType = 354;
    public static final int WhileStmt = 355;
    public static final int ExprT1 = 356;
    public static final int Expr4 = 357;
    public static final int ExprT4 = 358;
    public static final int ReturnExpr = 359;
    public static final int IfStmt = 360;
    public static final int OCStmt = 361;
    public static final int ExprT6 = 362;
    public static final int ExprT8 = 363;
    public static final int Expr7 = 364;
    public static final int ClassList = 365;
    public static final int Oper4 = 366;
    public static final int IfG = 367;
    public static final int Field = 368;
    
    /* start symbol */
    public final int start = Program;
    
    /**
      * Judge if a symbol (within valid range) is non-terminal.
      *
      * @param symbol the symbol to be judged.
      * @return true if and only if the symbol is non-terminal.
      */
        
    public boolean isNonTerminal(int symbol) {
        return symbol >= 294;
    }
    
    private final String[] allSymbols = {
        "VOID", "BOOL", "INT", "STRING", "CLASS",
        "NULL", "EXTENDS", "THIS", "WHILE", "FOR",
        "IF", "ELSE", "RETURN", "BREAK", "NEW",
        "PRINT", "READ_INTEGER", "READ_LINE", "LITERAL", "IDENTIFIER",
        "AND", "OR", "STATIC", "INSTANCEOF", "LESS_EQUAL",
        "GREATER_EQUAL", "EQUAL", "NOT_EQUAL", "SCOPY", "VAR",
        "SEALED", "DIVIDER", "ARRAY_REPEAT", "ARRAY_CONCAT", "DEFAULT",
        "IN", "FOREACH", "VariableDef", "ExprT5", "BoundVariable",
        "Oper3", "Oper6", "VariableList", "Formals", "Oper7",
        "Expr8", "AfterSimpleTypeExpr", "ARRAY", "Expr2", "Oper2",
        "ExprT31", "Expr6", "IfGContent", "ExprT32", "BreakStmt",
        "IfContent", "ExprT2", "ARRAY2", "Oper31", "StmtList",
        "Constant", "SubVariableList", "PrintStmt", "ForStmt", "Expr9",
        "Expr1", "ForeachStmt", "Oper1", "ElseClause", "FieldList",
        "IfBranch", "SubExprList", "Expr31", "AfterParenExpr", "ClassDef",
        "ReturnStmt", "ExprList", "StmtBlock", "FunctionField", "AfterIdentExpr",
        "Program", "Expr", "Oper32", "Type", "Expr5",
        "AfterNewExpr", "Assignment", "ExtendsClause", "Oper5", "ArrayType",
        "Expr3", "Actuals", "Expr32", "Variable", "ExprT3",
        "Stmt", "SimpleStmt", "SimpleType", "WhileStmt", "ExprT1",
        "Expr4", "ExprT4", "ReturnExpr", "IfStmt", "OCStmt",
        "ExprT6", "ExprT8", "Expr7", "ClassList", "Oper4",
        "IfG", "Field",
    };
    
    /**
      * Debugging function (pretty print).
      * Get string presentation of some token or symbol.
      *
      * @param symbol either terminal or non-terminal.
      * @return its string presentation.
      */
        
    public String name(int symbol) {
        if (symbol == eof) return "<eof>";
        if (symbol == eos) return "<eos>";
        if (symbol > 0 && symbol <= 256) return "'" + (char) symbol + "'";
        return allSymbols[symbol - 257];
    }
    
    /* begin lookahead symbols */
    private ArrayList<Set<Integer>> begin = new ArrayList<Set<Integer>>();
    private final Integer[][] beginRaw = {
        {VOID, CLASS, INT, STRING, BOOL},
        {Integer.valueOf('+'), Integer.valueOf('-'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), ARRAY_CONCAT, WHILE, Integer.valueOf('='), OR, ARRAY_REPEAT, AND, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {VAR, VOID, CLASS, INT, STRING, BOOL},
        {EQUAL, NOT_EQUAL},
        {Integer.valueOf('*'), Integer.valueOf('/'), Integer.valueOf('%')},
        {VOID, CLASS, INT, STRING, BOOL},
        {VOID, CLASS, INT, STRING, BOOL, Integer.valueOf(')')},
        {Integer.valueOf('-'), Integer.valueOf('!')},
        {READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {Integer.valueOf(']'), Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {Integer.valueOf(']'), LITERAL, NULL, Integer.valueOf('[')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {AND},
        {ARRAY_CONCAT},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER, Integer.valueOf('}')},
        {ARRAY_REPEAT, ARRAY_CONCAT},
        {BREAK},
        {Integer.valueOf('('), Integer.valueOf('{')},
        {AND, Integer.valueOf(']'), Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, Integer.valueOf(';')},
        {Integer.valueOf(','), Integer.valueOf(']')},
        {ARRAY_CONCAT},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, IDENTIFIER, NEW, IF, VAR, THIS, INSTANCEOF, STRING, LITERAL, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{'), Integer.valueOf('}')},
        {LITERAL, NULL, Integer.valueOf('[')},
        {Integer.valueOf(','), Integer.valueOf(')')},
        {PRINT},
        {FOR},
        {LITERAL, NULL, Integer.valueOf('['), READ_INTEGER, READ_LINE, THIS, NEW, INSTANCEOF, Integer.valueOf('('), IDENTIFIER},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {Integer.valueOf(')'), WHILE},
        {OR},
        {ELSE, PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, NEW, IF, VAR, THIS, DIVIDER, INSTANCEOF, STRING, LITERAL, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {VOID, CLASS, INT, STRING, STATIC, BOOL, Integer.valueOf('}')},
        {DIVIDER, Integer.valueOf('}')},
        {Integer.valueOf(','), Integer.valueOf(')')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER, CLASS},
        {SEALED, CLASS},
        {RETURN},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {Integer.valueOf('{')},
        {Integer.valueOf('('), Integer.valueOf(';')},
        {Integer.valueOf('('), Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), ARRAY_CONCAT, WHILE, Integer.valueOf('='), OR, Integer.valueOf('+'), ARRAY_REPEAT, AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {SEALED, CLASS},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {ARRAY_REPEAT},
        {VOID, CLASS, INT, STRING, BOOL},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {IDENTIFIER, VOID, CLASS, INT, STRING, BOOL},
        {Integer.valueOf('='), Integer.valueOf(';'), Integer.valueOf(')')},
        {EXTENDS, Integer.valueOf('{')},
        {Integer.valueOf('+'), Integer.valueOf('-')},
        {Integer.valueOf('['), IDENTIFIER},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER, Integer.valueOf(')')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {VOID, CLASS, INT, STRING, BOOL},
        {EQUAL, NOT_EQUAL, Integer.valueOf(']'), Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, AND, Integer.valueOf(';')},
        {VOID, CLASS, INT, STRING, BOOL, Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, VAR, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), READ_INTEGER, SCOPY, IF, WHILE, FOR, RETURN, PRINT, BREAK, Integer.valueOf('{'), FOREACH},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER, VAR, Integer.valueOf(';'), Integer.valueOf(')')},
        {INT, VOID, BOOL, STRING, CLASS},
        {WHILE},
        {OR, Integer.valueOf(']'), Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), Integer.valueOf(';')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {LESS_EQUAL, GREATER_EQUAL, Integer.valueOf('<'), Integer.valueOf('>'), Integer.valueOf(']'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), ARRAY_CONCAT, WHILE, Integer.valueOf('='), OR, ARRAY_REPEAT, AND, Integer.valueOf(';')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER, Integer.valueOf(';')},
        {IF},
        {SCOPY},
        {Integer.valueOf('*'), Integer.valueOf('/'), Integer.valueOf('%'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), ARRAY_CONCAT, WHILE, Integer.valueOf('='), OR, Integer.valueOf('+'), ARRAY_REPEAT, AND, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {Integer.valueOf('['), Integer.valueOf('.'), Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), ARRAY_CONCAT, WHILE, Integer.valueOf('='), OR, Integer.valueOf('+'), ARRAY_REPEAT, AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf('-'), Integer.valueOf('!'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {SEALED, CLASS, eof, eos},
        {LESS_EQUAL, GREATER_EQUAL, Integer.valueOf('<'), Integer.valueOf('>')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {STATIC, VOID, CLASS, INT, STRING, BOOL},
    };
    
    /**
      * Get begin lookahead tokens for `symbol`.
      *
      * @param symbol the non-terminal.
      * @return its begin lookahead tokens.
      */
        
    public Set<Integer> beginSet(int symbol) {
        return begin.get(symbol - 294);
    }
    
    /* follow set */
    private ArrayList<Set<Integer>> follow = new ArrayList<Set<Integer>>();
    private final Integer[][] followRaw = {
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, NEW, IF, VAR, THIS, DIVIDER, INSTANCEOF, STRING, LITERAL, ELSE, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), ARRAY_CONCAT, WHILE, Integer.valueOf('='), OR, ARRAY_REPEAT, AND, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {IN},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {Integer.valueOf(')')},
        {Integer.valueOf(')')},
        {READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), ARRAY_CONCAT, WHILE, Integer.valueOf('='), OR, Integer.valueOf('+'), ARRAY_REPEAT, AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), ARRAY_CONCAT, WHILE, Integer.valueOf('='), OR, Integer.valueOf('+'), ARRAY_REPEAT, AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), ARRAY_CONCAT, WHILE, Integer.valueOf('='), OR, Integer.valueOf('+'), ARRAY_REPEAT, AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf(']'), Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, Integer.valueOf(';')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {},
        {LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), ARRAY_CONCAT, WHILE, Integer.valueOf('='), OR, Integer.valueOf('+'), ARRAY_REPEAT, AND, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, NEW, IF, VAR, THIS, DIVIDER, INSTANCEOF, STRING, LITERAL, ELSE, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {ARRAY_CONCAT},
        {Integer.valueOf(';')},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, NEW, IF, VAR, THIS, DIVIDER, INSTANCEOF, STRING, LITERAL, ELSE, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {Integer.valueOf(']'), Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, Integer.valueOf(';')},
        {Integer.valueOf(']')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {Integer.valueOf('}')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), ARRAY_CONCAT, WHILE, Integer.valueOf('='), OR, Integer.valueOf('+'), ARRAY_REPEAT, AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf(')')},
        {Integer.valueOf(';')},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, NEW, IF, VAR, THIS, DIVIDER, INSTANCEOF, STRING, LITERAL, ELSE, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), ARRAY_CONCAT, WHILE, Integer.valueOf('='), OR, Integer.valueOf('+'), ARRAY_REPEAT, AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf(']'), Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), Integer.valueOf(';')},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, NEW, IF, VAR, THIS, DIVIDER, INSTANCEOF, STRING, LITERAL, ELSE, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, NEW, IF, VAR, THIS, DIVIDER, INSTANCEOF, STRING, LITERAL, ELSE, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {Integer.valueOf('}')},
        {Integer.valueOf('}')},
        {Integer.valueOf(')')},
        {},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), ARRAY_CONCAT, WHILE, Integer.valueOf('='), OR, Integer.valueOf('+'), ARRAY_REPEAT, AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {SEALED, CLASS, eof, eos},
        {Integer.valueOf(';')},
        {Integer.valueOf(')')},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, NEW, IF, VAR, THIS, DIVIDER, INSTANCEOF, STRING, LITERAL, STATIC, ELSE, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {VOID, CLASS, INT, Integer.valueOf('}'), STRING, STATIC, BOOL},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), ARRAY_CONCAT, WHILE, Integer.valueOf('='), OR, Integer.valueOf('+'), ARRAY_REPEAT, AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {eof, eos},
        {Integer.valueOf(']'), Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), Integer.valueOf(';')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {IDENTIFIER},
        {LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), ARRAY_CONCAT, WHILE, Integer.valueOf('='), OR, ARRAY_REPEAT, AND, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), ARRAY_CONCAT, WHILE, Integer.valueOf('='), OR, Integer.valueOf('+'), ARRAY_REPEAT, AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf(';'), Integer.valueOf(')')},
        {Integer.valueOf('{')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {IDENTIFIER},
        {Integer.valueOf(']'), Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, AND, Integer.valueOf(';')},
        {Integer.valueOf(')')},
        {ARRAY_CONCAT},
        {Integer.valueOf(';'), Integer.valueOf(','), Integer.valueOf(')')},
        {Integer.valueOf(']'), Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, AND, Integer.valueOf(';')},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, NEW, IF, VAR, THIS, DIVIDER, INSTANCEOF, STRING, LITERAL, ELSE, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {Integer.valueOf(';'), Integer.valueOf(')')},
        {Integer.valueOf('['), IDENTIFIER},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, NEW, IF, VAR, THIS, DIVIDER, INSTANCEOF, STRING, LITERAL, ELSE, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {Integer.valueOf(']'), Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), Integer.valueOf(';')},
        {Integer.valueOf(']'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), ARRAY_CONCAT, WHILE, Integer.valueOf('='), OR, ARRAY_REPEAT, AND, Integer.valueOf(';')},
        {Integer.valueOf(']'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), ARRAY_CONCAT, WHILE, Integer.valueOf('='), OR, ARRAY_REPEAT, AND, Integer.valueOf(';')},
        {Integer.valueOf(';')},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, NEW, IF, VAR, THIS, DIVIDER, INSTANCEOF, STRING, LITERAL, ELSE, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {Integer.valueOf(';')},
        {LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), ARRAY_CONCAT, WHILE, Integer.valueOf('='), OR, Integer.valueOf('+'), ARRAY_REPEAT, AND, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), ARRAY_CONCAT, WHILE, Integer.valueOf('='), OR, Integer.valueOf('+'), ARRAY_REPEAT, AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), ARRAY_CONCAT, WHILE, Integer.valueOf('='), OR, Integer.valueOf('+'), ARRAY_REPEAT, AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>'), Integer.valueOf('%')},
        {eof, eos},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {DIVIDER, Integer.valueOf('}')},
        {VOID, CLASS, INT, Integer.valueOf('}'), STRING, STATIC, BOOL},
    };
    
    /**
      * Get follow set for `symbol`.
      *
      * @param symbol the non-terminal.
      * @return its follow set.
      */
        
    public Set<Integer> followSet(int symbol) {
        return follow.get(symbol - 294);
    }
    
    public Table() {
        for (int i = 0; i < 75; i++) {
            begin.add(new HashSet<>(Arrays.asList(beginRaw[i])));
            follow.add(new HashSet<>(Arrays.asList(followRaw[i])));
        }
    }
    
    /**
      * Predictive table `M` query function.
      * `query(A, a)` will return the corresponding term `M(A, a)`, i.e., the target production
      * for non-terminal `A` when the lookahead token is `a`.
      *
      * @param nonTerminal   the non-terminal.
      * @param lookahead     the lookahead symbol.
      * @return a pair `<id, right>` where `right` is the right-hand side of the target
      * production `nonTerminal -> right`, and `id` is the corresponding action id. To execute
      * such action, call `act(id, params)`.
      * If the corresponding term is undefined in the table, `null` will be returned.
      */
        
    public Map.Entry<Integer, List<Integer>> query(int nonTerminal, int lookahead) {
        switch (nonTerminal) {
            //# line 49
            case VariableDef: {
                switch (lookahead) {
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(0, Arrays.asList(Variable, Integer.valueOf(';')));
                    default: return null;
                }
            }
            //# line 610
            case ExprT5: {
                switch (lookahead) {
                    case '+':
                    case '-':
                        return new AbstractMap.SimpleEntry<>(1, Arrays.asList(Oper5, Expr6, ExprT5));
                    case LESS_EQUAL:
                    case ']':
                    case GREATER_EQUAL:
                    case ':':
                    case EQUAL:
                    case ')':
                    case NOT_EQUAL:
                    case ',':
                    case ARRAY_CONCAT:
                    case WHILE:
                    case '=':
                    case OR:
                    case ARRAY_REPEAT:
                    case AND:
                    case ';':
                    case '<':
                    case '>':
                        return new AbstractMap.SimpleEntry<>(136, Arrays.asList());
                    default: return null;
                }
            }
            //# line 274
            case BoundVariable: {
                switch (lookahead) {
                    case VAR:
                        return new AbstractMap.SimpleEntry<>(3, Arrays.asList(VAR, IDENTIFIER));
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(4, Arrays.asList(Type, IDENTIFIER));
                    default: return null;
                }
            }
            //# line 326
            case Oper3: {
                switch (lookahead) {
                    case EQUAL:
                        return new AbstractMap.SimpleEntry<>(5, Arrays.asList(EQUAL));
                    case NOT_EQUAL:
                        return new AbstractMap.SimpleEntry<>(6, Arrays.asList(NOT_EQUAL));
                    default: return null;
                }
            }
            //# line 386
            case Oper6: {
                switch (lookahead) {
                    case '*':
                        return new AbstractMap.SimpleEntry<>(7, Arrays.asList(Integer.valueOf('*')));
                    case '/':
                        return new AbstractMap.SimpleEntry<>(8, Arrays.asList(Integer.valueOf('/')));
                    case '%':
                        return new AbstractMap.SimpleEntry<>(9, Arrays.asList(Integer.valueOf('%')));
                    default: return null;
                }
            }
            //# line 169
            case VariableList: {
                switch (lookahead) {
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(10, Arrays.asList(Variable, SubVariableList));
                    default: return null;
                }
            }
            //# line 159
            case Formals: {
                switch (lookahead) {
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(11, Arrays.asList(VariableList));
                    case ')':
                        return new AbstractMap.SimpleEntry<>(12, Arrays.asList());
                    default: return null;
                }
            }
            //# line 403
            case Oper7: {
                switch (lookahead) {
                    case '-':
                        return new AbstractMap.SimpleEntry<>(13, Arrays.asList(Integer.valueOf('-')));
                    case '!':
                        return new AbstractMap.SimpleEntry<>(14, Arrays.asList(Integer.valueOf('!')));
                    default: return null;
                }
            }
            //# line 666
            case Expr8: {
                switch (lookahead) {
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(15, Arrays.asList(Expr9, ExprT8));
                    default: return null;
                }
            }
            //# line 774
            case AfterSimpleTypeExpr: {
                switch (lookahead) {
                    case ']':
                        return new AbstractMap.SimpleEntry<>(16, Arrays.asList(Integer.valueOf(']'), Integer.valueOf('['), AfterSimpleTypeExpr));
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(17, Arrays.asList(Expr, Integer.valueOf(']')));
                    default: return null;
                }
            }
            //# line 812
            case ARRAY: {
                switch (lookahead) {
                    case ']':
                        return new AbstractMap.SimpleEntry<>(18, Arrays.asList(Integer.valueOf(']')));
                    case LITERAL:
                    case NULL:
                    case '[':
                        return new AbstractMap.SimpleEntry<>(19, Arrays.asList(Constant, ARRAY2, Integer.valueOf(']')));
                    default: return null;
                }
            }
            //# line 451
            case Expr2: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(20, Arrays.asList(Expr3, ExprT2));
                    default: return null;
                }
            }
            //# line 319
            case Oper2: {
                switch (lookahead) {
                    case AND:
                        return new AbstractMap.SimpleEntry<>(21, Arrays.asList(AND));
                    default: return null;
                }
            }
            //# line 524
            case ExprT31: {
                switch (lookahead) {
                    case ARRAY_CONCAT:
                        return new AbstractMap.SimpleEntry<>(22, Arrays.asList(Oper31, Expr32, ExprT31));
                    default: return null;
                }
            }
            //# line 627
            case Expr6: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(23, Arrays.asList(Expr7, ExprT6));
                    default: return null;
                }
            }
            //# line 905
            case IfGContent: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(24, Arrays.asList(IfG, IfBranch, Integer.valueOf('}')));
                    case '}':
                        return new AbstractMap.SimpleEntry<>(25, Arrays.asList(Integer.valueOf('}')));
                    default: return null;
                }
            }
            //# line 552
            case ExprT32: {
                switch (lookahead) {
                    case ARRAY_REPEAT:
                        return new AbstractMap.SimpleEntry<>(26, Arrays.asList(Oper32, Expr4, ExprT32));
                    case ARRAY_CONCAT:
                        return new AbstractMap.SimpleEntry<>(136, Arrays.asList());
                    default: return null;
                }
            }
            //# line 882
            case BreakStmt: {
                switch (lookahead) {
                    case BREAK:
                        return new AbstractMap.SimpleEntry<>(28, Arrays.asList(BREAK));
                    default: return null;
                }
            }
            //# line 895
            case IfContent: {
                switch (lookahead) {
                    case '(':
                        return new AbstractMap.SimpleEntry<>(29, Arrays.asList(Integer.valueOf('('), Expr, Integer.valueOf(')'), Stmt, ElseClause));
                    case '{':
                        return new AbstractMap.SimpleEntry<>(30, Arrays.asList(Integer.valueOf('{'), IfGContent));
                    default: return null;
                }
            }
            //# line 463
            case ExprT2: {
                switch (lookahead) {
                    case AND:
                        return new AbstractMap.SimpleEntry<>(31, Arrays.asList(Oper2, Expr3, ExprT2));
                    case ']':
                    case ':':
                    case ')':
                    case ',':
                    case WHILE:
                    case '=':
                    case OR:
                    case ';':
                        return new AbstractMap.SimpleEntry<>(136, Arrays.asList());
                    default: return null;
                }
            }
            //# line 826
            case ARRAY2: {
                switch (lookahead) {
                    case ',':
                        return new AbstractMap.SimpleEntry<>(33, Arrays.asList(Integer.valueOf(','), Constant, ARRAY2));
                    case ']':
                        return new AbstractMap.SimpleEntry<>(34, Arrays.asList());
                    default: return null;
                }
            }
            //# line 338
            case Oper31: {
                switch (lookahead) {
                    case ARRAY_CONCAT:
                        return new AbstractMap.SimpleEntry<>(35, Arrays.asList(ARRAY_CONCAT));
                    default: return null;
                }
            }
            //# line 196
            case StmtList: {
                switch (lookahead) {
                    case PRINT:
                    case VOID:
                    case FOR:
                    case '!':
                    case FOREACH:
                    case '-':
                    case CLASS:
                    case READ_LINE:
                    case WHILE:
                    case RETURN:
                    case NULL:
                    case INT:
                    case SCOPY:
                    case IDENTIFIER:
                    case NEW:
                    case IF:
                    case VAR:
                    case THIS:
                    case INSTANCEOF:
                    case STRING:
                    case LITERAL:
                    case '(':
                    case ';':
                    case '[':
                    case BOOL:
                    case BREAK:
                    case READ_INTEGER:
                    case '{':
                        return new AbstractMap.SimpleEntry<>(36, Arrays.asList(Stmt, StmtList));
                    case '}':
                        return new AbstractMap.SimpleEntry<>(136, Arrays.asList());
                    default: return null;
                }
            }
            //# line 798
            case Constant: {
                switch (lookahead) {
                    case LITERAL:
                        return new AbstractMap.SimpleEntry<>(38, Arrays.asList(LITERAL));
                    case NULL:
                        return new AbstractMap.SimpleEntry<>(39, Arrays.asList(NULL));
                    case '[':
                        return new AbstractMap.SimpleEntry<>(40, Arrays.asList(Integer.valueOf('['), ARRAY));
                    default: return null;
                }
            }
            //# line 179
            case SubVariableList: {
                switch (lookahead) {
                    case ',':
                        return new AbstractMap.SimpleEntry<>(41, Arrays.asList(Integer.valueOf(','), Variable, SubVariableList));
                    case ')':
                        return new AbstractMap.SimpleEntry<>(136, Arrays.asList());
                    default: return null;
                }
            }
            //# line 959
            case PrintStmt: {
                switch (lookahead) {
                    case PRINT:
                        return new AbstractMap.SimpleEntry<>(43, Arrays.asList(PRINT, Integer.valueOf('('), ExprList, Integer.valueOf(')')));
                    default: return null;
                }
            }
            //# line 876
            case ForStmt: {
                switch (lookahead) {
                    case FOR:
                        return new AbstractMap.SimpleEntry<>(44, Arrays.asList(FOR, Integer.valueOf('('), SimpleStmt, Integer.valueOf(';'), Expr, Integer.valueOf(';'), SimpleStmt, Integer.valueOf(')'), Stmt));
                    default: return null;
                }
            }
            //# line 718
            case Expr9: {
                switch (lookahead) {
                    case LITERAL:
                    case NULL:
                    case '[':
                        return new AbstractMap.SimpleEntry<>(45, Arrays.asList(Constant));
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(46, Arrays.asList(READ_INTEGER, Integer.valueOf('('), Integer.valueOf(')')));
                    case READ_LINE:
                        return new AbstractMap.SimpleEntry<>(47, Arrays.asList(READ_LINE, Integer.valueOf('('), Integer.valueOf(')')));
                    case THIS:
                        return new AbstractMap.SimpleEntry<>(48, Arrays.asList(THIS));
                    case NEW:
                        return new AbstractMap.SimpleEntry<>(49, Arrays.asList(NEW, AfterNewExpr));
                    case INSTANCEOF:
                        return new AbstractMap.SimpleEntry<>(50, Arrays.asList(INSTANCEOF, Integer.valueOf('('), Expr, Integer.valueOf(','), IDENTIFIER, Integer.valueOf(')')));
                    case '(':
                        return new AbstractMap.SimpleEntry<>(51, Arrays.asList(Integer.valueOf('('), AfterParenExpr));
                    case IDENTIFIER:
                        return new AbstractMap.SimpleEntry<>(52, Arrays.asList(IDENTIFIER, AfterIdentExpr));
                    default: return null;
                }
            }
            //# line 422
            case Expr1: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(53, Arrays.asList(Expr2, ExprT1));
                    default: return null;
                }
            }
            //# line 262
            case ForeachStmt: {
                switch (lookahead) {
                    case ')':
                        return new AbstractMap.SimpleEntry<>(54, Arrays.asList(Integer.valueOf(')'), Stmt));
                    case WHILE:
                        return new AbstractMap.SimpleEntry<>(55, Arrays.asList(WHILE, Expr, Integer.valueOf(')'), Stmt));
                    default: return null;
                }
            }
            //# line 312
            case Oper1: {
                switch (lookahead) {
                    case OR:
                        return new AbstractMap.SimpleEntry<>(56, Arrays.asList(OR));
                    default: return null;
                }
            }
            //# line 939
            case ElseClause: {
                switch (lookahead) {
                    case ELSE:
                        return new AbstractMap.SimpleEntry<>(57, Arrays.asList(ELSE, Stmt));
                    case PRINT:
                    case VOID:
                    case FOR:
                    case '!':
                    case FOREACH:
                    case '-':
                    case CLASS:
                    case READ_LINE:
                    case WHILE:
                    case RETURN:
                    case NULL:
                    case INT:
                    case SCOPY:
                    case '}':
                    case IDENTIFIER:
                    case NEW:
                    case IF:
                    case VAR:
                    case THIS:
                    case DIVIDER:
                    case INSTANCEOF:
                    case STRING:
                    case LITERAL:
                    case '(':
                    case ';':
                    case '[':
                    case BOOL:
                    case BREAK:
                    case READ_INTEGER:
                    case '{':
                        return new AbstractMap.SimpleEntry<>(136, Arrays.asList());
                    default: return null;
                }
            }
            //# line 119
            case FieldList: {
                switch (lookahead) {
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case STATIC:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(59, Arrays.asList(Field, FieldList));
                    case '}':
                        return new AbstractMap.SimpleEntry<>(60, Arrays.asList());
                    default: return null;
                }
            }
            //# line 928
            case IfBranch: {
                switch (lookahead) {
                    case DIVIDER:
                        return new AbstractMap.SimpleEntry<>(61, Arrays.asList(DIVIDER, IfG, IfBranch));
                    case '}':
                        return new AbstractMap.SimpleEntry<>(136, Arrays.asList());
                    default: return null;
                }
            }
            //# line 857
            case SubExprList: {
                switch (lookahead) {
                    case ',':
                        return new AbstractMap.SimpleEntry<>(63, Arrays.asList(Integer.valueOf(','), Expr, SubExprList));
                    case ')':
                        return new AbstractMap.SimpleEntry<>(64, Arrays.asList());
                    default: return null;
                }
            }
            //# line 509
            case Expr31: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(65, Arrays.asList(Expr32, ExprT31));
                    default: return null;
                }
            }
            //# line 786
            case AfterParenExpr: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(66, Arrays.asList(Expr, Integer.valueOf(')')));
                    case CLASS:
                        return new AbstractMap.SimpleEntry<>(67, Arrays.asList(CLASS, IDENTIFIER, Integer.valueOf(')'), Expr9));
                    default: return null;
                }
            }
            //# line 102
            case ClassDef: {
                switch (lookahead) {
                    case SEALED:
                        return new AbstractMap.SimpleEntry<>(68, Arrays.asList(SEALED, CLASS, IDENTIFIER, ExtendsClause, Integer.valueOf('{'), FieldList, Integer.valueOf('}')));
                    case CLASS:
                        return new AbstractMap.SimpleEntry<>(69, Arrays.asList(CLASS, IDENTIFIER, ExtendsClause, Integer.valueOf('{'), FieldList, Integer.valueOf('}')));
                    default: return null;
                }
            }
            //# line 946
            case ReturnStmt: {
                switch (lookahead) {
                    case RETURN:
                        return new AbstractMap.SimpleEntry<>(70, Arrays.asList(RETURN, ReturnExpr));
                    default: return null;
                }
            }
            //# line 849
            case ExprList: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(71, Arrays.asList(Expr, SubExprList));
                    default: return null;
                }
            }
            //# line 190
            case StmtBlock: {
                switch (lookahead) {
                    case '{':
                        return new AbstractMap.SimpleEntry<>(72, Arrays.asList(Integer.valueOf('{'), StmtList, Integer.valueOf('}')));
                    default: return null;
                }
            }
            //# line 151
            case FunctionField: {
                switch (lookahead) {
                    case '(':
                        return new AbstractMap.SimpleEntry<>(73, Arrays.asList(Integer.valueOf('('), Formals, Integer.valueOf(')'), StmtBlock));
                    case ';':
                        return new AbstractMap.SimpleEntry<>(136, Arrays.asList(Integer.valueOf(';')));
                    default: return null;
                }
            }
            //# line 711
            case AfterIdentExpr: {
                switch (lookahead) {
                    case '(':
                        return new AbstractMap.SimpleEntry<>(75, Arrays.asList(Integer.valueOf('('), Actuals, Integer.valueOf(')')));
                    case '/':
                    case LESS_EQUAL:
                    case ']':
                    case GREATER_EQUAL:
                    case '.':
                    case '-':
                    case ':':
                    case EQUAL:
                    case ')':
                    case NOT_EQUAL:
                    case ',':
                    case ARRAY_CONCAT:
                    case WHILE:
                    case '=':
                    case OR:
                    case '+':
                    case ARRAY_REPEAT:
                    case AND:
                    case '*':
                    case ';':
                    case '<':
                    case '[':
                    case '>':
                    case '%':
                        return new AbstractMap.SimpleEntry<>(136, Arrays.asList());
                    default: return null;
                }
            }
            //# line 27
            case Program: {
                switch (lookahead) {
                    case SEALED:
                    case CLASS:
                        return new AbstractMap.SimpleEntry<>(77, Arrays.asList(ClassDef, ClassList));
                    default: return null;
                }
            }
            //# line 416
            case Expr: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(78, Arrays.asList(Expr1));
                    default: return null;
                }
            }
            //# line 345
            case Oper32: {
                switch (lookahead) {
                    case ARRAY_REPEAT:
                        return new AbstractMap.SimpleEntry<>(79, Arrays.asList(ARRAY_REPEAT));
                    default: return null;
                }
            }
            //# line 83
            case Type: {
                switch (lookahead) {
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(80, Arrays.asList(SimpleType, ArrayType));
                    default: return null;
                }
            }
            //# line 598
            case Expr5: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(81, Arrays.asList(Expr6, ExprT5));
                    default: return null;
                }
            }
            //# line 760
            case AfterNewExpr: {
                switch (lookahead) {
                    case IDENTIFIER:
                        return new AbstractMap.SimpleEntry<>(82, Arrays.asList(IDENTIFIER, Integer.valueOf('('), Integer.valueOf(')')));
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(83, Arrays.asList(SimpleType, Integer.valueOf('['), AfterSimpleTypeExpr));
                    default: return null;
                }
            }
            //# line 303
            case Assignment: {
                switch (lookahead) {
                    case '=':
                        return new AbstractMap.SimpleEntry<>(84, Arrays.asList(Integer.valueOf('='), Expr));
                    case ';':
                    case ')':
                        return new AbstractMap.SimpleEntry<>(136, Arrays.asList());
                    default: return null;
                }
            }
            //# line 112
            case ExtendsClause: {
                switch (lookahead) {
                    case EXTENDS:
                        return new AbstractMap.SimpleEntry<>(86, Arrays.asList(EXTENDS, IDENTIFIER));
                    case '{':
                        return new AbstractMap.SimpleEntry<>(136, Arrays.asList());
                    default: return null;
                }
            }
            //# line 374
            case Oper5: {
                switch (lookahead) {
                    case '+':
                        return new AbstractMap.SimpleEntry<>(88, Arrays.asList(Integer.valueOf('+')));
                    case '-':
                        return new AbstractMap.SimpleEntry<>(89, Arrays.asList(Integer.valueOf('-')));
                    default: return null;
                }
            }
            //# line 92
            case ArrayType: {
                switch (lookahead) {
                    case '[':
                        return new AbstractMap.SimpleEntry<>(90, Arrays.asList(Integer.valueOf('['), Integer.valueOf(']'), ArrayType));
                    case IDENTIFIER:
                        return new AbstractMap.SimpleEntry<>(91, Arrays.asList());
                    default: return null;
                }
            }
            //# line 480
            case Expr3: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(92, Arrays.asList(Expr4, ExprT3));
                    default: return null;
                }
            }
            //# line 839
            case Actuals: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(93, Arrays.asList(ExprList));
                    case ')':
                        return new AbstractMap.SimpleEntry<>(94, Arrays.asList());
                    default: return null;
                }
            }
            //# line 541
            case Expr32: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(95, Arrays.asList(Expr4, ExprT32));
                    default: return null;
                }
            }
            //# line 55
            case Variable: {
                switch (lookahead) {
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(96, Arrays.asList(Type, IDENTIFIER));
                    default: return null;
                }
            }
            //# line 492
            case ExprT3: {
                switch (lookahead) {
                    case EQUAL:
                    case NOT_EQUAL:
                        return new AbstractMap.SimpleEntry<>(97, Arrays.asList(Oper3, Expr4, ExprT3));
                    case ']':
                    case ':':
                    case ')':
                    case ',':
                    case WHILE:
                    case '=':
                    case OR:
                    case AND:
                    case ';':
                        return new AbstractMap.SimpleEntry<>(136, Arrays.asList());
                    default: return null;
                }
            }
            //# line 204
            case Stmt: {
                switch (lookahead) {
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(99, Arrays.asList(VariableDef));
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case VAR:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case ';':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(100, Arrays.asList(SimpleStmt, Integer.valueOf(';')));
                    case SCOPY:
                        return new AbstractMap.SimpleEntry<>(101, Arrays.asList(OCStmt, Integer.valueOf(';')));
                    case IF:
                        return new AbstractMap.SimpleEntry<>(102, Arrays.asList(IfStmt));
                    case WHILE:
                        return new AbstractMap.SimpleEntry<>(103, Arrays.asList(WhileStmt));
                    case FOR:
                        return new AbstractMap.SimpleEntry<>(104, Arrays.asList(ForStmt));
                    case RETURN:
                        return new AbstractMap.SimpleEntry<>(105, Arrays.asList(ReturnStmt, Integer.valueOf(';')));
                    case PRINT:
                        return new AbstractMap.SimpleEntry<>(106, Arrays.asList(PrintStmt, Integer.valueOf(';')));
                    case BREAK:
                        return new AbstractMap.SimpleEntry<>(107, Arrays.asList(BreakStmt, Integer.valueOf(';')));
                    case '{':
                        return new AbstractMap.SimpleEntry<>(108, Arrays.asList(StmtBlock));
                    case FOREACH:
                        return new AbstractMap.SimpleEntry<>(109, Arrays.asList(FOREACH, Integer.valueOf('('), BoundVariable, IN, Expr, ForeachStmt));
                    default: return null;
                }
            }
            //# line 285
            case SimpleStmt: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(110, Arrays.asList(Expr, Assignment));
                    case VAR:
                        return new AbstractMap.SimpleEntry<>(111, Arrays.asList(VAR, IDENTIFIER, Integer.valueOf('='), Expr));
                    case ';':
                    case ')':
                        return new AbstractMap.SimpleEntry<>(136, Arrays.asList());
                    default: return null;
                }
            }
            //# line 61
            case SimpleType: {
                switch (lookahead) {
                    case INT:
                        return new AbstractMap.SimpleEntry<>(113, Arrays.asList(INT));
                    case VOID:
                        return new AbstractMap.SimpleEntry<>(114, Arrays.asList(VOID));
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(115, Arrays.asList(BOOL));
                    case STRING:
                        return new AbstractMap.SimpleEntry<>(116, Arrays.asList(STRING));
                    case CLASS:
                        return new AbstractMap.SimpleEntry<>(117, Arrays.asList(CLASS, IDENTIFIER));
                    default: return null;
                }
            }
            //# line 870
            case WhileStmt: {
                switch (lookahead) {
                    case WHILE:
                        return new AbstractMap.SimpleEntry<>(118, Arrays.asList(WHILE, Integer.valueOf('('), Expr, Integer.valueOf(')'), Stmt));
                    default: return null;
                }
            }
            //# line 434
            case ExprT1: {
                switch (lookahead) {
                    case OR:
                        return new AbstractMap.SimpleEntry<>(119, Arrays.asList(Oper1, Expr2, ExprT1));
                    case ']':
                    case ':':
                    case ')':
                    case ',':
                    case WHILE:
                    case '=':
                    case ';':
                        return new AbstractMap.SimpleEntry<>(136, Arrays.asList());
                    default: return null;
                }
            }
            //# line 569
            case Expr4: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(121, Arrays.asList(Expr5, ExprT4));
                    default: return null;
                }
            }
            //# line 581
            case ExprT4: {
                switch (lookahead) {
                    case LESS_EQUAL:
                    case GREATER_EQUAL:
                    case '<':
                    case '>':
                        return new AbstractMap.SimpleEntry<>(122, Arrays.asList(Oper4, Expr5, ExprT4));
                    case ']':
                    case ':':
                    case EQUAL:
                    case ')':
                    case NOT_EQUAL:
                    case ',':
                    case ARRAY_CONCAT:
                    case WHILE:
                    case '=':
                    case OR:
                    case ARRAY_REPEAT:
                    case AND:
                    case ';':
                        return new AbstractMap.SimpleEntry<>(136, Arrays.asList());
                    default: return null;
                }
            }
            //# line 952
            case ReturnExpr: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(124, Arrays.asList(Expr));
                    case ';':
                        return new AbstractMap.SimpleEntry<>(136, Arrays.asList());
                    default: return null;
                }
            }
            //# line 889
            case IfStmt: {
                switch (lookahead) {
                    case IF:
                        return new AbstractMap.SimpleEntry<>(126, Arrays.asList(IF, IfContent));
                    default: return null;
                }
            }
            //# line 965
            case OCStmt: {
                switch (lookahead) {
                    case SCOPY:
                        return new AbstractMap.SimpleEntry<>(127, Arrays.asList(SCOPY, Integer.valueOf('('), IDENTIFIER, Integer.valueOf(','), Expr, Integer.valueOf(')')));
                    default: return null;
                }
            }
            //# line 639
            case ExprT6: {
                switch (lookahead) {
                    case '*':
                    case '/':
                    case '%':
                        return new AbstractMap.SimpleEntry<>(128, Arrays.asList(Oper6, Expr7, ExprT6));
                    case LESS_EQUAL:
                    case ']':
                    case GREATER_EQUAL:
                    case '-':
                    case ':':
                    case EQUAL:
                    case ')':
                    case NOT_EQUAL:
                    case ',':
                    case ARRAY_CONCAT:
                    case WHILE:
                    case '=':
                    case OR:
                    case '+':
                    case ARRAY_REPEAT:
                    case AND:
                    case ';':
                    case '<':
                    case '>':
                        return new AbstractMap.SimpleEntry<>(136, Arrays.asList());
                    default: return null;
                }
            }
            //# line 686
            case ExprT8: {
                switch (lookahead) {
                    case '[':
                        return new AbstractMap.SimpleEntry<>(130, Arrays.asList(Integer.valueOf('['), Expr, Integer.valueOf(']'), ExprT8));
                    case '.':
                        return new AbstractMap.SimpleEntry<>(131, Arrays.asList(Integer.valueOf('.'), IDENTIFIER, AfterIdentExpr, ExprT8));
                    case '/':
                    case LESS_EQUAL:
                    case ']':
                    case GREATER_EQUAL:
                    case '-':
                    case ':':
                    case EQUAL:
                    case ')':
                    case NOT_EQUAL:
                    case ',':
                    case ARRAY_CONCAT:
                    case WHILE:
                    case '=':
                    case OR:
                    case '+':
                    case ARRAY_REPEAT:
                    case AND:
                    case '*':
                    case ';':
                    case '<':
                    case '>':
                    case '%':
                        return new AbstractMap.SimpleEntry<>(136, Arrays.asList());
                    default: return null;
                }
            }
            //# line 656
            case Expr7: {
                switch (lookahead) {
                    case '-':
                    case '!':
                        return new AbstractMap.SimpleEntry<>(133, Arrays.asList(Oper7, Expr8));
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(134, Arrays.asList(Expr8));
                    default: return null;
                }
            }
            //# line 38
            case ClassList: {
                switch (lookahead) {
                    case SEALED:
                    case CLASS:
                        return new AbstractMap.SimpleEntry<>(135, Arrays.asList(ClassDef, ClassList));
                    case eof:
                    case eos:
                        return new AbstractMap.SimpleEntry<>(136, Arrays.asList());
                    default: return null;
                }
            }
            //# line 352
            case Oper4: {
                switch (lookahead) {
                    case LESS_EQUAL:
                        return new AbstractMap.SimpleEntry<>(137, Arrays.asList(LESS_EQUAL));
                    case GREATER_EQUAL:
                        return new AbstractMap.SimpleEntry<>(138, Arrays.asList(GREATER_EQUAL));
                    case '<':
                        return new AbstractMap.SimpleEntry<>(139, Arrays.asList(Integer.valueOf('<')));
                    case '>':
                        return new AbstractMap.SimpleEntry<>(140, Arrays.asList(Integer.valueOf('>')));
                    default: return null;
                }
            }
            //# line 922
            case IfG: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(141, Arrays.asList(Expr, Integer.valueOf(':'), Stmt));
                    default: return null;
                }
            }
            //# line 135
            case Field: {
                switch (lookahead) {
                    case STATIC:
                        return new AbstractMap.SimpleEntry<>(142, Arrays.asList(STATIC, Type, IDENTIFIER, Integer.valueOf('('), Formals, Integer.valueOf(')'), StmtBlock));
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(143, Arrays.asList(Type, IDENTIFIER, FunctionField));
                    default: return null;
                }
            }
            default: return null;
        }
    }
    
    /**
      * Execute some user-defined semantic action on the specification file.
      * Note that `$$ = params[0], $1 = params[1], ...`. Nothing will be returned, so please
      * do not forget to store the parsed AST result in `params[0]`.
      *
      * @param id      the action id.
      * @param params  parameter array.
      */
        
    public void act(int id, SemValue[] params) {
        switch (id) {
            case 0: {
                //# line 50
                params[0].vdef = params[1].vdef;
                return;
            }
            case 1: {
                //# line 611
                params[0].svec = new Vector<Integer>();
                params[0].lvec = new Vector<Location>();
                params[0].evec = new Vector<Expr>();
                params[0].svec.add(params[1].counter);
                params[0].lvec.add(params[1].loc);
                params[0].evec.add(params[2].expr);
                if (params[3].svec != null) {
                    params[0].svec.addAll(params[3].svec);
                    params[0].lvec.addAll(params[3].lvec);
                    params[0].evec.addAll(params[3].evec);
                }
                return;
            }
            case 2: {
                /* no action */
                return;
            }
            case 3: {
                //# line 275
                params[0].lvalue = new LValue.BoundVar(null, params[2].ident, params[1].loc);
                return;
            }
            case 4: {
                //# line 279
                params[0].lvalue = new LValue.BoundVar(params[1].type, params[2].ident, params[1].loc);
                return;
            }
            case 5: {
                //# line 327
                params[0].counter = Tree.EQ;
                params[0].loc = params[1].loc;
                return;
            }
            case 6: {
                //# line 332
                params[0].counter = Tree.NE;
                params[0].loc = params[1].loc;
                return;
            }
            case 7: {
                //# line 387
                params[0].counter = Tree.MUL;
                params[0].loc = params[1].loc;
                return;
            }
            case 8: {
                //# line 392
                params[0].counter = Tree.DIV;
                params[0].loc = params[1].loc;
                return;
            }
            case 9: {
                //# line 397
                params[0].counter = Tree.MOD;
                params[0].loc = params[1].loc;
                return;
            }
            case 10: {
                //# line 170
                params[0].vlist = new ArrayList<VarDef>();
                params[0].vlist.add(params[1].vdef);
                if (params[2].vlist != null) {
                    params[0].vlist.addAll(params[2].vlist);
                }
                return;
            }
            case 11: {
                //# line 160
                params[0].vlist = params[1].vlist;
                return;
            }
            case 12: {
                //# line 164
                params[0].vlist = new ArrayList<VarDef>();
                return;
            }
            case 13: {
                //# line 404
                params[0].counter = Tree.NEG;
                params[0].loc = params[1].loc;
                return;
            }
            case 14: {
                //# line 409
                params[0].counter = Tree.NOT;
                params[0].loc = params[1].loc;
                return;
            }
            case 15: {
                //# line 667
                params[0].expr = params[1].expr;
                params[0].loc = params[1].loc;
                if (params[2].vec != null) {
                    for (SemValue v : params[2].vec) {
                        if (v.expr != null) {
                            params[0].expr = new Tree.Indexed(params[0].expr, v.expr, params[0].loc);
                        } else if (v.elist != null) {
                            params[0].expr = new Tree.CallExpr(params[0].expr, v.ident, v.elist, v.loc);
                            params[0].loc = v.loc;
                        } else {
                            params[0].expr = new Tree.Ident(params[0].expr, v.ident, v.loc);
                            params[0].loc = v.loc;
                        }
                    }
                }
                return;
            }
            case 16: {
                //# line 775
                params[0].expr = params[3].expr;
                params[0].counter = 1 + params[3].counter;
                return;
            }
            case 17: {
                //# line 780
                params[0].expr = params[1].expr;
                params[0].counter = 0;
                return;
            }
            case 18: {
                //# line 813
                params[0].expr = new Tree.ArrayConstant(null, params[1].loc);
                return;
            }
            case 19: {
                //# line 817
                params[0].elist = new ArrayList<Tree.Expr>();
                params[0].elist.add(params[1].expr);
                params[0].elist.addAll(params[2].elist);
                params[0].expr = new Tree.ArrayConstant(params[0].elist, params[1].loc);
                return;
            }
            case 20: {
                //# line 452
                params[0].expr = params[1].expr;
                if (params[2].svec != null) {
                    for (int i = 0; i < params[2].svec.size(); ++i) {
                        params[0].expr = new Tree.Binary(params[2].svec.get(i), params[0].expr,
                            params[2].evec.get(i), params[2].lvec.get(i));
                    }
                }
                return;
            }
            case 21: {
                //# line 320
                params[0].counter = Tree.AND;
                params[0].loc = params[1].loc;
                return;
            }
            case 22: {
                //# line 525
                params[0].svec = new Vector<Integer>();
                params[0].lvec = new Vector<Location>();
                params[0].evec = new Vector<Expr>();
                params[0].svec.add(params[1].counter);
                params[0].lvec.add(params[1].loc);
                params[0].evec.add(params[2].expr);
                if (params[3].svec != null) {
                    params[0].svec.addAll(params[3].svec);
                    params[0].lvec.addAll(params[3].lvec);
                    params[0].evec.addAll(params[3].evec);
                }
                return;
            }
            case 23: {
                //# line 628
                params[0].expr = params[1].expr;
                if (params[2].svec != null) {
                    for (int i = 0; i < params[2].svec.size(); ++i) {
                        params[0].expr = new Tree.Binary(params[2].svec.get(i), params[0].expr,
                            params[2].evec.get(i), params[2].lvec.get(i));
                    }
                }
                return;
            }
            case 24: {
                //# line 906
                params[0].slist = new ArrayList<Tree>();
                if (params[1].stmt != null) {
                    params[0].slist.add(params[1].stmt);
                }
                if (params[2].slist != null) {
                    params[0].slist.addAll(params[2].slist);
                }
                params[0].stmt = new Tree.Guard(params[0].slist, params[1].loc);
                return;
            }
            case 25: {
                //# line 917
                params[0].stmt = new Tree.Guard(null, params[1].loc);
                return;
            }
            case 26: {
                //# line 553
                params[0].svec = new Vector<Integer>();
                params[0].lvec = new Vector<Location>();
                params[0].evec = new Vector<Expr>();
                params[0].svec.add(params[1].counter);
                params[0].lvec.add(params[1].loc);
                params[0].evec.add(params[2].expr);
                if (params[3].svec != null) {
                    params[0].svec.addAll(params[3].svec);
                    params[0].lvec.addAll(params[3].lvec);
                    params[0].evec.addAll(params[3].evec);
                }
                return;
            }
            case 27: {
                /* no action */
                return;
            }
            case 28: {
                //# line 883
                params[0].stmt = new Tree.Break(params[1].loc);
                return;
            }
            case 29: {
                //# line 896
                params[0].stmt = new Tree.If(params[2].expr, params[4].stmt, params[5].stmt, params[1].loc);
                return;
            }
            case 30: {
                //# line 900
                params[0].stmt = params[2].stmt;
                return;
            }
            case 31: {
                //# line 464
                params[0].svec = new Vector<Integer>();
                params[0].lvec = new Vector<Location>();
                params[0].evec = new Vector<Expr>();
                params[0].svec.add(params[1].counter);
                params[0].lvec.add(params[1].loc);
                params[0].evec.add(params[2].expr);
                if (params[3].svec != null) {
                    params[0].svec.addAll(params[3].svec);
                    params[0].lvec.addAll(params[3].lvec);
                    params[0].evec.addAll(params[3].evec);
                }
                return;
            }
            case 32: {
                /* no action */
                return;
            }
            case 33: {
                //# line 827
                params[0].elist = new ArrayList<Tree.Expr>();
                params[0].elist.add(params[2].expr);
                params[0].elist.addAll(params[3].elist);
                return;
            }
            case 34: {
                //# line 833
                params[0].elist = new ArrayList<Tree.Expr>();
                return;
            }
            case 35: {
                //# line 339
                params[0].counter = Tree.ARRAYCONCAT;
                params[0].loc = params[1].loc;
                return;
            }
            case 36: {
                //# line 197
                params[0].slist.add(params[1].stmt);
                params[0].slist.addAll(params[2].slist);
                return;
            }
            case 37: {
                /* no action */
                return;
            }
            case 38: {
                //# line 799
                params[0].expr = new Tree.Literal(params[1].typeTag, params[1].literal, params[1].loc);
                return;
            }
            case 39: {
                //# line 803
                params[0].expr = new Null(params[1].loc);
                return;
            }
            case 40: {
                //# line 807
                params[0].expr = params[2].expr;
                return;
            }
            case 41: {
                //# line 180
                params[0].vlist = new ArrayList<VarDef>();
                params[0].vlist.add(params[2].vdef);
                if (params[3].vlist != null) {
                    params[0].vlist.addAll(params[3].vlist);
                }
                return;
            }
            case 42: {
                /* no action */
                return;
            }
            case 43: {
                //# line 960
                params[0].stmt = new Tree.Print(params[3].elist, params[1].loc);
                return;
            }
            case 44: {
                //# line 877
                params[0].stmt = new Tree.ForLoop(params[3].stmt, params[5].expr, params[7].stmt, params[9].stmt, params[1].loc);
                return;
            }
            case 45: {
                //# line 719
                params[0].expr = params[1].expr;
                return;
            }
            case 46: {
                //# line 723
                params[0].expr = new Tree.ReadIntExpr(params[1].loc);
                return;
            }
            case 47: {
                //# line 727
                params[0].expr = new Tree.ReadLineExpr(params[1].loc);
                return;
            }
            case 48: {
                //# line 731
                params[0].expr = new Tree.ThisExpr(params[1].loc);
                return;
            }
            case 49: {
                //# line 735
                if (params[2].ident != null) {
                    params[0].expr = new Tree.NewClass(params[2].ident, params[1].loc);
                } else {
                    params[0].expr = new Tree.NewArray(params[2].type, params[2].expr, params[1].loc);
                }
                return;
            }
            case 50: {
                //# line 743
                params[0].expr = new Tree.TypeTest(params[3].expr, params[5].ident, params[1].loc);
                return;
            }
            case 51: {
                //# line 747
                params[0].expr = params[2].expr;
                return;
            }
            case 52: {
                //# line 751
                if (params[2].elist != null) {
                    params[0].expr = new Tree.CallExpr(null, params[1].ident, params[2].elist, params[1].loc);
                } else {
                    params[0].expr = new Tree.Ident(null, params[1].ident, params[1].loc);
                }
                return;
            }
            case 53: {
                //# line 423
                params[0].expr = params[1].expr;
                if (params[2].svec != null) {
                    for (int i = 0; i < params[2].svec.size(); ++i) {
                        params[0].expr = new Tree.Binary(params[2].svec.get(i), params[0].expr,
                            params[2].evec.get(i), params[2].lvec.get(i));
                    }
                }
                return;
            }
            case 54: {
                //# line 263
                params[0].stmt = params[2].stmt;
                params[0].expr = null;
                return;
            }
            case 55: {
                //# line 268
                params[0].expr = params[2].expr;
                params[0].stmt = params[4].stmt;
                return;
            }
            case 56: {
                //# line 313
                params[0].counter = Tree.OR;
                params[0].loc = params[1].loc;
                return;
            }
            case 57: {
                //# line 940
                params[0].stmt = params[2].stmt;
                return;
            }
            case 58: {
                /* no action */
                return;
            }
            case 59: {
                //# line 120
                params[0].flist = new ArrayList<Tree>();
                if (params[1].vdef != null) {
                    params[0].flist.add(params[1].vdef);
                } else {
                    params[0].flist.add(params[1].fdef);
                }
                params[0].flist.addAll(params[2].flist);
                return;
            }
            case 60: {
                //# line 130
                params[0].flist = new ArrayList<Tree>();
                return;
            }
            case 61: {
                //# line 929
                params[0].slist = new ArrayList<Tree>();
                params[0].slist.add(params[2].stmt);
                if (params[3].slist != null) {
                    params[0].slist.addAll(params[3].slist);
                }
                return;
            }
            case 62: {
                /* no action */
                return;
            }
            case 63: {
                //# line 858
                params[0].elist = new ArrayList<Tree.Expr>();
                params[0].elist.add(params[2].expr);
                params[0].elist.addAll(params[3].elist);
                return;
            }
            case 64: {
                //# line 864
                params[0].elist = new ArrayList<Tree.Expr>();
                return;
            }
            case 65: {
                //# line 510
                if (params[2].svec != null && !params[2].svec.isEmpty()) {
                    params[0].expr = params[2].evec.get(params[2].svec.size() - 1);
                    for (int i = (int)params[2].svec.size() - 2; i >= 0; i--) {
                        params[0].expr = new Tree.Concat(params[2].evec.get(i), params[0].expr, params[2].lvec.get(i + 1));
                    }
                    params[0].expr = new Tree.Concat(params[1].expr, params[0].expr, params[2].lvec.get(0));
                }
                else {
                    params[0].expr = params[1].expr;
                }
                return;
            }
            case 66: {
                //# line 787
                params[0].expr = params[1].expr;
                return;
            }
            case 67: {
                //# line 791
                params[0].expr = new Tree.TypeCast(params[2].ident, params[4].expr, params[4].loc);
                return;
            }
            case 68: {
                //# line 103
                params[0].cdef = new Tree.ClassDef(true, params[3].ident, params[4].ident, params[6].flist, params[1].loc);
                return;
            }
            case 69: {
                //# line 107
                params[0].cdef = new Tree.ClassDef(false, params[2].ident, params[3].ident, params[5].flist, params[1].loc);
                return;
            }
            case 70: {
                //# line 947
                params[0].stmt = new Tree.Return(params[2].expr, params[1].loc);
                return;
            }
            case 71: {
                //# line 850
                params[0].elist = new ArrayList<Tree.Expr>();
                params[0].elist.add(params[1].expr);
                params[0].elist.addAll(params[2].elist);
                return;
            }
            case 72: {
                //# line 191
                params[0].stmt = new Tree.Block(params[2].slist, params[1].loc);
                return;
            }
            case 73: {
                //# line 152
                params[0].vlist = params[2].vlist;
                params[0].stmt = params[4].stmt;
                return;
            }
            case 74: {
                /* no action */
                return;
            }
            case 75: {
                //# line 712
                params[0].elist = params[2].elist;
                return;
            }
            case 76: {
                /* no action */
                return;
            }
            case 77: {
                //# line 28
                params[0].clist = new ArrayList<ClassDef>();
                params[0].clist.add(params[1].cdef);
                if (params[2].clist != null) {
                    params[0].clist.addAll(params[2].clist);
                }
                params[0].prog = new Tree.TopLevel(params[0].clist, params[0].loc);
                return;
            }
            case 78: {
                //# line 417
                params[0].expr = params[1].expr;
                return;
            }
            case 79: {
                //# line 346
                params[0].counter = Tree.ARRAYREPEAT;
                params[0].loc = params[1].loc;
                return;
            }
            case 80: {
                //# line 84
                params[0].type = params[1].type;
                for (int i = 0; i < params[2].counter; ++i) {
                    params[0].type = new Tree.TypeArray(params[0].type, params[1].loc);
                }
                return;
            }
            case 81: {
                //# line 599
                params[0].expr = params[1].expr;
                if (params[2].svec != null) {
                    for (int i = 0; i < params[2].svec.size(); ++i) {
                        params[0].expr = new Tree.Binary(params[2].svec.get(i), params[0].expr,
                            params[2].evec.get(i), params[2].lvec.get(i));
                    }
                }
                return;
            }
            case 82: {
                //# line 761
                params[0].ident = params[1].ident;
                return;
            }
            case 83: {
                //# line 765
                params[0].type = params[1].type;
                for (int i = 0; i < params[3].counter; ++i) {
                    params[0].type = new Tree.TypeArray(params[0].type, params[1].loc);
                }
                params[0].expr = params[3].expr;
                return;
            }
            case 84: {
                //# line 304
                params[0].loc = params[1].loc;
                params[0].expr = params[2].expr;
                return;
            }
            case 85: {
                /* no action */
                return;
            }
            case 86: {
                //# line 113
                params[0].ident = params[2].ident;
                return;
            }
            case 87: {
                /* no action */
                return;
            }
            case 88: {
                //# line 375
                params[0].counter = Tree.PLUS;
                params[0].loc = params[1].loc;
                return;
            }
            case 89: {
                //# line 380
                params[0].counter = Tree.MINUS;
                params[0].loc = params[1].loc;
                return;
            }
            case 90: {
                //# line 93
                params[0].counter = 1 + params[3].counter;
                return;
            }
            case 91: {
                //# line 97
                params[0].counter = 0;
                return;
            }
            case 92: {
                //# line 481
                params[0].expr = params[1].expr;
                if (params[2].svec != null) {
                    for (int i = 0; i < params[2].svec.size(); ++i) {
                        params[0].expr = new Tree.Binary(params[2].svec.get(i), params[0].expr,
                            params[2].evec.get(i), params[2].lvec.get(i));
                    }
                }
                return;
            }
            case 93: {
                //# line 840
                params[0].elist = params[1].elist;
                return;
            }
            case 94: {
                //# line 844
                params[0].elist = new ArrayList<Tree.Expr>();
                return;
            }
            case 95: {
                //# line 542
                params[0].expr = params[1].expr;
                if (params[2].svec != null) {
                    for (int i = 0; i < params[2].svec.size(); ++i) {
                        params[0].expr = new Tree.Repeat(params[0].expr, params[2].evec.get(i), params[2].lvec.get(i));
                    }
                }
                return;
            }
            case 96: {
                //# line 56
                params[0].vdef = new Tree.VarDef(params[2].ident, params[1].type, params[2].loc);
                return;
            }
            case 97: {
                //# line 493
                params[0].svec = new Vector<Integer>();
                params[0].lvec = new Vector<Location>();
                params[0].evec = new Vector<Expr>();
                params[0].svec.add(params[1].counter);
                params[0].lvec.add(params[1].loc);
                params[0].evec.add(params[2].expr);
                if (params[3].svec != null) {
                    params[0].svec.addAll(params[3].svec);
                    params[0].lvec.addAll(params[3].lvec);
                    params[0].evec.addAll(params[3].evec);
                }
                return;
            }
            case 98: {
                /* no action */
                return;
            }
            case 99: {
                //# line 205
                params[0].stmt = params[1].vdef;
                return;
            }
            case 100: {
                //# line 209
                if (params[1].stmt == null) {
                    params[0].stmt = new Tree.Skip(params[2].loc);
                } else {
                    params[0].stmt = params[1].stmt;
                }
                return;
            }
            case 101: {
                //# line 217
                params[0].stmt = params[1].stmt;
                return;
            }
            case 102: {
                //# line 221
                params[0].stmt = params[1].stmt;
                return;
            }
            case 103: {
                //# line 225
                params[0].stmt = params[1].stmt;
                return;
            }
            case 104: {
                //# line 229
                params[0].stmt = params[1].stmt;
                return;
            }
            case 105: {
                //# line 233
                params[0].stmt = params[1].stmt;
                return;
            }
            case 106: {
                //# line 237
                params[0].stmt = params[1].stmt;
                return;
            }
            case 107: {
                //# line 241
                params[0].stmt = params[1].stmt;
                return;
            }
            case 108: {
                //# line 245
                params[0].stmt = params[1].stmt;
                return;
            }
            case 109: {
                //# line 249
                if(params[6].expr==null)
                {
                    params[0].stmt = new Tree.ArrayFor(false, params[3].lvalue, params[5].expr, params[6].stmt, null, params[1].loc);
                }
                else
                {
                    params[0].stmt = new Tree.ArrayFor(true, params[3].lvalue, params[5].expr, params[6].stmt, params[6].expr, params[1].loc);
                }
                return;
            }
            case 110: {
                //# line 286
                if (params[2].expr == null) {
                    params[0].stmt = new Tree.Calculate(params[1].expr, params[1].loc);
                } else {
                    params[0].stmt = new Tree.Assign(params[1].expr, params[2].expr, params[2].loc);
                }
                return;
            }
            case 111: {
                //# line 294
                params[0].stmt = new Tree.Assign(true, params[2].ident, params[4].expr, params[1].loc);
                if (params[4].expr == null) {
                    params[0].loc = params[2].loc;
                }
                return;
            }
            case 112: {
                /* no action */
                return;
            }
            case 113: {
                //# line 62
                params[0].type = new Tree.TypeIdent(Tree.INT, params[1].loc);
                return;
            }
            case 114: {
                //# line 66
                params[0].type = new Tree.TypeIdent(Tree.VOID, params[1].loc);
                return;
            }
            case 115: {
                //# line 70
                params[0].type = new Tree.TypeIdent(Tree.BOOL, params[1].loc);
                return;
            }
            case 116: {
                //# line 74
                params[0].type = new Tree.TypeIdent(Tree.STRING, params[1].loc);
                return;
            }
            case 117: {
                //# line 78
                params[0].type = new Tree.TypeClass(params[2].ident, params[1].loc);
                return;
            }
            case 118: {
                //# line 871
                params[0].stmt = new Tree.WhileLoop(params[3].expr, params[5].stmt, params[1].loc);
                return;
            }
            case 119: {
                //# line 435
                params[0].svec = new Vector<Integer>();
                params[0].lvec = new Vector<Location>();
                params[0].evec = new Vector<Expr>();
                params[0].svec.add(params[1].counter);
                params[0].lvec.add(params[1].loc);
                params[0].evec.add(params[2].expr);
                if (params[3].svec != null) {
                    params[0].svec.addAll(params[3].svec);
                    params[0].lvec.addAll(params[3].lvec);
                    params[0].evec.addAll(params[3].evec);
                }
                return;
            }
            case 120: {
                /* no action */
                return;
            }
            case 121: {
                //# line 570
                params[0].expr = params[1].expr;
                if (params[2].svec != null) {
                    for (int i = 0; i < params[2].svec.size(); ++i) {
                        params[0].expr = new Tree.Binary(params[2].svec.get(i), params[0].expr,
                            params[2].evec.get(i), params[2].lvec.get(i));
                    }
                }
                return;
            }
            case 122: {
                //# line 582
                params[0].svec = new Vector<Integer>();
                params[0].lvec = new Vector<Location>();
                params[0].evec = new Vector<Expr>();
                params[0].svec.add(params[1].counter);
                params[0].lvec.add(params[1].loc);
                params[0].evec.add(params[2].expr);
                if (params[3].svec != null) {
                    params[0].svec.addAll(params[3].svec);
                    params[0].lvec.addAll(params[3].lvec);
                    params[0].evec.addAll(params[3].evec);
                }
                return;
            }
            case 123: {
                /* no action */
                return;
            }
            case 124: {
                //# line 953
                params[0].expr = params[1].expr;
                return;
            }
            case 125: {
                /* no action */
                return;
            }
            case 126: {
                //# line 890
                params[0].stmt = params[2].stmt;
                return;
            }
            case 127: {
                //# line 966
                params[0].stmt = new Tree.Scopy(params[3].ident, params[5].expr, params[3].loc);
                return;
            }
            case 128: {
                //# line 640
                params[0].svec = new Vector<Integer>();
                params[0].lvec = new Vector<Location>();
                params[0].evec = new Vector<Expr>();
                params[0].svec.add(params[1].counter);
                params[0].lvec.add(params[1].loc);
                params[0].evec.add(params[2].expr);
                if (params[3].svec != null) {
                    params[0].svec.addAll(params[3].svec);
                    params[0].lvec.addAll(params[3].lvec);
                    params[0].evec.addAll(params[3].evec);
                }
                return;
            }
            case 129: {
                /* no action */
                return;
            }
            case 130: {
                //# line 687
                SemValue sem = new SemValue();
                sem.expr = params[2].expr;
                params[0].vec = new Vector<SemValue>();
                params[0].vec.add(sem);
                if (params[4].vec != null) {
                    params[0].vec.addAll(params[4].vec);
                }
                return;
            }
            case 131: {
                //# line 697
                SemValue sem = new SemValue();
                sem.ident = params[2].ident;
                sem.loc = params[2].loc;
                sem.elist = params[3].elist;
                params[0].vec = new Vector<SemValue>();
                params[0].vec.add(sem);
                if (params[4].vec != null) {
                    params[0].vec.addAll(params[4].vec);
                }
                return;
            }
            case 132: {
                /* no action */
                return;
            }
            case 133: {
                //# line 657
                params[0].expr = new Tree.Unary(params[1].counter, params[2].expr, params[1].loc);
                return;
            }
            case 134: {
                //# line 661
                params[0].expr = params[1].expr;
                return;
            }
            case 135: {
                //# line 39
                params[0].clist = new ArrayList<ClassDef>();
                params[0].clist.add(params[1].cdef);
                if (params[2].clist != null) {
                    params[0].clist.addAll(params[2].clist);
                }
                return;
            }
            case 136: {
                /* no action */
                return;
            }
            case 137: {
                //# line 353
                params[0].counter = Tree.LE;
                params[0].loc = params[1].loc;
                return;
            }
            case 138: {
                //# line 358
                params[0].counter = Tree.GE;
                params[0].loc = params[1].loc;
                return;
            }
            case 139: {
                //# line 363
                params[0].counter = Tree.LT;
                params[0].loc = params[1].loc;
                return;
            }
            case 140: {
                //# line 368
                params[0].counter = Tree.GT;
                params[0].loc = params[1].loc;
                return;
            }
            case 141: {
                //# line 923
                params[0].stmt = new Tree.IfG(params[1].expr, params[3].stmt, params[2].loc);
                return;
            }
            case 142: {
                //# line 136
                params[0].fdef = new Tree.MethodDef(true, params[3].ident, params[2].type, params[5].vlist,
                    (Block) params[7].stmt, params[3].loc);
                return;
            }
            case 143: {
                //# line 141
                if (params[3].vlist != null) {
                    params[0].fdef = new Tree.MethodDef(false, params[2].ident, params[1].type, params[3].vlist,
                        (Block) params[3].stmt, params[2].loc);
                } else {
                    params[0].vdef = new Tree.VarDef(params[2].ident, params[1].type, params[2].loc);
                }
                return;
            }
        }
    }
}
/* end of file */
