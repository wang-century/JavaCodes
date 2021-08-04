# 多线程

## 线程的分类

- 用户线程
- 守护线程

注意：守护线程为用户线程服务，虚拟机不用等待守护线程执行完毕，如后台记录操作日志、监控内存使用等。

示例代码：DaemonDemo.java

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

查看线程状态示例ThreadStatus.java

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

- isAlive()    判断线程是否终止
- setName()  线程起名
- getName()  获取线程名称
- currentThread()  获取当前正在执行的线程对象，即获取自己本身

## 线程优先级

线程优先级 1-10

1. NORM_PRIORITY 5 默认
2. MIN_PRIORITY  1
3. MAX_PRIORITY  10

注意：优先级代表概率，不代表绝对的先后顺序

示例代码:PriorityDemo.java

## 线程同步

**并发：**同一个对象多个线程同时操作

**线程同步：**线程同步就是一种等待机制，多个需要同时访问此对象的线程进入这个对象的等待池形成队列，等待前面的线程使用完毕后，下一个线程再使用。

### 解决方法

- 锁机制(synchronized)

  在访问时加入锁机制，当一个线程获得对象的排它锁，独占资源，其它线程必须等待，使用完后释放锁。

  **缺陷**：

  ​	一个线程持有锁会导致其它所有需要此锁的线程挂起；

  ​	在多线程竞争下，加锁、释放锁会导致较多的上下文切换和调度延时，引起性能问题；

  ​	如果一个优先级高的线程等待一个优先级低的线程释放锁会导致优先级倒置，引起性能问题

  

  - 同步方法

    ```java
    public synchronized void method(int arg){}
    ```

    缺陷：若将一个大的方法声明为synchronized将会大大影响效率

    示例代码：threadsynchronization.syn.SynDemo1.java

  - 

- 

