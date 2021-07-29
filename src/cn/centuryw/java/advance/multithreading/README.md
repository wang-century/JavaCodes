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

![](https://github.com/wang-century/JavaCodes/blob/main/imgs/multithreading/01.png)

![](https://github.com/wang-century/JavaCodes/blob/main/imgs/multithreading/02.png)



## 终止线程

1. 线程正常执行完毕

2. 外部干涉-->加入标识位来控制线程关闭

   示例代码见TerminateThread.java



## 线程方法

- sleep() 	使线程停止运行一段时间，将处于阻塞状态

  sleep模拟倒计时示例代码见CountDown.java

- yield()      礼让线程，让当前正在执行的线程暂停，不是阻塞线程，而是将线程从运行状态转入就绪状态，让CPU重新调度

  yield模拟礼让示例代码见YieldDemo.java

- join()        合并线程，等此线程执行完毕后再执行其他线程，其他线程阻塞

  线程插队模拟代码示例JoinDemo.java
