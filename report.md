# Decaf PA 1-A

王世因 2016011246

### 任务描述

根据实验讲义上的说明，我需要通过更改以下的文件达到附加的功能：

| 文件名          | 含义                   | 说明                                            |
| --------------- | ---------------------- | ----------------------------------------------- |
| Lexer.l         | LEX 源程序             | 你要在此文件中定义正规 式，并给出相应的动作。   |
| Parser.y        | YACC 源程序            | 你要在其中加入 Decaf 的 语法规则和归约动作      |
| SemValue        | 文法符号的语义信息     | 你要根据自己的需要进行 适当的修改               |
| `ParserHelper ` | 编写 YACC 动作的辅助类 | 在这里编写 yacc 的动作， 然后粘贴到 Parser.y 中 |
| tree/*          | 抽象语法树的各种结点   | 你要在此文件中定义实验 新增特性的语法节点       |
| Driver          | Decaf 编译器入口       | 调试时可以修改                                  |
| utils/*         | 辅助的工具类           | 可以增加，不要修改原来的 部分                   |



#### 具体实现

#### 1. 修改bug

Lexer.l

添加this的保留字

```lex
"this"              { return keyword(Parser.THIS);          }
```

tree.java

有一个明显的bug在于临近的两个生命名称定义不是相连的

```java
	/**
     * Labelled statements, of type Labelled.
     */
    public static final int LABELLED = FORLOOP + 1;

    /**
     * Synchronized statements, of type Synchonized.
     */
    public static final int SYNCHRONIZED = CASE + 1;
```

改正过这个以后，代码就可以初步地跑起来力，程序通过了`error*.decaf`、`fibonacci.decaf`、`nqueues.decaf`和`test*.decaf`。

### 2. 