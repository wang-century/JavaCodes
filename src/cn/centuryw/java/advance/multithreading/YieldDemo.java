package cn.centuryw.java.advance.multithreading;

/**
 * yield礼让线程，暂停当前线程，转入就绪状态
 * 例子：主线程礼让创建的线程
 */
public class YieldDemo {
    public static void main(String[] args) {
        // 创建线程
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("创建的线程:" + i);
            }
        }).start();
        // 主线程执行
        for (int i = 0; i < 100; i++) {
            // 每到对十求余为0礼让一次
            if (i % 10 == 0) {
                Thread.yield(); // 礼让
            }
            System.out.println("主线程:"+i);
        }

    }
}
