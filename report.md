Lexer.l

添加this的保留字

```
"this"              { return keyword(Parser.THIS);          }
```

