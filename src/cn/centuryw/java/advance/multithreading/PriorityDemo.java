package cn.centuryw.java.advance.multithreading;

/**
 * 线程优先级 1-10
 * 1. NORM_PRIORITY 5 默认
 * 2. MIN_PRIORITY  1
 * 3. MAX_PRIORITY  10
 * 注意：优先级代表概率，不代表绝对的先后顺序
 */
public class PriorityDemo {
    public static void main(String[] args) {
        // 创建线程
        Thread thread = new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("自定义线程优先级:"+Thread.currentThread().getPriority());
        });
        // 设置线程优先级
        thread.setPriority(Thread.MAX_PRIORITY);
        // 开始线程
        thread.start();
        System.out.println("主线程优先级:"+Thread.currentThread().getPriority());
    }

}
