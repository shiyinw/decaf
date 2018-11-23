# Decaf PA 2

王世因	2016011246

### 1. 类的浅复制scopy

这个的问题比较简单，只需要增加`visitScopy`函数的定义即可。通过便利各种可能的错误，得到判定条件，并写代码中。重点就是考察函数的两个参数是不是`class`和`class type`的。

```java
@Override
public void visitScopy(Tree.Scopy scopy) {
    Symbol v = table.lookupBeforeLocation(scopy.indentifier, scopy.getLocation());
    if (v == null) {
        issueError(new UndeclVarError(scopy.getLocation(), scopy.indentifier));
    }
    else{
        if(!v.getType().isClassType()) {
            issueError(new BadScopyArgError(scopy.getLocation(), "dst", v.getType().toString()));
            scopy.expr.accept(this);
            if (!scopy.expr.type.isClassType()) {
                issueError(new BadScopyArgError(scopy.expr.getLocation(), "src", scopy.expr.type.toString()));
            }
            scopy.type = scopy.expr.type;
        }
        else{
            scopy.expr.accept(this);
            if (!scopy.expr.type.isClassType()) {
                issueError(new BadScopySrcError(scopy.getLocation(), v.getType().toString(), scopy.expr.type.toString()));
            }
            scopy.type = scopy.expr.type;
        }
    }

}
```

### 2. sealed

这个需要在每次的定义新的`class`的时候访问它的父类，看看它是不是一个`sealed`的类，具体实现上直接在给定的`visitClassDef`的基础上添加如下的判断即可：

```java
table.open(classDef.symbol.getAssociatedScope());
Class parent = table.lookupClass(classDef.parent);
if (parent!=null && parent.isSealed()){
	issueError(new BadSealedInherError(classDef.getLocation()));
}
```

### 3. 串行条件卫士

仿照`visitIf`，我利用了事先写好的`checkTestExpr(IFG.condition);`完成了检查：

```java
@Override
public void visitGuard(Tree.Guard guard){
    for (Tree s : guard.block) {
        s.accept(this);
    }
}

@Override
public void visitIfG(Tree.IfG IFG){
    checkTestExpr(IFG.condition);
    if (IFG.trueBranch != null) {
        IFG.trueBranch.accept(this);
    }
}
```



### 实验总结和体会

这次的PA和上次的PA目标是一致的，只不过不能用上次的YACC工具了，需要自己写LL(1)文法进行转化。在这个过程中，我对于理论部分有了深入的了解，也进一步锻炼了自己的代码能力。