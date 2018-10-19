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
public final static short STATIC=277;
public final static short SEALED=278;
public final static short INSTANCEOF=279;
public final static short DIVIDER=280;
public final static short SCOPY=281;
public final static short FOREACH=282;
public final static short DEFAULT=283;
public final static short IN=284;
public final static short VAR=285;
public final static short LESS_EQUAL=286;
public final static short GREATER_EQUAL=287;
public final static short ARRAY_REPEAT=288;
public final static short ARRAY_CONCAT=289;
public final static short EQUAL=290;
public final static short NOT_EQUAL=291;
public final static short AND=292;
public final static short OR=293;
public final static short UMINUS=294;
public final static short EMPTY=295;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    1,    1,    3,    4,    5,    5,    5,    5,    5,
    5,    2,    2,    6,    6,    7,    7,    7,    9,    9,
   10,   10,    8,    8,   11,   12,   12,   13,   13,   13,
   13,   13,   13,   13,   13,   13,   13,   13,   13,   14,
   14,   24,   24,   16,   16,   26,   26,   27,   15,   17,
   17,   17,   30,   30,   28,   28,   28,   29,   32,   25,
   25,   25,   25,   25,   25,   25,   25,   25,   25,   25,
   25,   25,   25,   25,   25,   25,   25,   25,   25,   25,
   25,   25,   25,   25,   25,   25,   25,   25,   25,   25,
   25,   33,   33,   33,   34,   34,   35,   35,   31,   31,
   36,   36,   19,   20,   23,   18,   37,   37,   21,   21,
   22,
};
final static short yylen[] = {                            2,
    1,    2,    1,    2,    2,    1,    1,    1,    1,    2,
    3,    7,    6,    2,    0,    2,    2,    0,    1,    0,
    3,    1,    7,    6,    3,    2,    0,    1,    2,    1,
    1,    2,    1,    1,    1,    2,    2,    2,    1,    7,
    9,    2,    2,    5,    3,    3,    0,    3,    6,    3,
    1,    0,    2,    0,    2,    2,    4,    5,    1,    7,
    9,    3,    3,    6,    6,    1,    1,    1,    3,    3,
    3,    3,    3,    3,    3,    3,    3,    3,    3,    3,
    3,    3,    2,    2,    3,    3,    1,    4,    5,    6,
    5,    1,    1,    1,    2,    3,    3,    1,    1,    0,
    3,    1,    5,    9,    1,    6,    2,    0,    2,    1,
    4,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    3,    0,    0,    2,    0,    0,
    0,   14,   18,    0,    0,   18,    7,    8,    6,    9,
    0,    0,   13,   16,    0,    0,   17,    0,   10,    0,
    4,    0,    0,   12,    0,    0,   11,    0,   22,    0,
    0,    0,    0,    5,    0,    0,    0,   27,   24,   21,
   23,    0,   94,   87,    0,    0,    0,    0,  105,    0,
    0,    0,    0,   93,    0,    0,    0,    0,    0,    0,
    0,    0,   25,   31,   39,   26,   28,    0,   30,    0,
   33,   34,   35,    0,    0,    0,    0,    0,    0,    0,
   68,   92,    0,    0,    0,    0,    0,   66,   67,    0,
    0,    0,    0,    0,    0,    0,    0,   55,   95,    0,
    0,    0,    0,    0,    0,    0,   29,   32,   36,   37,
   38,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   53,    0,    0,
    0,    0,    0,   45,    0,    0,    0,    0,    0,   85,
   86,    0,    0,    0,    0,    0,    0,   96,    0,    0,
   82,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   62,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   88,    0,    0,  111,    0,
    0,   42,   43,    0,    0,   97,    0,    0,    0,   98,
    0,    0,  103,    0,    0,    0,   46,   44,   89,    0,
    0,    0,    0,    0,    0,    0,    0,   58,    0,    0,
  106,   48,   90,   49,    0,    0,    0,    0,   64,    0,
  107,    0,   40,    0,   60,    0,    0,    0,    0,  104,
   41,   61,
};
final static short yydgoto[] = {                          3,
    4,    5,   74,   25,   40,   10,   15,   27,   41,   42,
   75,   52,   76,   77,   78,   79,   80,   81,   82,   83,
   84,   85,   86,  156,   87,  145,  185,   98,   99,   90,
  201,  239,   91,   92,  112,  149,  221,
};
final static short yysindex[] = {                      -241,
 -237, -213,    0, -241,    0, -210, -221,    0, -208,  -60,
 -210,    0,    0,  -46,  109,    0,    0,    0,    0,    0,
 -192,  148,    0,    0,   26,  -80,    0,  465,    0,  -79,
    0,   46,   19,    0,   53,  148,    0,  148,    0,  -78,
   73,   50,   74,    0,   -7,  148,   -7,    0,    0,    0,
    0, 1007,    0,    0,   83,   85,  -14, 1260,    0,   81,
  106,  113,  114,    0,  115,  119,  121, -147, 1059, 1260,
 1260, 1084,    0,    0,    0,    0,    0,   79,    0,  104,
    0,    0,    0,  107,  108,  117,  854,  116,    0, -111,
    0,    0, 1260, 1260, 1260,   55,  854,    0,    0,  139,
   90, 1260,  142,  143, 1260,  -88, -178,    0,    0,  501,
    0,  -42,  -13,  -13,  -86,  525,    0,    0,    0,    0,
    0, 1260, 1260, 1260, 1260, 1260, 1260, 1260, 1260, 1260,
 1260,  -29, 1260, 1260, 1260, 1260, 1260,    0, 1260,  155,
  536,  151,  558,    0, 1260,  172, 1116,  854,    8,    0,
    0,  586,  170,  -61,  -64,  -68,  -58,    0,  -29,  180,
    0,  379,  -13,  -13,  -13,  386,  386,  996,  996,  996,
  996,  207,    0,  -54, 1120, 1120,  931,  157,  854, 1260,
 1037, 1260, 1037,  597, -107,    0,  639, 1260,    0,  -51,
 1260,    0,    0, 1260,  -23,    0, 1260,  -43, 1260,    0,
  198,  219,    0,  674,    2, 1037,    0,    0,    0,  854,
  226,  650,  267, 1260, -257, 1260,  716,    0, 1260, 1037,
    0,    0,    0,    0, 1260, 1037,  416,  854,    0,  227,
    0,  820,    0, 1260,    0, 1037, 1037,  854,  176,    0,
    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,  277,    0,  178,    0,    0,    0,    0,
  178,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  243,    0,    0,    0,  262,    0,  262,    0,    0,
    0,  264,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  -45,    0,    0,    0,    0,    0,  -44,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   30,   30,
   30,   30,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  909,  459,    0,
    0,    0,   30,  -45,   30, 1170,  248,    0,    0,    0,
    0,   30,    0,    0,   30,    0,    0,    0,    0,    0,
  237,    0,   89,   98,    0,    0,    0,    0,    0,    0,
    0,   30,   30,   30,   30,   30,   30,   30,   30,   30,
   30,    0,   30,   30,   30,   30,   30,    0,   30,  -37,
    0,    0,    0,    0,   30,    0,   30,   54,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  127,  164,  200,  939, 1075,   69, 1295, 1335,
 1340,    0,    0,   29,  567,  761, 1371,  134,  -24,  -40,
  -45,   30,  -45,    0,    0,    0,    0,   30,    0,    0,
   30,    0,    0,   30,    0,    0,   30,   -1,   30,    0,
    0,  270,    0,    0,  978,  -45,    0,    0,    0,   67,
    0,    0,    0,   30,   59,   30,    0,    0,  -38,  -45,
    0,    0,    0,    0,   30,  -45,    0,    6,    0,    0,
    0,    0,    0,   30,    0,  -45,  -45,  185,    0,    0,
    0,    0,
};
final static short yygindex[] = {                         0,
    0,  314,    1,   -8,  382,  312,  315,    0,  294,    0,
   22,    0,  548,    0,    0,    0,  -75,    0,    0,    0,
    0,    0,    0,    0, 1546,    0,    0,  687,  853,    0,
    0,    0,  -35,    0,    0,  153,    0,
};
final static int YYTABLESIZE=1780;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         56,
  100,  159,   52,   56,   56,   56,   56,   56,   56,   56,
   33,   33,   33,   52,  110,   24,   50,  208,  142,    1,
   56,   56,   56,   56,   56,   95,   33,   39,   24,   39,
  132,  133,  138,  111,   50,   57,    2,   50,    6,   57,
   57,   57,   57,   57,   57,   57,   65,    7,  189,   65,
  158,  188,    9,   56,   11,   56,   57,   57,   57,   57,
   57,  172,   13,   65,   65,   63,   49,   12,   51,   63,
   63,   63,   63,   63,   63,   63,   16,  122,   17,   18,
   19,   20,   21,   29,   31,   36,   63,   63,   63,   57,
   63,   57,   38,   46,  102,   91,  173,  102,   65,   91,
   91,   91,   91,   91,   91,   91,  154,  101,   96,   76,
  101,   37,   76,   45,   47,   48,   91,   91,   91,   63,
   91,   63,   93,  196,   94,   84,   76,   76,  108,   84,
   84,   84,   84,   84,   83,   84,  200,  117,   83,   83,
   83,   83,   83,  230,   83,  102,   84,   84,   84,   91,
   84,   91,  103,  104,  105,   83,   83,   83,  106,   83,
  107,   76,  118,   71,  140,  119,  120,   71,   71,   71,
   71,   71,  207,   71,   81,  121,  139,   81,  146,  144,
  147,   84,  150,  151,   71,   71,   71,  153,   71,  160,
   83,   81,   81,  125,  180,   32,   35,   44,  123,  126,
   72,  127,  138,  124,   72,   72,   72,   72,   72,  182,
   72,  193,  186,  191,  192,  194,  128,  195,  129,   71,
  197,   72,   72,   72,  211,   72,   81,   56,   56,   56,
   54,   54,   53,   23,  133,   54,   73,   54,  218,  216,
   73,   73,   73,   73,   73,   64,   73,  122,   56,   56,
   56,   56,   56,   56,   56,   56,   72,   73,   73,   73,
  214,   73,  188,   57,   57,   57,  223,  236,  242,  220,
   65,   65,   65,   68,  132,  133,    1,   59,   68,   68,
   98,   68,   68,   68,   57,   57,   57,   57,   57,   57,
   57,   57,   73,   63,   63,   63,   68,  172,   68,  109,
   15,    5,   20,  125,   19,   54,  109,  226,  123,  126,
   99,  127,  138,  124,   63,   63,   63,    8,   63,   63,
   63,   63,   14,   91,   91,   91,  128,   68,  129,   98,
   28,   43,  202,   76,   76,   76,    0,   17,   18,   19,
   20,   21,    0,    0,   91,   91,    0,    0,   91,   91,
   91,   91,    0,   84,   84,   84,  100,  122,   76,   76,
   76,   76,   83,   83,   83,   17,   18,   19,   20,   21,
    0,    0,    0,    0,   84,   84,    0,    0,   84,   84,
   84,   84,    0,   83,   83,   22,    0,   83,   83,   83,
   83,   71,   71,   71,    0,    0,   26,    0,   81,   81,
   81,    0,    0,   30,   17,   18,   19,   20,   21,   26,
    0,    0,   71,   71,    0,  125,   71,   71,   71,   71,
  123,  126,  125,  127,  138,  124,   81,  123,   72,   72,
   72,  138,  124,    0,    0,    0,  199,    0,  128,    0,
  129,  101,  130,  131,  132,  133,  134,  135,  136,   72,
   72,    0,  125,   72,   72,   72,   72,  123,  126,    0,
  127,  138,  124,    0,   73,   73,   73,    0,   53,  122,
    0,  198,    0,    0,    0,  128,  122,  129,    0,    0,
    0,   64,    0,    0,    0,   73,   73,    0,  155,   73,
   73,   73,   73,    0,    0,   67,    0,    0,    0,   51,
   67,   67,   68,   67,   67,   67,  122,    0,  235,    0,
    0,    0,    0,    0,    0,    0,    0,   51,   67,    0,
   67,    0,   68,   68,   68,   68,   68,   68,   68,   68,
    0,  225,    0,    0,    0,    0,    0,  125,    0,    0,
    0,    0,  123,  126,    0,  127,  138,  124,    0,   67,
    0,    0,  130,  131,  132,  133,  134,  135,  136,  137,
  128,  125,  129,    0,    0,  161,  123,  126,    0,  127,
  138,  124,  125,    0,    0,    0,  181,  123,  126,    0,
  127,  138,  124,    0,  128,    0,  129,    0,    0,   34,
    0,  122,    0,    0,  125,  128,    0,  129,  183,  123,
  126,    0,  127,  138,  124,    0,    0,   74,    0,    0,
   74,    0,    0,    0,    0,  122,    0,  128,    0,  129,
    0,    0,  125,    0,   74,   74,  122,  123,  126,  190,
  127,  138,  124,  125,    0,    0,    0,    0,  123,  126,
    0,  127,  138,  124,    0,  128,    0,  129,  122,    0,
    0,    0,    0,    0,  206,    0,  128,    0,  129,   74,
    0,    0,    0,    0,  130,  131,  132,  133,  134,  135,
  136,  137,    0,  132,  133,  125,  122,    0,    0,    0,
  123,  126,  234,  127,  138,  124,  125,  122,    0,    0,
  224,  123,  126,    0,  127,  138,  124,    0,  128,    0,
  129,  130,  131,  132,  133,  134,  135,  136,  137,  128,
  125,  129,    0,    0,    0,  123,  126,    0,  127,  138,
  124,   17,   18,   19,   20,   21,    0,    0,  203,  122,
  205,  209,  219,  128,    0,  129,    0,    0,   88,    0,
  122,   22,    0,    0,   67,   67,   67,   67,   67,   67,
   67,   67,  125,  222,    0,    0,    0,  123,  126,    0,
  127,  138,  124,    0,  122,    0,  157,  231,    0,    0,
    0,    0,    0,  233,    0,  128,    0,  129,    0,    0,
   88,    0,    0,  240,  241,    0,  130,  131,  132,  133,
  134,  135,  136,  137,    0,    0,    0,    0,    0,    0,
    0,   75,    0,    0,   75,    0,  122,    0,  229,    0,
  130,  131,  132,  133,  134,  135,  136,  137,   75,   75,
    0,  130,  131,  132,  133,  134,  135,  136,  137,    0,
    0,   74,   74,   74,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  130,  131,  132,  133,  134,  135,  136,
  137,    0,    0,   75,    0,    0,  125,    0,   74,   74,
  237,  123,  126,    0,  127,  138,  124,   88,    0,   88,
    0,  130,  131,  132,  133,  134,  135,  136,  137,  128,
    0,  129,  130,  131,  132,  133,  134,  135,  136,  137,
  125,    0,   88,    0,    0,  123,  126,    0,  127,  138,
  124,    0,    0,    0,   89,   88,   88,    0,    0,    0,
  122,    0,   88,  128,    0,  129,    0,    0,    0,    0,
    0,    0,   88,   88,  130,  131,  132,  133,  134,  135,
  136,  137,    0,    0,    0,  130,  131,  132,  133,  134,
  135,  136,  137,    0,  122,   66,   89,    0,    0,    0,
   66,   66,    0,   66,   66,   66,    0,    0,    0,  130,
  131,  132,  133,  134,  135,  136,  137,  125,   66,    0,
   66,    0,  123,  126,    0,  127,  138,  124,    0,   69,
    0,   69,   69,   69,    0,    0,    0,    0,    0,    0,
  128,    0,  129,    0,    0,    0,   69,   69,   69,   66,
   69,  130,  131,  132,  133,  134,  135,  136,  137,    0,
  108,    0,    0,    0,    0,    0,    0,  108,    0,    0,
    0,  122,  108,    0,    0,   75,   75,   75,    0,    0,
    0,   69,  125,   89,    0,   89,  108,  123,  126,   70,
  127,  138,  124,    0,    0,    0,   72,    0,    0,    0,
    0,   71,   75,   75,    0,    0,    0,    0,   89,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  108,   70,
    0,   89,   89,    0,    0,    0,   72,    0,   89,    0,
    0,   71,    0,    0,    0,    0,  122,    0,   89,   89,
    0,   70,    0,    0,    0,    0,    0,   69,   72,    0,
  108,    0,  108,   71,    0,  130,  131,  132,  133,  134,
  135,  136,  137,    0,    0,   70,   70,   70,   70,   70,
    0,    0,    0,   72,    0,    0,    0,   69,   71,   48,
    0,   73,   70,   70,   70,    0,   70,    0,    0,  130,
  131,  132,  133,  134,  135,  136,  137,    0,   70,   69,
    0,  109,    0,    0,    0,   72,  125,    0,    0,   48,
   71,  123,  126,    0,  127,  138,  124,   70,    0,    0,
    0,    0,    0,    0,   69,    0,    0,    0,    0,  128,
    0,  129,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   66,   66,   66,   66,   66,   66,
   66,   66,   47,   69,   69,   69,   69,    0,   37,   47,
  122,    0,    0,    0,   47,    0,  130,  131,  132,  133,
  134,  135,    0,    0,   69,   69,    0,    0,   69,   69,
   69,   69,    0,    0,  108,  108,  108,  108,  108,  108,
    0,  108,  108,  108,  108,    0,  108,  108,  108,  108,
  108,  108,  108,  108,    0,    0,  108,  108,  108,  108,
   47,    0,  108,   17,   18,   19,   20,   21,   53,    0,
   54,   55,   56,   57,    0,   58,   59,   60,   61,   62,
   63,   64,    0,  132,  133,   65,    0,   66,   67,    0,
    0,   68,   70,   17,   18,   19,   20,   21,   53,   72,
   54,   55,   56,   57,   71,   58,   59,   60,   61,   62,
   63,   64,    0,    0,    0,   65,    0,   66,   67,    0,
   53,   68,   54,    0,    0,    0,    0,    0,    0,   60,
    0,   62,   63,   64,    0,   77,    0,   65,   77,   70,
   70,   70,    0,   68,  115,   53,    0,   54,    0,    0,
   69,    0,   77,   77,   60,    0,   62,   63,   64,    0,
   70,   70,   65,    0,   70,   70,   70,   70,   68,    0,
    0,    0,    0,    0,    0,   78,    0,   53,   78,   54,
   79,    0,    0,   79,    0,    0,   60,   77,   62,   63,
   64,    0,   78,   78,   65,    0,    0,   79,   79,    0,
   68,    0,    0,    0,    0,  130,  131,  132,  133,    0,
    0,   80,    0,    0,   80,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   78,   80,   80,
    0,   47,   79,   47,    0,    0,    0,    0,    0,    0,
   47,    0,   47,   47,   47,   47,    0,    0,   47,    0,
    0,    0,    0,    0,   47,    0,    0,    0,    0,    0,
    0,    0,    0,   80,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   53,    0,   54,    0,    0,    0,    0,    0,    0,
   60,    0,   62,   63,   64,    0,    0,    0,   65,    0,
    0,    0,    0,    0,   68,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   77,
   77,   77,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   77,   77,   77,   77,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   78,
   78,   78,    0,   97,   79,   79,   79,    0,    0,    0,
    0,    0,    0,    0,  110,  113,  114,  116,    0,    0,
    0,    0,    0,    0,   78,   78,   78,   78,    0,   79,
   79,   79,   79,    0,    0,   80,   80,   80,  141,    0,
  143,    0,    0,    0,    0,    0,    0,  148,    0,    0,
  152,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   80,   80,    0,    0,    0,  162,  163,  164,
  165,  166,  167,  168,  169,  170,  171,    0,  174,  175,
  176,  177,  178,    0,  179,    0,    0,    0,    0,    0,
  184,    0,  187,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  148,    0,  204,    0,    0,
    0,    0,    0,  210,    0,    0,  212,    0,    0,  213,
    0,    0,  215,    0,  217,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  227,
    0,  228,    0,    0,    0,    0,    0,    0,    0,    0,
  232,    0,    0,    0,    0,    0,    0,    0,    0,  238,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         37,
   41,   44,   41,   41,   42,   43,   44,   45,   46,   47,
   91,   91,   91,   59,   59,   15,   41,  125,   94,  261,
   58,   59,   60,   61,   62,   40,   91,   36,   28,   38,
  288,  289,   46,   69,   59,   37,  278,   46,  276,   41,
   42,   43,   44,   45,   46,   47,   41,  261,   41,   44,
   93,   44,  263,   91,  276,   93,   58,   59,   60,   61,
   62,   91,  123,   58,   59,   37,   45,  276,   47,   41,
   42,   43,   44,   45,   46,   47,  123,   91,  257,  258,
  259,  260,  261,  276,   59,   40,   58,   59,   60,   91,
   62,   93,   40,   44,   41,   37,  132,   44,   93,   41,
   42,   43,   44,   45,   46,   47,  285,   41,  123,   41,
   44,   93,   44,   41,   41,  123,   58,   59,   60,   91,
   62,   93,   40,  159,   40,   37,   58,   59,  276,   41,
   42,   43,   44,   45,   37,   47,  172,   59,   41,   42,
   43,   44,   45,  219,   47,   40,   58,   59,   60,   91,
   62,   93,   40,   40,   40,   58,   59,   60,   40,   62,
   40,   93,   59,   37,  276,   59,   59,   41,   42,   43,
   44,   45,  280,   47,   41,   59,   61,   44,   40,  125,
   91,   93,   41,   41,   58,   59,   60,  276,   62,  276,
   93,   58,   59,   37,   40,  276,  276,  276,   42,   43,
   37,   45,   46,   47,   41,   42,   43,   44,   45,   59,
   47,  276,   41,   44,  276,  284,   60,  276,   62,   93,
   41,   58,   59,   60,  276,   62,   93,  265,  266,  267,
  276,  276,  262,  125,  289,  276,   37,  276,   41,  283,
   41,   42,   43,   44,   45,  275,   47,   91,  286,  287,
  288,  289,  290,  291,  292,  293,   93,   58,   59,   60,
  284,   62,   44,  265,  266,  267,   41,   41,   93,  268,
  265,  266,  267,   37,  288,  289,    0,   93,   42,   43,
   44,   45,   46,   47,  286,  287,  288,  289,  290,  291,
  292,  293,   93,  265,  266,  267,   60,   91,   62,   93,
  123,   59,   41,   37,   41,  276,   59,   41,   42,   43,
   41,   45,   46,   47,  286,  287,  288,    4,  290,  291,
  292,  293,   11,  265,  266,  267,   60,   91,   62,   93,
   16,   38,  180,  265,  266,  267,   -1,  257,  258,  259,
  260,  261,   -1,   -1,  286,  287,   -1,   -1,  290,  291,
  292,  293,   -1,  265,  266,  267,  276,   91,  290,  291,
  292,  293,  265,  266,  267,  257,  258,  259,  260,  261,
   -1,   -1,   -1,   -1,  286,  287,   -1,   -1,  290,  291,
  292,  293,   -1,  286,  287,  277,   -1,  290,  291,  292,
  293,  265,  266,  267,   -1,   -1,   15,   -1,  265,  266,
  267,   -1,   -1,   22,  257,  258,  259,  260,  261,   28,
   -1,   -1,  286,  287,   -1,   37,  290,  291,  292,  293,
   42,   43,   37,   45,   46,   47,  293,   42,  265,  266,
  267,   46,   47,   -1,   -1,   -1,   58,   -1,   60,   -1,
   62,   60,  286,  287,  288,  289,  290,  291,  292,  286,
  287,   -1,   37,  290,  291,  292,  293,   42,   43,   -1,
   45,   46,   47,   -1,  265,  266,  267,   -1,  262,   91,
   -1,   93,   -1,   -1,   -1,   60,   91,   62,   -1,   -1,
   -1,  275,   -1,   -1,   -1,  286,  287,   -1,  107,  290,
  291,  292,  293,   -1,   -1,   37,   -1,   -1,   -1,   41,
   42,   43,  266,   45,   46,   47,   91,   -1,   93,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   59,   60,   -1,
   62,   -1,  286,  287,  288,  289,  290,  291,  292,  293,
   -1,  265,   -1,   -1,   -1,   -1,   -1,   37,   -1,   -1,
   -1,   -1,   42,   43,   -1,   45,   46,   47,   -1,   91,
   -1,   -1,  286,  287,  288,  289,  290,  291,  292,  293,
   60,   37,   62,   -1,   -1,   41,   42,   43,   -1,   45,
   46,   47,   37,   -1,   -1,   -1,   41,   42,   43,   -1,
   45,   46,   47,   -1,   60,   -1,   62,   -1,   -1,  125,
   -1,   91,   -1,   -1,   37,   60,   -1,   62,   41,   42,
   43,   -1,   45,   46,   47,   -1,   -1,   41,   -1,   -1,
   44,   -1,   -1,   -1,   -1,   91,   -1,   60,   -1,   62,
   -1,   -1,   37,   -1,   58,   59,   91,   42,   43,   44,
   45,   46,   47,   37,   -1,   -1,   -1,   -1,   42,   43,
   -1,   45,   46,   47,   -1,   60,   -1,   62,   91,   -1,
   -1,   -1,   -1,   -1,   58,   -1,   60,   -1,   62,   93,
   -1,   -1,   -1,   -1,  286,  287,  288,  289,  290,  291,
  292,  293,   -1,  288,  289,   37,   91,   -1,   -1,   -1,
   42,   43,  267,   45,   46,   47,   37,   91,   -1,   -1,
   41,   42,   43,   -1,   45,   46,   47,   -1,   60,   -1,
   62,  286,  287,  288,  289,  290,  291,  292,  293,   60,
   37,   62,   -1,   -1,   -1,   42,   43,   -1,   45,   46,
   47,  257,  258,  259,  260,  261,   -1,   -1,  181,   91,
  183,   93,   59,   60,   -1,   62,   -1,   -1,   52,   -1,
   91,  277,   -1,   -1,  286,  287,  288,  289,  290,  291,
  292,  293,   37,  206,   -1,   -1,   -1,   42,   43,   -1,
   45,   46,   47,   -1,   91,   -1,  266,  220,   -1,   -1,
   -1,   -1,   -1,  226,   -1,   60,   -1,   62,   -1,   -1,
   94,   -1,   -1,  236,  237,   -1,  286,  287,  288,  289,
  290,  291,  292,  293,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   41,   -1,   -1,   44,   -1,   91,   -1,   93,   -1,
  286,  287,  288,  289,  290,  291,  292,  293,   58,   59,
   -1,  286,  287,  288,  289,  290,  291,  292,  293,   -1,
   -1,  265,  266,  267,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  286,  287,  288,  289,  290,  291,  292,
  293,   -1,   -1,   93,   -1,   -1,   37,   -1,  292,  293,
   41,   42,   43,   -1,   45,   46,   47,  181,   -1,  183,
   -1,  286,  287,  288,  289,  290,  291,  292,  293,   60,
   -1,   62,  286,  287,  288,  289,  290,  291,  292,  293,
   37,   -1,  206,   -1,   -1,   42,   43,   -1,   45,   46,
   47,   -1,   -1,   -1,   52,  219,  220,   -1,   -1,   -1,
   91,   -1,  226,   60,   -1,   62,   -1,   -1,   -1,   -1,
   -1,   -1,  236,  237,  286,  287,  288,  289,  290,  291,
  292,  293,   -1,   -1,   -1,  286,  287,  288,  289,  290,
  291,  292,  293,   -1,   91,   37,   94,   -1,   -1,   -1,
   42,   43,   -1,   45,   46,   47,   -1,   -1,   -1,  286,
  287,  288,  289,  290,  291,  292,  293,   37,   60,   -1,
   62,   -1,   42,   43,   -1,   45,   46,   47,   -1,   41,
   -1,   43,   44,   45,   -1,   -1,   -1,   -1,   -1,   -1,
   60,   -1,   62,   -1,   -1,   -1,   58,   59,   60,   91,
   62,  286,  287,  288,  289,  290,  291,  292,  293,   -1,
   33,   -1,   -1,   -1,   -1,   -1,   -1,   40,   -1,   -1,
   -1,   91,   45,   -1,   -1,  265,  266,  267,   -1,   -1,
   -1,   93,   37,  181,   -1,  183,   59,   42,   43,   33,
   45,   46,   47,   -1,   -1,   -1,   40,   -1,   -1,   -1,
   -1,   45,  292,  293,   -1,   -1,   -1,   -1,  206,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   91,   33,
   -1,  219,  220,   -1,   -1,   -1,   40,   -1,  226,   -1,
   -1,   45,   -1,   -1,   -1,   -1,   91,   -1,  236,  237,
   -1,   33,   -1,   -1,   -1,   -1,   -1,   91,   40,   -1,
  123,   -1,  125,   45,   -1,  286,  287,  288,  289,  290,
  291,  292,  293,   -1,   -1,   41,   33,   43,   44,   45,
   -1,   -1,   -1,   40,   -1,   -1,   -1,   91,   45,  123,
   -1,  125,   58,   59,   60,   -1,   62,   -1,   -1,  286,
  287,  288,  289,  290,  291,  292,  293,   -1,   33,   91,
   -1,   93,   -1,   -1,   -1,   40,   37,   -1,   -1,  123,
   45,   42,   43,   -1,   45,   46,   47,   93,   -1,   -1,
   -1,   -1,   -1,   -1,   91,   -1,   -1,   -1,   -1,   60,
   -1,   62,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  286,  287,  288,  289,  290,  291,
  292,  293,   33,  265,  266,  267,   91,   -1,   93,   40,
   91,   -1,   -1,   -1,   45,   -1,  286,  287,  288,  289,
  290,  291,   -1,   -1,  286,  287,   -1,   -1,  290,  291,
  292,  293,   -1,   -1,  257,  258,  259,  260,  261,  262,
   -1,  264,  265,  266,  267,   -1,  269,  270,  271,  272,
  273,  274,  275,  276,   -1,   -1,  279,  280,  281,  282,
   91,   -1,  285,  257,  258,  259,  260,  261,  262,   -1,
  264,  265,  266,  267,   -1,  269,  270,  271,  272,  273,
  274,  275,   -1,  288,  289,  279,   -1,  281,  282,   -1,
   -1,  285,   33,  257,  258,  259,  260,  261,  262,   40,
  264,  265,  266,  267,   45,  269,  270,  271,  272,  273,
  274,  275,   -1,   -1,   -1,  279,   -1,  281,  282,   -1,
  262,  285,  264,   -1,   -1,   -1,   -1,   -1,   -1,  271,
   -1,  273,  274,  275,   -1,   41,   -1,  279,   44,  265,
  266,  267,   -1,  285,  261,  262,   -1,  264,   -1,   -1,
   91,   -1,   58,   59,  271,   -1,  273,  274,  275,   -1,
  286,  287,  279,   -1,  290,  291,  292,  293,  285,   -1,
   -1,   -1,   -1,   -1,   -1,   41,   -1,  262,   44,  264,
   41,   -1,   -1,   44,   -1,   -1,  271,   93,  273,  274,
  275,   -1,   58,   59,  279,   -1,   -1,   58,   59,   -1,
  285,   -1,   -1,   -1,   -1,  286,  287,  288,  289,   -1,
   -1,   41,   -1,   -1,   44,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   93,   58,   59,
   -1,  262,   93,  264,   -1,   -1,   -1,   -1,   -1,   -1,
  271,   -1,  273,  274,  275,  276,   -1,   -1,  279,   -1,
   -1,   -1,   -1,   -1,  285,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   93,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  262,   -1,  264,   -1,   -1,   -1,   -1,   -1,   -1,
  271,   -1,  273,  274,  275,   -1,   -1,   -1,  279,   -1,
   -1,   -1,   -1,   -1,  285,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  265,
  266,  267,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  290,  291,  292,  293,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  265,
  266,  267,   -1,   58,  265,  266,  267,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   69,   70,   71,   72,   -1,   -1,
   -1,   -1,   -1,   -1,  290,  291,  292,  293,   -1,  290,
  291,  292,  293,   -1,   -1,  265,  266,  267,   93,   -1,
   95,   -1,   -1,   -1,   -1,   -1,   -1,  102,   -1,   -1,
  105,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  292,  293,   -1,   -1,   -1,  122,  123,  124,
  125,  126,  127,  128,  129,  130,  131,   -1,  133,  134,
  135,  136,  137,   -1,  139,   -1,   -1,   -1,   -1,   -1,
  145,   -1,  147,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  180,   -1,  182,   -1,   -1,
   -1,   -1,   -1,  188,   -1,   -1,  191,   -1,   -1,  194,
   -1,   -1,  197,   -1,  199,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  214,
   -1,  216,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  225,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  234,
};
}
final static short YYFINAL=3;
final static short YYMAXTOKEN=295;
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
"NEW","PRINT","READ_INTEGER","READ_LINE","LITERAL","IDENTIFIER","STATIC",
"SEALED","INSTANCEOF","DIVIDER","SCOPY","FOREACH","DEFAULT","IN","VAR",
"LESS_EQUAL","GREATER_EQUAL","ARRAY_REPEAT","ARRAY_CONCAT","EQUAL","NOT_EQUAL",
"AND","OR","UMINUS","EMPTY",
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
"Stmt : ForeachStmt",
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
"ForeachStmt : FOREACH '(' BoundVariable IN Expr ')' Stmt",
"ForeachStmt : FOREACH '(' BoundVariable IN Expr WHILE Expr ')' Stmt",
"BoundVariable : VAR IDENTIFIER",
"BoundVariable : Type IDENTIFIER",
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
"BoolExpr : Expr",
"Expr : '[' Expr FOR IDENTIFIER IN Expr ']'",
"Expr : '[' Expr FOR IDENTIFIER IN Expr IF BoolExpr ']'",
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

//#line 564 "Parser.y"
    
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
//#line 798 "Parser.java"
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
//#line 72 "Parser.y"
{
						tree = new Tree.TopLevel(val_peek(0).clist, val_peek(0).loc);
					}
break;
case 2:
//#line 78 "Parser.y"
{
						yyval.clist.add(val_peek(0).cdef);
					}
break;
case 3:
//#line 82 "Parser.y"
{
                		yyval.clist = new ArrayList<Tree.ClassDef>();
                		yyval.clist.add(val_peek(0).cdef);
                	}
break;
case 5:
//#line 92 "Parser.y"
{
						yyval.vdef = new Tree.VarDef(val_peek(0).ident, val_peek(1).type, val_peek(0).loc);
					}
break;
case 6:
//#line 98 "Parser.y"
{
						yyval.type = new Tree.TypeIdent(Tree.INT, val_peek(0).loc);
					}
break;
case 7:
//#line 102 "Parser.y"
{
                		yyval.type = new Tree.TypeIdent(Tree.VOID, val_peek(0).loc);
                	}
break;
case 8:
//#line 106 "Parser.y"
{
                		yyval.type = new Tree.TypeIdent(Tree.BOOL, val_peek(0).loc);
                	}
break;
case 9:
//#line 110 "Parser.y"
{
                		yyval.type = new Tree.TypeIdent(Tree.STRING, val_peek(0).loc);
                	}
break;
case 10:
//#line 114 "Parser.y"
{
                		yyval.type = new Tree.TypeClass(val_peek(0).ident, val_peek(1).loc);
                	}
break;
case 11:
//#line 118 "Parser.y"
{
                		yyval.type = new Tree.TypeArray(val_peek(2).type, val_peek(2).loc);
                	}
break;
case 12:
//#line 124 "Parser.y"
{
						yyval.cdef = new Tree.ClassDef(true, val_peek(4).ident, val_peek(3).ident, val_peek(1).flist, val_peek(6).loc);
					}
break;
case 13:
//#line 128 "Parser.y"
{
                        yyval.cdef = new Tree.ClassDef(false, val_peek(4).ident, val_peek(3).ident, val_peek(1).flist, val_peek(5).loc);
                    }
break;
case 14:
//#line 134 "Parser.y"
{
						yyval.ident = val_peek(0).ident;
					}
break;
case 15:
//#line 138 "Parser.y"
{
                		yyval = new SemValue();
                	}
break;
case 16:
//#line 144 "Parser.y"
{
						yyval.flist.add(val_peek(0).vdef);
					}
break;
case 17:
//#line 148 "Parser.y"
{
						yyval.flist.add(val_peek(0).fdef);
					}
break;
case 18:
//#line 152 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.flist = new ArrayList<Tree>();
                	}
break;
case 20:
//#line 160 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.vlist = new ArrayList<Tree.VarDef>(); 
                	}
break;
case 21:
//#line 167 "Parser.y"
{
						yyval.vlist.add(val_peek(0).vdef);
					}
break;
case 22:
//#line 171 "Parser.y"
{
                		yyval.vlist = new ArrayList<Tree.VarDef>();
						yyval.vlist.add(val_peek(0).vdef);
                	}
break;
case 23:
//#line 179 "Parser.y"
{
						yyval.fdef = new MethodDef(true, val_peek(4).ident, val_peek(5).type, val_peek(2).vlist, (Block) val_peek(0).stmt, val_peek(4).loc);
					}
break;
case 24:
//#line 183 "Parser.y"
{
						yyval.fdef = new MethodDef(false, val_peek(4).ident, val_peek(5).type, val_peek(2).vlist, (Block) val_peek(0).stmt, val_peek(4).loc);
					}
break;
case 25:
//#line 189 "Parser.y"
{
						yyval.stmt = new Block(val_peek(1).slist, val_peek(2).loc);
					}
break;
case 26:
//#line 195 "Parser.y"
{
						yyval.slist.add(val_peek(0).stmt);
					}
break;
case 27:
//#line 199 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.slist = new ArrayList<Tree>();
                	}
break;
case 31:
//#line 209 "Parser.y"
{
						yyval.stmt = val_peek(0).vdef;
					}
break;
case 32:
//#line 214 "Parser.y"
{
                		if (yyval.stmt == null) {
                			yyval.stmt = new Tree.Skip(val_peek(0).loc);
                		}
                	}
break;
case 40:
//#line 229 "Parser.y"
{
                    yyval.stmt = new Tree.ArrayFor(false, val_peek(4).lvalue, val_peek(2).expr, val_peek(0).stmt, null, val_peek(6).loc);
                    }
break;
case 41:
//#line 233 "Parser.y"
{
                        yyval.stmt = new Tree.ArrayFor(true, val_peek(6).lvalue, val_peek(4).expr, val_peek(0).stmt, val_peek(2).expr, val_peek(8).loc);
                    }
break;
case 42:
//#line 239 "Parser.y"
{
                        yyval.lvalue = new LValue.BoundVar(null, val_peek(0).ident, val_peek(1).loc);
                    }
break;
case 43:
//#line 243 "Parser.y"
{
                        yyval.lvalue = new LValue.BoundVar(val_peek(1).type, val_peek(0).ident, val_peek(1).loc);
                    }
break;
case 44:
//#line 250 "Parser.y"
{
                    val_peek(2).slist.add(val_peek(1).stmt);
                    yyval.stmt = new Tree.Guard(val_peek(2).slist, val_peek(4).loc);

                }
break;
case 45:
//#line 256 "Parser.y"
{
                    yyval.stmt = new Tree.Guard(null, val_peek(2).loc);
                }
break;
case 46:
//#line 262 "Parser.y"
{
                        yyval.slist.add(val_peek(1).stmt);
                    }
break;
case 47:
//#line 266 "Parser.y"
{
                        yyval = new SemValue();
                        yyval.slist = new ArrayList<Tree>();
                    }
break;
case 48:
//#line 273 "Parser.y"
{
                        yyval.stmt = new Tree.IfG(val_peek(2).expr, val_peek(0).stmt, val_peek(2).loc);
                    }
break;
case 49:
//#line 280 "Parser.y"
{
                        yyval.stmt = new Tree.Scopy(val_peek(3).ident, val_peek(1).expr, val_peek(3).loc);
                    }
break;
case 50:
//#line 286 "Parser.y"
{
						yyval.stmt = new Tree.Assign(val_peek(2).lvalue, val_peek(0).expr, val_peek(1).loc);
					}
break;
case 51:
//#line 290 "Parser.y"
{
                		yyval.stmt = new Tree.Exec(val_peek(0).expr, val_peek(0).loc);
                	}
break;
case 52:
//#line 294 "Parser.y"
{
                		yyval = new SemValue();
                	}
break;
case 54:
//#line 301 "Parser.y"
{
                		yyval = new SemValue();
                	}
break;
case 55:
//#line 307 "Parser.y"
{
                        yyval.lvalue = new Tree.IdentVar(val_peek(0).ident, val_peek(0).loc);
                        if (val_peek(1).loc == null) {
                        yyval.loc = val_peek(0).loc;
                        }
                    }
break;
case 56:
//#line 314 "Parser.y"
{
						yyval.lvalue = new Tree.Ident(val_peek(1).expr, val_peek(0).ident, val_peek(0).loc);
						if (val_peek(1).loc == null) {
							yyval.loc = val_peek(0).loc;
						}
					}
break;
case 57:
//#line 321 "Parser.y"
{
                		yyval.lvalue = new Tree.Indexed(val_peek(3).expr, val_peek(1).expr, val_peek(3).loc);
                	}
break;
case 58:
//#line 327 "Parser.y"
{
						yyval.expr = new Tree.CallExpr(val_peek(4).expr, val_peek(3).ident, val_peek(1).elist, val_peek(3).loc);
						if (val_peek(4).loc == null) {
							yyval.loc = val_peek(3).loc;
						}
					}
break;
case 60:
//#line 339 "Parser.y"
{
                        yyval.expr = new Tree.ArrayComp(false, val_peek(5).expr, val_peek(3).ident, val_peek(1).expr, null, val_peek(6).loc);
                    }
break;
case 61:
//#line 343 "Parser.y"
{
                        yyval.expr = new Tree.ArrayComp(true, val_peek(7).expr, val_peek(5).ident, val_peek(3).expr, val_peek(1).expr, val_peek(8).loc);
                    }
break;
case 62:
//#line 347 "Parser.y"
{
                        yyval.expr = new Tree.ArrayInit(val_peek(2).expr, val_peek(0).expr, val_peek(2).loc);
                    }
break;
case 63:
//#line 351 "Parser.y"
{
                        yyval.expr = new Tree.ArrayConcat(val_peek(2).expr, val_peek(0).expr, val_peek(2).loc);
                    }
break;
case 64:
//#line 355 "Parser.y"
{
                        yyval.expr = new Tree.ArrayRef(val_peek(5).expr, val_peek(3).expr, val_peek(1).expr, val_peek(5).loc);
                    }
break;
case 65:
//#line 359 "Parser.y"
{
                        yyval.expr = new Tree.ArrayDefault(val_peek(5).expr, val_peek(3).expr, val_peek(0).expr, val_peek(5).loc);
                    }
break;
case 66:
//#line 363 "Parser.y"
{
						yyval.expr = val_peek(0).lvalue;
					}
break;
case 69:
//#line 369 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.PLUS, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 70:
//#line 373 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MINUS, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 71:
//#line 377 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MUL, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 72:
//#line 381 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.DIV, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 73:
//#line 385 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MOD, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 74:
//#line 389 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.EQ, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 75:
//#line 393 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.NE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 76:
//#line 397 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.LT, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 77:
//#line 401 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.GT, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 78:
//#line 405 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.LE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 79:
//#line 409 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.GE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 80:
//#line 413 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.AND, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 81:
//#line 417 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.OR, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 82:
//#line 421 "Parser.y"
{
                		yyval = val_peek(1);
                	}
break;
case 83:
//#line 425 "Parser.y"
{
                		yyval.expr = new Tree.Unary(Tree.NEG, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 84:
//#line 429 "Parser.y"
{
                		yyval.expr = new Tree.Unary(Tree.NOT, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 85:
//#line 433 "Parser.y"
{
                		yyval.expr = new Tree.ReadIntExpr(val_peek(2).loc);
                	}
break;
case 86:
//#line 437 "Parser.y"
{
                		yyval.expr = new Tree.ReadLineExpr(val_peek(2).loc);
                	}
break;
case 87:
//#line 441 "Parser.y"
{
                		yyval.expr = new Tree.ThisExpr(val_peek(0).loc);
                	}
break;
case 88:
//#line 445 "Parser.y"
{
                		yyval.expr = new Tree.NewClass(val_peek(2).ident, val_peek(3).loc);
                	}
break;
case 89:
//#line 449 "Parser.y"
{
                		yyval.expr = new Tree.NewArray(val_peek(3).type, val_peek(1).expr, val_peek(4).loc);
                	}
break;
case 90:
//#line 453 "Parser.y"
{
                		yyval.expr = new Tree.TypeTest(val_peek(3).expr, val_peek(1).ident, val_peek(5).loc);
                	}
break;
case 91:
//#line 457 "Parser.y"
{
                		yyval.expr = new Tree.TypeCast(val_peek(2).ident, val_peek(0).expr, val_peek(0).loc);
                	}
break;
case 93:
//#line 464 "Parser.y"
{
						yyval.expr = new Tree.Literal(val_peek(0).typeTag, val_peek(0).literal, val_peek(0).loc);
					}
break;
case 94:
//#line 468 "Parser.y"
{
						yyval.expr = new Null(val_peek(0).loc);
					}
break;
case 95:
//#line 474 "Parser.y"
{
                        yyval.expr = new Tree.Array(null, val_peek(1).loc);
                    }
break;
case 96:
//#line 478 "Parser.y"
{
                        yyval.expr = new Tree.Array(val_peek(1).elist, val_peek(2).loc);
                    }
break;
case 97:
//#line 484 "Parser.y"
{
						yyval.elist.add(val_peek(0).expr);
					}
break;
case 98:
//#line 488 "Parser.y"
{
                		yyval.elist = new ArrayList<Tree.Expr>();
						yyval.elist.add(val_peek(0).expr);
                	}
break;
case 100:
//#line 496 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.elist = new ArrayList<Tree.Expr>();
                	}
break;
case 101:
//#line 503 "Parser.y"
{
						yyval.elist.add(val_peek(0).expr);
					}
break;
case 102:
//#line 507 "Parser.y"
{
                		yyval.elist = new ArrayList<Tree.Expr>();
						yyval.elist.add(val_peek(0).expr);
                	}
break;
case 103:
//#line 514 "Parser.y"
{
						yyval.stmt = new Tree.WhileLoop(val_peek(2).expr, val_peek(0).stmt, val_peek(4).loc);
					}
break;
case 104:
//#line 520 "Parser.y"
{
						yyval.stmt = new Tree.ForLoop(val_peek(6).stmt, val_peek(4).expr, val_peek(2).stmt, val_peek(0).stmt, val_peek(8).loc);
					}
break;
case 105:
//#line 526 "Parser.y"
{
						yyval.stmt = new Tree.Break(val_peek(0).loc);
					}
break;
case 106:
//#line 532 "Parser.y"
{
						yyval.stmt = new Tree.If(val_peek(3).expr, val_peek(1).stmt, val_peek(0).stmt, val_peek(5).loc);
					}
break;
case 107:
//#line 538 "Parser.y"
{
						yyval.stmt = val_peek(0).stmt;
					}
break;
case 108:
//#line 542 "Parser.y"
{
						yyval = new SemValue();
					}
break;
case 109:
//#line 548 "Parser.y"
{
						yyval.stmt = new Tree.Return(val_peek(0).expr, val_peek(1).loc);
					}
break;
case 110:
//#line 552 "Parser.y"
{
                		yyval.stmt = new Tree.Return(null, val_peek(0).loc);
                	}
break;
case 111:
//#line 558 "Parser.y"
{
						yyval.stmt = new Print(val_peek(1).elist, val_peek(3).loc);
					}
break;
//#line 1524 "Parser.java"
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
