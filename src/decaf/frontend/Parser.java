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
public final static short LESS_EQUAL=284;
public final static short GREATER_EQUAL=285;
public final static short EQUAL=286;
public final static short NOT_EQUAL=287;
public final static short VAR=288;
public final static short UMINUS=289;
public final static short EMPTY=290;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    1,    1,    3,    4,    5,    5,    5,    5,    5,
    5,    2,    2,    6,    6,    7,    7,    7,    9,    9,
   10,   10,    8,    8,   11,   12,   12,   13,   13,   13,
   13,   13,   13,   13,   13,   13,   13,   13,   15,   15,
   23,   23,   24,   14,   16,   16,   16,   28,   28,   26,
   26,   26,   27,   25,   25,   25,   25,   25,   25,   25,
   25,   25,   25,   25,   25,   25,   25,   25,   25,   25,
   25,   25,   25,   25,   25,   25,   25,   25,   25,   30,
   30,   29,   29,   31,   31,   18,   19,   22,   17,   32,
   32,   20,   20,   21,
};
final static short yylen[] = {                            2,
    1,    2,    1,    2,    2,    1,    1,    1,    1,    2,
    3,    7,    6,    2,    0,    2,    2,    0,    1,    0,
    3,    1,    7,    6,    3,    2,    0,    2,    1,    1,
    2,    1,    1,    1,    2,    2,    2,    1,    5,    3,
    3,    0,    3,    6,    3,    1,    0,    2,    0,    2,
    2,    4,    5,    1,    1,    1,    3,    3,    3,    3,
    3,    3,    3,    3,    3,    3,    3,    3,    3,    3,
    2,    2,    3,    3,    1,    4,    5,    6,    5,    1,
    1,    1,    0,    3,    1,    5,    9,    1,    6,    2,
    0,    2,    1,    4,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    3,    0,    0,    2,    0,    0,
    0,   14,   18,    0,    0,   18,    7,    8,    6,    9,
    0,    0,   13,   16,    0,    0,   17,    0,   10,    0,
    4,    0,    0,   12,    0,    0,   11,    0,   22,    0,
    0,    0,    0,    5,    0,    0,    0,   27,   24,   21,
   23,    0,   81,   75,    0,    0,    0,    0,   88,    0,
    0,    0,    0,   80,    0,    0,    0,    0,    0,    0,
   25,   30,   38,   26,    0,   29,    0,   32,   33,   34,
    0,    0,    0,    0,    0,    0,    0,   56,    0,    0,
    0,    0,    0,   54,   55,    0,    0,    0,    0,    0,
    0,    0,   50,    0,    0,    0,    0,   28,   31,   35,
   36,   37,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   48,    0,    0,    0,    0,
    0,    0,   40,    0,    0,    0,    0,    0,   73,   74,
    0,    0,    0,   70,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   76,    0,    0,   94,    0,
    0,    0,   52,    0,    0,   86,    0,    0,   41,   39,
    0,   77,    0,    0,    0,   79,   53,    0,    0,   89,
   43,   78,   44,    0,   90,    0,   87,
};
final static short yydgoto[] = {                          3,
    4,    5,   72,   25,   40,   10,   15,   27,   41,   42,
   73,   52,   74,   75,   76,   77,   78,   79,   80,   81,
   82,   83,  134,  164,   84,   94,   95,   87,  174,   88,
  138,  190,
};
final static short yysindex[] = {                      -258,
 -271, -232,    0, -258,    0, -226, -224,    0, -222,  -62,
 -226,    0,    0,  -60,  -79,    0,    0,    0,    0,    0,
 -204,  -49,    0,    0,   14,  -87,    0,  142,    0,  -80,
    0,   35,  -14,    0,   40,  -49,    0,  -49,    0,  -77,
   50,   37,   52,    0,  -28,  -49,  -28,    0,    0,    0,
    0,   -1,    0,    0,   56,   57,  -21,   97,    0, -142,
   66,   67,   68,    0,   69,   71, -164,   97,   97,   49,
    0,    0,    0,    0,   54,    0,   61,    0,    0,    0,
   64,   70,   72,  748,   74,    0, -151,    0,   97,   97,
   97,    2,  748,    0,    0,   88,   42,   97,   95,   99,
   97, -138,    0,  -23,  -23, -135,  475,    0,    0,    0,
    0,    0,   97,   97,   97,   97,   97,   97,   97,   97,
   97,   97,   97,   97,   97,    0,   97,   97,  110,  497,
   92,  527,    0,   97,  111,   65,  748,  -11,    0,    0,
  538,  109,  114,    0,  855,  828,   13,   13,   41,   41,
   -6,   -6,  -23,  -23,  -23,   13,   13,  549,  748,   97,
   31,   97,   31, -123,  570,    0,  609,   97,    0, -120,
   97,   97,    0,  116,  122,    0,  664, -101,    0,    0,
   31,    0,  748,  127,  726,    0,    0,   97,   31,    0,
    0,    0,    0,  133,    0,   31,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,  176,    0,   60,    0,    0,    0,    0,
   60,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  118,    0,    0,    0,  143,    0,  143,    0,    0,
    0,  144,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  -53,    0,    0,    0,    0,    0,  -41,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  -85,  -85,  -85,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  816,  464,    0,    0,  -85,  -53,
  -85,   81,  135,    0,    0,    0,    0,  -85,    0,    0,
  -85,    0,    0,  128,  160,    0,    0,    0,    0,    0,
    0,    0,  -85,  -85,  -85,  -85,  -85,  -85,  -85,  -85,
  -85,  -85,  -85,  -85,  -85,    0,  -85,  -85,  102,    0,
    0,    0,    0,  -85,    0,  -85,   26,    0,    0,    0,
    0,    0,    0,    0,  -31,  -24,  274,  564,    7,  440,
  349,  867,  381,  411,  435,  646,  686,    0,  -17,  -32,
  -53,  -85,  -53,    0,    0,    0,    0,  -85,    0,    0,
  -85,  -85,    0,    0,  151,    0,    0,  -33,    0,    0,
  -53,    0,   33,    0,    0,    0,    0,  -25,  -53,    0,
    0,    0,    0,    0,    0,  -53,    0,
};
final static short yygindex[] = {                         0,
    0,  194,   10,   11,   -7,  195,  197,    0,  177,    0,
   -2,    0,  202,    0,    0,  -89,    0,    0,    0,    0,
    0,    0,    0,    0,  961,  793,  857,    0,    0,    0,
   85,    0,
};
final static int YYTABLESIZE=1154;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         91,
  131,  180,    1,   33,    6,   47,   91,   26,   83,   68,
   33,   91,   68,   33,   30,   47,   69,   93,   91,   69,
   26,    2,  126,   45,   24,   91,   68,   68,    7,  169,
  123,   69,  168,   69,   69,  121,    9,   24,   70,  126,
  122,   45,   49,   68,   51,   23,   39,   62,   39,  123,
   62,   11,   97,   12,  121,  119,   50,  120,  126,  122,
   13,   68,   16,   69,   62,   62,   85,  127,   69,   85,
   70,   29,   31,   84,   36,   68,   84,  123,   37,   38,
   46,   69,  121,  119,  127,  120,  126,  122,   70,   91,
   45,   91,   47,   68,   48,   89,   90,   69,  194,   62,
  125,   92,  124,  127,   70,   98,   99,  100,  101,   68,
  102,  103,  108,   42,   17,   18,   19,   20,   21,  109,
   42,   48,  110,   71,  129,   42,  133,  135,  111,   69,
  112,  127,  136,   96,  128,  139,   70,  142,   51,  140,
  143,   68,   51,   51,   51,   51,   51,   51,   51,  160,
  162,  166,  171,   48,  172,  184,  187,   37,  179,   51,
   51,   51,   51,   51,   71,  168,  189,  192,   71,   71,
   71,   71,   71,  196,   71,    1,    5,   17,   18,   19,
   20,   21,   15,   20,   19,   71,   71,   71,   32,   71,
   49,   82,   51,   92,   51,   35,   72,    8,   44,   22,
   72,   72,   72,   72,   72,   14,   72,   17,   18,   19,
   20,   21,   28,    0,   43,    0,    0,   72,   72,   72,
   71,   72,   49,   91,   91,   91,   91,   91,   91,    0,
   91,   91,   91,   91,   49,   91,   91,   91,   91,   91,
   91,   91,   91,   49,  175,   68,   68,   91,   91,   91,
   49,    0,   72,   69,   91,   17,   18,   19,   20,   21,
   53,    0,   54,   55,   56,   57,   34,   58,   59,   60,
   61,   62,   63,   64,    0,    0,    0,    0,    0,   65,
    0,   66,    0,   62,   62,    0,   67,   17,   18,   19,
   20,   21,   53,    0,   54,   55,   56,   57,    0,   58,
   59,   60,   61,   62,   63,   64,    0,    0,    0,  106,
   53,   65,   54,   66,   66,    0,    0,   66,   67,   60,
    0,   62,   63,   64,  115,  116,   53,    0,   54,   65,
    0,   66,   66,    0,    0,   60,   67,   62,   63,   64,
    0,    0,   42,    0,   42,   65,    0,    0,    0,    0,
    0,   42,   67,   42,   42,   42,   42,    0,   53,    0,
   54,   42,  176,    0,  178,    0,   66,   60,   42,   62,
   63,   64,    0,    0,    0,    0,    0,   65,   51,   51,
    0,    0,  191,    0,   67,   51,   51,   51,   51,   57,
  195,   57,   57,   57,    0,    0,    0,  197,   17,   18,
   19,   20,   21,    0,   71,   71,   57,   57,   57,    0,
   57,   71,   71,   71,   71,    0,    0,   59,    0,    0,
   22,   59,   59,   59,   59,   59,    0,   59,    0,    0,
    0,    0,    0,    0,    0,    0,   72,   72,   59,   59,
   59,   57,   59,   72,   72,   72,   72,   60,    0,    0,
    0,   60,   60,   60,   60,   60,    0,   60,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   60,   60,
   60,   61,   60,   59,    0,   61,   61,   61,   61,   61,
   63,   61,    0,   63,    0,    0,    0,    0,    0,    0,
    0,    0,   61,   61,   61,    0,   61,   63,   63,    0,
   55,    0,    0,   60,   46,   55,   55,    0,   55,   55,
   55,  123,    0,    0,    0,  144,  121,  119,    0,  120,
  126,  122,   46,   55,    0,   55,    0,   61,    0,    0,
    0,    0,   63,  123,  125,    0,  124,  161,  121,  119,
    0,  120,  126,  122,    0,    0,    0,    0,    0,    0,
   66,   66,    0,    0,   55,    0,  125,    0,  124,   66,
   66,    0,    0,  123,    0,  127,    0,  163,  121,  119,
    0,  120,  126,  122,  123,    0,    0,    0,    0,  121,
  119,  170,  120,  126,  122,  123,  125,  127,  124,    0,
  121,  119,    0,  120,  126,  122,    0,  125,    0,  124,
    0,    0,    0,    0,   67,    0,  123,   67,  125,    0,
  124,  121,  119,    0,  120,  126,  122,  127,    0,    0,
    0,   67,   67,    0,    0,   57,   57,  181,  127,  125,
    0,  124,   57,   57,   57,   57,    0,    0,    0,  127,
    0,  173,    0,    0,    0,  123,    0,    0,    0,    0,
  121,  119,    0,  120,  126,  122,   67,   59,   59,    0,
  127,    0,    0,    0,   59,   59,   59,   59,  125,    0,
  124,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   65,   60,   60,   65,
    0,    0,    0,    0,   60,   60,   60,   60,    0,  127,
  123,  182,    0,   65,   65,  121,  119,    0,  120,  126,
  122,   61,   61,    0,    0,    0,   63,   63,   61,   61,
   61,   61,  188,  125,    0,  124,   64,    0,    0,   64,
    0,    0,    0,    0,    0,    0,    0,    0,   65,    0,
   55,   55,    0,   64,   64,    0,    0,   55,   55,   55,
   55,  113,  114,    0,  127,    0,    0,    0,  115,  116,
  117,  118,  123,    0,    0,    0,  193,  121,  119,    0,
  120,  126,  122,  113,  114,    0,    0,    0,   64,    0,
  115,  116,  117,  118,  123,  125,    0,  124,    0,  121,
  119,    0,  120,  126,  122,    0,    0,    0,    0,    0,
    0,    0,    0,  113,  114,    0,    0,  125,    0,  124,
  115,  116,  117,  118,  113,  114,  127,    0,    0,    0,
    0,  115,  116,  117,  118,  113,  114,    0,    0,    0,
    0,    0,  115,  116,  117,  118,    0,    0,  127,    0,
   67,   67,    0,    0,   85,    0,  113,  114,    0,   67,
   67,    0,   54,  115,  116,  117,  118,   54,   54,    0,
   54,   54,   54,    0,  123,    0,    0,    0,    0,  121,
  119,    0,  120,  126,  122,   54,    0,   54,    0,    0,
    0,    0,   85,    0,    0,  113,  114,  125,    0,  124,
    0,  123,  115,  116,  117,  118,  121,  119,    0,  120,
  126,  122,    0,    0,    0,    0,   54,   58,   86,   58,
   58,   58,    0,    0,  125,    0,  124,    0,  127,    0,
    0,    0,   65,   65,   58,   58,   58,    0,   58,    0,
    0,   65,   65,    0,    0,    0,    0,    0,    0,    0,
  113,  114,    0,    0,    0,  127,   86,  115,  116,  117,
  118,    0,    0,   85,    0,   85,    0,    0,    0,   58,
    0,    0,   64,   64,    0,    0,    0,    0,    0,    0,
    0,   64,   64,   85,    0,    0,    0,    0,    0,    0,
   85,   85,    0,    0,    0,    0,    0,    0,   85,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  113,  114,    0,    0,    0,    0,    0,  115,
  116,  117,  118,    0,    0,    0,    0,   86,   93,   86,
    0,    0,    0,    0,  113,  114,    0,    0,  104,  105,
  107,  115,  116,  117,  118,    0,    0,   86,    0,    0,
    0,    0,    0,    0,   86,   86,    0,    0,    0,  130,
    0,  132,   86,    0,    0,    0,    0,    0,  137,    0,
    0,  141,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  145,  146,  147,  148,  149,  150,  151,
  152,  153,  154,  155,  156,  157,    0,  158,  159,    0,
    0,    0,   54,   54,  165,    0,  167,    0,    0,   54,
   54,   54,   54,    0,  113,    0,    0,    0,    0,    0,
    0,  115,  116,  117,  118,    0,    0,    0,    0,    0,
  137,    0,  177,    0,    0,    0,    0,    0,  183,    0,
    0,  185,  186,    0,    0,    0,    0,    0,  115,  116,
  117,  118,    0,   58,   58,    0,    0,    0,    0,    0,
   58,   58,   58,   58,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         33,
   90,  125,  261,   91,  276,   59,   40,   15,   41,   41,
   91,   45,   44,   91,   22,   41,   41,   59,   40,   44,
   28,  280,   46,   41,   15,   59,   58,   59,  261,   41,
   37,   33,   44,   58,   59,   42,  263,   28,   40,   46,
   47,   59,   45,   45,   47,  125,   36,   41,   38,   37,
   44,  276,   60,  276,   42,   43,   46,   45,   46,   47,
  123,   93,  123,   33,   58,   59,   41,   91,   93,   44,
   40,  276,   59,   41,   40,   45,   44,   37,   93,   40,
   44,   33,   42,   43,   91,   45,   46,   47,   40,  123,
   41,  125,   41,   45,  123,   40,   40,   33,  188,   93,
   60,  123,   62,   91,   40,   40,   40,   40,   40,   45,
   40,  276,   59,   33,  257,  258,  259,  260,  261,   59,
   40,  123,   59,  125,  276,   45,  125,   40,   59,   33,
   59,   91,   91,  276,   61,   41,   40,  276,   37,   41,
  276,   45,   41,   42,   43,   44,   45,   46,   47,   40,
   59,   41,   44,  123,   41,  276,   41,   93,  282,   58,
   59,   60,   61,   62,   37,   44,  268,   41,   41,   42,
   43,   44,   45,   41,   47,    0,   59,  257,  258,  259,
  260,  261,  123,   41,   41,   58,   59,   60,  276,   62,
  276,   41,   91,   59,   93,  276,   37,    4,  276,  279,
   41,   42,   43,   44,   45,   11,   47,  257,  258,  259,
  260,  261,   16,   -1,   38,   -1,   -1,   58,   59,   60,
   93,   62,  276,  257,  258,  259,  260,  261,  262,   -1,
  264,  265,  266,  267,  276,  269,  270,  271,  272,  273,
  274,  275,  276,  276,  160,  277,  278,  281,  282,  283,
  276,   -1,   93,  278,  288,  257,  258,  259,  260,  261,
  262,   -1,  264,  265,  266,  267,  125,  269,  270,  271,
  272,  273,  274,  275,   -1,   -1,   -1,   -1,   -1,  281,
   -1,  283,   -1,  277,  278,   -1,  288,  257,  258,  259,
  260,  261,  262,   -1,  264,  265,  266,  267,   -1,  269,
  270,  271,  272,  273,  274,  275,   -1,   -1,   -1,  261,
  262,  281,  264,  283,   41,   -1,   -1,   44,  288,  271,
   -1,  273,  274,  275,  284,  285,  262,   -1,  264,  281,
   -1,   58,   59,   -1,   -1,  271,  288,  273,  274,  275,
   -1,   -1,  262,   -1,  264,  281,   -1,   -1,   -1,   -1,
   -1,  271,  288,  273,  274,  275,  276,   -1,  262,   -1,
  264,  281,  161,   -1,  163,   -1,   93,  271,  288,  273,
  274,  275,   -1,   -1,   -1,   -1,   -1,  281,  277,  278,
   -1,   -1,  181,   -1,  288,  284,  285,  286,  287,   41,
  189,   43,   44,   45,   -1,   -1,   -1,  196,  257,  258,
  259,  260,  261,   -1,  277,  278,   58,   59,   60,   -1,
   62,  284,  285,  286,  287,   -1,   -1,   37,   -1,   -1,
  279,   41,   42,   43,   44,   45,   -1,   47,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  277,  278,   58,   59,
   60,   93,   62,  284,  285,  286,  287,   37,   -1,   -1,
   -1,   41,   42,   43,   44,   45,   -1,   47,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   58,   59,
   60,   37,   62,   93,   -1,   41,   42,   43,   44,   45,
   41,   47,   -1,   44,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   58,   59,   60,   -1,   62,   58,   59,   -1,
   37,   -1,   -1,   93,   41,   42,   43,   -1,   45,   46,
   47,   37,   -1,   -1,   -1,   41,   42,   43,   -1,   45,
   46,   47,   59,   60,   -1,   62,   -1,   93,   -1,   -1,
   -1,   -1,   93,   37,   60,   -1,   62,   41,   42,   43,
   -1,   45,   46,   47,   -1,   -1,   -1,   -1,   -1,   -1,
  277,  278,   -1,   -1,   91,   -1,   60,   -1,   62,  286,
  287,   -1,   -1,   37,   -1,   91,   -1,   41,   42,   43,
   -1,   45,   46,   47,   37,   -1,   -1,   -1,   -1,   42,
   43,   44,   45,   46,   47,   37,   60,   91,   62,   -1,
   42,   43,   -1,   45,   46,   47,   -1,   60,   -1,   62,
   -1,   -1,   -1,   -1,   41,   -1,   37,   44,   60,   -1,
   62,   42,   43,   -1,   45,   46,   47,   91,   -1,   -1,
   -1,   58,   59,   -1,   -1,  277,  278,   58,   91,   60,
   -1,   62,  284,  285,  286,  287,   -1,   -1,   -1,   91,
   -1,   93,   -1,   -1,   -1,   37,   -1,   -1,   -1,   -1,
   42,   43,   -1,   45,   46,   47,   93,  277,  278,   -1,
   91,   -1,   -1,   -1,  284,  285,  286,  287,   60,   -1,
   62,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   41,  277,  278,   44,
   -1,   -1,   -1,   -1,  284,  285,  286,  287,   -1,   91,
   37,   93,   -1,   58,   59,   42,   43,   -1,   45,   46,
   47,  277,  278,   -1,   -1,   -1,  277,  278,  284,  285,
  286,  287,   59,   60,   -1,   62,   41,   -1,   -1,   44,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   93,   -1,
  277,  278,   -1,   58,   59,   -1,   -1,  284,  285,  286,
  287,  277,  278,   -1,   91,   -1,   -1,   -1,  284,  285,
  286,  287,   37,   -1,   -1,   -1,   41,   42,   43,   -1,
   45,   46,   47,  277,  278,   -1,   -1,   -1,   93,   -1,
  284,  285,  286,  287,   37,   60,   -1,   62,   -1,   42,
   43,   -1,   45,   46,   47,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  277,  278,   -1,   -1,   60,   -1,   62,
  284,  285,  286,  287,  277,  278,   91,   -1,   -1,   -1,
   -1,  284,  285,  286,  287,  277,  278,   -1,   -1,   -1,
   -1,   -1,  284,  285,  286,  287,   -1,   -1,   91,   -1,
  277,  278,   -1,   -1,   52,   -1,  277,  278,   -1,  286,
  287,   -1,   37,  284,  285,  286,  287,   42,   43,   -1,
   45,   46,   47,   -1,   37,   -1,   -1,   -1,   -1,   42,
   43,   -1,   45,   46,   47,   60,   -1,   62,   -1,   -1,
   -1,   -1,   90,   -1,   -1,  277,  278,   60,   -1,   62,
   -1,   37,  284,  285,  286,  287,   42,   43,   -1,   45,
   46,   47,   -1,   -1,   -1,   -1,   91,   41,   52,   43,
   44,   45,   -1,   -1,   60,   -1,   62,   -1,   91,   -1,
   -1,   -1,  277,  278,   58,   59,   60,   -1,   62,   -1,
   -1,  286,  287,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  277,  278,   -1,   -1,   -1,   91,   90,  284,  285,  286,
  287,   -1,   -1,  161,   -1,  163,   -1,   -1,   -1,   93,
   -1,   -1,  277,  278,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  286,  287,  181,   -1,   -1,   -1,   -1,   -1,   -1,
  188,  189,   -1,   -1,   -1,   -1,   -1,   -1,  196,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  277,  278,   -1,   -1,   -1,   -1,   -1,  284,
  285,  286,  287,   -1,   -1,   -1,   -1,  161,   58,  163,
   -1,   -1,   -1,   -1,  277,  278,   -1,   -1,   68,   69,
   70,  284,  285,  286,  287,   -1,   -1,  181,   -1,   -1,
   -1,   -1,   -1,   -1,  188,  189,   -1,   -1,   -1,   89,
   -1,   91,  196,   -1,   -1,   -1,   -1,   -1,   98,   -1,
   -1,  101,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  113,  114,  115,  116,  117,  118,  119,
  120,  121,  122,  123,  124,  125,   -1,  127,  128,   -1,
   -1,   -1,  277,  278,  134,   -1,  136,   -1,   -1,  284,
  285,  286,  287,   -1,  277,   -1,   -1,   -1,   -1,   -1,
   -1,  284,  285,  286,  287,   -1,   -1,   -1,   -1,   -1,
  160,   -1,  162,   -1,   -1,   -1,   -1,   -1,  168,   -1,
   -1,  171,  172,   -1,   -1,   -1,   -1,   -1,  284,  285,
  286,  287,   -1,  277,  278,   -1,   -1,   -1,   -1,   -1,
  284,  285,  286,  287,
};
}
final static short YYFINAL=3;
final static short YYMAXTOKEN=290;
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
"STATIC","SEALED","INSTANCEOF","DIVIDER","SCOPY","LESS_EQUAL","GREATER_EQUAL",
"EQUAL","NOT_EQUAL","VAR","UMINUS","EMPTY",
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

//#line 478 "Parser.y"
    
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
//#line 632 "Parser.java"
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
//#line 57 "Parser.y"
{
						tree = new Tree.TopLevel(val_peek(0).clist, val_peek(0).loc);
					}
break;
case 2:
//#line 63 "Parser.y"
{
						yyval.clist.add(val_peek(0).cdef);
					}
break;
case 3:
//#line 67 "Parser.y"
{
                		yyval.clist = new ArrayList<Tree.ClassDef>();
                		yyval.clist.add(val_peek(0).cdef);
                	}
break;
case 5:
//#line 77 "Parser.y"
{
						yyval.vdef = new Tree.VarDef(val_peek(0).ident, val_peek(1).type, val_peek(0).loc);
					}
break;
case 6:
//#line 83 "Parser.y"
{
						yyval.type = new Tree.TypeIdent(Tree.INT, val_peek(0).loc);
					}
break;
case 7:
//#line 87 "Parser.y"
{
                		yyval.type = new Tree.TypeIdent(Tree.VOID, val_peek(0).loc);
                	}
break;
case 8:
//#line 91 "Parser.y"
{
                		yyval.type = new Tree.TypeIdent(Tree.BOOL, val_peek(0).loc);
                	}
break;
case 9:
//#line 95 "Parser.y"
{
                		yyval.type = new Tree.TypeIdent(Tree.STRING, val_peek(0).loc);
                	}
break;
case 10:
//#line 99 "Parser.y"
{
                		yyval.type = new Tree.TypeClass(val_peek(0).ident, val_peek(1).loc);
                	}
break;
case 11:
//#line 103 "Parser.y"
{
                		yyval.type = new Tree.TypeArray(val_peek(2).type, val_peek(2).loc);
                	}
break;
case 12:
//#line 109 "Parser.y"
{
						yyval.cdef = new Tree.ClassDef(true, val_peek(4).ident, val_peek(3).ident, val_peek(1).flist, val_peek(6).loc);
					}
break;
case 13:
//#line 113 "Parser.y"
{
                        yyval.cdef = new Tree.ClassDef(false, val_peek(4).ident, val_peek(3).ident, val_peek(1).flist, val_peek(5).loc);
                    }
break;
case 14:
//#line 119 "Parser.y"
{
						yyval.ident = val_peek(0).ident;
					}
break;
case 15:
//#line 123 "Parser.y"
{
                		yyval = new SemValue();
                	}
break;
case 16:
//#line 129 "Parser.y"
{
						yyval.flist.add(val_peek(0).vdef);
					}
break;
case 17:
//#line 133 "Parser.y"
{
						yyval.flist.add(val_peek(0).fdef);
					}
break;
case 18:
//#line 137 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.flist = new ArrayList<Tree>();
                	}
break;
case 20:
//#line 145 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.vlist = new ArrayList<Tree.VarDef>(); 
                	}
break;
case 21:
//#line 152 "Parser.y"
{
						yyval.vlist.add(val_peek(0).vdef);
					}
break;
case 22:
//#line 156 "Parser.y"
{
                		yyval.vlist = new ArrayList<Tree.VarDef>();
						yyval.vlist.add(val_peek(0).vdef);
                	}
break;
case 23:
//#line 164 "Parser.y"
{
						yyval.fdef = new MethodDef(true, val_peek(4).ident, val_peek(5).type, val_peek(2).vlist, (Block) val_peek(0).stmt, val_peek(4).loc);
					}
break;
case 24:
//#line 168 "Parser.y"
{
						yyval.fdef = new MethodDef(false, val_peek(4).ident, val_peek(5).type, val_peek(2).vlist, (Block) val_peek(0).stmt, val_peek(4).loc);
					}
break;
case 25:
//#line 174 "Parser.y"
{
						yyval.stmt = new Block(val_peek(1).slist, val_peek(2).loc);
					}
break;
case 26:
//#line 180 "Parser.y"
{
						yyval.slist.add(val_peek(0).stmt);
					}
break;
case 27:
//#line 184 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.slist = new ArrayList<Tree>();
                	}
break;
case 30:
//#line 193 "Parser.y"
{
						yyval.stmt = val_peek(0).vdef;
					}
break;
case 31:
//#line 198 "Parser.y"
{
                		if (yyval.stmt == null) {
                			yyval.stmt = new Tree.Skip(val_peek(0).loc);
                		}
                	}
break;
case 39:
//#line 213 "Parser.y"
{
                    val_peek(2).slist.add(val_peek(1).stmt);
                    yyval.stmt = new Tree.Guard(val_peek(2).slist, val_peek(4).loc);

                }
break;
case 40:
//#line 219 "Parser.y"
{
                    yyval.stmt = new Tree.Guard(null, val_peek(2).loc);
                }
break;
case 41:
//#line 225 "Parser.y"
{
                        yyval.slist.add(val_peek(1).stmt);
                    }
break;
case 42:
//#line 229 "Parser.y"
{
                        yyval = new SemValue();
                        yyval.slist = new ArrayList<Tree>();
                    }
break;
case 43:
//#line 236 "Parser.y"
{
                        yyval.stmt = new Tree.IfG(val_peek(2).expr, val_peek(0).stmt, val_peek(2).loc);
                    }
break;
case 44:
//#line 243 "Parser.y"
{
                        yyval.stmt = new Tree.Scopy(val_peek(3).ident, val_peek(1).expr, val_peek(3).loc);
                    }
break;
case 45:
//#line 249 "Parser.y"
{
						yyval.stmt = new Tree.Assign(val_peek(2).lvalue, val_peek(0).expr, val_peek(1).loc);
					}
break;
case 46:
//#line 253 "Parser.y"
{
                		yyval.stmt = new Tree.Exec(val_peek(0).expr, val_peek(0).loc);
                	}
break;
case 47:
//#line 257 "Parser.y"
{
                		yyval = new SemValue();
                	}
break;
case 49:
//#line 264 "Parser.y"
{
                		yyval = new SemValue();
                	}
break;
case 50:
//#line 270 "Parser.y"
{
                        yyval.lvalue = new Tree.IdentVar(val_peek(0).ident, val_peek(0).loc);
                        if (val_peek(1).loc == null) {
                        yyval.loc = val_peek(0).loc;
                        }
                    }
break;
case 51:
//#line 277 "Parser.y"
{
						yyval.lvalue = new Tree.Ident(val_peek(1).expr, val_peek(0).ident, val_peek(0).loc);
						if (val_peek(1).loc == null) {
							yyval.loc = val_peek(0).loc;
						}
					}
break;
case 52:
//#line 284 "Parser.y"
{
                		yyval.lvalue = new Tree.Indexed(val_peek(3).expr, val_peek(1).expr, val_peek(3).loc);
                	}
break;
case 53:
//#line 290 "Parser.y"
{
						yyval.expr = new Tree.CallExpr(val_peek(4).expr, val_peek(3).ident, val_peek(1).elist, val_peek(3).loc);
						if (val_peek(4).loc == null) {
							yyval.loc = val_peek(3).loc;
						}
					}
break;
case 54:
//#line 299 "Parser.y"
{
						yyval.expr = val_peek(0).lvalue;
					}
break;
case 57:
//#line 305 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.PLUS, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 58:
//#line 309 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MINUS, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 59:
//#line 313 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MUL, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 60:
//#line 317 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.DIV, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 61:
//#line 321 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MOD, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 62:
//#line 325 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.EQ, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 63:
//#line 329 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.NE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 64:
//#line 333 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.LT, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 65:
//#line 337 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.GT, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 66:
//#line 341 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.LE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 67:
//#line 345 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.GE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 68:
//#line 349 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.AND, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 69:
//#line 353 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.OR, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 70:
//#line 357 "Parser.y"
{
                		yyval = val_peek(1);
                	}
break;
case 71:
//#line 361 "Parser.y"
{
                		yyval.expr = new Tree.Unary(Tree.NEG, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 72:
//#line 365 "Parser.y"
{
                		yyval.expr = new Tree.Unary(Tree.NOT, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 73:
//#line 369 "Parser.y"
{
                		yyval.expr = new Tree.ReadIntExpr(val_peek(2).loc);
                	}
break;
case 74:
//#line 373 "Parser.y"
{
                		yyval.expr = new Tree.ReadLineExpr(val_peek(2).loc);
                	}
break;
case 75:
//#line 377 "Parser.y"
{
                		yyval.expr = new Tree.ThisExpr(val_peek(0).loc);
                	}
break;
case 76:
//#line 381 "Parser.y"
{
                		yyval.expr = new Tree.NewClass(val_peek(2).ident, val_peek(3).loc);
                	}
break;
case 77:
//#line 385 "Parser.y"
{
                		yyval.expr = new Tree.NewArray(val_peek(3).type, val_peek(1).expr, val_peek(4).loc);
                	}
break;
case 78:
//#line 389 "Parser.y"
{
                		yyval.expr = new Tree.TypeTest(val_peek(3).expr, val_peek(1).ident, val_peek(5).loc);
                	}
break;
case 79:
//#line 393 "Parser.y"
{
                		yyval.expr = new Tree.TypeCast(val_peek(2).ident, val_peek(0).expr, val_peek(0).loc);
                	}
break;
case 80:
//#line 399 "Parser.y"
{
						yyval.expr = new Tree.Literal(val_peek(0).typeTag, val_peek(0).literal, val_peek(0).loc);
					}
break;
case 81:
//#line 403 "Parser.y"
{
						yyval.expr = new Null(val_peek(0).loc);
					}
break;
case 83:
//#line 410 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.elist = new ArrayList<Tree.Expr>();
                	}
break;
case 84:
//#line 417 "Parser.y"
{
						yyval.elist.add(val_peek(0).expr);
					}
break;
case 85:
//#line 421 "Parser.y"
{
                		yyval.elist = new ArrayList<Tree.Expr>();
						yyval.elist.add(val_peek(0).expr);
                	}
break;
case 86:
//#line 428 "Parser.y"
{
						yyval.stmt = new Tree.WhileLoop(val_peek(2).expr, val_peek(0).stmt, val_peek(4).loc);
					}
break;
case 87:
//#line 434 "Parser.y"
{
						yyval.stmt = new Tree.ForLoop(val_peek(6).stmt, val_peek(4).expr, val_peek(2).stmt, val_peek(0).stmt, val_peek(8).loc);
					}
break;
case 88:
//#line 440 "Parser.y"
{
						yyval.stmt = new Tree.Break(val_peek(0).loc);
					}
break;
case 89:
//#line 446 "Parser.y"
{
						yyval.stmt = new Tree.If(val_peek(3).expr, val_peek(1).stmt, val_peek(0).stmt, val_peek(5).loc);
					}
break;
case 90:
//#line 452 "Parser.y"
{
						yyval.stmt = val_peek(0).stmt;
					}
break;
case 91:
//#line 456 "Parser.y"
{
						yyval = new SemValue();
					}
break;
case 92:
//#line 462 "Parser.y"
{
						yyval.stmt = new Tree.Return(val_peek(0).expr, val_peek(1).loc);
					}
break;
case 93:
//#line 466 "Parser.y"
{
                		yyval.stmt = new Tree.Return(null, val_peek(0).loc);
                	}
break;
case 94:
//#line 472 "Parser.y"
{
						yyval.stmt = new Print(val_peek(1).elist, val_peek(3).loc);
					}
break;
//#line 1273 "Parser.java"
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
