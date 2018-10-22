/* This is auto-generated source by LL1-Parser-Gen.
 * Specification file: /Users/sherilynw/Desktop/3_1/编译原理/decaf/decaf_PA1_B/src/decaf/frontend/Parser.spec
 * Options: unstrict mode
 * Generated at: Mon Oct 22 21:06:22 CST 2018
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
    public static final int Expr2 = 304;
    public static final int Oper2 = 305;
    public static final int Expr6 = 306;
    public static final int BreakStmt = 307;
    public static final int ExprT2 = 308;
    public static final int StmtList = 309;
    public static final int Constant = 310;
    public static final int SubVariableList = 311;
    public static final int PrintStmt = 312;
    public static final int ForStmt = 313;
    public static final int Expr9 = 314;
    public static final int Expr1 = 315;
    public static final int ForeachStmt = 316;
    public static final int GuardedStmt = 317;
    public static final int Oper1 = 318;
    public static final int ElseClause = 319;
    public static final int FieldList = 320;
    public static final int SubExprList = 321;
    public static final int AfterParenExpr = 322;
    public static final int ClassDef = 323;
    public static final int ReturnStmt = 324;
    public static final int ExprList = 325;
    public static final int IfBranchG = 326;
    public static final int StmtBlock = 327;
    public static final int FunctionField = 328;
    public static final int AfterIdentExpr = 329;
    public static final int Program = 330;
    public static final int Expr = 331;
    public static final int IfStmtG = 332;
    public static final int Type = 333;
    public static final int Expr5 = 334;
    public static final int AfterNewExpr = 335;
    public static final int Assignment = 336;
    public static final int ExtendsClause = 337;
    public static final int Oper5 = 338;
    public static final int ArrayType = 339;
    public static final int Expr3 = 340;
    public static final int Actuals = 341;
    public static final int Variable = 342;
    public static final int ExprT3 = 343;
    public static final int Stmt = 344;
    public static final int SimpleStmt = 345;
    public static final int SimpleType = 346;
    public static final int WhileStmt = 347;
    public static final int ExprT1 = 348;
    public static final int Expr4 = 349;
    public static final int ExprT4 = 350;
    public static final int ReturnExpr = 351;
    public static final int IfStmt = 352;
    public static final int OCStmt = 353;
    public static final int ExprT6 = 354;
    public static final int ExprT8 = 355;
    public static final int Expr7 = 356;
    public static final int ClassList = 357;
    public static final int Oper4 = 358;
    public static final int Field = 359;
    
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
        "Expr8", "AfterSimpleTypeExpr", "Expr2", "Oper2", "Expr6",
        "BreakStmt", "ExprT2", "StmtList", "Constant", "SubVariableList",
        "PrintStmt", "ForStmt", "Expr9", "Expr1", "ForeachStmt",
        "GuardedStmt", "Oper1", "ElseClause", "FieldList", "SubExprList",
        "AfterParenExpr", "ClassDef", "ReturnStmt", "ExprList", "IfBranchG",
        "StmtBlock", "FunctionField", "AfterIdentExpr", "Program", "Expr",
        "IfStmtG", "Type", "Expr5", "AfterNewExpr", "Assignment",
        "ExtendsClause", "Oper5", "ArrayType", "Expr3", "Actuals",
        "Variable", "ExprT3", "Stmt", "SimpleStmt", "SimpleType",
        "WhileStmt", "ExprT1", "Expr4", "ExprT4", "ReturnExpr",
        "IfStmt", "OCStmt", "ExprT6", "ExprT8", "Expr7",
        "ClassList", "Oper4", "Field",
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
        {Integer.valueOf('+'), Integer.valueOf('-'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, AND, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {VAR, VOID, CLASS, INT, STRING, BOOL},
        {EQUAL, NOT_EQUAL},
        {Integer.valueOf('*'), Integer.valueOf('/'), Integer.valueOf('%')},
        {VOID, CLASS, INT, STRING, BOOL},
        {VOID, CLASS, INT, STRING, BOOL, Integer.valueOf(')')},
        {Integer.valueOf('-'), Integer.valueOf('!')},
        {READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), READ_INTEGER},
        {Integer.valueOf(']'), Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), READ_INTEGER},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), READ_INTEGER},
        {AND},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), READ_INTEGER},
        {BREAK},
        {AND, Integer.valueOf(']'), Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, Integer.valueOf(';')},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, IDENTIFIER, NEW, IF, THIS, INSTANCEOF, STRING, LITERAL, Integer.valueOf('('), Integer.valueOf(';'), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{'), Integer.valueOf('}')},
        {LITERAL, NULL},
        {Integer.valueOf(','), Integer.valueOf(')')},
        {PRINT},
        {FOR},
        {LITERAL, NULL, READ_INTEGER, READ_LINE, THIS, NEW, INSTANCEOF, Integer.valueOf('('), IDENTIFIER},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), READ_INTEGER},
        {FOREACH},
        {IF},
        {OR},
        {ELSE, PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, NEW, IF, THIS, DIVIDER, INSTANCEOF, STRING, LITERAL, Integer.valueOf('('), Integer.valueOf(';'), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {VOID, CLASS, INT, STRING, STATIC, BOOL, Integer.valueOf('}')},
        {Integer.valueOf(','), Integer.valueOf(')')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), READ_INTEGER, CLASS},
        {SEALED, CLASS},
        {RETURN},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), READ_INTEGER},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), READ_INTEGER},
        {Integer.valueOf('{')},
        {Integer.valueOf('('), Integer.valueOf(';')},
        {Integer.valueOf('('), Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {SEALED, CLASS},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), READ_INTEGER},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), READ_INTEGER},
        {VOID, CLASS, INT, STRING, BOOL},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), READ_INTEGER},
        {IDENTIFIER, VOID, CLASS, INT, STRING, BOOL},
        {Integer.valueOf('='), Integer.valueOf(';'), Integer.valueOf(')')},
        {EXTENDS, Integer.valueOf('{')},
        {Integer.valueOf('+'), Integer.valueOf('-')},
        {Integer.valueOf('['), IDENTIFIER},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), READ_INTEGER},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), READ_INTEGER, Integer.valueOf(')')},
        {VOID, CLASS, INT, STRING, BOOL},
        {EQUAL, NOT_EQUAL, Integer.valueOf(']'), Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, AND, Integer.valueOf(';')},
        {FOREACH, SCOPY, IF, VOID, CLASS, INT, STRING, BOOL, Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf(';'), READ_INTEGER, WHILE, FOR, RETURN, PRINT, BREAK, Integer.valueOf('{')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), READ_INTEGER, Integer.valueOf(';'), Integer.valueOf(')')},
        {INT, VOID, BOOL, STRING, CLASS},
        {WHILE},
        {OR, Integer.valueOf(']'), Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), Integer.valueOf(';')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), READ_INTEGER},
        {LESS_EQUAL, GREATER_EQUAL, Integer.valueOf('<'), Integer.valueOf('>'), Integer.valueOf(']'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, AND, Integer.valueOf(';')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), READ_INTEGER, Integer.valueOf(';')},
        {IF},
        {SCOPY},
        {Integer.valueOf('*'), Integer.valueOf('/'), Integer.valueOf('%'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {Integer.valueOf('['), Integer.valueOf('.'), Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf('-'), Integer.valueOf('!'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), READ_INTEGER},
        {SEALED, CLASS, eof, eos},
        {LESS_EQUAL, GREATER_EQUAL, Integer.valueOf('<'), Integer.valueOf('>')},
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
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, NEW, IF, THIS, DIVIDER, INSTANCEOF, STRING, LITERAL, ELSE, Integer.valueOf('('), Integer.valueOf(';'), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, AND, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {IN},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), READ_INTEGER},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), READ_INTEGER},
        {Integer.valueOf(')')},
        {Integer.valueOf(')')},
        {READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), READ_INTEGER},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf(']'), Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, Integer.valueOf(';')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), READ_INTEGER},
        {LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {Integer.valueOf(';')},
        {Integer.valueOf(']'), Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, Integer.valueOf(';')},
        {Integer.valueOf('}')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf(')')},
        {Integer.valueOf(';')},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, NEW, IF, THIS, DIVIDER, INSTANCEOF, STRING, LITERAL, ELSE, Integer.valueOf('('), Integer.valueOf(';'), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf(']'), Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), Integer.valueOf(';')},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, NEW, IF, THIS, DIVIDER, INSTANCEOF, STRING, LITERAL, ELSE, Integer.valueOf('('), Integer.valueOf(';'), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, NEW, IF, THIS, DIVIDER, INSTANCEOF, STRING, LITERAL, ELSE, Integer.valueOf('('), Integer.valueOf(';'), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), READ_INTEGER},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, NEW, IF, THIS, DIVIDER, INSTANCEOF, STRING, LITERAL, ELSE, Integer.valueOf('('), Integer.valueOf(';'), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {Integer.valueOf('}')},
        {Integer.valueOf(')')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {SEALED, CLASS, eof, eos},
        {Integer.valueOf(';')},
        {Integer.valueOf(')')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), READ_INTEGER},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, NEW, IF, THIS, DIVIDER, INSTANCEOF, STRING, LITERAL, STATIC, ELSE, Integer.valueOf('('), Integer.valueOf(';'), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {VOID, CLASS, INT, Integer.valueOf('}'), STRING, STATIC, BOOL},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {eof, eos},
        {Integer.valueOf(']'), Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), Integer.valueOf(';')},
        {Integer.valueOf('}'), DIVIDER},
        {IDENTIFIER},
        {LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, AND, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf(';'), Integer.valueOf(')')},
        {Integer.valueOf('{')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), READ_INTEGER},
        {IDENTIFIER},
        {Integer.valueOf(']'), Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, AND, Integer.valueOf(';')},
        {Integer.valueOf(')')},
        {Integer.valueOf(';'), Integer.valueOf(','), Integer.valueOf(')')},
        {Integer.valueOf(']'), Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, AND, Integer.valueOf(';')},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, NEW, IF, THIS, DIVIDER, INSTANCEOF, STRING, LITERAL, ELSE, Integer.valueOf('('), Integer.valueOf(';'), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {Integer.valueOf(';'), Integer.valueOf(')')},
        {Integer.valueOf('['), IDENTIFIER},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, NEW, IF, THIS, DIVIDER, INSTANCEOF, STRING, LITERAL, ELSE, Integer.valueOf('('), Integer.valueOf(';'), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {Integer.valueOf(']'), Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), Integer.valueOf(';')},
        {Integer.valueOf(']'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, AND, Integer.valueOf(';')},
        {Integer.valueOf(']'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, AND, Integer.valueOf(';')},
        {Integer.valueOf(';')},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, NEW, IF, THIS, DIVIDER, INSTANCEOF, STRING, LITERAL, ELSE, Integer.valueOf('('), Integer.valueOf(';'), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {Integer.valueOf(';')},
        {LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), GREATER_EQUAL, Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, Integer.valueOf('+'), AND, Integer.valueOf('*'), Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>'), Integer.valueOf('%')},
        {eof, eos},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), READ_INTEGER},
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
        for (int i = 0; i < 66; i++) {
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
            //# line 50
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
            //# line 555
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
                    case WHILE:
                    case '=':
                    case OR:
                    case AND:
                    case ';':
                    case '<':
                    case '>':
                        return new AbstractMap.SimpleEntry<>(119, Arrays.asList());
                    default: return null;
                }
            }
            //# line 288
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
            //# line 344
            case Oper3: {
                switch (lookahead) {
                    case EQUAL:
                        return new AbstractMap.SimpleEntry<>(5, Arrays.asList(EQUAL));
                    case NOT_EQUAL:
                        return new AbstractMap.SimpleEntry<>(6, Arrays.asList(NOT_EQUAL));
                    default: return null;
                }
            }
            //# line 390
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
            //# line 171
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
            //# line 161
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
            //# line 407
            case Oper7: {
                switch (lookahead) {
                    case '-':
                        return new AbstractMap.SimpleEntry<>(13, Arrays.asList(Integer.valueOf('-')));
                    case '!':
                        return new AbstractMap.SimpleEntry<>(14, Arrays.asList(Integer.valueOf('!')));
                    default: return null;
                }
            }
            //# line 611
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
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(15, Arrays.asList(Expr9, ExprT8));
                    default: return null;
                }
            }
            //# line 719
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
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(17, Arrays.asList(Expr, Integer.valueOf(']')));
                    default: return null;
                }
            }
            //# line 455
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
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(18, Arrays.asList(Expr3, ExprT2));
                    default: return null;
                }
            }
            //# line 337
            case Oper2: {
                switch (lookahead) {
                    case AND:
                        return new AbstractMap.SimpleEntry<>(19, Arrays.asList(AND));
                    default: return null;
                }
            }
            //# line 572
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
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(20, Arrays.asList(Expr7, ExprT6));
                    default: return null;
                }
            }
            //# line 796
            case BreakStmt: {
                switch (lookahead) {
                    case BREAK:
                        return new AbstractMap.SimpleEntry<>(21, Arrays.asList(BREAK));
                    default: return null;
                }
            }
            //# line 467
            case ExprT2: {
                switch (lookahead) {
                    case AND:
                        return new AbstractMap.SimpleEntry<>(22, Arrays.asList(Oper2, Expr3, ExprT2));
                    case ']':
                    case ':':
                    case ')':
                    case ',':
                    case WHILE:
                    case '=':
                    case OR:
                    case ';':
                        return new AbstractMap.SimpleEntry<>(119, Arrays.asList());
                    default: return null;
                }
            }
            //# line 198
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
                    case THIS:
                    case INSTANCEOF:
                    case STRING:
                    case LITERAL:
                    case '(':
                    case ';':
                    case BOOL:
                    case BREAK:
                    case READ_INTEGER:
                    case '{':
                        return new AbstractMap.SimpleEntry<>(24, Arrays.asList(Stmt, StmtList));
                    case '}':
                        return new AbstractMap.SimpleEntry<>(119, Arrays.asList());
                    default: return null;
                }
            }
            //# line 743
            case Constant: {
                switch (lookahead) {
                    case LITERAL:
                        return new AbstractMap.SimpleEntry<>(26, Arrays.asList(LITERAL));
                    case NULL:
                        return new AbstractMap.SimpleEntry<>(27, Arrays.asList(NULL));
                    default: return null;
                }
            }
            //# line 181
            case SubVariableList: {
                switch (lookahead) {
                    case ',':
                        return new AbstractMap.SimpleEntry<>(28, Arrays.asList(Integer.valueOf(','), Variable, SubVariableList));
                    case ')':
                        return new AbstractMap.SimpleEntry<>(119, Arrays.asList());
                    default: return null;
                }
            }
            //# line 828
            case PrintStmt: {
                switch (lookahead) {
                    case PRINT:
                        return new AbstractMap.SimpleEntry<>(30, Arrays.asList(PRINT, Integer.valueOf('('), ExprList, Integer.valueOf(')')));
                    default: return null;
                }
            }
            //# line 790
            case ForStmt: {
                switch (lookahead) {
                    case FOR:
                        return new AbstractMap.SimpleEntry<>(31, Arrays.asList(FOR, Integer.valueOf('('), SimpleStmt, Integer.valueOf(';'), Expr, Integer.valueOf(';'), SimpleStmt, Integer.valueOf(')'), Stmt));
                    default: return null;
                }
            }
            //# line 663
            case Expr9: {
                switch (lookahead) {
                    case LITERAL:
                    case NULL:
                        return new AbstractMap.SimpleEntry<>(32, Arrays.asList(Constant));
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(33, Arrays.asList(READ_INTEGER, Integer.valueOf('('), Integer.valueOf(')')));
                    case READ_LINE:
                        return new AbstractMap.SimpleEntry<>(34, Arrays.asList(READ_LINE, Integer.valueOf('('), Integer.valueOf(')')));
                    case THIS:
                        return new AbstractMap.SimpleEntry<>(35, Arrays.asList(THIS));
                    case NEW:
                        return new AbstractMap.SimpleEntry<>(36, Arrays.asList(NEW, AfterNewExpr));
                    case INSTANCEOF:
                        return new AbstractMap.SimpleEntry<>(37, Arrays.asList(INSTANCEOF, Integer.valueOf('('), Expr, Integer.valueOf(','), IDENTIFIER, Integer.valueOf(')')));
                    case '(':
                        return new AbstractMap.SimpleEntry<>(38, Arrays.asList(Integer.valueOf('('), AfterParenExpr));
                    case IDENTIFIER:
                        return new AbstractMap.SimpleEntry<>(39, Arrays.asList(IDENTIFIER, AfterIdentExpr));
                    default: return null;
                }
            }
            //# line 426
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
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(40, Arrays.asList(Expr2, ExprT1));
                    default: return null;
                }
            }
            //# line 278
            case ForeachStmt: {
                switch (lookahead) {
                    case FOREACH:
                        return new AbstractMap.SimpleEntry<>(41, Arrays.asList(FOREACH, Integer.valueOf('('), BoundVariable, IN, Expr, Integer.valueOf(')'), Stmt));
                    default: return null;
                }
            }
            //# line 299
            case GuardedStmt: {
                switch (lookahead) {
                    case IF:
                        return new AbstractMap.SimpleEntry<>(42, Arrays.asList(IF, Integer.valueOf('{'), IfBranchG, IfStmtG, Integer.valueOf('}')));
                    default: return null;
                }
            }
            //# line 271
            case Oper1: {
                switch (lookahead) {
                    case OR:
                        return new AbstractMap.SimpleEntry<>(43, Arrays.asList(OR));
                    default: return null;
                }
            }
            //# line 808
            case ElseClause: {
                switch (lookahead) {
                    case ELSE:
                        return new AbstractMap.SimpleEntry<>(44, Arrays.asList(ELSE, Stmt));
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
                    case THIS:
                    case DIVIDER:
                    case INSTANCEOF:
                    case STRING:
                    case LITERAL:
                    case '(':
                    case ';':
                    case BOOL:
                    case BREAK:
                    case READ_INTEGER:
                    case '{':
                        return new AbstractMap.SimpleEntry<>(119, Arrays.asList());
                    default: return null;
                }
            }
            //# line 121
            case FieldList: {
                switch (lookahead) {
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case STATIC:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(46, Arrays.asList(Field, FieldList));
                    case '}':
                        return new AbstractMap.SimpleEntry<>(47, Arrays.asList());
                    default: return null;
                }
            }
            //# line 771
            case SubExprList: {
                switch (lookahead) {
                    case ',':
                        return new AbstractMap.SimpleEntry<>(48, Arrays.asList(Integer.valueOf(','), Expr, SubExprList));
                    case ')':
                        return new AbstractMap.SimpleEntry<>(49, Arrays.asList());
                    default: return null;
                }
            }
            //# line 731
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
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(50, Arrays.asList(Expr, Integer.valueOf(')')));
                    case CLASS:
                        return new AbstractMap.SimpleEntry<>(51, Arrays.asList(CLASS, IDENTIFIER, Integer.valueOf(')'), Expr9));
                    default: return null;
                }
            }
            //# line 104
            case ClassDef: {
                switch (lookahead) {
                    case SEALED:
                        return new AbstractMap.SimpleEntry<>(52, Arrays.asList(SEALED, CLASS, IDENTIFIER, ExtendsClause, Integer.valueOf('{'), FieldList, Integer.valueOf('}')));
                    case CLASS:
                        return new AbstractMap.SimpleEntry<>(53, Arrays.asList(CLASS, IDENTIFIER, ExtendsClause, Integer.valueOf('{'), FieldList, Integer.valueOf('}')));
                    default: return null;
                }
            }
            //# line 815
            case ReturnStmt: {
                switch (lookahead) {
                    case RETURN:
                        return new AbstractMap.SimpleEntry<>(54, Arrays.asList(RETURN, ReturnExpr));
                    default: return null;
                }
            }
            //# line 763
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
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(55, Arrays.asList(Expr, SubExprList));
                    default: return null;
                }
            }
            //# line 311
            case IfBranchG: {
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
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(56, Arrays.asList(IfBranchG, IfStmtG, DIVIDER));
                    default: return null;
                }
            }
            //# line 192
            case StmtBlock: {
                switch (lookahead) {
                    case '{':
                        return new AbstractMap.SimpleEntry<>(57, Arrays.asList(Integer.valueOf('{'), StmtList, Integer.valueOf('}')));
                    default: return null;
                }
            }
            //# line 153
            case FunctionField: {
                switch (lookahead) {
                    case '(':
                        return new AbstractMap.SimpleEntry<>(58, Arrays.asList(Integer.valueOf('('), Formals, Integer.valueOf(')'), StmtBlock));
                    case ';':
                        return new AbstractMap.SimpleEntry<>(119, Arrays.asList(Integer.valueOf(';')));
                    default: return null;
                }
            }
            //# line 656
            case AfterIdentExpr: {
                switch (lookahead) {
                    case '(':
                        return new AbstractMap.SimpleEntry<>(60, Arrays.asList(Integer.valueOf('('), Actuals, Integer.valueOf(')')));
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
                    case WHILE:
                    case '=':
                    case OR:
                    case '+':
                    case AND:
                    case '*':
                    case ';':
                    case '<':
                    case '[':
                    case '>':
                    case '%':
                        return new AbstractMap.SimpleEntry<>(119, Arrays.asList());
                    default: return null;
                }
            }
            //# line 28
            case Program: {
                switch (lookahead) {
                    case SEALED:
                    case CLASS:
                        return new AbstractMap.SimpleEntry<>(62, Arrays.asList(ClassDef, ClassList));
                    default: return null;
                }
            }
            //# line 420
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
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(63, Arrays.asList(Expr1));
                    default: return null;
                }
            }
            //# line 322
            case IfStmtG: {
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
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(64, Arrays.asList(Expr, Integer.valueOf(':'), Stmt));
                    default: return null;
                }
            }
            //# line 84
            case Type: {
                switch (lookahead) {
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(65, Arrays.asList(SimpleType, ArrayType));
                    default: return null;
                }
            }
            //# line 543
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
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(66, Arrays.asList(Expr6, ExprT5));
                    default: return null;
                }
            }
            //# line 705
            case AfterNewExpr: {
                switch (lookahead) {
                    case IDENTIFIER:
                        return new AbstractMap.SimpleEntry<>(67, Arrays.asList(IDENTIFIER, Integer.valueOf('('), Integer.valueOf(')')));
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(68, Arrays.asList(SimpleType, Integer.valueOf('['), AfterSimpleTypeExpr));
                    default: return null;
                }
            }
            //# line 262
            case Assignment: {
                switch (lookahead) {
                    case '=':
                        return new AbstractMap.SimpleEntry<>(69, Arrays.asList(Integer.valueOf('='), Expr));
                    case ';':
                    case ')':
                        return new AbstractMap.SimpleEntry<>(119, Arrays.asList());
                    default: return null;
                }
            }
            //# line 114
            case ExtendsClause: {
                switch (lookahead) {
                    case EXTENDS:
                        return new AbstractMap.SimpleEntry<>(71, Arrays.asList(EXTENDS, IDENTIFIER));
                    case '{':
                        return new AbstractMap.SimpleEntry<>(119, Arrays.asList());
                    default: return null;
                }
            }
            //# line 378
            case Oper5: {
                switch (lookahead) {
                    case '+':
                        return new AbstractMap.SimpleEntry<>(73, Arrays.asList(Integer.valueOf('+')));
                    case '-':
                        return new AbstractMap.SimpleEntry<>(74, Arrays.asList(Integer.valueOf('-')));
                    default: return null;
                }
            }
            //# line 93
            case ArrayType: {
                switch (lookahead) {
                    case '[':
                        return new AbstractMap.SimpleEntry<>(75, Arrays.asList(Integer.valueOf('['), Integer.valueOf(']'), ArrayType));
                    case IDENTIFIER:
                        return new AbstractMap.SimpleEntry<>(76, Arrays.asList());
                    default: return null;
                }
            }
            //# line 484
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
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(77, Arrays.asList(Expr4, ExprT3));
                    default: return null;
                }
            }
            //# line 753
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
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(78, Arrays.asList(ExprList));
                    case ')':
                        return new AbstractMap.SimpleEntry<>(79, Arrays.asList());
                    default: return null;
                }
            }
            //# line 56
            case Variable: {
                switch (lookahead) {
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(80, Arrays.asList(Type, IDENTIFIER));
                    default: return null;
                }
            }
            //# line 497
            case ExprT3: {
                switch (lookahead) {
                    case EQUAL:
                    case NOT_EQUAL:
                        return new AbstractMap.SimpleEntry<>(81, Arrays.asList(Oper3, Expr4, ExprT3));
                    case ']':
                    case ':':
                    case ')':
                    case ',':
                    case WHILE:
                    case '=':
                    case OR:
                    case AND:
                    case ';':
                        return new AbstractMap.SimpleEntry<>(119, Arrays.asList());
                    default: return null;
                }
            }
            //# line 206
            case Stmt: {
                switch (lookahead) {
                    case FOREACH:
                        return new AbstractMap.SimpleEntry<>(119, Arrays.asList(ForeachStmt));
                    case SCOPY:
                        return new AbstractMap.SimpleEntry<>(119, Arrays.asList(OCStmt, Integer.valueOf(';')));
                    case IF:
                        return new AbstractMap.SimpleEntry<>(119, Arrays.asList(GuardedStmt));
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(86, Arrays.asList(VariableDef));
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
                    case ';':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(87, Arrays.asList(SimpleStmt, Integer.valueOf(';')));
                    case WHILE:
                        return new AbstractMap.SimpleEntry<>(88, Arrays.asList(WhileStmt));
                    case FOR:
                        return new AbstractMap.SimpleEntry<>(89, Arrays.asList(ForStmt));
                    case RETURN:
                        return new AbstractMap.SimpleEntry<>(90, Arrays.asList(ReturnStmt, Integer.valueOf(';')));
                    case PRINT:
                        return new AbstractMap.SimpleEntry<>(91, Arrays.asList(PrintStmt, Integer.valueOf(';')));
                    case BREAK:
                        return new AbstractMap.SimpleEntry<>(92, Arrays.asList(BreakStmt, Integer.valueOf(';')));
                    case '{':
                        return new AbstractMap.SimpleEntry<>(93, Arrays.asList(StmtBlock));
                    default: return null;
                }
            }
            //# line 251
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
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(94, Arrays.asList(Expr, Assignment));
                    case ';':
                    case ')':
                        return new AbstractMap.SimpleEntry<>(119, Arrays.asList());
                    default: return null;
                }
            }
            //# line 62
            case SimpleType: {
                switch (lookahead) {
                    case INT:
                        return new AbstractMap.SimpleEntry<>(96, Arrays.asList(INT));
                    case VOID:
                        return new AbstractMap.SimpleEntry<>(97, Arrays.asList(VOID));
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(98, Arrays.asList(BOOL));
                    case STRING:
                        return new AbstractMap.SimpleEntry<>(99, Arrays.asList(STRING));
                    case CLASS:
                        return new AbstractMap.SimpleEntry<>(100, Arrays.asList(CLASS, IDENTIFIER));
                    default: return null;
                }
            }
            //# line 784
            case WhileStmt: {
                switch (lookahead) {
                    case WHILE:
                        return new AbstractMap.SimpleEntry<>(101, Arrays.asList(WHILE, Integer.valueOf('('), Expr, Integer.valueOf(')'), Stmt));
                    default: return null;
                }
            }
            //# line 438
            case ExprT1: {
                switch (lookahead) {
                    case OR:
                        return new AbstractMap.SimpleEntry<>(102, Arrays.asList(Oper1, Expr2, ExprT1));
                    case ']':
                    case ':':
                    case ')':
                    case ',':
                    case WHILE:
                    case '=':
                    case ';':
                        return new AbstractMap.SimpleEntry<>(119, Arrays.asList());
                    default: return null;
                }
            }
            //# line 514
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
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(104, Arrays.asList(Expr5, ExprT4));
                    default: return null;
                }
            }
            //# line 526
            case ExprT4: {
                switch (lookahead) {
                    case LESS_EQUAL:
                    case GREATER_EQUAL:
                    case '<':
                    case '>':
                        return new AbstractMap.SimpleEntry<>(105, Arrays.asList(Oper4, Expr5, ExprT4));
                    case ']':
                    case ':':
                    case EQUAL:
                    case ')':
                    case NOT_EQUAL:
                    case ',':
                    case WHILE:
                    case '=':
                    case OR:
                    case AND:
                    case ';':
                        return new AbstractMap.SimpleEntry<>(119, Arrays.asList());
                    default: return null;
                }
            }
            //# line 821
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
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(107, Arrays.asList(Expr));
                    case ';':
                        return new AbstractMap.SimpleEntry<>(119, Arrays.asList());
                    default: return null;
                }
            }
            //# line 802
            case IfStmt: {
                switch (lookahead) {
                    case IF:
                        return new AbstractMap.SimpleEntry<>(109, Arrays.asList(IF, Integer.valueOf('('), Expr, Integer.valueOf(')'), Stmt, ElseClause));
                    default: return null;
                }
            }
            //# line 329
            case OCStmt: {
                switch (lookahead) {
                    case SCOPY:
                        return new AbstractMap.SimpleEntry<>(110, Arrays.asList(SCOPY, Integer.valueOf('('), IDENTIFIER, Integer.valueOf(','), Expr, Integer.valueOf(')')));
                    default: return null;
                }
            }
            //# line 584
            case ExprT6: {
                switch (lookahead) {
                    case '*':
                    case '/':
                    case '%':
                        return new AbstractMap.SimpleEntry<>(111, Arrays.asList(Oper6, Expr7, ExprT6));
                    case LESS_EQUAL:
                    case ']':
                    case GREATER_EQUAL:
                    case '-':
                    case ':':
                    case EQUAL:
                    case ')':
                    case NOT_EQUAL:
                    case ',':
                    case WHILE:
                    case '=':
                    case OR:
                    case '+':
                    case AND:
                    case ';':
                    case '<':
                    case '>':
                        return new AbstractMap.SimpleEntry<>(119, Arrays.asList());
                    default: return null;
                }
            }
            //# line 631
            case ExprT8: {
                switch (lookahead) {
                    case '[':
                        return new AbstractMap.SimpleEntry<>(113, Arrays.asList(Integer.valueOf('['), Expr, Integer.valueOf(']'), ExprT8));
                    case '.':
                        return new AbstractMap.SimpleEntry<>(114, Arrays.asList(Integer.valueOf('.'), IDENTIFIER, AfterIdentExpr, ExprT8));
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
                    case WHILE:
                    case '=':
                    case OR:
                    case '+':
                    case AND:
                    case '*':
                    case ';':
                    case '<':
                    case '>':
                    case '%':
                        return new AbstractMap.SimpleEntry<>(119, Arrays.asList());
                    default: return null;
                }
            }
            //# line 601
            case Expr7: {
                switch (lookahead) {
                    case '-':
                    case '!':
                        return new AbstractMap.SimpleEntry<>(116, Arrays.asList(Oper7, Expr8));
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(117, Arrays.asList(Expr8));
                    default: return null;
                }
            }
            //# line 39
            case ClassList: {
                switch (lookahead) {
                    case SEALED:
                    case CLASS:
                        return new AbstractMap.SimpleEntry<>(118, Arrays.asList(ClassDef, ClassList));
                    case eof:
                    case eos:
                        return new AbstractMap.SimpleEntry<>(119, Arrays.asList());
                    default: return null;
                }
            }
            //# line 356
            case Oper4: {
                switch (lookahead) {
                    case LESS_EQUAL:
                        return new AbstractMap.SimpleEntry<>(120, Arrays.asList(LESS_EQUAL));
                    case GREATER_EQUAL:
                        return new AbstractMap.SimpleEntry<>(121, Arrays.asList(GREATER_EQUAL));
                    case '<':
                        return new AbstractMap.SimpleEntry<>(122, Arrays.asList(Integer.valueOf('<')));
                    case '>':
                        return new AbstractMap.SimpleEntry<>(123, Arrays.asList(Integer.valueOf('>')));
                    default: return null;
                }
            }
            //# line 137
            case Field: {
                switch (lookahead) {
                    case STATIC:
                        return new AbstractMap.SimpleEntry<>(124, Arrays.asList(STATIC, Type, IDENTIFIER, Integer.valueOf('('), Formals, Integer.valueOf(')'), StmtBlock));
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(125, Arrays.asList(Type, IDENTIFIER, FunctionField));
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
                //# line 51
                params[0].vdef = params[1].vdef;
                return;
            }
            case 1: {
                //# line 556
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
                //# line 289
                params[0].lvalue = new LValue.BoundVar(null, params[2].ident, params[1].loc);
                return;
            }
            case 4: {
                //# line 293
                params[0].lvalue = new LValue.BoundVar(params[1].type, params[2].ident, params[1].loc);
                return;
            }
            case 5: {
                //# line 345
                params[0].counter = Tree.EQ;
                params[0].loc = params[1].loc;
                return;
            }
            case 6: {
                //# line 350
                params[0].counter = Tree.NE;
                params[0].loc = params[1].loc;
                return;
            }
            case 7: {
                //# line 391
                params[0].counter = Tree.MUL;
                params[0].loc = params[1].loc;
                return;
            }
            case 8: {
                //# line 396
                params[0].counter = Tree.DIV;
                params[0].loc = params[1].loc;
                return;
            }
            case 9: {
                //# line 401
                params[0].counter = Tree.MOD;
                params[0].loc = params[1].loc;
                return;
            }
            case 10: {
                //# line 172
                params[0].vlist = new ArrayList<VarDef>();
                params[0].vlist.add(params[1].vdef);
                if (params[2].vlist != null) {
                    params[0].vlist.addAll(params[2].vlist);
                }
                return;
            }
            case 11: {
                //# line 162
                params[0].vlist = params[1].vlist;
                return;
            }
            case 12: {
                //# line 166
                params[0].vlist = new ArrayList<VarDef>();
                return;
            }
            case 13: {
                //# line 408
                params[0].counter = Tree.NEG;
                params[0].loc = params[1].loc;
                return;
            }
            case 14: {
                //# line 413
                params[0].counter = Tree.NOT;
                params[0].loc = params[1].loc;
                return;
            }
            case 15: {
                //# line 612
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
                //# line 720
                params[0].expr = params[3].expr;
                params[0].counter = 1 + params[3].counter;
                return;
            }
            case 17: {
                //# line 725
                params[0].expr = params[1].expr;
                params[0].counter = 0;
                return;
            }
            case 18: {
                //# line 456
                params[0].expr = params[1].expr;
                if (params[2].svec != null) {
                    for (int i = 0; i < params[2].svec.size(); ++i) {
                        params[0].expr = new Tree.Binary(params[2].svec.get(i), params[0].expr,
                            params[2].evec.get(i), params[2].lvec.get(i));
                    }
                }
                return;
            }
            case 19: {
                //# line 338
                params[0].counter = Tree.AND;
                params[0].loc = params[1].loc;
                return;
            }
            case 20: {
                //# line 573
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
                //# line 797
                params[0].stmt = new Tree.Break(params[1].loc);
                return;
            }
            case 22: {
                //# line 468
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
                /* no action */
                return;
            }
            case 24: {
                //# line 199
                params[0].slist.add(params[1].stmt);
                params[0].slist.addAll(params[2].slist);
                return;
            }
            case 25: {
                /* no action */
                return;
            }
            case 26: {
                //# line 744
                params[0].expr = new Tree.Literal(params[1].typeTag, params[1].literal, params[1].loc);
                return;
            }
            case 27: {
                //# line 748
                params[0].expr = new Null(params[1].loc);
                return;
            }
            case 28: {
                //# line 182
                params[0].vlist = new ArrayList<VarDef>();
                params[0].vlist.add(params[2].vdef);
                if (params[3].vlist != null) {
                    params[0].vlist.addAll(params[3].vlist);
                }
                return;
            }
            case 29: {
                /* no action */
                return;
            }
            case 30: {
                //# line 829
                params[0].stmt = new Tree.Print(params[3].elist, params[1].loc);
                return;
            }
            case 31: {
                //# line 791
                params[0].stmt = new Tree.ForLoop(params[3].stmt, params[5].expr, params[7].stmt, params[9].stmt, params[1].loc);
                return;
            }
            case 32: {
                //# line 664
                params[0].expr = params[1].expr;
                return;
            }
            case 33: {
                //# line 668
                params[0].expr = new Tree.ReadIntExpr(params[1].loc);
                return;
            }
            case 34: {
                //# line 672
                params[0].expr = new Tree.ReadLineExpr(params[1].loc);
                return;
            }
            case 35: {
                //# line 676
                params[0].expr = new Tree.ThisExpr(params[1].loc);
                return;
            }
            case 36: {
                //# line 680
                if (params[2].ident != null) {
                    params[0].expr = new Tree.NewClass(params[2].ident, params[1].loc);
                } else {
                    params[0].expr = new Tree.NewArray(params[2].type, params[2].expr, params[1].loc);
                }
                return;
            }
            case 37: {
                //# line 688
                params[0].expr = new Tree.TypeTest(params[3].expr, params[5].ident, params[1].loc);
                return;
            }
            case 38: {
                //# line 692
                params[0].expr = params[2].expr;
                return;
            }
            case 39: {
                //# line 696
                if (params[2].elist != null) {
                    params[0].expr = new Tree.CallExpr(null, params[1].ident, params[2].elist, params[1].loc);
                } else {
                    params[0].expr = new Tree.Ident(null, params[1].ident, params[1].loc);
                }
                return;
            }
            case 40: {
                //# line 427
                params[0].expr = params[1].expr;
                if (params[2].svec != null) {
                    for (int i = 0; i < params[2].svec.size(); ++i) {
                        params[0].expr = new Tree.Binary(params[2].svec.get(i), params[0].expr,
                            params[2].evec.get(i), params[2].lvec.get(i));
                    }
                }
                return;
            }
            case 41: {
                //# line 279
                params[0].stmt = new Tree.ArrayFor(false, params[3].lvalue, params[5].expr, params[7].stmt, null, params[1].loc);
                return;
            }
            case 42: {
                //# line 300
                params[3].slist.add(params[4].stmt);
                params[0].stmt = new Tree.Guard(params[3].slist, params[1].loc);
                return;
            }
            case 43: {
                //# line 272
                params[0].counter = Tree.OR;
                params[0].loc = params[1].loc;
                return;
            }
            case 44: {
                //# line 809
                params[0].stmt = params[2].stmt;
                return;
            }
            case 45: {
                /* no action */
                return;
            }
            case 46: {
                //# line 122
                params[0].flist = new ArrayList<Tree>();
                if (params[1].vdef != null) {
                    params[0].flist.add(params[1].vdef);
                } else {
                    params[0].flist.add(params[1].fdef);
                }
                params[0].flist.addAll(params[2].flist);
                return;
            }
            case 47: {
                //# line 132
                params[0].flist = new ArrayList<Tree>();
                return;
            }
            case 48: {
                //# line 772
                params[0].elist = new ArrayList<Tree.Expr>();
                params[0].elist.add(params[2].expr);
                params[0].elist.addAll(params[3].elist);
                return;
            }
            case 49: {
                //# line 778
                params[0].elist = new ArrayList<Tree.Expr>();
                return;
            }
            case 50: {
                //# line 732
                params[0].expr = params[1].expr;
                return;
            }
            case 51: {
                //# line 736
                params[0].expr = new Tree.TypeCast(params[2].ident, params[4].expr, params[4].loc);
                return;
            }
            case 52: {
                //# line 105
                params[0].cdef = new Tree.ClassDef(true, params[3].ident, params[4].ident, params[6].flist, params[1].loc);
                return;
            }
            case 53: {
                //# line 109
                params[0].cdef = new Tree.ClassDef(false, params[2].ident, params[3].ident, params[5].flist, params[1].loc);
                return;
            }
            case 54: {
                //# line 816
                params[0].stmt = new Tree.Return(params[2].expr, params[1].loc);
                return;
            }
            case 55: {
                //# line 764
                params[0].elist = new ArrayList<Tree.Expr>();
                params[0].elist.add(params[1].expr);
                params[0].elist.addAll(params[2].elist);
                return;
            }
            case 56: {
                //# line 312
                params[0].slist.add(params[2].stmt);
                return;
            }
            case 57: {
                //# line 193
                params[0].stmt = new Tree.Block(params[2].slist, params[1].loc);
                return;
            }
            case 58: {
                //# line 154
                params[0].vlist = params[2].vlist;
                params[0].stmt = params[4].stmt;
                return;
            }
            case 59: {
                /* no action */
                return;
            }
            case 60: {
                //# line 657
                params[0].elist = params[2].elist;
                return;
            }
            case 61: {
                /* no action */
                return;
            }
            case 62: {
                //# line 29
                params[0].clist = new ArrayList<ClassDef>();
                params[0].clist.add(params[1].cdef);
                if (params[2].clist != null) {
                    params[0].clist.addAll(params[2].clist);
                }
                params[0].prog = new Tree.TopLevel(params[0].clist, params[0].loc);
                return;
            }
            case 63: {
                //# line 421
                params[0].expr = params[1].expr;
                return;
            }
            case 64: {
                //# line 323
                params[0].stmt = new Tree.IfG(params[1].expr, params[3].stmt, params[1].loc);
                return;
            }
            case 65: {
                //# line 85
                params[0].type = params[1].type;
                for (int i = 0; i < params[2].counter; ++i) {
                    params[0].type = new Tree.TypeArray(params[0].type, params[1].loc);
                }
                return;
            }
            case 66: {
                //# line 544
                params[0].expr = params[1].expr;
                if (params[2].svec != null) {
                    for (int i = 0; i < params[2].svec.size(); ++i) {
                        params[0].expr = new Tree.Binary(params[2].svec.get(i), params[0].expr,
                            params[2].evec.get(i), params[2].lvec.get(i));
                    }
                }
                return;
            }
            case 67: {
                //# line 706
                params[0].ident = params[1].ident;
                return;
            }
            case 68: {
                //# line 710
                params[0].type = params[1].type;
                for (int i = 0; i < params[3].counter; ++i) {
                    params[0].type = new Tree.TypeArray(params[0].type, params[1].loc);
                }
                params[0].expr = params[3].expr;
                return;
            }
            case 69: {
                //# line 263
                params[0].loc = params[1].loc;
                params[0].expr = params[2].expr;
                return;
            }
            case 70: {
                /* no action */
                return;
            }
            case 71: {
                //# line 115
                params[0].ident = params[2].ident;
                return;
            }
            case 72: {
                /* no action */
                return;
            }
            case 73: {
                //# line 379
                params[0].counter = Tree.PLUS;
                params[0].loc = params[1].loc;
                return;
            }
            case 74: {
                //# line 384
                params[0].counter = Tree.MINUS;
                params[0].loc = params[1].loc;
                return;
            }
            case 75: {
                //# line 94
                params[0].counter = 1 + params[3].counter;
                return;
            }
            case 76: {
                //# line 98
                params[0].counter = 0;
                return;
            }
            case 77: {
                //# line 485
                params[0].expr = params[1].expr;
                if (params[2].svec != null) {
                    for (int i = 0; i < params[2].svec.size(); ++i) {
                        params[0].expr = new Tree.Binary(params[2].svec.get(i), params[0].expr,
                            params[2].evec.get(i), params[2].lvec.get(i));
                    }
                }
                return;
            }
            case 78: {
                //# line 754
                params[0].elist = params[1].elist;
                return;
            }
            case 79: {
                //# line 758
                params[0].elist = new ArrayList<Tree.Expr>();
                return;
            }
            case 80: {
                //# line 57
                params[0].vdef = new Tree.VarDef(params[2].ident, params[1].type, params[2].loc);
                return;
            }
            case 81: {
                //# line 498
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
            case 82: {
                /* no action */
                return;
            }
            case 83: {
                /* no action */
                return;
            }
            case 84: {
                /* no action */
                return;
            }
            case 85: {
                /* no action */
                return;
            }
            case 86: {
                //# line 210
                params[0].stmt = params[1].vdef;
                return;
            }
            case 87: {
                //# line 214
                if (params[1].stmt == null) {
                    params[0].stmt = new Tree.Skip(params[2].loc);
                } else {
                    params[0].stmt = params[1].stmt;
                }
                return;
            }
            case 88: {
                //# line 226
                params[0].stmt = params[1].stmt;
                return;
            }
            case 89: {
                //# line 230
                params[0].stmt = params[1].stmt;
                return;
            }
            case 90: {
                //# line 234
                params[0].stmt = params[1].stmt;
                return;
            }
            case 91: {
                //# line 238
                params[0].stmt = params[1].stmt;
                return;
            }
            case 92: {
                //# line 242
                params[0].stmt = params[1].stmt;
                return;
            }
            case 93: {
                //# line 246
                params[0].stmt = params[1].stmt;
                return;
            }
            case 94: {
                //# line 252
                if (params[2].expr == null) {
                    params[0].stmt = new Tree.Calculate(params[1].expr, params[1].loc);
                } else {
                    params[0].stmt = new Tree.Assign(params[1].expr, params[2].expr, params[2].loc);
                }
                return;
            }
            case 95: {
                /* no action */
                return;
            }
            case 96: {
                //# line 63
                params[0].type = new Tree.TypeIdent(Tree.INT, params[1].loc);
                return;
            }
            case 97: {
                //# line 67
                params[0].type = new Tree.TypeIdent(Tree.VOID, params[1].loc);
                return;
            }
            case 98: {
                //# line 71
                params[0].type = new Tree.TypeIdent(Tree.BOOL, params[1].loc);
                return;
            }
            case 99: {
                //# line 75
                params[0].type = new Tree.TypeIdent(Tree.STRING, params[1].loc);
                return;
            }
            case 100: {
                //# line 79
                params[0].type = new Tree.TypeClass(params[2].ident, params[1].loc);
                return;
            }
            case 101: {
                //# line 785
                params[0].stmt = new Tree.WhileLoop(params[3].expr, params[5].stmt, params[1].loc);
                return;
            }
            case 102: {
                //# line 439
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
            case 103: {
                /* no action */
                return;
            }
            case 104: {
                //# line 515
                params[0].expr = params[1].expr;
                if (params[2].svec != null) {
                    for (int i = 0; i < params[2].svec.size(); ++i) {
                        params[0].expr = new Tree.Binary(params[2].svec.get(i), params[0].expr,
                            params[2].evec.get(i), params[2].lvec.get(i));
                    }
                }
                return;
            }
            case 105: {
                //# line 527
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
            case 106: {
                /* no action */
                return;
            }
            case 107: {
                //# line 822
                params[0].expr = params[1].expr;
                return;
            }
            case 108: {
                /* no action */
                return;
            }
            case 109: {
                //# line 803
                params[0].stmt = new Tree.If(params[3].expr, params[5].stmt, params[6].stmt, params[1].loc);
                return;
            }
            case 110: {
                //# line 330
                params[0].stmt = new Tree.Scopy(params[3].ident, params[5].expr, params[3].loc);
                return;
            }
            case 111: {
                //# line 585
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
            case 112: {
                /* no action */
                return;
            }
            case 113: {
                //# line 632
                SemValue sem = new SemValue();
                sem.expr = params[2].expr;
                params[0].vec = new Vector<SemValue>();
                params[0].vec.add(sem);
                if (params[4].vec != null) {
                    params[0].vec.addAll(params[4].vec);
                }
                return;
            }
            case 114: {
                //# line 642
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
            case 115: {
                /* no action */
                return;
            }
            case 116: {
                //# line 602
                params[0].expr = new Tree.Unary(params[1].counter, params[2].expr, params[1].loc);
                return;
            }
            case 117: {
                //# line 606
                params[0].expr = params[1].expr;
                return;
            }
            case 118: {
                //# line 40
                params[0].clist = new ArrayList<ClassDef>();
                params[0].clist.add(params[1].cdef);
                if (params[2].clist != null) {
                    params[0].clist.addAll(params[2].clist);
                }
                return;
            }
            case 119: {
                /* no action */
                return;
            }
            case 120: {
                //# line 357
                params[0].counter = Tree.LE;
                params[0].loc = params[1].loc;
                return;
            }
            case 121: {
                //# line 362
                params[0].counter = Tree.GE;
                params[0].loc = params[1].loc;
                return;
            }
            case 122: {
                //# line 367
                params[0].counter = Tree.LT;
                params[0].loc = params[1].loc;
                return;
            }
            case 123: {
                //# line 372
                params[0].counter = Tree.GT;
                params[0].loc = params[1].loc;
                return;
            }
            case 124: {
                //# line 138
                params[0].fdef = new Tree.MethodDef(true, params[3].ident, params[2].type, params[5].vlist,
                    (Block) params[7].stmt, params[3].loc);
                return;
            }
            case 125: {
                //# line 143
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
