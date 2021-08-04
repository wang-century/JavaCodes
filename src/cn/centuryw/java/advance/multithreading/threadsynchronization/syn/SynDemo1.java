package cn.centuryw.java.advance.multithreading.threadsynchronization.syn;

/**
 * 线程安全：在并发时保证数据的正确性，效率尽可能高
 * 通过synchronized
 * 1. 同步方法
 * 2. 同步块
 */
public class SynDemo1 {
    public static void main(String[] args) {
        // 一份资源
        WebSource webSource = new WebSource();
        // 多个代理
        new Thread(webSource, "窗口一").start();
        new Thread(webSource, "窗口二").start();
        new Thread(webSource, "窗口三").start();
    }
}

class WebSource implements Runnable {
    private int ticketCount = 10;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            // 模拟延时
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
            sell();
        }
    }

    public synchronized void sell() {
        if (ticketCount <= 0) {
            flag = false;
            return;
        }
        // 模拟延时
        try {
            Thread.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-->" + ticketCount--);
    }
}