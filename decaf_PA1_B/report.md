# Decaf PA 1-A

王世因 2016011246

### 遇到的问题

#### 1. follow set的更新方式

我在样例中报错`stackoverflow`，是因为`parser.java`代码中的纠错部分陷入了死循环。正确的写法是每次把当前节点的follow set加入到总的follow set中，包含它所有的父节点的follow set，这样我们可以在遇到文件的结尾的时候退出循环。

```java
Set<Integer> beginset = beginSet(symbol);
Set<Integer> followset =followSet(symbol);
followset.addAll(follow);  // add the follow set of A
```

