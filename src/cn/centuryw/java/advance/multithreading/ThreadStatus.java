package cn.centuryw.java.advance.multithreading;

/**
 * 查看线程状态
 */
public class ThreadStatus {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("...");
            }
        });
        Thread.State state = thread.getState(); // 获取线程状态
        System.out.println(state);  // NEW
        thread.start(); // 开始线程
        state = thread.getState(); // 获取线程状态
        System.out.println(state);  // RUNNABLE
        while (state != Thread.State.TERMINATED) {
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
            state = thread.getState();  // 获取线程状态
            System.out.println(state);  // TIMED_WAITING
        }
        state = thread.getState();  // 获取线程状态
        System.out.println(state);  // TERMINATED
    }

}
