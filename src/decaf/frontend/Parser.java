//### This file created by BYACC 1.8(/Java extension  1.13)
//### Java capabilities added 7 Jan 97, Bob Jamison
//### Updated : 27 Nov 97  -- Bob Jamison, Joe Nieten
//###           01 Jan 98  -- Bob Jamison -- fixed generic semantic constructor
//###           01 Jun 99  -- Bob Jamison -- added Runnable support
//###           06 Aug 00  -- Bob Jamison -- made state variables class-global
//###           03 Jan 01  -- Bob Jamison -- improved flags, tracing
//###           16 May 01  -- Bob Jamison -- added custom stack sizing
//###           04 Mar 02  -- Yuval Oren  -- improved java performance, added options
//###           14 Mar 02  -- Tomas Hurka -- -d support, static initializer workaround
//###           14 Sep 06  -- Keltin Leung-- ReduceListener support, eliminate underflow report in error recovery
//### Please send bug reports to tom@hukatronic.cz
//### static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";






//#line 11 "Parser.y"
package decaf.frontend;

import decaf.tree.Tree;
import decaf.tree.Tree.*;
import decaf.error.*;
import java.util.*;
//#line 25 "Parser.java"
interface ReduceListener {
  public boolean onReduce(String rule);
}




public class Parser
             extends BaseParser
             implements ReduceListener
{

boolean yydebug;        //do I want debug output?
int yynerrs;            //number of errors so far
int yyerrflag;          //was there an error?
int yychar;             //the current working character

ReduceListener reduceListener = null;
void yyclearin ()       {yychar = (-1);}
void yyerrok ()         {yyerrflag=0;}
void addReduceListener(ReduceListener l) {
  reduceListener = l;}


//########## MESSAGES ##########
//###############################################################
// method: debug
//###############################################################
void debug(String msg)
{
  if (yydebug)
    System.out.println(msg);
}

//########## STATE STACK ##########
final static int YYSTACKSIZE = 500;  //maximum stack size
int statestk[] = new int[YYSTACKSIZE]; //state stack
int stateptr;
int stateptrmax;                     //highest index of stackptr
int statemax;                        //state when highest index reached
//###############################################################
// methods: state stack push,pop,drop,peek
//###############################################################
final void state_push(int state)
{
  try {
		stateptr++;
		statestk[stateptr]=state;
	 }
	 catch (ArrayIndexOutOfBoundsException e) {
     int oldsize = statestk.length;
     int newsize = oldsize * 2;
     int[] newstack = new int[newsize];
     System.arraycopy(statestk,0,newstack,0,oldsize);
     statestk = newstack;
     statestk[stateptr]=state;
  }
}
final int state_pop()
{
  return statestk[stateptr--];
}
final void state_drop(int cnt)
{
  stateptr -= cnt; 
}
final int state_peek(int relative)
{
  return statestk[stateptr-relative];
}
//###############################################################
// method: init_stacks : allocate and prepare stacks
//###############################################################
final boolean init_stacks()
{
  stateptr = -1;
  val_init();
  return true;
}
//###############################################################
// method: dump_stacks : show n levels of the stacks
//###############################################################
void dump_stacks(int count)
{
int i;
  System.out.println("=index==state====value=     s:"+stateptr+"  v:"+valptr);
  for (i=0;i<count;i++)
    System.out.println(" "+i+"    "+statestk[i]+"      "+valstk[i]);
  System.out.println("======================");
}


//########## SEMANTIC VALUES ##########
//## **user defined:SemValue
String   yytext;//user variable to return contextual strings
SemValue yyval; //used to return semantic vals from action routines
SemValue yylval;//the 'lval' (result) I got from yylex()
SemValue valstk[] = new SemValue[YYSTACKSIZE];
int valptr;
//###############################################################
// methods: value stack push,pop,drop,peek.
//###############################################################
final void val_init()
{
  yyval=new SemValue();
  yylval=new SemValue();
  valptr=-1;
}
final void val_push(SemValue val)
{
  try {
    valptr++;
    valstk[valptr]=val;
  }
  catch (ArrayIndexOutOfBoundsException e) {
    int oldsize = valstk.length;
    int newsize = oldsize*2;
    SemValue[] newstack = new SemValue[newsize];
    System.arraycopy(valstk,0,newstack,0,oldsize);
    valstk = newstack;
    valstk[valptr]=val;
  }
}
final SemValue val_pop()
{
  return valstk[valptr--];
}
final void val_drop(int cnt)
{
  valptr -= cnt;
}
final SemValue val_peek(int relative)
{
  return valstk[valptr-relative];
}
//#### end semantic value section ####
public final static short VOID=257;
public final static short BOOL=258;
public final static short INT=259;
public final static short STRING=260;
public final static short CLASS=261;
public final static short NULL=262;
public final static short EXTENDS=263;
public final static short THIS=264;
public final static short WHILE=265;
public final static short FOR=266;
public final static short IF=267;
public final static short ELSE=268;
public final static short RETURN=269;
public final static short BREAK=270;
public final static short NEW=271;
public final static short PRINT=272;
public final static short READ_INTEGER=273;
public final static short READ_LINE=274;
public final static short LITERAL=275;
public final static short IDENTIFIER=276;
public final static short AND=277;
public final static short OR=278;
public final static short STATIC=279;
public final static short SEALED=280;
public final static short INSTANCEOF=281;
public final static short DIVIDER=282;
public final static short SCOPY=283;
public final static short FOREACH=284;
public final static short DEFAULT=285;
public final static short LESS_EQUAL=286;
public final static short GREATER_EQUAL=287;
public final static short EQUAL=288;
public final static short NOT_EQUAL=289;
public final static short VAR=290;
public final static short ARRAY_REPEAT=291;
public final static short ARRAY_CONCAT=292;
public final static short UMINUS=293;
public final static short EMPTY=294;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    1,    1,    3,    4,    5,    5,    5,    5,    5,
    5,    2,    2,    6,    6,    7,    7,    7,    9,    9,
   10,   10,    8,    8,   11,   12,   12,   13,   13,   13,
   13,   13,   13,   13,   13,   13,   13,   13,   15,   15,
   23,   23,   24,   14,   16,   16,   16,   28,   28,   26,
   26,   26,   27,   25,   25,   25,   25,   25,   25,   25,
   25,   25,   25,   25,   25,   25,   25,   25,   25,   25,
   25,   25,   25,   25,   25,   25,   25,   25,   25,   25,
   25,   25,   25,   30,   30,   30,   31,   31,   32,   32,
   29,   29,   33,   33,   18,   19,   22,   17,   34,   34,
   20,   20,   21,
};
final static short yylen[] = {                            2,
    1,    2,    1,    2,    2,    1,    1,    1,    1,    2,
    3,    7,    6,    2,    0,    2,    2,    0,    1,    0,
    3,    1,    7,    6,    3,    2,    0,    2,    1,    1,
    2,    1,    1,    1,    2,    2,    2,    1,    5,    3,
    3,    0,    3,    6,    3,    1,    0,    2,    0,    2,
    2,    4,    5,    3,    3,    6,    6,    1,    1,    1,
    3,    3,    3,    3,    3,    3,    3,    3,    3,    3,
    3,    3,    3,    3,    2,    2,    3,    3,    1,    4,
    5,    6,    5,    1,    1,    1,    2,    3,    3,    1,
    1,    0,    3,    1,    5,    9,    1,    6,    2,    0,
    2,    1,    4,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    3,    0,    0,    2,    0,    0,
    0,   14,   18,    0,    0,   18,    7,    8,    6,    9,
    0,    0,   13,   16,    0,    0,   17,    0,   10,    0,
    4,    0,    0,   12,    0,    0,   11,    0,   22,    0,
    0,    0,    0,    5,    0,    0,    0,   27,   24,   21,
   23,    0,   86,   79,    0,    0,    0,    0,   97,    0,
    0,    0,    0,   85,    0,    0,    0,    0,    0,    0,
    0,   25,   30,   38,   26,    0,   29,    0,   32,   33,
   34,    0,    0,    0,    0,    0,    0,    0,   60,   84,
    0,    0,    0,    0,    0,   58,   59,    0,    0,    0,
    0,    0,    0,    0,   50,    0,    0,    0,    0,   87,
   90,    0,   28,   31,   35,   36,   37,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   48,    0,    0,    0,    0,    0,    0,   40,
    0,    0,    0,    0,    0,   77,   78,    0,    0,    0,
   74,    0,   88,    0,    0,    0,    0,    0,    0,   54,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   80,    0,    0,  103,
    0,    0,    0,   89,    0,    0,    0,    0,   95,    0,
    0,   41,   39,    0,   81,    0,    0,    0,    0,    0,
    0,   53,    0,    0,   98,   43,   82,   44,   56,    0,
    0,   99,    0,   96,
};
final static short yydgoto[] = {                          3,
    4,    5,   73,   25,   40,   10,   15,   27,   41,   42,
   74,   52,   75,   76,   77,   78,   79,   80,   81,   82,
   83,   84,  141,  175,   85,   96,   97,   88,  187,   89,
   90,  112,  145,  205,
};
final static short yysindex[] = {                      -250,
 -260, -225,    0, -250,    0, -218, -226,    0, -216,  -61,
 -218,    0,    0,  -60,  -94,    0,    0,    0,    0,    0,
 -211,   48,    0,    0,    9,  -88,    0,   58,    0,  -87,
    0,   29,  -19,    0,   35,   48,    0,   48,    0,  -85,
   36,   32,   42,    0,  -43,   48,  -43,    0,    0,    0,
    0,   -6,    0,    0,   47,   55,  -27,   96,    0,  345,
   61,   62,   66,    0,   67,   70, -188,   96,   96,   39,
  -70,    0,    0,    0,    0,   54,    0,   56,    0,    0,
    0,   68,   74,   75,  510,   37,    0, -162,    0,    0,
   96,   96,   96,    1,  510,    0,    0,   81,   34,   96,
   94,   98,   96, -139,    0,  -21,  -21, -136,  373,    0,
    0,  -36,    0,    0,    0,    0,    0,   96,   96,   96,
   96,   96,   96,  -59,   96,   96,   96,   96,   96,   96,
   96,   96,    0,   96,   96,  102,  406,   88,  413,    0,
   96,  107,   60,  510,   -3,    0,    0,  301,  105,  111,
    0,  -59,    0,  775,  626,    6,    6,  796,  796,    0,
 -131,  -18,  -18,  -21,  -21,  -21,    6,    6,  336,  510,
   96,   21,   96,   21, -120,  434,    0,  441,   96,    0,
 -108,   96,   96,    0,   96, -115,  135,  133,    0,  468,
  -90,    0,    0,   21,    0,  510,  138,  475, -277,  503,
   96,    0,   96,   21,    0,    0,    0,    0,    0,  510,
  140,    0,   21,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,  182,    0,   63,    0,    0,    0,    0,
   63,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  125,    0,    0,    0,  152,    0,  152,    0,    0,
    0,  160,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  -58,    0,    0,    0,    0,    0,  -57,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  -74,  -74,  -74,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  538,  366,    0,    0,    0,
  -74,  -58,  -74,   78,  148,    0,    0,    0,    0,  -74,
    0,    0,  -74,    0,    0,  883,  907,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  -74,  -74,  -74,
  -74,  -74,  -74,    0,  -74,  -74,  -74,  -74,  -74,  -74,
  -74,  -74,    0,  -74,  -74,  113,    0,    0,    0,    0,
  -74,    0,  -74,    3,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   50,   45,   87,  875,  465,  574,    0,
  803,  983, 1052,  936,  960, 1013,  930, 1080,    0,  -24,
  -31,  -58,  -74,  -58,    0,    0,    0,    0,  -74,    0,
    0,  -74,  -74,    0,  -74,  153,    0,  167,    0,    0,
  -33,    0,    0,  -58,    0,   15,    0,    0,  830,    0,
  -74,    0,   -4,  -58,    0,    0,    0,    0,    0,   23,
    0,    0,  -58,    0,
};
final static short yygindex[] = {                         0,
    0,  205,   27,   86,   18,  199,  201,    0,  183,    0,
  -25,    0,  295,    0,    0,  -83,    0,    0,    0,    0,
    0,    0,    0,    0, 1252,  812,  985,    0,    0,  -53,
    0,    0,   49,    0,
};
final static int YYTABLESIZE=1453;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        100,
   47,  102,   33,   33,  193,   33,  100,  152,  138,   92,
    1,  100,   93,  124,  125,    6,   45,  111,  130,   49,
   71,   51,  110,  128,  133,  100,   69,  133,  129,    2,
   23,   71,   26,   70,   45,    7,   47,  180,   68,   30,
  179,   24,  130,   94,    9,   26,   94,  128,  126,   11,
  127,  133,  129,   69,   24,   93,  153,  100,   93,   12,
   70,   13,   16,   57,   29,   68,   57,   31,   36,  134,
  160,   69,  134,   37,   38,   46,   45,   99,   70,   48,
   57,   57,   47,   68,   71,   73,   91,  105,   73,  100,
   72,  100,   69,   72,   92,   94,  134,  135,  184,   70,
  100,  101,   73,   73,   68,  102,  103,   72,   72,  104,
   42,   71,  113,  136,  114,   57,   48,   42,   72,  211,
  142,   39,   42,   39,  143,  140,  115,   70,   69,   71,
   70,   50,  116,  117,  146,   70,  149,   73,  147,  150,
   68,  171,   72,   48,   70,   70,  173,  177,  182,   51,
   71,  183,   37,   51,   51,   51,   51,   51,   51,   51,
  125,  192,   17,   18,   19,   20,   21,  197,   42,  201,
   51,   51,   51,   51,   51,  202,  179,  204,  207,   70,
  213,    1,   34,    5,   22,   15,   71,   32,   35,   52,
   44,   53,   20,   52,   52,   52,   52,   52,   52,   52,
   19,   49,   53,   51,   64,   51,  101,   91,    8,   14,
   52,   52,   52,   52,   52,   64,   28,   49,   49,  188,
   43,    0,    0,  100,  100,  100,  100,  100,  100,    0,
  100,  100,  100,  100,    0,  100,  100,  100,  100,  100,
  100,  100,  100,   52,   49,   52,    0,  100,  100,  100,
   17,   18,   19,   20,   21,   53,  100,   54,   55,   56,
   57,    0,   58,   59,   60,   61,   62,   63,   64,  124,
  125,   49,  124,  125,   65,    0,   66,   17,   18,   19,
   20,   21,   53,   67,   54,   55,   56,   57,    0,   58,
   59,   60,   61,   62,   63,   64,  124,  125,    0,  108,
   53,   65,   54,   66,   17,   18,   19,   20,   21,   60,
   67,   62,   63,   64,   17,   18,   19,   20,   21,   65,
    0,   53,   73,   54,    0,    0,   72,   72,   67,    0,
   60,    0,   62,   63,   64,    0,   22,  130,    0,   42,
   65,   42,  128,  126,  181,  127,  133,  129,   42,   67,
   42,   42,   42,   42,    0,    0,    0,   53,   42,   54,
  132,    0,  131,   70,   70,    0,   60,   42,   62,   63,
   64,    0,  130,    0,   70,   70,   65,  128,  126,    0,
  127,  133,  129,    0,    0,   67,    0,    0,    0,   51,
   51,  134,    0,  185,    0,  132,    0,  131,   51,   51,
   51,   51,   59,   51,   51,    0,   46,   59,   59,  130,
   59,   59,   59,  151,  128,  126,    0,  127,  133,  129,
    0,    0,    0,    0,   46,   59,  134,   59,  186,   52,
   52,    0,  132,    0,  131,    0,    0,    0,   52,   52,
   52,   52,  130,   52,   52,    0,  172,  128,  126,  130,
  127,  133,  129,  174,  128,  126,   59,  127,  133,  129,
    0,    0,    0,  134,    0,  132,  189,  131,  191,    0,
  130,    0,  132,    0,  131,  128,  126,  130,  127,  133,
  129,    0,  128,  126,    0,  127,  133,  129,  206,    0,
    0,  194,    0,  132,    0,  131,  134,    0,  212,    0,
  132,    0,  131,  134,  130,   66,    0,  214,   66,  128,
  126,  130,  127,  133,  129,  208,  128,  126,    0,  127,
  133,  129,   66,   66,  134,    0,  203,  132,    0,  131,
    0,  134,    0,  195,  132,    0,  131,    0,    0,  130,
    0,    0,    0,    0,  128,  126,  130,  127,  133,  129,
    0,  128,  126,    0,  127,  133,  129,   66,  134,    0,
    0,    0,  132,    0,  131,  134,    0,    0,    0,  132,
    0,  131,    0,    0,   58,    0,    0,  118,  119,   58,
   58,    0,   58,   58,   58,    0,  120,  121,  122,  123,
    0,  124,  125,  134,    0,  209,    0,   58,    0,   58,
  134,   17,   18,   19,   20,   21,    0,    0,    0,    0,
    0,    0,  118,  119,   67,    0,    0,   67,    0,    0,
   98,  120,  121,  122,  123,    0,  124,  125,   58,    0,
    0,   67,   67,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   59,   59,    0,    0,    0,    0,    0,  118,
  119,   59,   59,   59,   59,    0,   59,   59,  120,  121,
  122,  123,  130,  124,  125,    0,   67,  128,  126,    0,
  127,  133,  129,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  118,  119,    0,  132,    0,  131,    0,  118,
  119,  120,  121,  122,  123,    0,  124,  125,  120,  121,
  122,  123,    0,  124,  125,    0,    0,    0,    0,    0,
  118,  119,    0,    0,    0,    0,  134,  118,  119,  120,
  121,  122,  123,    0,  124,  125,  120,  121,  122,  123,
    0,  124,  125,    0,    0,    0,    0,    0,    0,    0,
    0,   66,   66,    0,  118,  119,    0,    0,    0,    0,
    0,  118,  119,  120,  121,  122,  123,    0,  124,  125,
  120,  121,  122,  123,    0,  124,  125,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  118,
  119,    0,    0,    0,    0,    0,  118,  119,  120,  121,
  122,  123,    0,  124,  125,  120,  121,  122,  123,    0,
  124,  125,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  130,    0,    0,   58,   58,  128,  126,    0,  127,
  133,  129,    0,   58,   58,   58,   58,    0,   58,   58,
    0,    0,  130,    0,  132,    0,  131,  128,  126,   55,
  127,  133,  129,   55,   55,   55,   55,   55,   55,   55,
   67,   67,    0,    0,    0,  132,    0,  131,    0,    0,
   55,   55,   55,   86,   55,  134,   83,    0,    0,    0,
   83,   83,   83,   83,   83,   83,   83,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  134,   83,   83,   83,
    0,   83,    0,   55,    0,   55,    0,    0,    0,    0,
    0,    0,  118,   86,    0,    0,    0,    0,    0,    0,
    0,  120,  121,  122,  123,   71,  124,  125,   71,   75,
   83,    0,   83,   75,   75,   75,   75,   75,    0,   75,
    0,    0,   71,   71,    0,    0,    0,    0,    0,    0,
   75,   75,   75,   76,   75,    0,    0,   76,   76,   76,
   76,   76,    0,   76,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   76,   76,   76,   71,   76,    0,
   69,    0,   63,   69,    0,   75,   63,   63,   63,   63,
   63,    0,   63,   86,    0,   86,    0,   69,   69,    0,
    0,    0,    0,   63,   63,   63,   64,   63,    0,   76,
   64,   64,   64,   64,   64,   86,   64,    0,    0,    0,
    0,    0,    0,    0,   86,   86,    0,   64,   64,   64,
    0,   64,   69,   61,   86,   61,   61,   61,   63,    0,
    0,    0,    0,    0,    0,    0,   87,    0,    0,    0,
   61,   61,   61,    0,   61,    0,    0,    0,    0,   65,
    0,    0,   64,   65,   65,   65,   65,   65,    0,   65,
  120,  121,  122,  123,    0,  124,  125,    0,    0,    0,
   65,   65,   65,    0,   65,   61,   87,    0,    0,   55,
   55,  120,  121,    0,    0,    0,  124,  125,   55,   55,
   55,   55,   62,   55,   62,   62,   62,    0,    0,    0,
    0,    0,    0,    0,    0,   65,   83,   83,    0,   62,
   62,   62,    0,   62,    0,   83,   83,   83,   83,    0,
   68,    0,    0,   68,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   68,   68,    0,
    0,    0,    0,    0,   62,    0,    0,    0,    0,    0,
    0,   71,   71,    0,    0,    0,   87,    0,   87,   75,
   75,    0,   71,   71,    0,    0,    0,    0,   75,   75,
   75,   75,   68,    0,    0,    0,    0,    0,   87,    0,
    0,    0,    0,   76,   76,    0,    0,   87,   87,    0,
    0,    0,   76,   76,   76,   76,    0,   87,    0,    0,
    0,    0,    0,    0,    0,    0,   69,   69,    0,    0,
    0,    0,   63,   63,    0,    0,    0,   69,   69,    0,
    0,   63,   63,   63,   63,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   64,   64,    0,    0,
    0,    0,    0,    0,    0,   64,   64,   64,   64,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   61,
   61,    0,    0,    0,    0,    0,    0,    0,   61,   61,
   61,   61,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   65,
   65,    0,    0,    0,    0,    0,    0,    0,   65,   65,
   65,   65,    0,    0,    0,    0,    0,    0,    0,   95,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  106,
  107,  109,    0,    0,    0,    0,    0,    0,   62,   62,
    0,    0,    0,    0,    0,    0,    0,   62,   62,   62,
   62,    0,  137,    0,  139,    0,    0,    0,    0,    0,
    0,  144,    0,    0,  148,    0,   68,   68,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   68,   68,  154,
  155,  156,  157,  158,  159,    0,  161,  162,  163,  164,
  165,  166,  167,  168,    0,  169,  170,    0,    0,    0,
    0,    0,  176,    0,  178,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  144,    0,  190,    0,    0,    0,    0,    0,
  196,    0,    0,  198,  199,    0,  200,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  210,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         33,
   59,   59,   91,   91,  125,   91,   40,   44,   92,   41,
  261,   45,   40,  291,  292,  276,   41,   71,   37,   45,
   91,   47,   93,   42,   46,   59,   33,   46,   47,  280,
  125,   91,   15,   40,   59,  261,   41,   41,   45,   22,
   44,   15,   37,   41,  263,   28,   44,   42,   43,  276,
   45,   46,   47,   33,   28,   41,   93,   91,   44,  276,
   40,  123,  123,   41,  276,   45,   44,   59,   40,   91,
  124,   33,   91,   93,   40,   44,   41,   60,   40,  123,
   58,   59,   41,   45,   91,   41,   40,  276,   44,  123,
   41,  125,   33,   44,   40,  123,   91,   61,  152,   40,
   40,   40,   58,   59,   45,   40,   40,   58,   59,   40,
   33,   91,   59,  276,   59,   93,  123,   40,  125,  203,
   40,   36,   45,   38,   91,  125,   59,   41,   33,   91,
   44,   46,   59,   59,   41,   40,  276,   93,   41,  276,
   45,   40,   93,  123,   58,   59,   59,   41,   44,   37,
   91,   41,   93,   41,   42,   43,   44,   45,   46,   47,
  292,  282,  257,  258,  259,  260,  261,  276,   91,  285,
   58,   59,   60,   61,   62,   41,   44,  268,   41,   93,
   41,    0,  125,   59,  279,  123,   91,  276,  276,   37,
  276,  262,   41,   41,   42,   43,   44,   45,   46,   47,
   41,  276,  262,   91,  275,   93,   59,   41,    4,   11,
   58,   59,   60,   61,   62,  275,   16,  276,  276,  171,
   38,   -1,   -1,  257,  258,  259,  260,  261,  262,   -1,
  264,  265,  266,  267,   -1,  269,  270,  271,  272,  273,
  274,  275,  276,   91,  276,   93,   -1,  281,  282,  283,
  257,  258,  259,  260,  261,  262,  290,  264,  265,  266,
  267,   -1,  269,  270,  271,  272,  273,  274,  275,  291,
  292,  276,  291,  292,  281,   -1,  283,  257,  258,  259,
  260,  261,  262,  290,  264,  265,  266,  267,   -1,  269,
  270,  271,  272,  273,  274,  275,  291,  292,   -1,  261,
  262,  281,  264,  283,  257,  258,  259,  260,  261,  271,
  290,  273,  274,  275,  257,  258,  259,  260,  261,  281,
   -1,  262,  278,  264,   -1,   -1,  277,  278,  290,   -1,
  271,   -1,  273,  274,  275,   -1,  279,   37,   -1,  262,
  281,  264,   42,   43,   44,   45,   46,   47,  271,  290,
  273,  274,  275,  276,   -1,   -1,   -1,  262,  281,  264,
   60,   -1,   62,  277,  278,   -1,  271,  290,  273,  274,
  275,   -1,   37,   -1,  288,  289,  281,   42,   43,   -1,
   45,   46,   47,   -1,   -1,  290,   -1,   -1,   -1,  277,
  278,   91,   -1,   58,   -1,   60,   -1,   62,  286,  287,
  288,  289,   37,  291,  292,   -1,   41,   42,   43,   37,
   45,   46,   47,   41,   42,   43,   -1,   45,   46,   47,
   -1,   -1,   -1,   -1,   59,   60,   91,   62,   93,  277,
  278,   -1,   60,   -1,   62,   -1,   -1,   -1,  286,  287,
  288,  289,   37,  291,  292,   -1,   41,   42,   43,   37,
   45,   46,   47,   41,   42,   43,   91,   45,   46,   47,
   -1,   -1,   -1,   91,   -1,   60,  172,   62,  174,   -1,
   37,   -1,   60,   -1,   62,   42,   43,   37,   45,   46,
   47,   -1,   42,   43,   -1,   45,   46,   47,  194,   -1,
   -1,   58,   -1,   60,   -1,   62,   91,   -1,  204,   -1,
   60,   -1,   62,   91,   37,   41,   -1,  213,   44,   42,
   43,   37,   45,   46,   47,   41,   42,   43,   -1,   45,
   46,   47,   58,   59,   91,   -1,   59,   60,   -1,   62,
   -1,   91,   -1,   93,   60,   -1,   62,   -1,   -1,   37,
   -1,   -1,   -1,   -1,   42,   43,   37,   45,   46,   47,
   -1,   42,   43,   -1,   45,   46,   47,   93,   91,   -1,
   -1,   -1,   60,   -1,   62,   91,   -1,   -1,   -1,   60,
   -1,   62,   -1,   -1,   37,   -1,   -1,  277,  278,   42,
   43,   -1,   45,   46,   47,   -1,  286,  287,  288,  289,
   -1,  291,  292,   91,   -1,   93,   -1,   60,   -1,   62,
   91,  257,  258,  259,  260,  261,   -1,   -1,   -1,   -1,
   -1,   -1,  277,  278,   41,   -1,   -1,   44,   -1,   -1,
  276,  286,  287,  288,  289,   -1,  291,  292,   91,   -1,
   -1,   58,   59,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  277,  278,   -1,   -1,   -1,   -1,   -1,  277,
  278,  286,  287,  288,  289,   -1,  291,  292,  286,  287,
  288,  289,   37,  291,  292,   -1,   93,   42,   43,   -1,
   45,   46,   47,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  277,  278,   -1,   60,   -1,   62,   -1,  277,
  278,  286,  287,  288,  289,   -1,  291,  292,  286,  287,
  288,  289,   -1,  291,  292,   -1,   -1,   -1,   -1,   -1,
  277,  278,   -1,   -1,   -1,   -1,   91,  277,  278,  286,
  287,  288,  289,   -1,  291,  292,  286,  287,  288,  289,
   -1,  291,  292,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  277,  278,   -1,  277,  278,   -1,   -1,   -1,   -1,
   -1,  277,  278,  286,  287,  288,  289,   -1,  291,  292,
  286,  287,  288,  289,   -1,  291,  292,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  277,
  278,   -1,   -1,   -1,   -1,   -1,  277,  278,  286,  287,
  288,  289,   -1,  291,  292,  286,  287,  288,  289,   -1,
  291,  292,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   37,   -1,   -1,  277,  278,   42,   43,   -1,   45,
   46,   47,   -1,  286,  287,  288,  289,   -1,  291,  292,
   -1,   -1,   37,   -1,   60,   -1,   62,   42,   43,   37,
   45,   46,   47,   41,   42,   43,   44,   45,   46,   47,
  277,  278,   -1,   -1,   -1,   60,   -1,   62,   -1,   -1,
   58,   59,   60,   52,   62,   91,   37,   -1,   -1,   -1,
   41,   42,   43,   44,   45,   46,   47,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   91,   58,   59,   60,
   -1,   62,   -1,   91,   -1,   93,   -1,   -1,   -1,   -1,
   -1,   -1,  277,   92,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  286,  287,  288,  289,   41,  291,  292,   44,   37,
   91,   -1,   93,   41,   42,   43,   44,   45,   -1,   47,
   -1,   -1,   58,   59,   -1,   -1,   -1,   -1,   -1,   -1,
   58,   59,   60,   37,   62,   -1,   -1,   41,   42,   43,
   44,   45,   -1,   47,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   58,   59,   60,   93,   62,   -1,
   41,   -1,   37,   44,   -1,   93,   41,   42,   43,   44,
   45,   -1,   47,  172,   -1,  174,   -1,   58,   59,   -1,
   -1,   -1,   -1,   58,   59,   60,   37,   62,   -1,   93,
   41,   42,   43,   44,   45,  194,   47,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  203,  204,   -1,   58,   59,   60,
   -1,   62,   93,   41,  213,   43,   44,   45,   93,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   52,   -1,   -1,   -1,
   58,   59,   60,   -1,   62,   -1,   -1,   -1,   -1,   37,
   -1,   -1,   93,   41,   42,   43,   44,   45,   -1,   47,
  286,  287,  288,  289,   -1,  291,  292,   -1,   -1,   -1,
   58,   59,   60,   -1,   62,   93,   92,   -1,   -1,  277,
  278,  286,  287,   -1,   -1,   -1,  291,  292,  286,  287,
  288,  289,   41,  291,   43,   44,   45,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   93,  277,  278,   -1,   58,
   59,   60,   -1,   62,   -1,  286,  287,  288,  289,   -1,
   41,   -1,   -1,   44,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   58,   59,   -1,
   -1,   -1,   -1,   -1,   93,   -1,   -1,   -1,   -1,   -1,
   -1,  277,  278,   -1,   -1,   -1,  172,   -1,  174,  277,
  278,   -1,  288,  289,   -1,   -1,   -1,   -1,  286,  287,
  288,  289,   93,   -1,   -1,   -1,   -1,   -1,  194,   -1,
   -1,   -1,   -1,  277,  278,   -1,   -1,  203,  204,   -1,
   -1,   -1,  286,  287,  288,  289,   -1,  213,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  277,  278,   -1,   -1,
   -1,   -1,  277,  278,   -1,   -1,   -1,  288,  289,   -1,
   -1,  286,  287,  288,  289,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  277,  278,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  286,  287,  288,  289,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  277,
  278,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  286,  287,
  288,  289,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  277,
  278,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  286,  287,
  288,  289,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   58,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   68,
   69,   70,   -1,   -1,   -1,   -1,   -1,   -1,  277,  278,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  286,  287,  288,
  289,   -1,   91,   -1,   93,   -1,   -1,   -1,   -1,   -1,
   -1,  100,   -1,   -1,  103,   -1,  277,  278,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  288,  289,  118,
  119,  120,  121,  122,  123,   -1,  125,  126,  127,  128,
  129,  130,  131,  132,   -1,  134,  135,   -1,   -1,   -1,
   -1,   -1,  141,   -1,  143,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  171,   -1,  173,   -1,   -1,   -1,   -1,   -1,
  179,   -1,   -1,  182,  183,   -1,  185,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  201,
};
}
final static short YYFINAL=3;
final static short YYMAXTOKEN=294;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,"'!'",null,null,null,"'%'",null,null,"'('","')'","'*'","'+'",
"','","'-'","'.'","'/'",null,null,null,null,null,null,null,null,null,null,"':'",
"';'","'<'","'='","'>'",null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,"'['",null,"']'",null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,"'{'",null,"'}'",null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,"VOID","BOOL","INT","STRING",
"CLASS","NULL","EXTENDS","THIS","WHILE","FOR","IF","ELSE","RETURN","BREAK",
"NEW","PRINT","READ_INTEGER","READ_LINE","LITERAL","IDENTIFIER","AND","OR",
"STATIC","SEALED","INSTANCEOF","DIVIDER","SCOPY","FOREACH","DEFAULT",
"LESS_EQUAL","GREATER_EQUAL","EQUAL","NOT_EQUAL","VAR","ARRAY_REPEAT",
"ARRAY_CONCAT","UMINUS","EMPTY",
};
final static String yyrule[] = {
"$accept : Program",
"Program : ClassList",
"ClassList : ClassList ClassDef",
"ClassList : ClassDef",
"VariableDef : Variable ';'",
"Variable : Type IDENTIFIER",
"Type : INT",
"Type : VOID",
"Type : BOOL",
"Type : STRING",
"Type : CLASS IDENTIFIER",
"Type : Type '[' ']'",
"ClassDef : SEALED CLASS IDENTIFIER ExtendsClause '{' FieldList '}'",
"ClassDef : CLASS IDENTIFIER ExtendsClause '{' FieldList '}'",
"ExtendsClause : EXTENDS IDENTIFIER",
"ExtendsClause :",
"FieldList : FieldList VariableDef",
"FieldList : FieldList FunctionDef",
"FieldList :",
"Formals : VariableList",
"Formals :",
"VariableList : VariableList ',' Variable",
"VariableList : Variable",
"FunctionDef : STATIC Type IDENTIFIER '(' Formals ')' StmtBlock",
"FunctionDef : Type IDENTIFIER '(' Formals ')' StmtBlock",
"StmtBlock : '{' StmtList '}'",
"StmtList : StmtList Stmt",
"StmtList :",
"Stmt : OCStmt ';'",
"Stmt : GuardedStmt",
"Stmt : VariableDef",
"Stmt : SimpleStmt ';'",
"Stmt : IfStmt",
"Stmt : WhileStmt",
"Stmt : ForStmt",
"Stmt : ReturnStmt ';'",
"Stmt : PrintStmt ';'",
"Stmt : BreakStmt ';'",
"Stmt : StmtBlock",
"GuardedStmt : IF '{' IfBranchG IfStmtG '}'",
"GuardedStmt : IF '{' '}'",
"IfBranchG : IfBranchG IfStmtG DIVIDER",
"IfBranchG :",
"IfStmtG : Expr ':' Stmt",
"OCStmt : SCOPY '(' IDENTIFIER ',' Expr ')'",
"SimpleStmt : LValue '=' Expr",
"SimpleStmt : Call",
"SimpleStmt :",
"Receiver : Expr '.'",
"Receiver :",
"LValue : VAR IDENTIFIER",
"LValue : Receiver IDENTIFIER",
"LValue : Expr '[' Expr ']'",
"Call : Receiver IDENTIFIER '(' Actuals ')'",
"Expr : Expr ARRAY_REPEAT Constant",
"Expr : Expr ARRAY_CONCAT Expr",
"Expr : Expr '[' Expr ':' Expr ']'",
"Expr : Expr '[' Expr ']' DEFAULT Expr",
"Expr : LValue",
"Expr : Call",
"Expr : Constant",
"Expr : Expr '+' Expr",
"Expr : Expr '-' Expr",
"Expr : Expr '*' Expr",
"Expr : Expr '/' Expr",
"Expr : Expr '%' Expr",
"Expr : Expr EQUAL Expr",
"Expr : Expr NOT_EQUAL Expr",
"Expr : Expr '<' Expr",
"Expr : Expr '>' Expr",
"Expr : Expr LESS_EQUAL Expr",
"Expr : Expr GREATER_EQUAL Expr",
"Expr : Expr AND Expr",
"Expr : Expr OR Expr",
"Expr : '(' Expr ')'",
"Expr : '-' Expr",
"Expr : '!' Expr",
"Expr : READ_INTEGER '(' ')'",
"Expr : READ_LINE '(' ')'",
"Expr : THIS",
"Expr : NEW IDENTIFIER '(' ')'",
"Expr : NEW Type '[' Expr ']'",
"Expr : INSTANCEOF '(' Expr ',' IDENTIFIER ')'",
"Expr : '(' CLASS IDENTIFIER ')' Expr",
"Constant : ArrayConstant",
"Constant : LITERAL",
"Constant : NULL",
"ArrayConstant : '[' ']'",
"ArrayConstant : '[' ArrayInsider ']'",
"ArrayInsider : ArrayInsider ',' Constant",
"ArrayInsider : Constant",
"Actuals : ExprList",
"Actuals :",
"ExprList : ExprList ',' Expr",
"ExprList : Expr",
"WhileStmt : WHILE '(' Expr ')' Stmt",
"ForStmt : FOR '(' SimpleStmt ';' Expr ';' SimpleStmt ')' Stmt",
"BreakStmt : BREAK",
"IfStmt : IF '(' Expr ')' Stmt ElseClause",
"ElseClause : ELSE Stmt",
"ElseClause :",
"ReturnStmt : RETURN Expr",
"ReturnStmt : RETURN",
"PrintStmt : PRINT '(' ExprList ')'",
};

//#line 515 "Parser.y"
    
	/**
	 * 打印当前归约所用的语法规则<br>
	 * 请勿修改。
	 */
    public boolean onReduce(String rule) {
		if (rule.startsWith("$$"))
			return false;
		else
			rule = rule.replaceAll(" \\$\\$\\d+", "");

   	    if (rule.endsWith(":"))
    	    System.out.println(rule + " <empty>");
   	    else
			System.out.println(rule);
		return false;
    }
    
    public void diagnose() {
		addReduceListener(this);
		yyparse();
	}
//#line 714 "Parser.java"
//###############################################################
// method: yylexdebug : check lexer state
//###############################################################
void yylexdebug(int state,int ch)
{
String s=null;
  if (ch < 0) ch=0;
  if (ch <= YYMAXTOKEN) //check index bounds
     s = yyname[ch];    //now get it
  if (s==null)
    s = "illegal-symbol";
  debug("state "+state+", reading "+ch+" ("+s+")");
}





//The following are now global, to aid in error reporting
int yyn;       //next next thing to do
int yym;       //
int yystate;   //current parsing state from state table
String yys;    //current token string


//###############################################################
// method: yyparse : parse input and execute indicated items
//###############################################################
int yyparse()
{
boolean doaction;
  init_stacks();
  yynerrs = 0;
  yyerrflag = 0;
  yychar = -1;          //impossible char forces a read
  yystate=0;            //initial state
  state_push(yystate);  //save it
  while (true) //until parsing is done, either correctly, or w/error
    {
    doaction=true;
    //if (yydebug) debug("loop"); 
    //#### NEXT ACTION (from reduction table)
    for (yyn=yydefred[yystate];yyn==0;yyn=yydefred[yystate])
      {
      //if (yydebug) debug("yyn:"+yyn+"  state:"+yystate+"  yychar:"+yychar);
      if (yychar < 0)      //we want a char?
        {
        yychar = yylex();  //get next token
        //if (yydebug) debug(" next yychar:"+yychar);
        //#### ERROR CHECK ####
        //if (yychar < 0)    //it it didn't work/error
        //  {
        //  yychar = 0;      //change it to default string (no -1!)
          //if (yydebug)
          //  yylexdebug(yystate,yychar);
        //  }
        }//yychar<0
      yyn = yysindex[yystate];  //get amount to shift by (shift index)
      if ((yyn != 0) && (yyn += yychar) >= 0 &&
          yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
        {
        //if (yydebug)
          //debug("state "+yystate+", shifting to state "+yytable[yyn]);
        //#### NEXT STATE ####
        yystate = yytable[yyn];//we are in a new state
        state_push(yystate);   //save it
        val_push(yylval);      //push our lval as the input for next rule
        yychar = -1;           //since we have 'eaten' a token, say we need another
        if (yyerrflag > 0)     //have we recovered an error?
           --yyerrflag;        //give ourselves credit
        doaction=false;        //but don't process yet
        break;   //quit the yyn=0 loop
        }

    yyn = yyrindex[yystate];  //reduce
    if ((yyn !=0 ) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
      {   //we reduced!
      //if (yydebug) debug("reduce");
      yyn = yytable[yyn];
      doaction=true; //get ready to execute
      break;         //drop down to actions
      }
    else //ERROR RECOVERY
      {
      if (yyerrflag==0)
        {
        yyerror("syntax error");
        yynerrs++;
        }
      if (yyerrflag < 3) //low error count?
        {
        yyerrflag = 3;
        while (true)   //do until break
          {
          if (stateptr<0 || valptr<0)   //check for under & overflow here
            {
            return 1;
            }
          yyn = yysindex[state_peek(0)];
          if ((yyn != 0) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
            //if (yydebug)
              //debug("state "+state_peek(0)+", error recovery shifting to state "+yytable[yyn]+" ");
            yystate = yytable[yyn];
            state_push(yystate);
            val_push(yylval);
            doaction=false;
            break;
            }
          else
            {
            //if (yydebug)
              //debug("error recovery discarding state "+state_peek(0)+" ");
            if (stateptr<0 || valptr<0)   //check for under & overflow here
              {
              return 1;
              }
            state_pop();
            val_pop();
            }
          }
        }
      else            //discard this token
        {
        if (yychar == 0)
          return 1; //yyabort
        //if (yydebug)
          //{
          //yys = null;
          //if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
          //if (yys == null) yys = "illegal-symbol";
          //debug("state "+yystate+", error recovery discards token "+yychar+" ("+yys+")");
          //}
        yychar = -1;  //read another
        }
      }//end error recovery
    }//yyn=0 loop
    if (!doaction)   //any reason not to proceed?
      continue;      //skip action
    yym = yylen[yyn];          //get count of terminals on rhs
    //if (yydebug)
      //debug("state "+yystate+", reducing "+yym+" by rule "+yyn+" ("+yyrule[yyn]+")");
    if (yym>0)                 //if count of rhs not 'nil'
      yyval = val_peek(yym-1); //get current semantic value
    if (reduceListener == null || reduceListener.onReduce(yyrule[yyn])) // if intercepted!
      switch(yyn)
      {
//########## USER-SUPPLIED ACTIONS ##########
case 1:
//#line 62 "Parser.y"
{
						tree = new Tree.TopLevel(val_peek(0).clist, val_peek(0).loc);
					}
break;
case 2:
//#line 68 "Parser.y"
{
						yyval.clist.add(val_peek(0).cdef);
					}
break;
case 3:
//#line 72 "Parser.y"
{
                		yyval.clist = new ArrayList<Tree.ClassDef>();
                		yyval.clist.add(val_peek(0).cdef);
                	}
break;
case 5:
//#line 82 "Parser.y"
{
						yyval.vdef = new Tree.VarDef(val_peek(0).ident, val_peek(1).type, val_peek(0).loc);
					}
break;
case 6:
//#line 88 "Parser.y"
{
						yyval.type = new Tree.TypeIdent(Tree.INT, val_peek(0).loc);
					}
break;
case 7:
//#line 92 "Parser.y"
{
                		yyval.type = new Tree.TypeIdent(Tree.VOID, val_peek(0).loc);
                	}
break;
case 8:
//#line 96 "Parser.y"
{
                		yyval.type = new Tree.TypeIdent(Tree.BOOL, val_peek(0).loc);
                	}
break;
case 9:
//#line 100 "Parser.y"
{
                		yyval.type = new Tree.TypeIdent(Tree.STRING, val_peek(0).loc);
                	}
break;
case 10:
//#line 104 "Parser.y"
{
                		yyval.type = new Tree.TypeClass(val_peek(0).ident, val_peek(1).loc);
                	}
break;
case 11:
//#line 108 "Parser.y"
{
                		yyval.type = new Tree.TypeArray(val_peek(2).type, val_peek(2).loc);
                	}
break;
case 12:
//#line 114 "Parser.y"
{
						yyval.cdef = new Tree.ClassDef(true, val_peek(4).ident, val_peek(3).ident, val_peek(1).flist, val_peek(6).loc);
					}
break;
case 13:
//#line 118 "Parser.y"
{
                        yyval.cdef = new Tree.ClassDef(false, val_peek(4).ident, val_peek(3).ident, val_peek(1).flist, val_peek(5).loc);
                    }
break;
case 14:
//#line 124 "Parser.y"
{
						yyval.ident = val_peek(0).ident;
					}
break;
case 15:
//#line 128 "Parser.y"
{
                		yyval = new SemValue();
                	}
break;
case 16:
//#line 134 "Parser.y"
{
						yyval.flist.add(val_peek(0).vdef);
					}
break;
case 17:
//#line 138 "Parser.y"
{
						yyval.flist.add(val_peek(0).fdef);
					}
break;
case 18:
//#line 142 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.flist = new ArrayList<Tree>();
                	}
break;
case 20:
//#line 150 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.vlist = new ArrayList<Tree.VarDef>(); 
                	}
break;
case 21:
//#line 157 "Parser.y"
{
						yyval.vlist.add(val_peek(0).vdef);
					}
break;
case 22:
//#line 161 "Parser.y"
{
                		yyval.vlist = new ArrayList<Tree.VarDef>();
						yyval.vlist.add(val_peek(0).vdef);
                	}
break;
case 23:
//#line 169 "Parser.y"
{
						yyval.fdef = new MethodDef(true, val_peek(4).ident, val_peek(5).type, val_peek(2).vlist, (Block) val_peek(0).stmt, val_peek(4).loc);
					}
break;
case 24:
//#line 173 "Parser.y"
{
						yyval.fdef = new MethodDef(false, val_peek(4).ident, val_peek(5).type, val_peek(2).vlist, (Block) val_peek(0).stmt, val_peek(4).loc);
					}
break;
case 25:
//#line 179 "Parser.y"
{
						yyval.stmt = new Block(val_peek(1).slist, val_peek(2).loc);
					}
break;
case 26:
//#line 185 "Parser.y"
{
						yyval.slist.add(val_peek(0).stmt);
					}
break;
case 27:
//#line 189 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.slist = new ArrayList<Tree>();
                	}
break;
case 30:
//#line 198 "Parser.y"
{
						yyval.stmt = val_peek(0).vdef;
					}
break;
case 31:
//#line 203 "Parser.y"
{
                		if (yyval.stmt == null) {
                			yyval.stmt = new Tree.Skip(val_peek(0).loc);
                		}
                	}
break;
case 39:
//#line 218 "Parser.y"
{
                    val_peek(2).slist.add(val_peek(1).stmt);
                    yyval.stmt = new Tree.Guard(val_peek(2).slist, val_peek(4).loc);

                }
break;
case 40:
//#line 224 "Parser.y"
{
                    yyval.stmt = new Tree.Guard(null, val_peek(2).loc);
                }
break;
case 41:
//#line 230 "Parser.y"
{
                        yyval.slist.add(val_peek(1).stmt);
                    }
break;
case 42:
//#line 234 "Parser.y"
{
                        yyval = new SemValue();
                        yyval.slist = new ArrayList<Tree>();
                    }
break;
case 43:
//#line 241 "Parser.y"
{
                        yyval.stmt = new Tree.IfG(val_peek(2).expr, val_peek(0).stmt, val_peek(2).loc);
                    }
break;
case 44:
//#line 248 "Parser.y"
{
                        yyval.stmt = new Tree.Scopy(val_peek(3).ident, val_peek(1).expr, val_peek(3).loc);
                    }
break;
case 45:
//#line 254 "Parser.y"
{
						yyval.stmt = new Tree.Assign(val_peek(2).lvalue, val_peek(0).expr, val_peek(1).loc);
					}
break;
case 46:
//#line 258 "Parser.y"
{
                		yyval.stmt = new Tree.Exec(val_peek(0).expr, val_peek(0).loc);
                	}
break;
case 47:
//#line 262 "Parser.y"
{
                		yyval = new SemValue();
                	}
break;
case 49:
//#line 269 "Parser.y"
{
                		yyval = new SemValue();
                	}
break;
case 50:
//#line 275 "Parser.y"
{
                        yyval.lvalue = new Tree.IdentVar(val_peek(0).ident, val_peek(0).loc);
                        if (val_peek(1).loc == null) {
                        yyval.loc = val_peek(0).loc;
                        }
                    }
break;
case 51:
//#line 282 "Parser.y"
{
						yyval.lvalue = new Tree.Ident(val_peek(1).expr, val_peek(0).ident, val_peek(0).loc);
						if (val_peek(1).loc == null) {
							yyval.loc = val_peek(0).loc;
						}
					}
break;
case 52:
//#line 289 "Parser.y"
{
                		yyval.lvalue = new Tree.Indexed(val_peek(3).expr, val_peek(1).expr, val_peek(3).loc);
                	}
break;
case 53:
//#line 295 "Parser.y"
{
						yyval.expr = new Tree.CallExpr(val_peek(4).expr, val_peek(3).ident, val_peek(1).elist, val_peek(3).loc);
						if (val_peek(4).loc == null) {
							yyval.loc = val_peek(3).loc;
						}
					}
break;
case 54:
//#line 304 "Parser.y"
{
                        yyval.expr = new Tree.ArrayInit(val_peek(2).expr, val_peek(0).expr, val_peek(2).loc);
                    }
break;
case 55:
//#line 308 "Parser.y"
{
                        yyval.expr = new Tree.ArrayConcat(val_peek(2).expr, val_peek(0).expr, val_peek(2).loc);
                    }
break;
case 58:
//#line 314 "Parser.y"
{
						yyval.expr = val_peek(0).lvalue;
					}
break;
case 61:
//#line 320 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.PLUS, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 62:
//#line 324 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MINUS, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 63:
//#line 328 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MUL, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 64:
//#line 332 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.DIV, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 65:
//#line 336 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MOD, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 66:
//#line 340 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.EQ, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 67:
//#line 344 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.NE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 68:
//#line 348 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.LT, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 69:
//#line 352 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.GT, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 70:
//#line 356 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.LE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 71:
//#line 360 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.GE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 72:
//#line 364 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.AND, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 73:
//#line 368 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.OR, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 74:
//#line 372 "Parser.y"
{
                		yyval = val_peek(1);
                	}
break;
case 75:
//#line 376 "Parser.y"
{
                		yyval.expr = new Tree.Unary(Tree.NEG, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 76:
//#line 380 "Parser.y"
{
                		yyval.expr = new Tree.Unary(Tree.NOT, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 77:
//#line 384 "Parser.y"
{
                		yyval.expr = new Tree.ReadIntExpr(val_peek(2).loc);
                	}
break;
case 78:
//#line 388 "Parser.y"
{
                		yyval.expr = new Tree.ReadLineExpr(val_peek(2).loc);
                	}
break;
case 79:
//#line 392 "Parser.y"
{
                		yyval.expr = new Tree.ThisExpr(val_peek(0).loc);
                	}
break;
case 80:
//#line 396 "Parser.y"
{
                		yyval.expr = new Tree.NewClass(val_peek(2).ident, val_peek(3).loc);
                	}
break;
case 81:
//#line 400 "Parser.y"
{
                		yyval.expr = new Tree.NewArray(val_peek(3).type, val_peek(1).expr, val_peek(4).loc);
                	}
break;
case 82:
//#line 404 "Parser.y"
{
                		yyval.expr = new Tree.TypeTest(val_peek(3).expr, val_peek(1).ident, val_peek(5).loc);
                	}
break;
case 83:
//#line 408 "Parser.y"
{
                		yyval.expr = new Tree.TypeCast(val_peek(2).ident, val_peek(0).expr, val_peek(0).loc);
                	}
break;
case 85:
//#line 415 "Parser.y"
{
						yyval.expr = new Tree.Literal(val_peek(0).typeTag, val_peek(0).literal, val_peek(0).loc);
					}
break;
case 86:
//#line 419 "Parser.y"
{
						yyval.expr = new Null(val_peek(0).loc);
					}
break;
case 87:
//#line 425 "Parser.y"
{
                        yyval.expr = new Tree.Array(null, val_peek(1).loc);
                    }
break;
case 88:
//#line 429 "Parser.y"
{
                        yyval.expr = new Tree.Array(val_peek(1).elist, val_peek(2).loc);
                    }
break;
case 89:
//#line 435 "Parser.y"
{
						yyval.elist.add(val_peek(0).expr);
					}
break;
case 90:
//#line 439 "Parser.y"
{
                		yyval.elist = new ArrayList<Tree.Expr>();
						yyval.elist.add(val_peek(0).expr);
                	}
break;
case 92:
//#line 447 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.elist = new ArrayList<Tree.Expr>();
                	}
break;
case 93:
//#line 454 "Parser.y"
{
						yyval.elist.add(val_peek(0).expr);
					}
break;
case 94:
//#line 458 "Parser.y"
{
                		yyval.elist = new ArrayList<Tree.Expr>();
						yyval.elist.add(val_peek(0).expr);
                	}
break;
case 95:
//#line 465 "Parser.y"
{
						yyval.stmt = new Tree.WhileLoop(val_peek(2).expr, val_peek(0).stmt, val_peek(4).loc);
					}
break;
case 96:
//#line 471 "Parser.y"
{
						yyval.stmt = new Tree.ForLoop(val_peek(6).stmt, val_peek(4).expr, val_peek(2).stmt, val_peek(0).stmt, val_peek(8).loc);
					}
break;
case 97:
//#line 477 "Parser.y"
{
						yyval.stmt = new Tree.Break(val_peek(0).loc);
					}
break;
case 98:
//#line 483 "Parser.y"
{
						yyval.stmt = new Tree.If(val_peek(3).expr, val_peek(1).stmt, val_peek(0).stmt, val_peek(5).loc);
					}
break;
case 99:
//#line 489 "Parser.y"
{
						yyval.stmt = val_peek(0).stmt;
					}
break;
case 100:
//#line 493 "Parser.y"
{
						yyval = new SemValue();
					}
break;
case 101:
//#line 499 "Parser.y"
{
						yyval.stmt = new Tree.Return(val_peek(0).expr, val_peek(1).loc);
					}
break;
case 102:
//#line 503 "Parser.y"
{
                		yyval.stmt = new Tree.Return(null, val_peek(0).loc);
                	}
break;
case 103:
//#line 509 "Parser.y"
{
						yyval.stmt = new Print(val_peek(1).elist, val_peek(3).loc);
					}
break;
//#line 1392 "Parser.java"
//########## END OF USER-SUPPLIED ACTIONS ##########
    }//switch
    //#### Now let's reduce... ####
    //if (yydebug) debug("reduce");
    state_drop(yym);             //we just reduced yylen states
    yystate = state_peek(0);     //get new state
    val_drop(yym);               //corresponding value drop
    yym = yylhs[yyn];            //select next TERMINAL(on lhs)
    if (yystate == 0 && yym == 0)//done? 'rest' state and at first TERMINAL
      {
      //if (yydebug) debug("After reduction, shifting from state 0 to state "+YYFINAL+"");
      yystate = YYFINAL;         //explicitly say we're done
      state_push(YYFINAL);       //and save it
      val_push(yyval);           //also save the semantic value of parsing
      if (yychar < 0)            //we want another character?
        {
        yychar = yylex();        //get next character
        //if (yychar<0) yychar=0;  //clean, if necessary
        //if (yydebug)
          //yylexdebug(yystate,yychar);
        }
      if (yychar == 0)          //Good exit (if lex returns 0 ;-)
         break;                 //quit the loop--all DONE
      }//if yystate
    else                        //else not done yet
      {                         //get next state and push, for next yydefred[]
      yyn = yygindex[yym];      //find out where to go
      if ((yyn != 0) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn]; //get new state
      else
        yystate = yydgoto[yym]; //else go to new defred
      //if (yydebug) debug("after reduction, shifting from state "+state_peek(0)+" to state "+yystate+"");
      state_push(yystate);     //going again, so push state & val...
      val_push(yyval);         //for next action
      }
    }//main loop
  return 0;//yyaccept!!
}
//## end of method parse() ######################################



//## run() --- for Thread #######################################
//## The -Jnorun option was used ##
//## end of method run() ########################################



//## Constructors ###############################################
//## The -Jnoconstruct option was used ##
//###############################################################



}
//################### END OF CLASS ##############################
