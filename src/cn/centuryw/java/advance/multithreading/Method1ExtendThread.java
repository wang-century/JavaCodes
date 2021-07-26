package cn.centuryw.java.advance.multithreading;


/**
 * 创建多线程，方法一：继承Thread类
 * 说明：继承Thread并重写run方法
 */
public class Method1ExtendThread extends Thread {
    private final int sleepTime;

    public Method1ExtendThread(String name, int sleepTime) {
        super(name);
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        // 线程要进行的操作
        System.out.println(this.getName()+"开始执行");
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(this.sleepTime);
                System.out.println(this.getName() + "打印:" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.getName()+"结束执行");
    }

    /**
     * 测试多线程
     */
    public static void main(String[] args) {
        // 创建线程
        Method1ExtendThread thread1 = new Method1ExtendThread("线程一",2000);
        Method1ExtendThread thread2 = new Method1ExtendThread("线程二",1000);
        // 启动线程
        thread1.start();
        thread2.start();
    }
}
