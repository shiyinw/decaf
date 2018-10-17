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
public final static short LESS_EQUAL=282;
public final static short GREATER_EQUAL=283;
public final static short EQUAL=284;
public final static short NOT_EQUAL=285;
public final static short UMINUS=286;
public final static short EMPTY=287;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    1,    1,    3,    4,    5,    5,    5,    5,    5,
    5,    2,    2,    6,    6,    7,    7,    7,    9,    9,
   10,   10,    8,    8,   11,   12,   12,   13,   13,   13,
   13,   13,   13,   13,   13,   13,   14,   14,   14,   24,
   24,   21,   21,   23,   22,   22,   22,   22,   22,   22,
   22,   22,   22,   22,   22,   22,   22,   22,   22,   22,
   22,   22,   22,   22,   22,   22,   22,   22,   22,   22,
   26,   26,   25,   25,   27,   27,   16,   17,   20,   15,
   28,   28,   18,   18,   19,
};
final static short yylen[] = {                            2,
    1,    2,    1,    2,    2,    1,    1,    1,    1,    2,
    3,    7,    6,    2,    0,    2,    2,    0,    1,    0,
    3,    1,    7,    6,    3,    2,    0,    1,    2,    1,
    1,    1,    2,    2,    2,    1,    3,    1,    0,    2,
    0,    2,    4,    5,    1,    1,    1,    3,    3,    3,
    3,    3,    3,    3,    3,    3,    3,    3,    3,    3,
    3,    2,    2,    3,    3,    1,    4,    5,    6,    5,
    1,    1,    1,    0,    3,    1,    5,    9,    1,    6,
    2,    0,    2,    1,    4,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    3,    0,    0,    2,    0,    0,
    0,   14,   18,    0,    0,   18,    7,    8,    6,    9,
    0,    0,   13,   16,    0,    0,   17,    0,   10,    0,
    4,    0,    0,   12,    0,    0,   11,    0,   22,    0,
    0,    0,    0,    5,    0,    0,    0,   27,   24,   21,
   23,    0,   72,   66,    0,    0,    0,    0,   79,    0,
    0,    0,    0,   71,    0,    0,    0,    0,   25,   28,
   36,   26,    0,   30,   31,   32,    0,    0,    0,    0,
    0,    0,    0,   47,    0,    0,    0,   45,    0,   46,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   29,   33,   34,   35,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   40,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   64,   65,
    0,    0,   61,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   67,    0,    0,   85,    0,    0,   43,    0,
    0,   77,    0,    0,   68,    0,    0,   70,   44,    0,
    0,   80,   69,    0,   81,    0,   78,
};
final static short yydgoto[] = {                          3,
    4,    5,   70,   25,   40,   10,   15,   27,   41,   42,
   71,   52,   72,   73,   74,   75,   76,   77,   78,   79,
   88,   81,   90,   83,  160,   84,  128,  172,
};
final static short yysindex[] = {                      -240,
 -268, -252,    0, -240,    0, -246, -235,    0, -232,  -93,
 -246,    0,    0,  -71,   36,    0,    0,    0,    0,    0,
 -218, -149,    0,    0,    4,  -87,    0,  225,    0,  -86,
    0,   33,  -15,    0,   46, -149,    0, -149,    0,  -85,
   47,   45,   50,    0,  -24, -149,  -24,    0,    0,    0,
    0,   -8,    0,    0,   66,   73,   78,  521,    0,  -56,
   81,   84,   92,    0,   94,  521,  521,  340,    0,    0,
    0,    0,   41,    0,    0,    0,   67,   76,   77,   80,
  465,    0, -139,    0,  521,  521,  521,    0,  465,    0,
   98,   48,  521,  101,  102,  521,  -43,  -43, -132,  286,
    0,    0,    0,    0,  521,  521,  521,  521,  521,  521,
  521,  521,  521,  521,  521,  521,  521,  521,    0,  521,
  107,  312,   90,  377,  110,  376,  465,  -25,    0,    0,
  401,  111,    0,  465,  538,  497,  341,  341,  581,  581,
  -19,  -19,  -43,  -43,  -43,  341,  341,  412,  521,   17,
  521,   17,    0,  433,  521,    0, -114,  521,    0,  127,
  126,    0,  454,  -97,    0,  465,  133,    0,    0,  521,
   17,    0,    0,  135,    0,   17,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,  177,    0,   55,    0,    0,    0,    0,
   55,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  121,    0,    0,    0,  142,    0,  142,    0,    0,
    0,  144,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  -58,    0,    0,    0,    0,    0,  -57,    0,    0,
    0,    0,    0,    0,    0,  -90,  -90,  -90,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  486,
    0,   34,    0,    0,  -90,  -58,  -90,    0,  128,    0,
    0,    0,  -90,    0,    0,  -90,   60,   86,    0,    0,
    0,    0,    0,    0,  -90,  -90,  -90,  -90,  -90,  -90,
  -90,  -90,  -90,  -90,  -90,  -90,  -90,  -90,    0,  -90,
   23,    0,    0,    0,    0,  -90,   10,    0,    0,    0,
    0,    0,    0,  -10,   -6,    2,  532,  575,  367,  685,
  660,  713,  113,  122,  151,  589,  632,    0,  -31,  -58,
  -90,  -58,    0,    0,  -90,    0,    0,  -90,    0,    0,
  156,    0,    0,  -33,    0,   15,    0,    0,    0,  -30,
  -58,    0,    0,    0,    0,  -58,    0,
};
final static short yygindex[] = {                         0,
    0,  195,    5,    9,   14,  189,  191,    0,  170,    0,
  -23,    0, -137,  -72,    0,    0,    0,    0,    0,    0,
  365,  861,  648,    0,    0,    0,   63,    0,
};
final static int YYTABLESIZE=1019;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         82,
   39,   84,  119,   33,   33,   33,   82,    6,    7,   74,
   39,   82,  162,  123,  164,  156,    9,  116,  155,   24,
    1,   49,  114,   51,   67,   82,  119,  115,   26,   13,
   37,   68,   24,  175,   59,   30,   66,   59,  177,    2,
   11,   26,   60,   12,   39,   60,   39,  120,   37,   67,
   76,   16,   59,   76,   50,   75,   68,   29,   75,   42,
   60,   66,   31,   42,   42,   42,   42,   42,   42,   42,
   46,  120,   36,   92,   38,   46,   46,   37,   46,   46,
   46,   42,   42,   42,   42,   38,   59,   45,   46,   82,
   47,   82,   38,   46,   60,   46,   62,  174,   48,  101,
   62,   62,   62,   62,   62,   85,   62,   17,   18,   19,
   20,   21,   86,   42,   48,   42,   69,   87,   62,   62,
   93,   62,   63,   94,   46,  102,   63,   63,   63,   63,
   63,   95,   63,   96,  103,  104,  121,  125,  126,   48,
  105,  129,  130,  132,   63,   63,  149,   63,  151,   50,
  153,  158,   62,   50,   50,   50,   50,   50,   51,   50,
   23,  167,   51,   51,   51,   51,   51,  169,   51,  155,
  171,   50,   50,  173,   50,  176,    1,   15,   63,    5,
   51,   51,   20,   51,   19,   41,   83,   52,   32,   35,
   44,   52,   52,   52,   52,   52,   73,   52,    8,   14,
   17,   18,   19,   20,   21,   50,   28,   43,    0,   52,
   52,  161,   52,    0,   51,    0,    0,   41,   41,   91,
    0,    0,    0,   82,   82,   82,   82,   82,   82,    0,
   82,   82,   82,   82,    0,   82,   82,   82,   82,   82,
   82,   82,   82,   52,   41,   41,    0,   82,   17,   18,
   19,   20,   21,   53,    0,   54,   55,   56,   57,    0,
   58,   59,   60,   61,   62,   63,   64,    0,    0,    0,
   59,   59,   65,   17,   18,   19,   20,   21,   53,   60,
   54,   55,   56,   57,    0,   58,   59,   60,   61,   62,
   63,   64,   17,   18,   19,   20,   21,   65,    0,   42,
   42,    0,    0,    0,   42,   42,   42,   42,    0,    0,
   46,   46,    0,    0,   22,   46,   46,   46,   46,    0,
    0,    0,  116,    0,    0,    0,  133,  114,  112,    0,
  113,  119,  115,    0,    0,    0,   62,   62,    0,    0,
    0,   62,   62,   62,   62,  118,    0,  117,  116,   34,
    0,    0,  150,  114,  112,    0,  113,  119,  115,    0,
    0,    0,   63,   63,    0,    0,    0,   63,   63,   63,
   63,  118,   67,  117,    0,    0,  120,  116,    0,   68,
    0,    0,  114,  112,   66,  113,  119,  115,    0,   50,
   50,    0,    0,    0,   50,   50,   50,   50,   51,   51,
    0,    0,  120,   51,   51,   51,   51,   53,   67,    0,
   53,    0,    0,  116,    0,   68,   80,  152,  114,  112,
   66,  113,  119,  115,    0,   53,    0,   52,   52,    0,
    0,  120,   52,   52,   52,   52,  118,  116,  117,    0,
    0,    0,  114,  112,  157,  113,  119,  115,  116,    0,
   80,    0,    0,  114,  112,    0,  113,  119,  115,   53,
  118,    0,  117,    0,    0,    0,    0,  120,   37,  116,
    0,  118,    0,  117,  114,  112,    0,  113,  119,  115,
    0,   17,   18,   19,   20,   21,    0,    0,    0,    0,
  116,  120,  118,    0,  117,  114,  112,    0,  113,  119,
  115,  116,  120,   22,  159,    0,  114,  112,    0,  113,
  119,  115,  170,  118,   80,  117,   80,    0,    0,    0,
    0,    0,   45,  120,  118,  165,  117,   45,   45,    0,
   45,   45,   45,  116,   80,   80,    0,    0,  114,  112,
   80,  113,  119,  115,  120,   45,    0,   45,    0,    0,
    0,    0,    0,   67,    0,  120,  118,    0,  117,    0,
   68,    0,  106,  107,    0,   66,    0,  108,  109,  110,
  111,    0,   57,    0,  116,   57,   45,    0,    0,  114,
  112,    0,  113,  119,  115,    0,    0,  120,  106,  107,
   57,    0,    0,  108,  109,  110,  111,  118,    0,  117,
   99,   53,    0,   54,    0,    0,    0,    0,    0,    0,
   60,    0,   62,   63,   64,   58,    0,  116,   58,    0,
   65,    0,  114,  112,   57,  113,  119,  115,  120,   56,
    0,    0,   56,   58,    0,    0,    0,   53,    0,   54,
  118,    0,  117,   53,   53,    0,   60,   56,   62,   63,
   64,    0,    0,  106,  107,    0,   65,    0,  108,  109,
  110,  111,    0,    0,    0,    0,    0,   58,    0,    0,
    0,  120,   55,    0,    0,   55,    0,  106,  107,    0,
    0,   56,  108,  109,  110,  111,    0,    0,  106,  107,
   55,    0,    0,  108,  109,  110,  111,    0,    0,   82,
   48,    0,   48,   48,   48,    0,    0,    0,    0,  106,
  107,    0,    0,    0,  108,  109,  110,  111,   48,   48,
    0,   48,    0,    0,   55,   54,    0,    0,   54,    0,
  106,  107,    0,   82,    0,  108,  109,  110,  111,    0,
    0,  106,  107,   54,    0,    0,  108,  109,  110,  111,
    0,    0,   48,   49,    0,   49,   49,   49,    0,    0,
    0,    0,   45,   45,    0,    0,    0,   45,   45,   45,
   45,   49,   49,  106,   49,    0,    0,   54,  108,  109,
  110,  111,   53,    0,   54,    0,    0,    0,    0,    0,
    0,   60,    0,   62,   63,   64,    0,   82,    0,   82,
    0,   65,    0,    0,    0,   49,    0,    0,   57,   57,
    0,    0,    0,    0,    0,   57,   57,   82,   82,  108,
  109,  110,  111,   82,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   58,   58,    0,    0,    0,    0,    0,   58,   58,
    0,    0,  108,  109,    0,   56,   56,    0,    0,    0,
    0,    0,   56,   56,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   55,   55,
    0,    0,    0,    0,    0,   55,   55,    0,   89,    0,
    0,    0,    0,    0,    0,    0,   97,   98,  100,    0,
    0,    0,    0,    0,    0,    0,   48,   48,    0,    0,
    0,   48,   48,   48,   48,  122,    0,  124,    0,    0,
    0,    0,    0,  127,    0,    0,  131,    0,    0,    0,
    0,   54,   54,    0,    0,  134,  135,  136,  137,  138,
  139,  140,  141,  142,  143,  144,  145,  146,  147,    0,
  148,    0,    0,    0,    0,    0,  154,    0,    0,   49,
   49,    0,    0,    0,   49,   49,   49,   49,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  127,
    0,  163,    0,    0,    0,  166,    0,    0,  168,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         33,
   59,   59,   46,   91,   91,   91,   40,  276,  261,   41,
   41,   45,  150,   86,  152,   41,  263,   37,   44,   15,
  261,   45,   42,   47,   33,   59,   46,   47,   15,  123,
   41,   40,   28,  171,   41,   22,   45,   44,  176,  280,
  276,   28,   41,  276,   36,   44,   38,   91,   59,   33,
   41,  123,   59,   44,   46,   41,   40,  276,   44,   37,
   59,   45,   59,   41,   42,   43,   44,   45,   46,   47,
   37,   91,   40,   60,   41,   42,   43,   93,   45,   46,
   47,   59,   60,   61,   62,   40,   93,   41,   44,  123,
   41,  125,   59,   60,   93,   62,   37,  170,  123,   59,
   41,   42,   43,   44,   45,   40,   47,  257,  258,  259,
  260,  261,   40,   91,  123,   93,  125,   40,   59,   60,
   40,   62,   37,   40,   91,   59,   41,   42,   43,   44,
   45,   40,   47,   40,   59,   59,  276,   40,   91,  123,
   61,   41,   41,  276,   59,   60,   40,   62,   59,   37,
   41,   41,   93,   41,   42,   43,   44,   45,   37,   47,
  125,  276,   41,   42,   43,   44,   45,   41,   47,   44,
  268,   59,   60,   41,   62,   41,    0,  123,   93,   59,
   59,   60,   41,   62,   41,  276,   59,   37,  276,  276,
  276,   41,   42,   43,   44,   45,   41,   47,    4,   11,
  257,  258,  259,  260,  261,   93,   16,   38,   -1,   59,
   60,  149,   62,   -1,   93,   -1,   -1,  276,  276,  276,
   -1,   -1,   -1,  257,  258,  259,  260,  261,  262,   -1,
  264,  265,  266,  267,   -1,  269,  270,  271,  272,  273,
  274,  275,  276,   93,  276,  276,   -1,  281,  257,  258,
  259,  260,  261,  262,   -1,  264,  265,  266,  267,   -1,
  269,  270,  271,  272,  273,  274,  275,   -1,   -1,   -1,
  277,  278,  281,  257,  258,  259,  260,  261,  262,  278,
  264,  265,  266,  267,   -1,  269,  270,  271,  272,  273,
  274,  275,  257,  258,  259,  260,  261,  281,   -1,  277,
  278,   -1,   -1,   -1,  282,  283,  284,  285,   -1,   -1,
  277,  278,   -1,   -1,  279,  282,  283,  284,  285,   -1,
   -1,   -1,   37,   -1,   -1,   -1,   41,   42,   43,   -1,
   45,   46,   47,   -1,   -1,   -1,  277,  278,   -1,   -1,
   -1,  282,  283,  284,  285,   60,   -1,   62,   37,  125,
   -1,   -1,   41,   42,   43,   -1,   45,   46,   47,   -1,
   -1,   -1,  277,  278,   -1,   -1,   -1,  282,  283,  284,
  285,   60,   33,   62,   -1,   -1,   91,   37,   -1,   40,
   -1,   -1,   42,   43,   45,   45,   46,   47,   -1,  277,
  278,   -1,   -1,   -1,  282,  283,  284,  285,  277,  278,
   -1,   -1,   91,  282,  283,  284,  285,   41,   33,   -1,
   44,   -1,   -1,   37,   -1,   40,   52,   41,   42,   43,
   45,   45,   46,   47,   -1,   59,   -1,  277,  278,   -1,
   -1,   91,  282,  283,  284,  285,   60,   37,   62,   -1,
   -1,   -1,   42,   43,   44,   45,   46,   47,   37,   -1,
   86,   -1,   -1,   42,   43,   -1,   45,   46,   47,   93,
   60,   -1,   62,   -1,   -1,   -1,   -1,   91,   93,   37,
   -1,   60,   -1,   62,   42,   43,   -1,   45,   46,   47,
   -1,  257,  258,  259,  260,  261,   -1,   -1,   -1,   -1,
   37,   91,   60,   -1,   62,   42,   43,   -1,   45,   46,
   47,   37,   91,  279,   93,   -1,   42,   43,   -1,   45,
   46,   47,   59,   60,  150,   62,  152,   -1,   -1,   -1,
   -1,   -1,   37,   91,   60,   93,   62,   42,   43,   -1,
   45,   46,   47,   37,  170,  171,   -1,   -1,   42,   43,
  176,   45,   46,   47,   91,   60,   -1,   62,   -1,   -1,
   -1,   -1,   -1,   33,   -1,   91,   60,   -1,   62,   -1,
   40,   -1,  277,  278,   -1,   45,   -1,  282,  283,  284,
  285,   -1,   41,   -1,   37,   44,   91,   -1,   -1,   42,
   43,   -1,   45,   46,   47,   -1,   -1,   91,  277,  278,
   59,   -1,   -1,  282,  283,  284,  285,   60,   -1,   62,
  261,  262,   -1,  264,   -1,   -1,   -1,   -1,   -1,   -1,
  271,   -1,  273,  274,  275,   41,   -1,   37,   44,   -1,
  281,   -1,   42,   43,   93,   45,   46,   47,   91,   41,
   -1,   -1,   44,   59,   -1,   -1,   -1,  262,   -1,  264,
   60,   -1,   62,  277,  278,   -1,  271,   59,  273,  274,
  275,   -1,   -1,  277,  278,   -1,  281,   -1,  282,  283,
  284,  285,   -1,   -1,   -1,   -1,   -1,   93,   -1,   -1,
   -1,   91,   41,   -1,   -1,   44,   -1,  277,  278,   -1,
   -1,   93,  282,  283,  284,  285,   -1,   -1,  277,  278,
   59,   -1,   -1,  282,  283,  284,  285,   -1,   -1,   52,
   41,   -1,   43,   44,   45,   -1,   -1,   -1,   -1,  277,
  278,   -1,   -1,   -1,  282,  283,  284,  285,   59,   60,
   -1,   62,   -1,   -1,   93,   41,   -1,   -1,   44,   -1,
  277,  278,   -1,   86,   -1,  282,  283,  284,  285,   -1,
   -1,  277,  278,   59,   -1,   -1,  282,  283,  284,  285,
   -1,   -1,   93,   41,   -1,   43,   44,   45,   -1,   -1,
   -1,   -1,  277,  278,   -1,   -1,   -1,  282,  283,  284,
  285,   59,   60,  277,   62,   -1,   -1,   93,  282,  283,
  284,  285,  262,   -1,  264,   -1,   -1,   -1,   -1,   -1,
   -1,  271,   -1,  273,  274,  275,   -1,  150,   -1,  152,
   -1,  281,   -1,   -1,   -1,   93,   -1,   -1,  277,  278,
   -1,   -1,   -1,   -1,   -1,  284,  285,  170,  171,  282,
  283,  284,  285,  176,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  277,  278,   -1,   -1,   -1,   -1,   -1,  284,  285,
   -1,   -1,  282,  283,   -1,  277,  278,   -1,   -1,   -1,
   -1,   -1,  284,  285,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  277,  278,
   -1,   -1,   -1,   -1,   -1,  284,  285,   -1,   58,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   66,   67,   68,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  277,  278,   -1,   -1,
   -1,  282,  283,  284,  285,   85,   -1,   87,   -1,   -1,
   -1,   -1,   -1,   93,   -1,   -1,   96,   -1,   -1,   -1,
   -1,  277,  278,   -1,   -1,  105,  106,  107,  108,  109,
  110,  111,  112,  113,  114,  115,  116,  117,  118,   -1,
  120,   -1,   -1,   -1,   -1,   -1,  126,   -1,   -1,  277,
  278,   -1,   -1,   -1,  282,  283,  284,  285,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  149,
   -1,  151,   -1,   -1,   -1,  155,   -1,   -1,  158,
};
}
final static short YYFINAL=3;
final static short YYMAXTOKEN=287;
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
"STATIC","SEALED","INSTANCEOF","LESS_EQUAL","GREATER_EQUAL","EQUAL","NOT_EQUAL",
"UMINUS","EMPTY",
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
"Stmt : VariableDef",
"Stmt : SimpleStmt ';'",
"Stmt : IfStmt",
"Stmt : WhileStmt",
"Stmt : ForStmt",
"Stmt : ReturnStmt ';'",
"Stmt : PrintStmt ';'",
"Stmt : BreakStmt ';'",
"Stmt : StmtBlock",
"SimpleStmt : LValue '=' Expr",
"SimpleStmt : Call",
"SimpleStmt :",
"Receiver : Expr '.'",
"Receiver :",
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

//#line 428 "Parser.y"
    
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
//#line 582 "Parser.java"
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
//#line 52 "Parser.y"
{
						tree = new Tree.TopLevel(val_peek(0).clist, val_peek(0).loc);
					}
break;
case 2:
//#line 58 "Parser.y"
{
						yyval.clist.add(val_peek(0).cdef);
					}
break;
case 3:
//#line 62 "Parser.y"
{
                		yyval.clist = new ArrayList<Tree.ClassDef>();
                		yyval.clist.add(val_peek(0).cdef);
                	}
break;
case 5:
//#line 72 "Parser.y"
{
						yyval.vdef = new Tree.VarDef(val_peek(0).ident, val_peek(1).type, val_peek(0).loc);
					}
break;
case 6:
//#line 78 "Parser.y"
{
						yyval.type = new Tree.TypeIdent(Tree.INT, val_peek(0).loc);
					}
break;
case 7:
//#line 82 "Parser.y"
{
                		yyval.type = new Tree.TypeIdent(Tree.VOID, val_peek(0).loc);
                	}
break;
case 8:
//#line 86 "Parser.y"
{
                		yyval.type = new Tree.TypeIdent(Tree.BOOL, val_peek(0).loc);
                	}
break;
case 9:
//#line 90 "Parser.y"
{
                		yyval.type = new Tree.TypeIdent(Tree.STRING, val_peek(0).loc);
                	}
break;
case 10:
//#line 94 "Parser.y"
{
                		yyval.type = new Tree.TypeClass(val_peek(0).ident, val_peek(1).loc);
                	}
break;
case 11:
//#line 98 "Parser.y"
{
                		yyval.type = new Tree.TypeArray(val_peek(2).type, val_peek(2).loc);
                	}
break;
case 12:
//#line 104 "Parser.y"
{
						yyval.cdef = new Tree.ClassDef(true, val_peek(4).ident, val_peek(3).ident, val_peek(1).flist, val_peek(6).loc);
					}
break;
case 13:
//#line 108 "Parser.y"
{
                        yyval.cdef = new Tree.ClassDef(false, val_peek(4).ident, val_peek(3).ident, val_peek(1).flist, val_peek(5).loc);
                    }
break;
case 14:
//#line 114 "Parser.y"
{
						yyval.ident = val_peek(0).ident;
					}
break;
case 15:
//#line 118 "Parser.y"
{
                		yyval = new SemValue();
                	}
break;
case 16:
//#line 124 "Parser.y"
{
						yyval.flist.add(val_peek(0).vdef);
					}
break;
case 17:
//#line 128 "Parser.y"
{
						yyval.flist.add(val_peek(0).fdef);
					}
break;
case 18:
//#line 132 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.flist = new ArrayList<Tree>();
                	}
break;
case 20:
//#line 140 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.vlist = new ArrayList<Tree.VarDef>(); 
                	}
break;
case 21:
//#line 147 "Parser.y"
{
						yyval.vlist.add(val_peek(0).vdef);
					}
break;
case 22:
//#line 151 "Parser.y"
{
                		yyval.vlist = new ArrayList<Tree.VarDef>();
						yyval.vlist.add(val_peek(0).vdef);
                	}
break;
case 23:
//#line 159 "Parser.y"
{
						yyval.fdef = new MethodDef(true, val_peek(4).ident, val_peek(5).type, val_peek(2).vlist, (Block) val_peek(0).stmt, val_peek(4).loc);
					}
break;
case 24:
//#line 163 "Parser.y"
{
						yyval.fdef = new MethodDef(false, val_peek(4).ident, val_peek(5).type, val_peek(2).vlist, (Block) val_peek(0).stmt, val_peek(4).loc);
					}
break;
case 25:
//#line 169 "Parser.y"
{
						yyval.stmt = new Block(val_peek(1).slist, val_peek(2).loc);
					}
break;
case 26:
//#line 175 "Parser.y"
{
						yyval.slist.add(val_peek(0).stmt);
					}
break;
case 27:
//#line 179 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.slist = new ArrayList<Tree>();
                	}
break;
case 28:
//#line 186 "Parser.y"
{
						yyval.stmt = val_peek(0).vdef;
					}
break;
case 29:
//#line 191 "Parser.y"
{
                		if (yyval.stmt == null) {
                			yyval.stmt = new Tree.Skip(val_peek(0).loc);
                		}
                	}
break;
case 37:
//#line 206 "Parser.y"
{
						yyval.stmt = new Tree.Assign(val_peek(2).lvalue, val_peek(0).expr, val_peek(1).loc);
					}
break;
case 38:
//#line 210 "Parser.y"
{
                		yyval.stmt = new Tree.Exec(val_peek(0).expr, val_peek(0).loc);
                	}
break;
case 39:
//#line 214 "Parser.y"
{
                		yyval = new SemValue();
                	}
break;
case 41:
//#line 221 "Parser.y"
{
                		yyval = new SemValue();
                	}
break;
case 42:
//#line 227 "Parser.y"
{
						yyval.lvalue = new Tree.Ident(val_peek(1).expr, val_peek(0).ident, val_peek(0).loc);
						if (val_peek(1).loc == null) {
							yyval.loc = val_peek(0).loc;
						}
					}
break;
case 43:
//#line 234 "Parser.y"
{
                		yyval.lvalue = new Tree.Indexed(val_peek(3).expr, val_peek(1).expr, val_peek(3).loc);
                	}
break;
case 44:
//#line 240 "Parser.y"
{
						yyval.expr = new Tree.CallExpr(val_peek(4).expr, val_peek(3).ident, val_peek(1).elist, val_peek(3).loc);
						if (val_peek(4).loc == null) {
							yyval.loc = val_peek(3).loc;
						}
					}
break;
case 45:
//#line 249 "Parser.y"
{
						yyval.expr = val_peek(0).lvalue;
					}
break;
case 48:
//#line 255 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.PLUS, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 49:
//#line 259 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MINUS, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 50:
//#line 263 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MUL, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 51:
//#line 267 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.DIV, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 52:
//#line 271 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MOD, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 53:
//#line 275 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.EQ, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 54:
//#line 279 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.NE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 55:
//#line 283 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.LT, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 56:
//#line 287 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.GT, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 57:
//#line 291 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.LE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 58:
//#line 295 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.GE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 59:
//#line 299 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.AND, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 60:
//#line 303 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.OR, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 61:
//#line 307 "Parser.y"
{
                		yyval = val_peek(1);
                	}
break;
case 62:
//#line 311 "Parser.y"
{
                		yyval.expr = new Tree.Unary(Tree.NEG, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 63:
//#line 315 "Parser.y"
{
                		yyval.expr = new Tree.Unary(Tree.NOT, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 64:
//#line 319 "Parser.y"
{
                		yyval.expr = new Tree.ReadIntExpr(val_peek(2).loc);
                	}
break;
case 65:
//#line 323 "Parser.y"
{
                		yyval.expr = new Tree.ReadLineExpr(val_peek(2).loc);
                	}
break;
case 66:
//#line 327 "Parser.y"
{
                		yyval.expr = new Tree.ThisExpr(val_peek(0).loc);
                	}
break;
case 67:
//#line 331 "Parser.y"
{
                		yyval.expr = new Tree.NewClass(val_peek(2).ident, val_peek(3).loc);
                	}
break;
case 68:
//#line 335 "Parser.y"
{
                		yyval.expr = new Tree.NewArray(val_peek(3).type, val_peek(1).expr, val_peek(4).loc);
                	}
break;
case 69:
//#line 339 "Parser.y"
{
                		yyval.expr = new Tree.TypeTest(val_peek(3).expr, val_peek(1).ident, val_peek(5).loc);
                	}
break;
case 70:
//#line 343 "Parser.y"
{
                		yyval.expr = new Tree.TypeCast(val_peek(2).ident, val_peek(0).expr, val_peek(0).loc);
                	}
break;
case 71:
//#line 349 "Parser.y"
{
						yyval.expr = new Tree.Literal(val_peek(0).typeTag, val_peek(0).literal, val_peek(0).loc);
					}
break;
case 72:
//#line 353 "Parser.y"
{
						yyval.expr = new Null(val_peek(0).loc);
					}
break;
case 74:
//#line 360 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.elist = new ArrayList<Tree.Expr>();
                	}
break;
case 75:
//#line 367 "Parser.y"
{
						yyval.elist.add(val_peek(0).expr);
					}
break;
case 76:
//#line 371 "Parser.y"
{
                		yyval.elist = new ArrayList<Tree.Expr>();
						yyval.elist.add(val_peek(0).expr);
                	}
break;
case 77:
//#line 378 "Parser.y"
{
						yyval.stmt = new Tree.WhileLoop(val_peek(2).expr, val_peek(0).stmt, val_peek(4).loc);
					}
break;
case 78:
//#line 384 "Parser.y"
{
						yyval.stmt = new Tree.ForLoop(val_peek(6).stmt, val_peek(4).expr, val_peek(2).stmt, val_peek(0).stmt, val_peek(8).loc);
					}
break;
case 79:
//#line 390 "Parser.y"
{
						yyval.stmt = new Tree.Break(val_peek(0).loc);
					}
break;
case 80:
//#line 396 "Parser.y"
{
						yyval.stmt = new Tree.If(val_peek(3).expr, val_peek(1).stmt, val_peek(0).stmt, val_peek(5).loc);
					}
break;
case 81:
//#line 402 "Parser.y"
{
						yyval.stmt = val_peek(0).stmt;
					}
break;
case 82:
//#line 406 "Parser.y"
{
						yyval = new SemValue();
					}
break;
case 83:
//#line 412 "Parser.y"
{
						yyval.stmt = new Tree.Return(val_peek(0).expr, val_peek(1).loc);
					}
break;
case 84:
//#line 416 "Parser.y"
{
                		yyval.stmt = new Tree.Return(null, val_peek(0).loc);
                	}
break;
case 85:
//#line 422 "Parser.y"
{
						yyval.stmt = new Print(val_peek(1).elist, val_peek(3).loc);
					}
break;
//#line 1175 "Parser.java"
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
