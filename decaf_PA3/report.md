# Decaf PA 3

王世因	2016011246

### Runtime Error 添加被除数是0的报错

* 修改文件 error/RuntimeError.java

```java
public static final String DIVIDE_BY_ZERO = "Decaf runtime error: Division by zero error.\n";
```

* 修改文件 translate/TransPass2.java 中的visitBinary

在第二遍遍历的时候，我们计算出了各表达式的值，在此基础上进行是否为0的判断

```java
case Tree.DIV:
    tr.genCheckNZero(expr.right.val);
    expr.val = tr.genDiv(expr.left.val, expr.right.val);
    break;
case Tree.MOD:
    tr.genCheckNZero(expr.right.val);
    expr.val = tr.genMod(expr.left.val, expr.right.val);
    break;
```

* 修改文件 translate/translator.java

仿照其他的比较大小的函数，我定义了判断是否为0的函数

```java
public void genCheckNZero(Temp size){
    Label exit = Label.createLabel();
    Temp cond = genEqu(size, genLoadImm4(0));
    genBeqz(cond, exit);
    Temp msg = genLoadStrConst(RuntimeError.DIVIDE_BY_ZERO);
    genParm(msg);
    genIntrinsicCall(Intrinsic.PRINT_STRING);
    genIntrinsicCall(Intrinsic.HALT);
    genMark(exit);
}
```

### Guard条件卫士

* 修改文件 translate/TransPass2.java

```java
@Override
public void visitGuard(Tree.Guard guard){
    for (Tree s : guard.block) {
        s.accept(this);
    }
}

@Override
public void visitIfG(Tree.IfG ifStmt){
    ifStmt.condition.accept(this);
    if (ifStmt.trueBranch != null) {
        Label exit = Label.createLabel();
        tr.genBeqz(ifStmt.condition.val, exit);
        if (ifStmt.trueBranch != null) {
            ifStmt.trueBranch.accept(this);
        }
        tr.genMark(exit);
    }
}
```

### var 类型推导

* 修改文件translate/TransPass1.java 定义变量

```java
@Override
public void visitVarAssign(Tree.VarAssign varDef) {
    vars.add(varDef.symbol);
    objectSize += OffsetCounter.WORD_SIZE;
}
```

* 修改文件translate/TransPass2.java 计算类型的值

结合了`visitVarDef`和`visitAssign`两个函数

```java
@Override
public void visitVarAssign(Tree.VarAssign var) {
    var.expr.accept(this);

    if (var.symbol.isLocalVar()) {
        Temp t = Temp.createTempI4();
        t.sym = var.symbol;
        var.symbol.setTemp(t);
    }
    tr.genAssign(((Tree.VarAssign) var).symbol.getTemp(), var.expr.val);
}
```

### Array 数组

#### 

### 实验总结和体会

照猫画虎固然可行，但是提前摸清楚算法的原理，可以让我们少走许多弯路，对于实验也有一个高屋建瓴的把控。visitor模式太巧妙了，我体会到了数据结构设计的魅力，这个思想我会好好记住，没准日后会再用上。

我注意到在Intellij IDE中，编译的时候会进行冲突检查，在继承关系复杂的时候，因为不知道具体的输入是子类还是父类，使用只有子类中有的属性的时候会报错。所以有的时候需要强制类型转化一下。