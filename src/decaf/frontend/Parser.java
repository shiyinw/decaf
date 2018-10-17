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
public final static short SCOPY=282;
public final static short LESS_EQUAL=283;
public final static short GREATER_EQUAL=284;
public final static short EQUAL=285;
public final static short NOT_EQUAL=286;
public final static short VAR=287;
public final static short UMINUS=288;
public final static short EMPTY=289;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    1,    1,    3,    4,    5,    5,    5,    5,    5,
    5,    2,    2,    6,    6,    7,    7,    7,    9,    9,
   10,   10,    8,    8,   11,   12,   12,   13,   13,   13,
   13,   13,   13,   13,   13,   13,   13,   14,   15,   15,
   15,   25,   25,   23,   23,   23,   24,   22,   22,   22,
   22,   22,   22,   22,   22,   22,   22,   22,   22,   22,
   22,   22,   22,   22,   22,   22,   22,   22,   22,   22,
   22,   22,   22,   27,   27,   26,   26,   28,   28,   17,
   18,   21,   16,   29,   29,   19,   19,   20,
};
final static short yylen[] = {                            2,
    1,    2,    1,    2,    2,    1,    1,    1,    1,    2,
    3,    7,    6,    2,    0,    2,    2,    0,    1,    0,
    3,    1,    7,    6,    3,    2,    0,    2,    1,    2,
    1,    1,    1,    2,    2,    2,    1,    6,    3,    1,
    0,    2,    0,    2,    2,    4,    5,    1,    1,    1,
    3,    3,    3,    3,    3,    3,    3,    3,    3,    3,
    3,    3,    3,    3,    2,    2,    3,    3,    1,    4,
    5,    6,    5,    1,    1,    1,    0,    3,    1,    5,
    9,    1,    6,    2,    0,    2,    1,    4,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    3,    0,    0,    2,    0,    0,
    0,   14,   18,    0,    0,   18,    7,    8,    6,    9,
    0,    0,   13,   16,    0,    0,   17,    0,   10,    0,
    4,    0,    0,   12,    0,    0,   11,    0,   22,    0,
    0,    0,    0,    5,    0,    0,    0,   27,   24,   21,
   23,    0,   75,   69,    0,    0,    0,    0,   82,    0,
    0,    0,    0,   74,    0,    0,    0,    0,    0,    0,
   25,   29,   37,   26,    0,    0,   31,   32,   33,    0,
    0,    0,    0,    0,    0,    0,   50,    0,    0,    0,
    0,   48,   49,    0,    0,    0,    0,    0,    0,    0,
   44,    0,    0,    0,    0,   28,   30,   34,   35,   36,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   42,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   67,   68,    0,    0,    0,   64,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   70,
    0,    0,   88,    0,    0,    0,   46,    0,    0,   80,
    0,    0,   71,    0,    0,    0,   73,   47,    0,    0,
   83,   72,   38,    0,   84,    0,   81,
};
final static short yydgoto[] = {                          3,
    4,    5,   72,   25,   40,   10,   15,   27,   41,   42,
   73,   52,   74,   75,   76,   77,   78,   79,   80,   81,
   82,   83,   92,   93,   86,  168,   87,  134,  181,
};
final static short yysindex[] = {                      -236,
 -267, -229,    0, -236,    0, -210, -219,    0, -212,  -48,
 -210,    0,    0,  -44,  -89,    0,    0,    0,    0,    0,
 -195,  -52,    0,    0,   23,  -88,    0,   96,    0,  -85,
    0,   45,   -7,    0,   51,  -52,    0,  -52,    0,  -74,
   52,   50,   55,    0,  -22,  -52,  -22,    0,    0,    0,
    0,   -2,    0,    0,   63,   64,   65,   77,    0, -110,
   66,   68,   69,    0,   71,   72, -162,   77,   77,   44,
    0,    0,    0,    0,   56,   57,    0,    0,    0,   59,
   60,   74,  601,   73,    0, -138,    0,   77,   77,   77,
  601,    0,    0,  106,   67,   77,  118,  119,   77, -103,
    0,  -42,  -42, -101,  413,    0,    0,    0,    0,    0,
   77,   77,   77,   77,   77,   77,   77,   77,   77,   77,
   77,   77,   77,    0,   77,   77,  137,  437,  125,  464,
  145,   62,  601,  -23,    0,    0,  475,  134,  146,    0,
  782,  758,    9,    9,  -32,  -32,   41,   41,  -42,  -42,
  -42,    9,    9,  496,  601,   77,   29,   77,   29,    0,
  507,   77,    0,  -84,   77,   77,    0,  157,  156,    0,
  531,  -67,    0,  601,  174,  568,    0,    0,   77,   29,
    0,    0,    0,  175,    0,   29,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,  217,    0,   97,    0,    0,    0,    0,
   97,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  163,    0,    0,    0,  182,    0,  182,    0,    0,
    0,  189,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  -58,    0,    0,    0,    0,    0,  -57,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  -41,  -41,  -41,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  664,   94,    0,    0,  -41,  -58,  -41,
  185,    0,    0,    0,    0,  -41,    0,    0,  -41,    0,
    0,  120,  152,    0,    0,    0,    0,    0,    0,    0,
  -41,  -41,  -41,  -41,  -41,  -41,  -41,  -41,  -41,  -41,
  -41,  -41,  -41,    0,  -41,  -41,   83,    0,    0,    0,
    0,  -41,  -17,    0,    0,    0,    0,    0,    0,    0,
    4,  -25,  580,  623,    6,  303,  486,  684,  348,  372,
  402,  625,  695,    0,  -18,   -1,  -58,  -41,  -58,    0,
    0,  -41,    0,    0,  -41,  -41,    0,    0,  205,    0,
    0,  -33,    0,   17,    0,    0,    0,    0,    1,  -58,
    0,    0,    0,    0,    0,  -58,    0,
};
final static short yygindex[] = {                         0,
    0,  243,    5,   34,    7,  239,  245,    0,  228,    0,
   26,    0, -120,    0,  -81,    0,    0,    0,    0,    0,
    0,  895,   24,  495,    0,    0,    0,  122,    0,
};
final static int YYTABLESIZE=1068;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         85,
   41,   87,   33,  124,  121,   33,   85,  129,    6,  119,
  117,   85,  118,  124,  120,   63,   33,  163,   63,   24,
  162,   26,   39,   79,    1,   85,   79,  123,   30,  122,
   69,    7,   24,   63,   26,   23,  170,   70,  172,   77,
   39,   41,   68,    2,   62,  121,   56,   62,  125,   56,
  119,  117,    9,  118,  124,  120,   11,   78,  125,  185,
   78,   69,   62,   12,   56,  187,   95,   63,   70,   39,
   49,   39,   51,   68,   13,   84,   69,  121,   16,   50,
   29,   31,  119,   70,   36,   37,  124,  120,   68,   85,
   38,   85,   45,   46,   69,   47,   62,  184,   56,  125,
   48,   70,   88,   89,   90,   96,   68,   97,   98,   69,
   99,  100,   84,  101,  106,  107,   70,  108,  109,   45,
   48,   68,   71,   45,   45,   45,   45,   45,   45,   45,
   49,  125,  110,  126,   40,   49,   49,  127,   49,   49,
   49,   45,   45,   45,   45,  131,   17,   18,   19,   20,
   21,   48,   40,   49,   37,   49,   65,  132,  135,  136,
   65,   65,   65,   65,   65,   94,   65,   17,   18,   19,
   20,   21,  138,   45,  139,   45,  156,  165,   65,   65,
   84,   65,   84,  158,   49,  160,  166,   32,   66,   22,
   35,  175,   66,   66,   66,   66,   66,  178,   66,  162,
  180,   44,   84,   84,   17,   18,   19,   20,   21,   84,
   66,   66,   65,   66,  182,  186,    1,   43,   43,   15,
   34,    5,   20,   85,   85,   85,   85,   85,   85,   19,
   85,   85,   85,   85,   43,   85,   85,   85,   85,   85,
   85,   85,   85,   86,   66,   76,    8,   85,   85,   14,
  113,  114,   63,   85,   17,   18,   19,   20,   21,   53,
   28,   54,   55,   56,   57,   43,   58,   59,   60,   61,
   62,   63,   64,    0,   43,    0,   43,  169,   65,   66,
   62,   62,   56,   56,   67,   17,   18,   19,   20,   21,
   53,    0,   54,   55,   56,   57,    0,   58,   59,   60,
   61,   62,   63,   64,  104,   53,    0,   54,    0,   65,
   66,    0,    0,    0,   60,   67,   62,   63,   64,    0,
    0,    0,    0,   53,   65,   54,    0,    0,    0,    0,
   67,    0,   60,    0,   62,   63,   64,    0,   53,    0,
   54,    0,   65,   57,    0,    0,   57,   60,   67,   62,
   63,   64,   17,   18,   19,   20,   21,   65,    0,   45,
   45,   57,    0,   67,    0,   45,   45,   45,   45,    0,
   49,   49,    0,    0,   22,    0,   49,   49,   49,   49,
    0,    0,    0,    0,   53,    0,    0,    0,   53,   53,
   53,   53,   53,    0,   53,   57,   65,   65,    0,    0,
    0,    0,   65,   65,   65,   65,   53,   53,   54,   53,
    0,    0,   54,   54,   54,   54,   54,    0,   54,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   66,   66,
   54,   54,    0,   54,   66,   66,   66,   66,   55,    0,
   53,    0,   55,   55,   55,   55,   55,    0,   55,  121,
    0,    0,    0,  140,  119,  117,    0,  118,  124,  120,
   55,   55,    0,   55,   54,    0,    0,    0,    0,    0,
    0,    0,  123,  121,  122,    0,    0,  157,  119,  117,
    0,  118,  124,  120,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   55,    0,  123,    0,  122,    0,
  121,    0,    0,  125,  159,  119,  117,    0,  118,  124,
  120,  121,    0,    0,    0,    0,  119,  117,  164,  118,
  124,  120,    0,  123,    0,  122,   51,  125,   51,   51,
   51,    0,  121,    0,  123,    0,  122,  119,  117,    0,
  118,  124,  120,  121,   51,   51,   85,   51,  119,  117,
    0,  118,  124,  120,  125,  123,    0,  122,    0,    0,
    0,    0,    0,    0,    0,  125,  123,  121,  122,    0,
    0,    0,  119,  117,    0,  118,  124,  120,   51,   57,
   57,    0,    0,   85,    0,    0,  125,    0,  167,  179,
  123,    0,  122,    0,    0,    0,    0,  125,    0,  173,
    0,    0,    0,    0,  121,    0,    0,    0,  183,  119,
  117,    0,  118,  124,  120,    0,    0,    0,    0,    0,
   60,  125,    0,   60,   53,   53,    0,  123,    0,  122,
   53,   53,   53,   53,    0,    0,    0,  121,   60,    0,
    0,    0,  119,  117,    0,  118,  124,  120,   54,   54,
    0,   85,    0,   85,   54,   54,   54,   54,  125,    0,
  123,    0,  122,   61,    0,   59,   61,    0,   59,    0,
    0,    0,   60,   85,   85,    0,    0,    0,   55,   55,
   85,   61,    0,   59,   55,   55,   55,   55,    0,  111,
  112,  125,    0,    0,    0,  113,  114,  115,  116,    0,
   48,    0,    0,    0,    0,   48,   48,    0,   48,   48,
   48,    0,    0,  111,  112,   61,    0,   59,    0,  113,
  114,  115,  116,   48,   52,   48,   52,   52,   52,    0,
    0,    0,    0,    0,    0,   58,    0,    0,   58,    0,
  111,  112,   52,   52,    0,   52,  113,  114,  115,  116,
    0,  111,  112,   58,   48,    0,    0,  113,  114,  115,
  116,    0,   51,   51,    0,    0,    0,    0,   51,   51,
   51,   51,  111,  112,    0,    0,   52,    0,  113,  114,
  115,  116,    0,  111,  112,    0,    0,   58,    0,  113,
  114,  115,  116,    0,  121,    0,    0,    0,    0,  119,
  117,    0,  118,  124,  120,    0,    0,  111,  112,    0,
    0,    0,    0,  113,  114,  115,  116,  123,  121,  122,
    0,    0,    0,  119,  117,    0,  118,  124,  120,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  123,    0,  122,  111,  112,    0,    0,  125,    0,
  113,  114,  115,  116,    0,    0,   60,   60,    0,    0,
    0,    0,    0,    0,   60,   60,    0,    0,    0,    0,
    0,    0,  125,    0,    0,    0,    0,  111,  112,    0,
    0,    0,    0,  113,  114,  115,  116,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   61,
   61,   59,   59,    0,    0,    0,    0,   61,   61,   59,
   59,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   48,   48,    0,    0,    0,    0,   48,   48,   48,   48,
    0,    0,   91,    0,    0,    0,    0,    0,    0,    0,
   52,   52,  102,  103,  105,    0,   52,   52,   52,   52,
    0,   58,   58,    0,    0,    0,    0,    0,    0,   58,
   58,    0,  128,    0,  130,    0,    0,    0,    0,    0,
  133,    0,    0,  137,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  141,  142,  143,  144,  145,
  146,  147,  148,  149,  150,  151,  152,  153,    0,  154,
  155,    0,    0,    0,    0,    0,  161,    0,    0,    0,
    0,    0,    0,    0,  111,    0,    0,    0,    0,    0,
  113,  114,  115,  116,    0,    0,    0,    0,    0,    0,
  133,    0,  171,    0,    0,    0,  174,    0,    0,  176,
  177,    0,    0,    0,  113,  114,  115,  116,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         33,
   59,   59,   91,   46,   37,   91,   40,   89,  276,   42,
   43,   45,   45,   46,   47,   41,   91,   41,   44,   15,
   44,   15,   41,   41,  261,   59,   44,   60,   22,   62,
   33,  261,   28,   59,   28,  125,  157,   40,  159,   41,
   59,   41,   45,  280,   41,   37,   41,   44,   91,   44,
   42,   43,  263,   45,   46,   47,  276,   41,   91,  180,
   44,   33,   59,  276,   59,  186,   60,   93,   40,   36,
   45,   38,   47,   45,  123,   52,   33,   37,  123,   46,
  276,   59,   42,   40,   40,   93,   46,   47,   45,  123,
   40,  125,   41,   44,   33,   41,   93,  179,   93,   91,
  123,   40,   40,   40,   40,   40,   45,   40,   40,   33,
   40,   40,   89,  276,   59,   59,   40,   59,   59,   37,
  123,   45,  125,   41,   42,   43,   44,   45,   46,   47,
   37,   91,   59,   61,   41,   42,   43,  276,   45,   46,
   47,   59,   60,   61,   62,   40,  257,  258,  259,  260,
  261,  123,   59,   60,   93,   62,   37,   91,   41,   41,
   41,   42,   43,   44,   45,  276,   47,  257,  258,  259,
  260,  261,  276,   91,  276,   93,   40,   44,   59,   60,
  157,   62,  159,   59,   91,   41,   41,  276,   37,  279,
  276,  276,   41,   42,   43,   44,   45,   41,   47,   44,
  268,  276,  179,  180,  257,  258,  259,  260,  261,  186,
   59,   60,   93,   62,   41,   41,    0,  276,  276,  123,
  125,   59,   41,  257,  258,  259,  260,  261,  262,   41,
  264,  265,  266,  267,  276,  269,  270,  271,  272,  273,
  274,  275,  276,   59,   93,   41,    4,  281,  282,   11,
  283,  284,  278,  287,  257,  258,  259,  260,  261,  262,
   16,  264,  265,  266,  267,   38,  269,  270,  271,  272,
  273,  274,  275,   -1,  276,   -1,  276,  156,  281,  282,
  277,  278,  277,  278,  287,  257,  258,  259,  260,  261,
  262,   -1,  264,  265,  266,  267,   -1,  269,  270,  271,
  272,  273,  274,  275,  261,  262,   -1,  264,   -1,  281,
  282,   -1,   -1,   -1,  271,  287,  273,  274,  275,   -1,
   -1,   -1,   -1,  262,  281,  264,   -1,   -1,   -1,   -1,
  287,   -1,  271,   -1,  273,  274,  275,   -1,  262,   -1,
  264,   -1,  281,   41,   -1,   -1,   44,  271,  287,  273,
  274,  275,  257,  258,  259,  260,  261,  281,   -1,  277,
  278,   59,   -1,  287,   -1,  283,  284,  285,  286,   -1,
  277,  278,   -1,   -1,  279,   -1,  283,  284,  285,  286,
   -1,   -1,   -1,   -1,   37,   -1,   -1,   -1,   41,   42,
   43,   44,   45,   -1,   47,   93,  277,  278,   -1,   -1,
   -1,   -1,  283,  284,  285,  286,   59,   60,   37,   62,
   -1,   -1,   41,   42,   43,   44,   45,   -1,   47,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  277,  278,
   59,   60,   -1,   62,  283,  284,  285,  286,   37,   -1,
   93,   -1,   41,   42,   43,   44,   45,   -1,   47,   37,
   -1,   -1,   -1,   41,   42,   43,   -1,   45,   46,   47,
   59,   60,   -1,   62,   93,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   60,   37,   62,   -1,   -1,   41,   42,   43,
   -1,   45,   46,   47,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   93,   -1,   60,   -1,   62,   -1,
   37,   -1,   -1,   91,   41,   42,   43,   -1,   45,   46,
   47,   37,   -1,   -1,   -1,   -1,   42,   43,   44,   45,
   46,   47,   -1,   60,   -1,   62,   41,   91,   43,   44,
   45,   -1,   37,   -1,   60,   -1,   62,   42,   43,   -1,
   45,   46,   47,   37,   59,   60,   52,   62,   42,   43,
   -1,   45,   46,   47,   91,   60,   -1,   62,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   91,   60,   37,   62,   -1,
   -1,   -1,   42,   43,   -1,   45,   46,   47,   93,  277,
  278,   -1,   -1,   89,   -1,   -1,   91,   -1,   93,   59,
   60,   -1,   62,   -1,   -1,   -1,   -1,   91,   -1,   93,
   -1,   -1,   -1,   -1,   37,   -1,   -1,   -1,   41,   42,
   43,   -1,   45,   46,   47,   -1,   -1,   -1,   -1,   -1,
   41,   91,   -1,   44,  277,  278,   -1,   60,   -1,   62,
  283,  284,  285,  286,   -1,   -1,   -1,   37,   59,   -1,
   -1,   -1,   42,   43,   -1,   45,   46,   47,  277,  278,
   -1,  157,   -1,  159,  283,  284,  285,  286,   91,   -1,
   60,   -1,   62,   41,   -1,   41,   44,   -1,   44,   -1,
   -1,   -1,   93,  179,  180,   -1,   -1,   -1,  277,  278,
  186,   59,   -1,   59,  283,  284,  285,  286,   -1,  277,
  278,   91,   -1,   -1,   -1,  283,  284,  285,  286,   -1,
   37,   -1,   -1,   -1,   -1,   42,   43,   -1,   45,   46,
   47,   -1,   -1,  277,  278,   93,   -1,   93,   -1,  283,
  284,  285,  286,   60,   41,   62,   43,   44,   45,   -1,
   -1,   -1,   -1,   -1,   -1,   41,   -1,   -1,   44,   -1,
  277,  278,   59,   60,   -1,   62,  283,  284,  285,  286,
   -1,  277,  278,   59,   91,   -1,   -1,  283,  284,  285,
  286,   -1,  277,  278,   -1,   -1,   -1,   -1,  283,  284,
  285,  286,  277,  278,   -1,   -1,   93,   -1,  283,  284,
  285,  286,   -1,  277,  278,   -1,   -1,   93,   -1,  283,
  284,  285,  286,   -1,   37,   -1,   -1,   -1,   -1,   42,
   43,   -1,   45,   46,   47,   -1,   -1,  277,  278,   -1,
   -1,   -1,   -1,  283,  284,  285,  286,   60,   37,   62,
   -1,   -1,   -1,   42,   43,   -1,   45,   46,   47,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   60,   -1,   62,  277,  278,   -1,   -1,   91,   -1,
  283,  284,  285,  286,   -1,   -1,  277,  278,   -1,   -1,
   -1,   -1,   -1,   -1,  285,  286,   -1,   -1,   -1,   -1,
   -1,   -1,   91,   -1,   -1,   -1,   -1,  277,  278,   -1,
   -1,   -1,   -1,  283,  284,  285,  286,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  277,
  278,  277,  278,   -1,   -1,   -1,   -1,  285,  286,  285,
  286,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  277,  278,   -1,   -1,   -1,   -1,  283,  284,  285,  286,
   -1,   -1,   58,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  277,  278,   68,   69,   70,   -1,  283,  284,  285,  286,
   -1,  277,  278,   -1,   -1,   -1,   -1,   -1,   -1,  285,
  286,   -1,   88,   -1,   90,   -1,   -1,   -1,   -1,   -1,
   96,   -1,   -1,   99,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  111,  112,  113,  114,  115,
  116,  117,  118,  119,  120,  121,  122,  123,   -1,  125,
  126,   -1,   -1,   -1,   -1,   -1,  132,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  277,   -1,   -1,   -1,   -1,   -1,
  283,  284,  285,  286,   -1,   -1,   -1,   -1,   -1,   -1,
  156,   -1,  158,   -1,   -1,   -1,  162,   -1,   -1,  165,
  166,   -1,   -1,   -1,  283,  284,  285,  286,
};
}
final static short YYFINAL=3;
final static short YYMAXTOKEN=289;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,"'!'",null,null,null,"'%'",null,null,"'('","')'","'*'","'+'",
"','","'-'","'.'","'/'",null,null,null,null,null,null,null,null,null,null,null,
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
"STATIC","SEALED","INSTANCEOF","SCOPY","LESS_EQUAL","GREATER_EQUAL","EQUAL",
"NOT_EQUAL","VAR","UMINUS","EMPTY",
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
"Stmt : VariableDef",
"Stmt : SimpleStmt ';'",
"Stmt : IfStmt",
"Stmt : WhileStmt",
"Stmt : ForStmt",
"Stmt : ReturnStmt ';'",
"Stmt : PrintStmt ';'",
"Stmt : BreakStmt ';'",
"Stmt : StmtBlock",
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
"Constant : LITERAL",
"Constant : NULL",
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

//#line 446 "Parser.y"
    
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
//#line 600 "Parser.java"
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
//#line 56 "Parser.y"
{
						tree = new Tree.TopLevel(val_peek(0).clist, val_peek(0).loc);
					}
break;
case 2:
//#line 62 "Parser.y"
{
						yyval.clist.add(val_peek(0).cdef);
					}
break;
case 3:
//#line 66 "Parser.y"
{
                		yyval.clist = new ArrayList<Tree.ClassDef>();
                		yyval.clist.add(val_peek(0).cdef);
                	}
break;
case 5:
//#line 76 "Parser.y"
{
						yyval.vdef = new Tree.VarDef(val_peek(0).ident, val_peek(1).type, val_peek(0).loc);
					}
break;
case 6:
//#line 82 "Parser.y"
{
						yyval.type = new Tree.TypeIdent(Tree.INT, val_peek(0).loc);
					}
break;
case 7:
//#line 86 "Parser.y"
{
                		yyval.type = new Tree.TypeIdent(Tree.VOID, val_peek(0).loc);
                	}
break;
case 8:
//#line 90 "Parser.y"
{
                		yyval.type = new Tree.TypeIdent(Tree.BOOL, val_peek(0).loc);
                	}
break;
case 9:
//#line 94 "Parser.y"
{
                		yyval.type = new Tree.TypeIdent(Tree.STRING, val_peek(0).loc);
                	}
break;
case 10:
//#line 98 "Parser.y"
{
                		yyval.type = new Tree.TypeClass(val_peek(0).ident, val_peek(1).loc);
                	}
break;
case 11:
//#line 102 "Parser.y"
{
                		yyval.type = new Tree.TypeArray(val_peek(2).type, val_peek(2).loc);
                	}
break;
case 12:
//#line 108 "Parser.y"
{
						yyval.cdef = new Tree.ClassDef(true, val_peek(4).ident, val_peek(3).ident, val_peek(1).flist, val_peek(6).loc);
					}
break;
case 13:
//#line 112 "Parser.y"
{
                        yyval.cdef = new Tree.ClassDef(false, val_peek(4).ident, val_peek(3).ident, val_peek(1).flist, val_peek(5).loc);
                    }
break;
case 14:
//#line 118 "Parser.y"
{
						yyval.ident = val_peek(0).ident;
					}
break;
case 15:
//#line 122 "Parser.y"
{
                		yyval = new SemValue();
                	}
break;
case 16:
//#line 128 "Parser.y"
{
						yyval.flist.add(val_peek(0).vdef);
					}
break;
case 17:
//#line 132 "Parser.y"
{
						yyval.flist.add(val_peek(0).fdef);
					}
break;
case 18:
//#line 136 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.flist = new ArrayList<Tree>();
                	}
break;
case 20:
//#line 144 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.vlist = new ArrayList<Tree.VarDef>(); 
                	}
break;
case 21:
//#line 151 "Parser.y"
{
						yyval.vlist.add(val_peek(0).vdef);
					}
break;
case 22:
//#line 155 "Parser.y"
{
                		yyval.vlist = new ArrayList<Tree.VarDef>();
						yyval.vlist.add(val_peek(0).vdef);
                	}
break;
case 23:
//#line 163 "Parser.y"
{
						yyval.fdef = new MethodDef(true, val_peek(4).ident, val_peek(5).type, val_peek(2).vlist, (Block) val_peek(0).stmt, val_peek(4).loc);
					}
break;
case 24:
//#line 167 "Parser.y"
{
						yyval.fdef = new MethodDef(false, val_peek(4).ident, val_peek(5).type, val_peek(2).vlist, (Block) val_peek(0).stmt, val_peek(4).loc);
					}
break;
case 25:
//#line 173 "Parser.y"
{
						yyval.stmt = new Block(val_peek(1).slist, val_peek(2).loc);
					}
break;
case 26:
//#line 179 "Parser.y"
{
						yyval.slist.add(val_peek(0).stmt);
					}
break;
case 27:
//#line 183 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.slist = new ArrayList<Tree>();
                	}
break;
case 29:
//#line 191 "Parser.y"
{
						yyval.stmt = val_peek(0).vdef;
					}
break;
case 30:
//#line 196 "Parser.y"
{
                		if (yyval.stmt == null) {
                			yyval.stmt = new Tree.Skip(val_peek(0).loc);
                		}
                	}
break;
case 38:
//#line 211 "Parser.y"
{
                        yyval.stmt = new Tree.Scopy(val_peek(3).ident, val_peek(1).expr, val_peek(3).loc);
                    }
break;
case 39:
//#line 217 "Parser.y"
{
						yyval.stmt = new Tree.Assign(val_peek(2).lvalue, val_peek(0).expr, val_peek(1).loc);
					}
break;
case 40:
//#line 221 "Parser.y"
{
                		yyval.stmt = new Tree.Exec(val_peek(0).expr, val_peek(0).loc);
                	}
break;
case 41:
//#line 225 "Parser.y"
{
                		yyval = new SemValue();
                	}
break;
case 43:
//#line 232 "Parser.y"
{
                		yyval = new SemValue();
                	}
break;
case 44:
//#line 238 "Parser.y"
{
                        yyval.lvalue = new Tree.IdentVar(val_peek(0).ident, val_peek(0).loc);
                        if (val_peek(1).loc == null) {
                        yyval.loc = val_peek(0).loc;
                        }
                    }
break;
case 45:
//#line 245 "Parser.y"
{
						yyval.lvalue = new Tree.Ident(val_peek(1).expr, val_peek(0).ident, val_peek(0).loc);
						if (val_peek(1).loc == null) {
							yyval.loc = val_peek(0).loc;
						}
					}
break;
case 46:
//#line 252 "Parser.y"
{
                		yyval.lvalue = new Tree.Indexed(val_peek(3).expr, val_peek(1).expr, val_peek(3).loc);
                	}
break;
case 47:
//#line 258 "Parser.y"
{
						yyval.expr = new Tree.CallExpr(val_peek(4).expr, val_peek(3).ident, val_peek(1).elist, val_peek(3).loc);
						if (val_peek(4).loc == null) {
							yyval.loc = val_peek(3).loc;
						}
					}
break;
case 48:
//#line 267 "Parser.y"
{
						yyval.expr = val_peek(0).lvalue;
					}
break;
case 51:
//#line 273 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.PLUS, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 52:
//#line 277 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MINUS, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 53:
//#line 281 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MUL, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 54:
//#line 285 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.DIV, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 55:
//#line 289 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MOD, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 56:
//#line 293 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.EQ, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 57:
//#line 297 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.NE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 58:
//#line 301 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.LT, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 59:
//#line 305 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.GT, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 60:
//#line 309 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.LE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 61:
//#line 313 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.GE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 62:
//#line 317 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.AND, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 63:
//#line 321 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.OR, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 64:
//#line 325 "Parser.y"
{
                		yyval = val_peek(1);
                	}
break;
case 65:
//#line 329 "Parser.y"
{
                		yyval.expr = new Tree.Unary(Tree.NEG, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 66:
//#line 333 "Parser.y"
{
                		yyval.expr = new Tree.Unary(Tree.NOT, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 67:
//#line 337 "Parser.y"
{
                		yyval.expr = new Tree.ReadIntExpr(val_peek(2).loc);
                	}
break;
case 68:
//#line 341 "Parser.y"
{
                		yyval.expr = new Tree.ReadLineExpr(val_peek(2).loc);
                	}
break;
case 69:
//#line 345 "Parser.y"
{
                		yyval.expr = new Tree.ThisExpr(val_peek(0).loc);
                	}
break;
case 70:
//#line 349 "Parser.y"
{
                		yyval.expr = new Tree.NewClass(val_peek(2).ident, val_peek(3).loc);
                	}
break;
case 71:
//#line 353 "Parser.y"
{
                		yyval.expr = new Tree.NewArray(val_peek(3).type, val_peek(1).expr, val_peek(4).loc);
                	}
break;
case 72:
//#line 357 "Parser.y"
{
                		yyval.expr = new Tree.TypeTest(val_peek(3).expr, val_peek(1).ident, val_peek(5).loc);
                	}
break;
case 73:
//#line 361 "Parser.y"
{
                		yyval.expr = new Tree.TypeCast(val_peek(2).ident, val_peek(0).expr, val_peek(0).loc);
                	}
break;
case 74:
//#line 367 "Parser.y"
{
						yyval.expr = new Tree.Literal(val_peek(0).typeTag, val_peek(0).literal, val_peek(0).loc);
					}
break;
case 75:
//#line 371 "Parser.y"
{
						yyval.expr = new Null(val_peek(0).loc);
					}
break;
case 77:
//#line 378 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.elist = new ArrayList<Tree.Expr>();
                	}
break;
case 78:
//#line 385 "Parser.y"
{
						yyval.elist.add(val_peek(0).expr);
					}
break;
case 79:
//#line 389 "Parser.y"
{
                		yyval.elist = new ArrayList<Tree.Expr>();
						yyval.elist.add(val_peek(0).expr);
                	}
break;
case 80:
//#line 396 "Parser.y"
{
						yyval.stmt = new Tree.WhileLoop(val_peek(2).expr, val_peek(0).stmt, val_peek(4).loc);
					}
break;
case 81:
//#line 402 "Parser.y"
{
						yyval.stmt = new Tree.ForLoop(val_peek(6).stmt, val_peek(4).expr, val_peek(2).stmt, val_peek(0).stmt, val_peek(8).loc);
					}
break;
case 82:
//#line 408 "Parser.y"
{
						yyval.stmt = new Tree.Break(val_peek(0).loc);
					}
break;
case 83:
//#line 414 "Parser.y"
{
						yyval.stmt = new Tree.If(val_peek(3).expr, val_peek(1).stmt, val_peek(0).stmt, val_peek(5).loc);
					}
break;
case 84:
//#line 420 "Parser.y"
{
						yyval.stmt = val_peek(0).stmt;
					}
break;
case 85:
//#line 424 "Parser.y"
{
						yyval = new SemValue();
					}
break;
case 86:
//#line 430 "Parser.y"
{
						yyval.stmt = new Tree.Return(val_peek(0).expr, val_peek(1).loc);
					}
break;
case 87:
//#line 434 "Parser.y"
{
                		yyval.stmt = new Tree.Return(null, val_peek(0).loc);
                	}
break;
case 88:
//#line 440 "Parser.y"
{
						yyval.stmt = new Print(val_peek(1).elist, val_peek(3).loc);
					}
break;
//#line 1208 "Parser.java"
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
