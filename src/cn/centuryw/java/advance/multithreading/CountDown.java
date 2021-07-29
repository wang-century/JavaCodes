package cn.centuryw.java.advance.multithreading;

/**
 * sleep模拟倒计时
 */
public class CountDown {
    public static void main(String[] args) throws InterruptedException {
        // 倒计时10秒
        int num = 10;
        do {
            Thread.sleep(1000);
            System.out.println(num--);
        } while (num != 0);
    }

}
