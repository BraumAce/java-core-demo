package com.yuan.chapter7.stackTrace;

import java.util.Scanner;

/**
 * 7.2.6 分析栈轨迹元素
 * 7-1 栈轨迹
 */
public class StackTraceTest {

    public static int factorial (int n) {
        System.out.println("factorial(" + n + "):");
        StackWalker walker = StackWalker.getInstance();
        walker.forEach(System.out::println);
        int r;
        if (n <= 1) {
            r = 1;
        }
        else {
            r = n * factorial(n - 1);
        }
        System.out.println("return " + r);
        return r;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter n: ");
            int n = in.nextInt();
            factorial(n);
        }
    }
}
