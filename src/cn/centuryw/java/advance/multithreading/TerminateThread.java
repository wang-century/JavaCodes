package cn.centuryw.java.advance.multithreading;

/**
 * 终止线程
 * 1. 线程正常执行完毕
 * 2. 外部干涉 --> 加入标识
 */
public class TerminateThread implements Runnable {
    private boolean flag = true;   // 标记线程是否可以运行
    private final String name;

    public static void main(String[] args) {
        // 创建对象
        TerminateThread terminateThread = new TerminateThread("线程一");
        // 创建并启动线程
        new Thread(terminateThread).start();
        // 等待一段时间
        try {
            Thread.sleep(4000);
            // 设置标识符为false
            terminateThread.terminate();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行完毕");

    }

    public TerminateThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name+"开始执行");
        // 关联标识  true运行 false停止运行
        int i = 0;
        while (flag) {
            try {
                System.out.println(name + ":" + i++);
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name+"执行结束");
    }

    public void terminate() {
        this.flag = false;
    }
}
