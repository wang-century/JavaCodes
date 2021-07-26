package cn.centuryw.java.advance.multithreading;


/**
 * 创建多线程，方法二：实现Runnable接口
 */
public class Method2ImplementsRunnable implements Runnable {
    public final int sleepTime;
    public final String name;

    public Method2ImplementsRunnable(String name, int sleepTime) {
        this.name = name;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        // 线程要进行的操作
        System.out.println(this.name + "开始执行");
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(this.sleepTime);
                System.out.println(this.name + "打印:" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.name + "结束执行");
    }

    /**
     * 测试多线程
     */
    public static void main(String[] args) {
        // 创建线程
        Method2ImplementsRunnable runnable1 = new Method2ImplementsRunnable("线程一", 2000);
        Method2ImplementsRunnable runnable2 = new Method2ImplementsRunnable("线程二", 1000);
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        // 启动线程
        thread1.start();
        thread2.start();
    }
}
