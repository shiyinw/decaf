# Decaf PA 1-B

王世因 2016011246

### 1. 本阶段工作

#### 步骤一:阅读 LL(1)分析算法的实现

第一天拿到作业代码的时候，我发现`parser.spec`和PA1-A的`parser.y`十分相似，于是就直接从那里粘贴了很多代码过来，然后遇到了错误。经过仔细看实验报告和ppt，我从现成代码入手看LL(1)分析的语法规则，照猫画虎开始写新增加的特性。

在增加条件卫士特性的时候，我按照PA1A的习惯改代码后，总是报错，而且是以下这种情况，让我十分困惑。后来发现每次修改`parser.spec`后需要`clean`一下再`build`。

```
*** Error at (1,1): syntax error
```

#### 步骤二:增加错误恢复功能

在刚开始运行初始程序的时候，我看到报错NullPointerError，不知道怎么入手。参加了班级的编译原理讲座后理解了大致的写法，之后就根据报告中的算法描述写了。这样我们可以在遇到一个报错的时候，继续继续分析之后的语法，直到遇到了语法的终结符退出这个分支。

```java
Set<Integer> begin = beginSet(symbol);
Set<Integer> end = followSet(symbol);
end.addAll(follow);

if (!begin.contains(lookahead)) {
    error();
    while(true) {
        if (begin.contains(lookahead)) {
            return parse(symbol, follow);
        }
        else if (end.contains(lookahead)) {
            return null;
        }
        lookahead = lex(); // get the next input
    }
}
```

我在样例中报错`stackoverflow`，是因为`parser.java`代码中的纠错部分陷入了死循环。正确的写法是每次把当前节点的follow set加入到总的follow set中，包含它所有的父节点的follow set，这样我们可以在遇到文件的结尾的时候退出循环。

### 2.  if 语句的 else 分支为空冲突处理

### 3. 数组comprehension表达式文法

### 4. 误报