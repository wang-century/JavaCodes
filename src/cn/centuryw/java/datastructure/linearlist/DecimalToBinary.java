package cn.centuryw.java.datastructure.linearlist;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 十进制转二进制
 *
 * @author centuryw
 */
public class DecimalToBinary {
    public static void main(String[] args) {
        // 给定十进制数
        int n = 14;
        // 转换为二进制
        int t = n;    // 商
        Deque<Integer> stack = new LinkedList<>();
        do {
            int mode = t % 2;   // 余数
            stack.push(mode);
            t = t / 2;
        } while (t > 0);
        System.out.print(n+"-->");
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
