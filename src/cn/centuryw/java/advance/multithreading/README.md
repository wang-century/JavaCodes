# 多线程

### 线程创建方式

1. **继承Thread类**

   说明：继承Thread并重写run方法

   示例代码见 Method1ExtendThread.java 

2. **实现Runnable接口**

   说明：创建类实现Runnable接口 --> 将实现类放入Thread类创建对象 --> 调用创建的Thread对象

   示例代码见 Method2ImplementsRunnable.java

3. **实现Callable接口**

   说明：创建类实现Callable接口 --> 创建对象 --> 创建执行服务 --> 将对象放入服务提交执行 --> 获取执行结果 --> 关闭执行服务

   示例代码见 Method3ImplementsCallable.java



## 使用Lambda表达式简化(用一次的)线程的使用

示例代码见 LambdaThread.java



## 静态代理设计模式

说明：分为两个角色

1. 真实角色
2. 代理角色

示例代码见 StaticProxy.java



## 线程状态

![](https://github.com/wang-century/JavaCodes/blob/main/imgs/multithreadingThreadStatus.png)

