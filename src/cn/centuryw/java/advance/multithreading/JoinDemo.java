package cn.centuryw.java.advance.multithreading;

/**
 * join合并线程(插队)
 */
public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        // 创建线程
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("创建的线程:" + i);
            }
        });
        // 主线程执行
        for (int i = 0; i < 100; i++) {
            if (i == 20) {
                thread.start(); // 开始执行创建的线程
                thread.join();  // 线程插队，必须执行完该线程才能继续执行主线程
            }
            System.out.println("主线程:" + i);
        }
    }
}
