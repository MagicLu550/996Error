# 996 Kotlin Errors
Kotlin版本的996异常，参考Java版本写了`996Error`、`996Exception`和`996RuntimeException`，
并利用Kotlin强大的DSL支持写了`996TryCatch`。
## 如何使用？
### Config
```kotlin
// 默认为‘该程序由996公司开发’
var Config996Errors.word
// 是否调用Println函数打印word
var Config996Errors.isPrint
```
### DSL
```kotlin
TryCatchDSL996.`try` {
    ...
}.catch(...) {
    ...
} finally {
    ...
} and Done
```
### 996Exceptions
ammmmmm  
**Just Throw !!!!!**
