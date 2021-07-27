package cn.centuryw.java.advance.multithreading;

/**
 * Lambda表达式简化(用一次的)线程的使用
 */
public class LambdaThread {

    public static void main(String[] args) {
        // 匿名内部类，必须借助接口或者父类
        new Thread(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                // 线程要进行的操作
                System.out.println(name + "开始执行");
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(600);
                        System.out.println(name + "打印:" + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(name + "结束执行");
            }
        }).start();
        // jdk1.8简化 lambda
        new Thread(() -> {
            String name = Thread.currentThread().getName();
            // 线程要进行的操作
            System.out.println(name + "开始执行");
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(600);
                    System.out.println(name + "打印:" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(name + "结束执行");
        }).start();
    }

}
