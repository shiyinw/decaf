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
public final static short UMINUS=287;
public final static short EMPTY=288;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    1,    1,    3,    4,    5,    5,    5,    5,    5,
    5,    2,    2,    6,    6,    7,    7,    7,    9,    9,
   10,   10,    8,    8,   11,   12,   12,   13,   13,   13,
   13,   13,   13,   13,   13,   13,   13,   14,   15,   15,
   15,   25,   25,   23,   23,   24,   22,   22,   22,   22,
   22,   22,   22,   22,   22,   22,   22,   22,   22,   22,
   22,   22,   22,   22,   22,   22,   22,   22,   22,   22,
   22,   22,   27,   27,   26,   26,   28,   28,   17,   18,
   21,   16,   29,   29,   19,   19,   20,
};
final static short yylen[] = {                            2,
    1,    2,    1,    2,    2,    1,    1,    1,    1,    2,
    3,    7,    6,    2,    0,    2,    2,    0,    1,    0,
    3,    1,    7,    6,    3,    2,    0,    2,    1,    2,
    1,    1,    1,    2,    2,    2,    1,    6,    3,    1,
    0,    2,    0,    2,    4,    5,    1,    1,    1,    3,
    3,    3,    3,    3,    3,    3,    3,    3,    3,    3,
    3,    3,    3,    2,    2,    3,    3,    1,    4,    5,
    6,    5,    1,    1,    1,    0,    3,    1,    5,    9,
    1,    6,    2,    0,    2,    1,    4,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    3,    0,    0,    2,    0,    0,
    0,   14,   18,    0,    0,   18,    7,    8,    6,    9,
    0,    0,   13,   16,    0,    0,   17,    0,   10,    0,
    4,    0,    0,   12,    0,    0,   11,    0,   22,    0,
    0,    0,    0,    5,    0,    0,    0,   27,   24,   21,
   23,    0,   74,   68,    0,    0,    0,    0,   81,    0,
    0,    0,    0,   73,    0,    0,    0,    0,    0,   25,
   29,   37,   26,    0,    0,   31,   32,   33,    0,    0,
    0,    0,    0,    0,    0,   49,    0,    0,    0,    0,
   47,   48,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   28,   30,   34,   35,   36,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   42,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   66,   67,    0,    0,    0,   63,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   69,    0,    0,
   87,    0,    0,    0,   45,    0,    0,   79,    0,    0,
   70,    0,    0,    0,   72,   46,    0,    0,   82,   71,
   38,    0,   83,    0,   80,
};
final static short yydgoto[] = {                          3,
    4,    5,   71,   25,   40,   10,   15,   27,   41,   42,
   72,   52,   73,   74,   75,   76,   77,   78,   79,   80,
   81,   82,   91,   92,   85,  166,   86,  132,  179,
};
final static short yysindex[] = {                      -247,
 -268, -236,    0, -247,    0, -232, -240,    0, -239,  -82,
 -232,    0,    0,  -79,  502,    0,    0,    0,    0,    0,
 -222, -120,    0,    0,   17,  -89,    0,  557,    0,  -86,
    0,   37,  -11,    0,   51, -120,    0, -120,    0,  -85,
   54,   57,   61,    0,  -10, -120,  -10,    0,    0,    0,
    0,   -6,    0,    0,   71,   72,   75,  538,    0, -238,
   76,   83,   85,    0,   87,   88,  538,  538,  373,    0,
    0,    0,    0,   86,   91,    0,    0,    0,   94,   95,
  102,  488,   74,    0, -134,    0,  538,  538,  538,  488,
    0,    0,  104,   55,  538,  106,  123,  538, -111,  -30,
  -30, -110,  289,    0,    0,    0,    0,    0,  538,  538,
  538,  538,  538,  538,  538,  538,  538,  538,  538,  538,
  538,    0,  538,  538,  132,  316,  117,  379,  138,  524,
  488,  -12,    0,    0,  403,  140,  151,    0,  568,  561,
    3,    3,  664,  664,    5,    5,  -30,  -30,  -30,    3,
    3,  414,  488,  538,   20,  538,   20,    0,  435,  538,
    0,  -78,  538,  538,    0,  159,  158,    0,  456,  -63,
    0,  488,  165,  467,    0,    0,  538,   20,    0,    0,
    0,  168,    0,   20,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,  213,    0,   92,    0,    0,    0,    0,
   92,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  157,    0,    0,    0,  176,    0,  176,    0,    0,
    0,  180,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  -58,    0,    0,    0,    0,    0,  -56,    0,    0,
    0,    0,    0,    0,    0,    0,  -54,  -54,  -54,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  499,   38,    0,    0,  -54,  -58,  -54,  164,
    0,    0,    0,    0,  -54,    0,    0,  -54,    0,   62,
   89,    0,    0,    0,    0,    0,    0,    0,  -54,  -54,
  -54,  -54,  -54,  -54,  -54,  -54,  -54,  -54,  -54,  -54,
  -54,    0,  -54,  -54,   27,    0,    0,    0,    0,  -54,
   14,    0,    0,    0,    0,    0,    0,    0,  -31,  259,
  592,  609,  427,  748,  581,  634,  115,  126,  152,  687,
  734,    0,  -24,  -32,  -58,  -54,  -58,    0,    0,  -54,
    0,    0,  -54,  -54,    0,    0,  189,    0,    0,  -33,
    0,   22,    0,    0,    0,    0,  -26,  -58,    0,    0,
    0,    0,    0,  -58,    0,
};
final static short yygindex[] = {                         0,
    0,  231,   15,   21,   -4,  246,  254,    0,  224,    0,
   63,    0,   23,    0,  -84,    0,    0,    0,    0,    0,
    0,  868,   26,  706,    0,    0,    0,  118,    0,
};
final static int YYTABLESIZE=1032;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         84,
   41,   33,   86,  127,   33,   33,   84,    6,   76,   61,
   26,   84,   61,    1,   41,  122,   39,   30,   17,   18,
   19,   20,   21,   26,    7,   84,   68,   61,  161,   24,
    9,  160,    2,   69,   39,   11,   12,   93,   67,  119,
   13,  119,   24,   16,  117,  115,  117,  116,  122,  118,
  122,  118,   68,   29,   78,   94,   39,   78,   39,   69,
  123,   61,   77,   44,   67,   77,   50,   44,   44,   44,
   44,   44,   44,   44,   48,   31,   36,   83,   40,   48,
   48,   37,   48,   48,   48,   44,   44,   44,   44,   84,
   38,   84,  182,  123,   45,  123,   40,   48,   64,   48,
   46,   47,   64,   64,   64,   64,   64,   49,   64,   51,
   87,   88,   48,   83,   89,   95,   48,   44,   70,   44,
   64,   64,   96,   64,   97,   65,   98,   99,   48,   65,
   65,   65,   65,   65,  124,   65,   17,   18,   19,   20,
   21,  125,   48,  129,  104,  130,  133,   65,   65,  105,
   65,   52,  106,  107,   64,   52,   52,   52,   52,   52,
  108,   52,   53,  134,  136,  137,   53,   53,   53,   53,
   53,  154,   53,   52,   52,  156,   52,  168,  158,  170,
   83,   65,   83,  163,   53,   53,   32,   53,   54,   35,
   44,  164,   54,   54,   54,   54,   54,  173,   54,  176,
  183,  160,   83,   83,  178,  180,  185,   52,  184,   83,
   54,   54,    1,   54,   15,    5,   20,   43,   53,   43,
   19,   43,   85,   84,   84,   84,   84,   84,   84,   75,
   84,   84,   84,   84,    8,   84,   84,   84,   84,   84,
   84,   84,   84,   43,   54,   61,   61,   84,   84,   43,
   17,   18,   19,   20,   21,   53,   14,   54,   55,   56,
   57,   43,   58,   59,   60,   61,   62,   63,   64,   28,
    0,  167,    0,    0,   65,   66,   17,   18,   19,   20,
   21,   53,    0,   54,   55,   56,   57,    0,   58,   59,
   60,   61,   62,   63,   64,    0,    0,    0,    0,   62,
   65,   66,   62,   44,   44,    0,    0,    0,    0,   44,
   44,   44,   44,    0,   48,   48,    0,   62,    0,    0,
   48,   48,   48,   48,    0,  119,    0,    0,    0,  138,
  117,  115,    0,  116,  122,  118,    0,    0,   64,   64,
    0,    0,    0,    0,   64,   64,   64,   64,  121,    0,
  120,   62,  119,    0,    0,    0,  155,  117,  115,    0,
  116,  122,  118,    0,    0,   65,   65,    0,    0,    0,
    0,   65,   65,   65,   65,  121,    0,  120,    0,  123,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   52,   52,    0,    0,    0,    0,   52,   52,   52,
   52,    0,   53,   53,    0,   68,  123,    0,   53,   53,
   53,   53,   69,    0,    0,  119,    0,   67,    0,  157,
  117,  115,    0,  116,  122,  118,    0,    0,   54,   54,
    0,    0,    0,    0,   54,   54,   54,   54,  121,  119,
  120,    0,    0,    0,  117,  115,  162,  116,  122,  118,
  119,    0,    0,    0,    0,  117,  115,    0,  116,  122,
  118,    0,  121,    0,  120,    0,    0,   55,    0,  123,
   55,  119,    0,  121,    0,  120,  117,  115,    0,  116,
  122,  118,    0,    0,    0,   55,    0,    0,    0,    0,
    0,    0,  119,  123,  121,    0,  120,  117,  115,    0,
  116,  122,  118,  119,  123,    0,  165,  181,  117,  115,
    0,  116,  122,  118,  177,  121,    0,  120,    0,   55,
    0,    0,    0,    0,  119,  123,  121,  171,  120,  117,
  115,    0,  116,  122,  118,   47,   62,    0,    0,    0,
   47,   47,    0,   47,   47,   47,  123,  121,    0,  120,
    0,    0,    0,    0,    0,    0,   68,  123,   47,    0,
   47,    0,    0,   69,    0,  109,  110,    0,   67,    0,
   68,  111,  112,  113,  114,    0,    0,   69,  123,    0,
    0,    0,   67,    0,    0,    0,    0,    0,    0,   47,
    0,    0,  109,  110,    0,    0,    0,  119,  111,  112,
  113,  114,  117,  115,  119,  116,  122,  118,    0,  117,
  115,    0,  116,  122,  118,    0,   37,    0,    0,    0,
  121,   50,  120,   50,   50,   50,   23,  121,    0,  120,
    0,    0,   59,  102,   53,   59,   54,    0,    0,   50,
   50,    0,   50,   60,    0,   62,   63,   64,    0,   60,
   59,  123,   60,   65,    0,  109,  110,    0,  123,    0,
    0,  111,  112,  113,  114,    0,    0,   60,    0,    0,
    0,    0,    0,   50,   51,    0,   51,   51,   51,  109,
  110,   34,    0,    0,   59,  111,  112,  113,  114,    0,
  109,  110,   51,   51,    0,   51,  111,  112,  113,  114,
  119,   60,    0,   55,   55,  117,  115,    0,  116,  122,
  118,  109,  110,    0,    0,    0,    0,  111,  112,  113,
  114,    0,    0,  121,    0,  120,   51,   58,    0,    0,
   58,    0,  109,  110,    0,    0,    0,    0,  111,  112,
  113,  114,    0,  109,  110,   58,    0,    0,    0,  111,
  112,  113,  114,    0,  123,    0,    0,   84,   17,   18,
   19,   20,   21,    0,  109,  110,    0,    0,    0,    0,
  111,  112,  113,  114,   57,   47,   47,   57,    0,   58,
   22,   47,   47,   47,   47,   53,    0,   54,   56,    0,
    0,   56,   57,   84,   60,    0,   62,   63,   64,   53,
    0,   54,    0,    0,   65,    0,   56,    0,   60,    0,
   62,   63,   64,   17,   18,   19,   20,   21,   65,    0,
    0,    0,    0,    0,    0,    0,   57,    0,    0,    0,
    0,    0,    0,    0,    0,   22,    0,  109,    0,    0,
   56,    0,    0,  111,  112,  113,  114,    0,    0,    0,
  111,  112,  113,  114,    0,    0,    0,   50,   50,    0,
   84,    0,   84,   50,   50,   50,   50,    0,   59,   59,
    0,    0,    0,    0,    0,    0,   59,   59,    0,    0,
    0,    0,   84,   84,    0,   60,   60,    0,    0,   84,
    0,    0,    0,   60,   60,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   51,   51,    0,    0,    0,    0,   51,   51,   51,   51,
    0,    0,    0,    0,    0,   90,    0,    0,    0,    0,
    0,    0,    0,    0,  100,  101,  103,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  111,  112,    0,    0,
    0,    0,    0,    0,  126,    0,  128,    0,    0,    0,
    0,    0,  131,   58,   58,  135,    0,    0,    0,    0,
    0,   58,   58,    0,    0,    0,  139,  140,  141,  142,
  143,  144,  145,  146,  147,  148,  149,  150,  151,    0,
  152,  153,    0,    0,    0,    0,    0,  159,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   57,   57,    0,    0,    0,    0,    0,    0,   57,   57,
    0,  131,    0,  169,   56,   56,    0,  172,    0,    0,
  174,  175,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         33,
   59,   91,   59,   88,   91,   91,   40,  276,   41,   41,
   15,   45,   44,  261,   41,   46,   41,   22,  257,  258,
  259,  260,  261,   28,  261,   59,   33,   59,   41,   15,
  263,   44,  280,   40,   59,  276,  276,  276,   45,   37,
  123,   37,   28,  123,   42,   43,   42,   45,   46,   47,
   46,   47,   33,  276,   41,   60,   36,   44,   38,   40,
   91,   93,   41,   37,   45,   44,   46,   41,   42,   43,
   44,   45,   46,   47,   37,   59,   40,   52,   41,   42,
   43,   93,   45,   46,   47,   59,   60,   61,   62,  123,
   40,  125,  177,   91,   41,   91,   59,   60,   37,   62,
   44,   41,   41,   42,   43,   44,   45,   45,   47,   47,
   40,   40,  123,   88,   40,   40,  123,   91,  125,   93,
   59,   60,   40,   62,   40,   37,   40,   40,   91,   41,
   42,   43,   44,   45,   61,   47,  257,  258,  259,  260,
  261,  276,  123,   40,   59,   91,   41,   59,   60,   59,
   62,   37,   59,   59,   93,   41,   42,   43,   44,   45,
   59,   47,   37,   41,  276,  276,   41,   42,   43,   44,
   45,   40,   47,   59,   60,   59,   62,  155,   41,  157,
  155,   93,  157,   44,   59,   60,  276,   62,   37,  276,
  276,   41,   41,   42,   43,   44,   45,  276,   47,   41,
  178,   44,  177,  178,  268,   41,  184,   93,   41,  184,
   59,   60,    0,   62,  123,   59,   41,  276,   93,  276,
   41,  276,   59,  257,  258,  259,  260,  261,  262,   41,
  264,  265,  266,  267,    4,  269,  270,  271,  272,  273,
  274,  275,  276,  276,   93,  277,  278,  281,  282,  276,
  257,  258,  259,  260,  261,  262,   11,  264,  265,  266,
  267,   38,  269,  270,  271,  272,  273,  274,  275,   16,
   -1,  154,   -1,   -1,  281,  282,  257,  258,  259,  260,
  261,  262,   -1,  264,  265,  266,  267,   -1,  269,  270,
  271,  272,  273,  274,  275,   -1,   -1,   -1,   -1,   41,
  281,  282,   44,  277,  278,   -1,   -1,   -1,   -1,  283,
  284,  285,  286,   -1,  277,  278,   -1,   59,   -1,   -1,
  283,  284,  285,  286,   -1,   37,   -1,   -1,   -1,   41,
   42,   43,   -1,   45,   46,   47,   -1,   -1,  277,  278,
   -1,   -1,   -1,   -1,  283,  284,  285,  286,   60,   -1,
   62,   93,   37,   -1,   -1,   -1,   41,   42,   43,   -1,
   45,   46,   47,   -1,   -1,  277,  278,   -1,   -1,   -1,
   -1,  283,  284,  285,  286,   60,   -1,   62,   -1,   91,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  277,  278,   -1,   -1,   -1,   -1,  283,  284,  285,
  286,   -1,  277,  278,   -1,   33,   91,   -1,  283,  284,
  285,  286,   40,   -1,   -1,   37,   -1,   45,   -1,   41,
   42,   43,   -1,   45,   46,   47,   -1,   -1,  277,  278,
   -1,   -1,   -1,   -1,  283,  284,  285,  286,   60,   37,
   62,   -1,   -1,   -1,   42,   43,   44,   45,   46,   47,
   37,   -1,   -1,   -1,   -1,   42,   43,   -1,   45,   46,
   47,   -1,   60,   -1,   62,   -1,   -1,   41,   -1,   91,
   44,   37,   -1,   60,   -1,   62,   42,   43,   -1,   45,
   46,   47,   -1,   -1,   -1,   59,   -1,   -1,   -1,   -1,
   -1,   -1,   37,   91,   60,   -1,   62,   42,   43,   -1,
   45,   46,   47,   37,   91,   -1,   93,   41,   42,   43,
   -1,   45,   46,   47,   59,   60,   -1,   62,   -1,   93,
   -1,   -1,   -1,   -1,   37,   91,   60,   93,   62,   42,
   43,   -1,   45,   46,   47,   37,  278,   -1,   -1,   -1,
   42,   43,   -1,   45,   46,   47,   91,   60,   -1,   62,
   -1,   -1,   -1,   -1,   -1,   -1,   33,   91,   60,   -1,
   62,   -1,   -1,   40,   -1,  277,  278,   -1,   45,   -1,
   33,  283,  284,  285,  286,   -1,   -1,   40,   91,   -1,
   -1,   -1,   45,   -1,   -1,   -1,   -1,   -1,   -1,   91,
   -1,   -1,  277,  278,   -1,   -1,   -1,   37,  283,  284,
  285,  286,   42,   43,   37,   45,   46,   47,   -1,   42,
   43,   -1,   45,   46,   47,   -1,   93,   -1,   -1,   -1,
   60,   41,   62,   43,   44,   45,  125,   60,   -1,   62,
   -1,   -1,   41,  261,  262,   44,  264,   -1,   -1,   59,
   60,   -1,   62,  271,   -1,  273,  274,  275,   -1,   41,
   59,   91,   44,  281,   -1,  277,  278,   -1,   91,   -1,
   -1,  283,  284,  285,  286,   -1,   -1,   59,   -1,   -1,
   -1,   -1,   -1,   93,   41,   -1,   43,   44,   45,  277,
  278,  125,   -1,   -1,   93,  283,  284,  285,  286,   -1,
  277,  278,   59,   60,   -1,   62,  283,  284,  285,  286,
   37,   93,   -1,  277,  278,   42,   43,   -1,   45,   46,
   47,  277,  278,   -1,   -1,   -1,   -1,  283,  284,  285,
  286,   -1,   -1,   60,   -1,   62,   93,   41,   -1,   -1,
   44,   -1,  277,  278,   -1,   -1,   -1,   -1,  283,  284,
  285,  286,   -1,  277,  278,   59,   -1,   -1,   -1,  283,
  284,  285,  286,   -1,   91,   -1,   -1,   52,  257,  258,
  259,  260,  261,   -1,  277,  278,   -1,   -1,   -1,   -1,
  283,  284,  285,  286,   41,  277,  278,   44,   -1,   93,
  279,  283,  284,  285,  286,  262,   -1,  264,   41,   -1,
   -1,   44,   59,   88,  271,   -1,  273,  274,  275,  262,
   -1,  264,   -1,   -1,  281,   -1,   59,   -1,  271,   -1,
  273,  274,  275,  257,  258,  259,  260,  261,  281,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   93,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  279,   -1,  277,   -1,   -1,
   93,   -1,   -1,  283,  284,  285,  286,   -1,   -1,   -1,
  283,  284,  285,  286,   -1,   -1,   -1,  277,  278,   -1,
  155,   -1,  157,  283,  284,  285,  286,   -1,  277,  278,
   -1,   -1,   -1,   -1,   -1,   -1,  285,  286,   -1,   -1,
   -1,   -1,  177,  178,   -1,  277,  278,   -1,   -1,  184,
   -1,   -1,   -1,  285,  286,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  277,  278,   -1,   -1,   -1,   -1,  283,  284,  285,  286,
   -1,   -1,   -1,   -1,   -1,   58,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   67,   68,   69,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  283,  284,   -1,   -1,
   -1,   -1,   -1,   -1,   87,   -1,   89,   -1,   -1,   -1,
   -1,   -1,   95,  277,  278,   98,   -1,   -1,   -1,   -1,
   -1,  285,  286,   -1,   -1,   -1,  109,  110,  111,  112,
  113,  114,  115,  116,  117,  118,  119,  120,  121,   -1,
  123,  124,   -1,   -1,   -1,   -1,   -1,  130,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  277,  278,   -1,   -1,   -1,   -1,   -1,   -1,  285,  286,
   -1,  154,   -1,  156,  277,  278,   -1,  160,   -1,   -1,
  163,  164,
};
}
final static short YYFINAL=3;
final static short YYMAXTOKEN=288;
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
"NOT_EQUAL","UMINUS","EMPTY",
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

//#line 439 "Parser.y"
    
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
//#line 592 "Parser.java"
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
						yyval.lvalue = new Tree.Ident(val_peek(1).expr, val_peek(0).ident, val_peek(0).loc);
						if (val_peek(1).loc == null) {
							yyval.loc = val_peek(0).loc;
						}
					}
break;
case 45:
//#line 245 "Parser.y"
{
                		yyval.lvalue = new Tree.Indexed(val_peek(3).expr, val_peek(1).expr, val_peek(3).loc);
                	}
break;
case 46:
//#line 251 "Parser.y"
{
						yyval.expr = new Tree.CallExpr(val_peek(4).expr, val_peek(3).ident, val_peek(1).elist, val_peek(3).loc);
						if (val_peek(4).loc == null) {
							yyval.loc = val_peek(3).loc;
						}
					}
break;
case 47:
//#line 260 "Parser.y"
{
						yyval.expr = val_peek(0).lvalue;
					}
break;
case 50:
//#line 266 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.PLUS, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 51:
//#line 270 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MINUS, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 52:
//#line 274 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MUL, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 53:
//#line 278 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.DIV, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 54:
//#line 282 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MOD, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 55:
//#line 286 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.EQ, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 56:
//#line 290 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.NE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 57:
//#line 294 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.LT, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 58:
//#line 298 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.GT, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 59:
//#line 302 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.LE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 60:
//#line 306 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.GE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 61:
//#line 310 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.AND, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 62:
//#line 314 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.OR, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 63:
//#line 318 "Parser.y"
{
                		yyval = val_peek(1);
                	}
break;
case 64:
//#line 322 "Parser.y"
{
                		yyval.expr = new Tree.Unary(Tree.NEG, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 65:
//#line 326 "Parser.y"
{
                		yyval.expr = new Tree.Unary(Tree.NOT, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 66:
//#line 330 "Parser.y"
{
                		yyval.expr = new Tree.ReadIntExpr(val_peek(2).loc);
                	}
break;
case 67:
//#line 334 "Parser.y"
{
                		yyval.expr = new Tree.ReadLineExpr(val_peek(2).loc);
                	}
break;
case 68:
//#line 338 "Parser.y"
{
                		yyval.expr = new Tree.ThisExpr(val_peek(0).loc);
                	}
break;
case 69:
//#line 342 "Parser.y"
{
                		yyval.expr = new Tree.NewClass(val_peek(2).ident, val_peek(3).loc);
                	}
break;
case 70:
//#line 346 "Parser.y"
{
                		yyval.expr = new Tree.NewArray(val_peek(3).type, val_peek(1).expr, val_peek(4).loc);
                	}
break;
case 71:
//#line 350 "Parser.y"
{
                		yyval.expr = new Tree.TypeTest(val_peek(3).expr, val_peek(1).ident, val_peek(5).loc);
                	}
break;
case 72:
//#line 354 "Parser.y"
{
                		yyval.expr = new Tree.TypeCast(val_peek(2).ident, val_peek(0).expr, val_peek(0).loc);
                	}
break;
case 73:
//#line 360 "Parser.y"
{
						yyval.expr = new Tree.Literal(val_peek(0).typeTag, val_peek(0).literal, val_peek(0).loc);
					}
break;
case 74:
//#line 364 "Parser.y"
{
						yyval.expr = new Null(val_peek(0).loc);
					}
break;
case 76:
//#line 371 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.elist = new ArrayList<Tree.Expr>();
                	}
break;
case 77:
//#line 378 "Parser.y"
{
						yyval.elist.add(val_peek(0).expr);
					}
break;
case 78:
//#line 382 "Parser.y"
{
                		yyval.elist = new ArrayList<Tree.Expr>();
						yyval.elist.add(val_peek(0).expr);
                	}
break;
case 79:
//#line 389 "Parser.y"
{
						yyval.stmt = new Tree.WhileLoop(val_peek(2).expr, val_peek(0).stmt, val_peek(4).loc);
					}
break;
case 80:
//#line 395 "Parser.y"
{
						yyval.stmt = new Tree.ForLoop(val_peek(6).stmt, val_peek(4).expr, val_peek(2).stmt, val_peek(0).stmt, val_peek(8).loc);
					}
break;
case 81:
//#line 401 "Parser.y"
{
						yyval.stmt = new Tree.Break(val_peek(0).loc);
					}
break;
case 82:
//#line 407 "Parser.y"
{
						yyval.stmt = new Tree.If(val_peek(3).expr, val_peek(1).stmt, val_peek(0).stmt, val_peek(5).loc);
					}
break;
case 83:
//#line 413 "Parser.y"
{
						yyval.stmt = val_peek(0).stmt;
					}
break;
case 84:
//#line 417 "Parser.y"
{
						yyval = new SemValue();
					}
break;
case 85:
//#line 423 "Parser.y"
{
						yyval.stmt = new Tree.Return(val_peek(0).expr, val_peek(1).loc);
					}
break;
case 86:
//#line 427 "Parser.y"
{
                		yyval.stmt = new Tree.Return(null, val_peek(0).loc);
                	}
break;
case 87:
//#line 433 "Parser.y"
{
						yyval.stmt = new Print(val_peek(1).elist, val_peek(3).loc);
					}
break;
//#line 1191 "Parser.java"
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
