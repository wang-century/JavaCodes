package cn.centuryw.java.advance.multithreading;

import java.util.concurrent.*;

/**
 * 创建多线程，方法三：实现Callable接口
 * 说明：创建类实现Callable接口 --> 创建对象 --> 创建执行服务 --> 将对象放入服务提交执行 --> 获取执行结果 --> 关闭执行服务
 */
public class Method3ImplementsCallable implements Callable<Boolean> {
    public final int sleepTime;
    public final String name;

    public Method3ImplementsCallable(String name, int sleepTime) {
        this.sleepTime = sleepTime;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        // 线程要进行的操作
        System.out.println(this.name + "开始执行");
        for (int i = 0; i < 5; i++) {
            Thread.sleep(this.sleepTime);
            System.out.println(this.name + "打印:" + i);
        }
        return true;
    }

    public static void main(String[] args) {
        // 创建
        Method3ImplementsCallable callable1 = new Method3ImplementsCallable("线程一", 2000);
        Method3ImplementsCallable callable2 = new Method3ImplementsCallable("线程二", 1000);
        // 创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(3);
        // 提交执行
        Future<Boolean> result1 = service.submit(callable1);
        Future<Boolean> result2 = service.submit(callable2);
        // 获取结果
        try {
            boolean r1 = result1.get();
            boolean r2 = result2.get();
            if (r1) {
                System.out.println("线程一执行完毕");
            }
            if (r2) {
                System.out.println("线程二执行完毕");
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        // 关闭服务
        service.shutdownNow();
    }
}
