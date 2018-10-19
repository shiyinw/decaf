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
public final static short IN=286;
public final static short LESS_EQUAL=287;
public final static short GREATER_EQUAL=288;
public final static short EQUAL=289;
public final static short NOT_EQUAL=290;
public final static short VAR=291;
public final static short ARRAY_REPEAT=292;
public final static short ARRAY_CONCAT=293;
public final static short UMINUS=294;
public final static short EMPTY=295;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    1,    1,    3,    4,    5,    5,    5,    5,    5,
    5,    2,    2,    6,    6,    7,    7,    7,    9,    9,
   10,   10,    8,    8,   11,   12,   12,   13,   13,   13,
   13,   13,   13,   13,   13,   13,   13,   13,   13,   14,
   24,   24,   16,   16,   26,   26,   27,   15,   17,   17,
   17,   30,   30,   28,   28,   28,   29,   25,   25,   25,
   25,   25,   25,   25,   25,   25,   25,   25,   25,   25,
   25,   25,   25,   25,   25,   25,   25,   25,   25,   25,
   25,   25,   25,   25,   25,   25,   25,   32,   32,   32,
   33,   33,   34,   34,   31,   31,   35,   35,   19,   20,
   23,   18,   36,   36,   21,   21,   22,
};
final static short yylen[] = {                            2,
    1,    2,    1,    2,    2,    1,    1,    1,    1,    2,
    3,    7,    6,    2,    0,    2,    2,    0,    1,    0,
    3,    1,    7,    6,    3,    2,    0,    1,    2,    1,
    1,    2,    1,    1,    1,    2,    2,    2,    1,    7,
    2,    2,    5,    3,    3,    0,    3,    6,    3,    1,
    0,    2,    0,    2,    2,    4,    5,    3,    3,    6,
    6,    1,    1,    1,    3,    3,    3,    3,    3,    3,
    3,    3,    3,    3,    3,    3,    3,    3,    2,    2,
    3,    3,    1,    4,    5,    6,    5,    1,    1,    1,
    2,    3,    3,    1,    1,    0,    3,    1,    5,    9,
    1,    6,    2,    0,    2,    1,    4,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    3,    0,    0,    2,    0,    0,
    0,   14,   18,    0,    0,   18,    7,    8,    6,    9,
    0,    0,   13,   16,    0,    0,   17,    0,   10,    0,
    4,    0,    0,   12,    0,    0,   11,    0,   22,    0,
    0,    0,    0,    5,    0,    0,    0,   27,   24,   21,
   23,    0,   90,   83,    0,    0,    0,    0,  101,    0,
    0,    0,    0,   89,    0,    0,    0,    0,    0,    0,
    0,    0,   25,   31,   39,   26,   28,    0,   30,    0,
   33,   34,   35,    0,    0,    0,    0,    0,    0,    0,
   64,   88,    0,    0,    0,    0,    0,   62,   63,    0,
    0,    0,    0,    0,    0,    0,    0,   54,    0,    0,
    0,    0,   91,   94,    0,   29,   32,   36,   37,   38,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   52,    0,    0,    0,    0,
    0,    0,   44,    0,    0,    0,    0,    0,   81,   82,
    0,    0,    0,    0,    0,    0,   78,    0,   92,    0,
    0,    0,    0,    0,    0,   58,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   84,    0,    0,  107,    0,    0,   41,   42,
    0,    0,   93,    0,    0,    0,    0,   99,    0,    0,
    0,   45,   43,   85,    0,    0,    0,    0,    0,    0,
    0,   57,    0,    0,  102,   47,   86,   48,    0,   60,
    0,    0,  103,   40,    0,  100,
};
final static short yydgoto[] = {                          3,
    4,    5,   74,   25,   40,   10,   15,   27,   41,   42,
   75,   52,   76,   77,   78,   79,   80,   81,   82,   83,
   84,   85,   86,  155,   87,  144,  182,   98,   99,   90,
  196,   91,   92,  115,  148,  215,
};
final static short yysindex[] = {                      -241,
 -262, -237,    0, -241,    0, -227, -221,    0, -219,  -62,
 -227,    0,    0,  -46,  -76,    0,    0,    0,    0,    0,
 -207,  206,    0,    0,   20,  -87,    0,  240,    0,  -85,
    0,   45,  -13,    0,   47,  206,    0,  206,    0,  -83,
   48,   44,   54,    0,  -26,  206,  -26,    0,    0,    0,
    0,   -5,    0,    0,   62,   63,  -27,   97,    0,  163,
   66,   67,   70,    0,   71,   72,   73, -160,   97,   97,
   38,  -88,    0,    0,    0,    0,    0,   58,    0,   64,
    0,    0,    0,   65,   69,   80,  615,   79,    0, -155,
    0,    0,   97,   97,   97,   16,  615,    0,    0,   85,
   53,   97,  104,  106,   97, -128, -215,    0,  -19,  -19,
 -126,  415,    0,    0,  -29,    0,    0,    0,    0,    0,
   97,   97,   97,   97,   97,   97,  -70,   97,   97,   97,
   97,   97,   97,   97,   97,    0,   97,   97,  115,  442,
   98,  449,    0,   97,  124,   60,  615,  -12,    0,    0,
  470,  112, -107,  -74, -116,  130,    0,  -70,    0,  818,
  797,   89,   89,  852,  852,    0, -121,   28,   28,  -19,
  -19,  -19,   89,   89,  356,  615,   97,   23,   97,   23,
  492, -114,    0,  520,   97,    0,  -90,   97,    0,    0,
   97,   97,    0,   97,  -81,  166,  162,    0,  527,  -59,
   23,    0,    0,    0,  615,  175,  559,  594, -226,  652,
   97,    0,   97,   23,    0,    0,    0,    0,   23,    0,
  615,  176,    0,    0,   23,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,  220,    0,   99,    0,    0,    0,    0,
   99,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  164,    0,    0,    0,  180,    0,  180,    0,    0,
    0,  189,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  -58,    0,    0,    0,    0,    0,  -57,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  -41,  -41,
  -41,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  730,  391,    0,
    0,    0,  -41,  -58,  -41,   82,  188,    0,    0,    0,
    0,  -41,    0,    0,  -41,    0,    0,    0,  934,  987,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  -41,  -41,  -41,  -41,  -41,  -41,    0,  -41,  -41,  -41,
  -41,  -41,  -41,  -41,  -41,    0,  -41,  -41,  117,    0,
    0,    0,    0,  -41,    0,  -41,  -10,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   40,
  483,   50, 1034,  108,  549,    0,  874, 1074, 1132, 1011,
 1054, 1112, 1137, 1160,    0,  -18,  -31,  -58,  -41,  -58,
    0,    0,    0,    0,  -41,    0,    0,  -41,    0,    0,
  -41,  -41,    0,  -41,  153,    0,  222,    0,    0,  -33,
  -58,    0,    0,    0,   18,    0,    0,    0,  910,    0,
  -41,    0,   -4,  -58,    0,    0,    0,    0,  -58,    0,
  -11,    0,    0,    0,  -58,    0,
};
final static short yygindex[] = {                         0,
    0,  267,   10,   14,   -6,  264,  261,    0,  253,    0,
    6,    0,  165,    0,    0,    0,  -75,    0,    0,    0,
    0,    0,    0,    0, 1337,    0,    0, 1030, 1089,    0,
    0,  -54,    0,    0,  126,    0,
};
final static int YYTABLESIZE=1548;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        104,
   51,  106,   72,   33,  113,   33,  104,   33,   26,   96,
  203,  104,   95,    6,  158,   30,   33,  114,  141,    1,
   72,   26,   49,    7,   24,  104,  136,   70,  186,   61,
   98,  185,   61,   98,   71,    9,   51,   24,    2,   69,
   49,   17,   18,   19,   20,   21,   61,   61,   23,   39,
   49,   39,   51,  101,   11,   70,   12,  104,   97,   50,
   13,   97,   71,  159,  133,  127,  128,   69,   29,  131,
   70,  137,  166,  136,  132,  153,   16,   71,   31,   37,
   76,   61,   69,   76,   36,   72,   38,   46,   45,  104,
   74,  104,   70,   74,   47,   96,   48,   76,   76,   71,
  154,   93,   94,  193,   69,  102,  103,   74,   74,  104,
  105,  106,  107,   72,   46,  108,  116,   48,  137,   73,
  139,   46,  117,  118,  145,  133,   46,  119,   72,   70,
  131,  129,   76,  130,  136,  132,   71,  222,  120,  138,
  143,   69,   74,  146,  149,   48,  150,  152,   70,  156,
   72,   70,   37,   55,  177,  188,  179,   55,   55,   55,
   55,   55,   55,   55,  183,   70,   70,  202,  189,  191,
  192,  128,   46,   53,   55,   55,   55,   55,   55,  137,
   17,   18,   19,   20,   21,  206,   64,   72,   32,   56,
   35,   53,   44,   56,   56,   56,   56,   56,   56,   56,
   70,  190,   22,  211,   64,  185,  212,   55,  214,   55,
   56,   56,   56,   56,   56,  217,  225,   53,   53,    1,
   20,   15,    5,  104,  104,  104,  104,  104,  104,   19,
  104,  104,  104,  104,   53,  104,  104,  104,  104,  104,
  104,  104,  104,   56,   53,   56,  105,  104,  104,  104,
  104,   17,   18,   19,   20,   21,   53,  104,   54,   55,
   56,   57,   95,   58,   59,   60,   61,   62,   63,   64,
    8,   53,  127,  128,   14,   65,   28,   66,   67,   17,
   18,   19,   20,   21,   53,   68,   54,   55,   56,   57,
   43,   58,   59,   60,   61,   62,   63,   64,  111,   53,
    0,   54,  197,   65,    0,   66,   67,    0,   60,    0,
   62,   63,   64,   68,    0,    0,   76,   76,   65,  127,
  128,   53,    0,   54,    0,    0,   74,   74,   68,    0,
   60,    0,   62,   63,   64,    0,    0,    0,   74,   74,
   65,    0,  198,   46,  200,   46,    0,    0,    0,    0,
   68,    0,   46,    0,   46,   46,   46,   46,   53,    0,
   54,    0,   46,    0,   34,  216,    0,   60,    0,   62,
   63,   64,   46,    0,    0,    0,    0,   65,  223,    0,
  127,  128,    0,  224,   70,   70,    0,   68,    0,  226,
    0,    0,  133,   55,   55,    0,    0,  131,  129,    0,
  130,  136,  132,   55,   55,   55,   55,    0,   55,   55,
    0,    0,    0,  194,    0,  135,    0,  134,    0,   17,
   18,   19,   20,   21,    0,    0,    0,   63,    0,   56,
   56,   50,   63,   63,    0,   63,   63,   63,  100,   56,
   56,   56,   56,    0,   56,   56,  137,    0,  195,   50,
   63,  133,   63,    0,    0,  157,  131,  129,    0,  130,
  136,  132,   17,   18,   19,   20,   21,    0,    0,    0,
    0,    0,    0,    0,  135,    0,  134,    0,  133,    0,
    0,   63,  178,  131,  129,  133,  130,  136,  132,  180,
  131,  129,    0,  130,  136,  132,   17,   18,   19,   20,
   21,  135,    0,  134,    0,  137,  133,    0,  135,    0,
  134,  131,  129,  187,  130,  136,  132,    0,   22,    0,
    0,    0,    0,   77,    0,    0,   77,    0,  133,  135,
    0,  134,  137,  131,  129,    0,  130,  136,  132,  137,
   77,   77,    0,    0,    0,    0,    0,    0,    0,  201,
    0,  135,    0,  134,    0,    0,  133,    0,    0,    0,
  137,  131,  129,  133,  130,  136,  132,    0,  131,  129,
    0,  130,  136,  132,    0,   77,    0,    0,    0,  135,
    0,  134,  137,    0,    0,  213,  135,    0,  134,   71,
    0,    0,   71,    0,    0,  133,    0,    0,    0,  218,
  131,  129,    0,  130,  136,  132,   71,   71,    0,    0,
  137,    0,  204,    0,    0,    0,    0,  137,  135,    0,
  134,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  133,    0,  121,  122,  219,  131,  129,    0,  130,  136,
  132,   71,  123,  124,  125,  126,    0,  127,  128,  137,
    0,  133,    0,  135,    0,  134,  131,  129,    0,  130,
  136,  132,    0,    0,    0,    0,    0,   63,   63,    0,
    0,    0,    0,    0,  135,    0,  134,   63,   63,   63,
   63,    0,   63,   63,  137,    0,    0,    0,  133,    0,
    0,  121,  122,  131,  129,    0,  130,  136,  132,    0,
    0,  123,  124,  125,  126,  137,  127,  128,    0,    0,
    0,  135,    0,  134,    0,    0,    0,    0,  121,  122,
    0,    0,    0,    0,    0,  121,  122,    0,  123,  124,
  125,  126,    0,  127,  128,  123,  124,  125,  126,    0,
  127,  128,  137,    0,  220,    0,  121,  122,    0,    0,
    0,    0,    0,    0,    0,    0,  123,  124,  125,  126,
   77,  127,  128,    0,    0,    0,   62,    0,  121,  122,
    0,   62,   62,    0,   62,   62,   62,    0,  123,  124,
  125,  126,    0,  127,  128,    0,    0,    0,    0,   62,
    0,   62,    0,    0,    0,    0,  121,  122,    0,    0,
    0,    0,    0,  121,  122,    0,  123,  124,  125,  126,
    0,  127,  128,  123,  124,  125,  126,    0,  127,  128,
   62,    0,    0,    0,    0,   71,   71,    0,    0,    0,
    0,    0,    0,  133,    0,  121,  122,    0,  131,  129,
    0,  130,  136,  132,    0,  123,  124,  125,  126,    0,
  127,  128,    0,    0,  133,    0,  135,    0,  134,  131,
  129,    0,  130,  136,  132,    0,    0,    0,    0,    0,
  121,  122,    0,    0,    0,    0,    0,  135,    0,  134,
  123,  124,  125,  126,    0,  127,  128,  137,  133,    0,
    0,  121,  122,  131,  129,    0,  130,  136,  132,    0,
    0,  123,  124,  125,  126,    0,  127,  128,  137,    0,
   59,  135,    0,  134,   59,   59,   59,   59,   59,   59,
   59,    0,    0,    0,    0,    0,    0,    0,  121,  122,
    0,   59,   59,   59,    0,   59,    0,    0,  123,  124,
  125,  126,  137,  127,  128,    0,   87,    0,    0,    0,
   87,   87,   87,   87,   87,   87,   87,    0,    0,    0,
    0,    0,    0,    0,   59,    0,   59,   87,   87,   87,
   79,   87,    0,    0,   79,   79,   79,   79,   79,    0,
   79,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   79,   79,   79,    0,   79,    0,    0,    0,    0,
   87,    0,   87,    0,    0,    0,   62,   62,    0,    0,
    0,    0,    0,    0,    0,    0,   62,   62,   62,   62,
    0,   62,   62,   80,    0,    0,   79,   80,   80,   80,
   80,   80,    0,   80,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   80,   80,   80,   67,   80,    0,
    0,   67,   67,   67,   67,   67,    0,   67,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   67,   67,
   67,    0,   67,  121,   75,    0,    0,   75,    0,   80,
    0,   88,    0,  123,  124,  125,  126,    0,  127,  128,
   68,   75,   75,    0,   68,   68,   68,   68,   68,    0,
   68,    0,    0,   67,  123,  124,  125,  126,    0,  127,
  128,   68,   68,   68,   65,   68,   65,   65,   65,    0,
    0,    0,    0,   88,    0,    0,   75,    0,    0,    0,
    0,   65,   65,   65,    0,   65,    0,    0,  123,  124,
   89,    0,    0,  127,  128,    0,   68,    0,   69,    0,
   59,   59,   69,   69,   69,   69,   69,    0,   69,    0,
   59,   59,   59,   59,    0,   59,   65,    0,    0,   69,
   69,   69,   66,   69,   66,   66,   66,   73,    0,    0,
   73,    0,   89,    0,    0,    0,   87,   87,    0,   66,
   66,   66,    0,   66,   73,   73,   87,   87,   87,   87,
   72,    0,    0,   72,   69,    0,    0,   88,    0,   88,
   79,   79,    0,    0,    0,    0,    0,   72,   72,    0,
   79,   79,   79,   79,   66,    0,    0,    0,    0,   73,
   88,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   88,   88,    0,    0,    0,    0,   88,    0,
    0,    0,   72,    0,   88,    0,    0,    0,    0,    0,
    0,    0,    0,   80,   80,    0,   89,    0,   89,    0,
    0,    0,    0,   80,   80,   80,   80,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   67,   67,   89,
    0,    0,    0,    0,    0,    0,    0,   67,   67,   67,
   67,   89,   89,    0,    0,    0,    0,   89,    0,    0,
   75,   75,    0,   89,    0,    0,    0,    0,    0,    0,
    0,    0,   75,   75,    0,    0,    0,    0,    0,    0,
   68,   68,    0,    0,    0,    0,    0,    0,    0,    0,
   68,   68,   68,   68,    0,    0,    0,    0,    0,    0,
   65,   65,    0,    0,    0,    0,    0,    0,    0,    0,
   65,   65,   65,   65,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   69,   69,
    0,    0,    0,    0,   97,    0,    0,    0,   69,   69,
   69,   69,    0,    0,    0,  109,  110,  112,   66,   66,
    0,    0,    0,   73,   73,    0,    0,    0,   66,   66,
   66,   66,    0,    0,    0,   73,   73,    0,    0,  140,
    0,  142,    0,    0,    0,    0,   72,   72,  147,    0,
    0,  151,    0,    0,    0,    0,    0,    0,   72,   72,
    0,    0,    0,    0,    0,    0,    0,  160,  161,  162,
  163,  164,  165,    0,  167,  168,  169,  170,  171,  172,
  173,  174,    0,  175,  176,    0,    0,    0,    0,    0,
  181,    0,  184,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  147,    0,  199,    0,    0,    0,    0,
    0,  205,    0,    0,  207,    0,    0,  208,  209,    0,
  210,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  221,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         33,
   59,   59,   91,   91,   93,   91,   40,   91,   15,   41,
  125,   45,   40,  276,   44,   22,   91,   72,   94,  261,
   91,   28,   41,  261,   15,   59,   46,   33,   41,   41,
   41,   44,   44,   44,   40,  263,   41,   28,  280,   45,
   59,  257,  258,  259,  260,  261,   58,   59,  125,   36,
   45,   38,   47,   60,  276,   33,  276,   91,   41,   46,
  123,   44,   40,   93,   37,  292,  293,   45,  276,   42,
   33,   91,  127,   46,   47,  291,  123,   40,   59,   93,
   41,   93,   45,   44,   40,   91,   40,   44,   41,  123,
   41,  125,   33,   44,   41,  123,  123,   58,   59,   40,
  107,   40,   40,  158,   45,   40,   40,   58,   59,   40,
   40,   40,   40,   91,   33,  276,   59,  123,   91,  125,
  276,   40,   59,   59,   40,   37,   45,   59,   91,   33,
   42,   43,   93,   45,   46,   47,   40,  213,   59,   61,
  125,   45,   93,   91,   41,  123,   41,  276,   41,  276,
   91,   44,   93,   37,   40,   44,   59,   41,   42,   43,
   44,   45,   46,   47,   41,   58,   59,  282,  276,  286,
   41,  293,   91,  262,   58,   59,   60,   61,   62,   91,
  257,  258,  259,  260,  261,  276,  275,   91,  276,   37,
  276,  262,  276,   41,   42,   43,   44,   45,   46,   47,
   93,  276,  279,  285,  275,   44,   41,   91,  268,   93,
   58,   59,   60,   61,   62,   41,   41,  276,  276,    0,
   41,  123,   59,  257,  258,  259,  260,  261,  262,   41,
  264,  265,  266,  267,  276,  269,  270,  271,  272,  273,
  274,  275,  276,   91,  276,   93,   59,  281,  282,  283,
  284,  257,  258,  259,  260,  261,  262,  291,  264,  265,
  266,  267,   41,  269,  270,  271,  272,  273,  274,  275,
    4,  276,  292,  293,   11,  281,   16,  283,  284,  257,
  258,  259,  260,  261,  262,  291,  264,  265,  266,  267,
   38,  269,  270,  271,  272,  273,  274,  275,  261,  262,
   -1,  264,  177,  281,   -1,  283,  284,   -1,  271,   -1,
  273,  274,  275,  291,   -1,   -1,  277,  278,  281,  292,
  293,  262,   -1,  264,   -1,   -1,  277,  278,  291,   -1,
  271,   -1,  273,  274,  275,   -1,   -1,   -1,  289,  290,
  281,   -1,  178,  262,  180,  264,   -1,   -1,   -1,   -1,
  291,   -1,  271,   -1,  273,  274,  275,  276,  262,   -1,
  264,   -1,  281,   -1,  125,  201,   -1,  271,   -1,  273,
  274,  275,  291,   -1,   -1,   -1,   -1,  281,  214,   -1,
  292,  293,   -1,  219,  277,  278,   -1,  291,   -1,  225,
   -1,   -1,   37,  277,  278,   -1,   -1,   42,   43,   -1,
   45,   46,   47,  287,  288,  289,  290,   -1,  292,  293,
   -1,   -1,   -1,   58,   -1,   60,   -1,   62,   -1,  257,
  258,  259,  260,  261,   -1,   -1,   -1,   37,   -1,  277,
  278,   41,   42,   43,   -1,   45,   46,   47,  276,  287,
  288,  289,  290,   -1,  292,  293,   91,   -1,   93,   59,
   60,   37,   62,   -1,   -1,   41,   42,   43,   -1,   45,
   46,   47,  257,  258,  259,  260,  261,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   60,   -1,   62,   -1,   37,   -1,
   -1,   91,   41,   42,   43,   37,   45,   46,   47,   41,
   42,   43,   -1,   45,   46,   47,  257,  258,  259,  260,
  261,   60,   -1,   62,   -1,   91,   37,   -1,   60,   -1,
   62,   42,   43,   44,   45,   46,   47,   -1,  279,   -1,
   -1,   -1,   -1,   41,   -1,   -1,   44,   -1,   37,   60,
   -1,   62,   91,   42,   43,   -1,   45,   46,   47,   91,
   58,   59,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   58,
   -1,   60,   -1,   62,   -1,   -1,   37,   -1,   -1,   -1,
   91,   42,   43,   37,   45,   46,   47,   -1,   42,   43,
   -1,   45,   46,   47,   -1,   93,   -1,   -1,   -1,   60,
   -1,   62,   91,   -1,   -1,   59,   60,   -1,   62,   41,
   -1,   -1,   44,   -1,   -1,   37,   -1,   -1,   -1,   41,
   42,   43,   -1,   45,   46,   47,   58,   59,   -1,   -1,
   91,   -1,   93,   -1,   -1,   -1,   -1,   91,   60,   -1,
   62,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   37,   -1,  277,  278,   41,   42,   43,   -1,   45,   46,
   47,   93,  287,  288,  289,  290,   -1,  292,  293,   91,
   -1,   37,   -1,   60,   -1,   62,   42,   43,   -1,   45,
   46,   47,   -1,   -1,   -1,   -1,   -1,  277,  278,   -1,
   -1,   -1,   -1,   -1,   60,   -1,   62,  287,  288,  289,
  290,   -1,  292,  293,   91,   -1,   -1,   -1,   37,   -1,
   -1,  277,  278,   42,   43,   -1,   45,   46,   47,   -1,
   -1,  287,  288,  289,  290,   91,  292,  293,   -1,   -1,
   -1,   60,   -1,   62,   -1,   -1,   -1,   -1,  277,  278,
   -1,   -1,   -1,   -1,   -1,  277,  278,   -1,  287,  288,
  289,  290,   -1,  292,  293,  287,  288,  289,  290,   -1,
  292,  293,   91,   -1,   93,   -1,  277,  278,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  287,  288,  289,  290,
  278,  292,  293,   -1,   -1,   -1,   37,   -1,  277,  278,
   -1,   42,   43,   -1,   45,   46,   47,   -1,  287,  288,
  289,  290,   -1,  292,  293,   -1,   -1,   -1,   -1,   60,
   -1,   62,   -1,   -1,   -1,   -1,  277,  278,   -1,   -1,
   -1,   -1,   -1,  277,  278,   -1,  287,  288,  289,  290,
   -1,  292,  293,  287,  288,  289,  290,   -1,  292,  293,
   91,   -1,   -1,   -1,   -1,  277,  278,   -1,   -1,   -1,
   -1,   -1,   -1,   37,   -1,  277,  278,   -1,   42,   43,
   -1,   45,   46,   47,   -1,  287,  288,  289,  290,   -1,
  292,  293,   -1,   -1,   37,   -1,   60,   -1,   62,   42,
   43,   -1,   45,   46,   47,   -1,   -1,   -1,   -1,   -1,
  277,  278,   -1,   -1,   -1,   -1,   -1,   60,   -1,   62,
  287,  288,  289,  290,   -1,  292,  293,   91,   37,   -1,
   -1,  277,  278,   42,   43,   -1,   45,   46,   47,   -1,
   -1,  287,  288,  289,  290,   -1,  292,  293,   91,   -1,
   37,   60,   -1,   62,   41,   42,   43,   44,   45,   46,
   47,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  277,  278,
   -1,   58,   59,   60,   -1,   62,   -1,   -1,  287,  288,
  289,  290,   91,  292,  293,   -1,   37,   -1,   -1,   -1,
   41,   42,   43,   44,   45,   46,   47,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   91,   -1,   93,   58,   59,   60,
   37,   62,   -1,   -1,   41,   42,   43,   44,   45,   -1,
   47,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   58,   59,   60,   -1,   62,   -1,   -1,   -1,   -1,
   91,   -1,   93,   -1,   -1,   -1,  277,  278,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  287,  288,  289,  290,
   -1,  292,  293,   37,   -1,   -1,   93,   41,   42,   43,
   44,   45,   -1,   47,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   58,   59,   60,   37,   62,   -1,
   -1,   41,   42,   43,   44,   45,   -1,   47,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   58,   59,
   60,   -1,   62,  277,   41,   -1,   -1,   44,   -1,   93,
   -1,   52,   -1,  287,  288,  289,  290,   -1,  292,  293,
   37,   58,   59,   -1,   41,   42,   43,   44,   45,   -1,
   47,   -1,   -1,   93,  287,  288,  289,  290,   -1,  292,
  293,   58,   59,   60,   41,   62,   43,   44,   45,   -1,
   -1,   -1,   -1,   94,   -1,   -1,   93,   -1,   -1,   -1,
   -1,   58,   59,   60,   -1,   62,   -1,   -1,  287,  288,
   52,   -1,   -1,  292,  293,   -1,   93,   -1,   37,   -1,
  277,  278,   41,   42,   43,   44,   45,   -1,   47,   -1,
  287,  288,  289,  290,   -1,  292,   93,   -1,   -1,   58,
   59,   60,   41,   62,   43,   44,   45,   41,   -1,   -1,
   44,   -1,   94,   -1,   -1,   -1,  277,  278,   -1,   58,
   59,   60,   -1,   62,   58,   59,  287,  288,  289,  290,
   41,   -1,   -1,   44,   93,   -1,   -1,  178,   -1,  180,
  277,  278,   -1,   -1,   -1,   -1,   -1,   58,   59,   -1,
  287,  288,  289,  290,   93,   -1,   -1,   -1,   -1,   93,
  201,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  213,  214,   -1,   -1,   -1,   -1,  219,   -1,
   -1,   -1,   93,   -1,  225,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  277,  278,   -1,  178,   -1,  180,   -1,
   -1,   -1,   -1,  287,  288,  289,  290,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  277,  278,  201,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  287,  288,  289,
  290,  213,  214,   -1,   -1,   -1,   -1,  219,   -1,   -1,
  277,  278,   -1,  225,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  289,  290,   -1,   -1,   -1,   -1,   -1,   -1,
  277,  278,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  287,  288,  289,  290,   -1,   -1,   -1,   -1,   -1,   -1,
  277,  278,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  287,  288,  289,  290,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  277,  278,
   -1,   -1,   -1,   -1,   58,   -1,   -1,   -1,  287,  288,
  289,  290,   -1,   -1,   -1,   69,   70,   71,  277,  278,
   -1,   -1,   -1,  277,  278,   -1,   -1,   -1,  287,  288,
  289,  290,   -1,   -1,   -1,  289,  290,   -1,   -1,   93,
   -1,   95,   -1,   -1,   -1,   -1,  277,  278,  102,   -1,
   -1,  105,   -1,   -1,   -1,   -1,   -1,   -1,  289,  290,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  121,  122,  123,
  124,  125,  126,   -1,  128,  129,  130,  131,  132,  133,
  134,  135,   -1,  137,  138,   -1,   -1,   -1,   -1,   -1,
  144,   -1,  146,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  177,   -1,  179,   -1,   -1,   -1,   -1,
   -1,  185,   -1,   -1,  188,   -1,   -1,  191,  192,   -1,
  194,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  211,
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
"NEW","PRINT","READ_INTEGER","READ_LINE","LITERAL","IDENTIFIER","AND","OR",
"STATIC","SEALED","INSTANCEOF","DIVIDER","SCOPY","FOREACH","DEFAULT","IN",
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

//#line 536 "Parser.y"
    
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
//#line 740 "Parser.java"
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
case 31:
//#line 199 "Parser.y"
{
						yyval.stmt = val_peek(0).vdef;
					}
break;
case 32:
//#line 204 "Parser.y"
{
                		if (yyval.stmt == null) {
                			yyval.stmt = new Tree.Skip(val_peek(0).loc);
                		}
                	}
break;
case 40:
//#line 219 "Parser.y"
{
                    yyval.stmt = new Tree.ArrayFor(false, val_peek(4).lvalue, val_peek(2).expr, val_peek(0).stmt, null, val_peek(6).loc);
                }
break;
case 41:
//#line 225 "Parser.y"
{
                        yyval.lvalue = new LValue.BoundVar(val_peek(0).ident, val_peek(0).loc);
                    }
break;
case 42:
//#line 229 "Parser.y"
{
                        yyval.lvalue = new LValue.BoundVar(val_peek(0).ident, val_peek(0).loc);
                    }
break;
case 43:
//#line 236 "Parser.y"
{
                    val_peek(2).slist.add(val_peek(1).stmt);
                    yyval.stmt = new Tree.Guard(val_peek(2).slist, val_peek(4).loc);

                }
break;
case 44:
//#line 242 "Parser.y"
{
                    yyval.stmt = new Tree.Guard(null, val_peek(2).loc);
                }
break;
case 45:
//#line 248 "Parser.y"
{
                        yyval.slist.add(val_peek(1).stmt);
                    }
break;
case 46:
//#line 252 "Parser.y"
{
                        yyval = new SemValue();
                        yyval.slist = new ArrayList<Tree>();
                    }
break;
case 47:
//#line 259 "Parser.y"
{
                        yyval.stmt = new Tree.IfG(val_peek(2).expr, val_peek(0).stmt, val_peek(2).loc);
                    }
break;
case 48:
//#line 266 "Parser.y"
{
                        yyval.stmt = new Tree.Scopy(val_peek(3).ident, val_peek(1).expr, val_peek(3).loc);
                    }
break;
case 49:
//#line 272 "Parser.y"
{
						yyval.stmt = new Tree.Assign(val_peek(2).lvalue, val_peek(0).expr, val_peek(1).loc);
					}
break;
case 50:
//#line 276 "Parser.y"
{
                		yyval.stmt = new Tree.Exec(val_peek(0).expr, val_peek(0).loc);
                	}
break;
case 51:
//#line 280 "Parser.y"
{
                		yyval = new SemValue();
                	}
break;
case 53:
//#line 287 "Parser.y"
{
                		yyval = new SemValue();
                	}
break;
case 54:
//#line 293 "Parser.y"
{
                        yyval.lvalue = new Tree.IdentVar(val_peek(0).ident, val_peek(0).loc);
                        if (val_peek(1).loc == null) {
                        yyval.loc = val_peek(0).loc;
                        }
                    }
break;
case 55:
//#line 300 "Parser.y"
{
						yyval.lvalue = new Tree.Ident(val_peek(1).expr, val_peek(0).ident, val_peek(0).loc);
						if (val_peek(1).loc == null) {
							yyval.loc = val_peek(0).loc;
						}
					}
break;
case 56:
//#line 307 "Parser.y"
{
                		yyval.lvalue = new Tree.Indexed(val_peek(3).expr, val_peek(1).expr, val_peek(3).loc);
                	}
break;
case 57:
//#line 313 "Parser.y"
{
						yyval.expr = new Tree.CallExpr(val_peek(4).expr, val_peek(3).ident, val_peek(1).elist, val_peek(3).loc);
						if (val_peek(4).loc == null) {
							yyval.loc = val_peek(3).loc;
						}
					}
break;
case 58:
//#line 322 "Parser.y"
{
                        yyval.expr = new Tree.ArrayInit(val_peek(2).expr, val_peek(0).expr, val_peek(2).loc);
                    }
break;
case 59:
//#line 326 "Parser.y"
{
                        yyval.expr = new Tree.ArrayConcat(val_peek(2).expr, val_peek(0).expr, val_peek(2).loc);
                    }
break;
case 60:
//#line 330 "Parser.y"
{
                        yyval.expr = new Tree.ArrayRef(val_peek(5).expr, val_peek(3).expr, val_peek(1).expr, val_peek(5).loc);
                    }
break;
case 62:
//#line 335 "Parser.y"
{
						yyval.expr = val_peek(0).lvalue;
					}
break;
case 65:
//#line 341 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.PLUS, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 66:
//#line 345 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MINUS, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 67:
//#line 349 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MUL, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 68:
//#line 353 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.DIV, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 69:
//#line 357 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MOD, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 70:
//#line 361 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.EQ, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 71:
//#line 365 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.NE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 72:
//#line 369 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.LT, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 73:
//#line 373 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.GT, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 74:
//#line 377 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.LE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 75:
//#line 381 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.GE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 76:
//#line 385 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.AND, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 77:
//#line 389 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.OR, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 78:
//#line 393 "Parser.y"
{
                		yyval = val_peek(1);
                	}
break;
case 79:
//#line 397 "Parser.y"
{
                		yyval.expr = new Tree.Unary(Tree.NEG, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 80:
//#line 401 "Parser.y"
{
                		yyval.expr = new Tree.Unary(Tree.NOT, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 81:
//#line 405 "Parser.y"
{
                		yyval.expr = new Tree.ReadIntExpr(val_peek(2).loc);
                	}
break;
case 82:
//#line 409 "Parser.y"
{
                		yyval.expr = new Tree.ReadLineExpr(val_peek(2).loc);
                	}
break;
case 83:
//#line 413 "Parser.y"
{
                		yyval.expr = new Tree.ThisExpr(val_peek(0).loc);
                	}
break;
case 84:
//#line 417 "Parser.y"
{
                		yyval.expr = new Tree.NewClass(val_peek(2).ident, val_peek(3).loc);
                	}
break;
case 85:
//#line 421 "Parser.y"
{
                		yyval.expr = new Tree.NewArray(val_peek(3).type, val_peek(1).expr, val_peek(4).loc);
                	}
break;
case 86:
//#line 425 "Parser.y"
{
                		yyval.expr = new Tree.TypeTest(val_peek(3).expr, val_peek(1).ident, val_peek(5).loc);
                	}
break;
case 87:
//#line 429 "Parser.y"
{
                		yyval.expr = new Tree.TypeCast(val_peek(2).ident, val_peek(0).expr, val_peek(0).loc);
                	}
break;
case 89:
//#line 436 "Parser.y"
{
						yyval.expr = new Tree.Literal(val_peek(0).typeTag, val_peek(0).literal, val_peek(0).loc);
					}
break;
case 90:
//#line 440 "Parser.y"
{
						yyval.expr = new Null(val_peek(0).loc);
					}
break;
case 91:
//#line 446 "Parser.y"
{
                        yyval.expr = new Tree.Array(null, val_peek(1).loc);
                    }
break;
case 92:
//#line 450 "Parser.y"
{
                        yyval.expr = new Tree.Array(val_peek(1).elist, val_peek(2).loc);
                    }
break;
case 93:
//#line 456 "Parser.y"
{
						yyval.elist.add(val_peek(0).expr);
					}
break;
case 94:
//#line 460 "Parser.y"
{
                		yyval.elist = new ArrayList<Tree.Expr>();
						yyval.elist.add(val_peek(0).expr);
                	}
break;
case 96:
//#line 468 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.elist = new ArrayList<Tree.Expr>();
                	}
break;
case 97:
//#line 475 "Parser.y"
{
						yyval.elist.add(val_peek(0).expr);
					}
break;
case 98:
//#line 479 "Parser.y"
{
                		yyval.elist = new ArrayList<Tree.Expr>();
						yyval.elist.add(val_peek(0).expr);
                	}
break;
case 99:
//#line 486 "Parser.y"
{
						yyval.stmt = new Tree.WhileLoop(val_peek(2).expr, val_peek(0).stmt, val_peek(4).loc);
					}
break;
case 100:
//#line 492 "Parser.y"
{
						yyval.stmt = new Tree.ForLoop(val_peek(6).stmt, val_peek(4).expr, val_peek(2).stmt, val_peek(0).stmt, val_peek(8).loc);
					}
break;
case 101:
//#line 498 "Parser.y"
{
						yyval.stmt = new Tree.Break(val_peek(0).loc);
					}
break;
case 102:
//#line 504 "Parser.y"
{
						yyval.stmt = new Tree.If(val_peek(3).expr, val_peek(1).stmt, val_peek(0).stmt, val_peek(5).loc);
					}
break;
case 103:
//#line 510 "Parser.y"
{
						yyval.stmt = val_peek(0).stmt;
					}
break;
case 104:
//#line 514 "Parser.y"
{
						yyval = new SemValue();
					}
break;
case 105:
//#line 520 "Parser.y"
{
						yyval.stmt = new Tree.Return(val_peek(0).expr, val_peek(1).loc);
					}
break;
case 106:
//#line 524 "Parser.y"
{
                		yyval.stmt = new Tree.Return(null, val_peek(0).loc);
                	}
break;
case 107:
//#line 530 "Parser.y"
{
						yyval.stmt = new Print(val_peek(1).elist, val_peek(3).loc);
					}
break;
//#line 1442 "Parser.java"
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
