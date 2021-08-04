package cn.centuryw.java.advance.multithreading;

/**
 * 线程的分类
 * - 用户线程
 * - 守护线程
 * 注：守护线程为用户线程服务，虚拟机不用等待守护线程执行完毕，如后台记录操作日志、监控内存使用等。
 */
public class DaemonDemo {
    public static void main(String[] args) {
        // 创建线程
        Thread god = new Thread(() -> {
            while (true) {
                System.out.println("上帝保佑你");
            }
        });
        Thread you = new Thread(() -> {
            for (int i = 1; i < 1000; i++) {
                System.out.println("你正在做第" + i + "件事");
            }
        });
        // 设置线程为守护线程（默认为用户线程）
        god.setDaemon(true);
        // 开始线程
        god.start();
        you.start();
    }
}

