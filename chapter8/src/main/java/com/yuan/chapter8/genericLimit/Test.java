package com.yuan.chapter8.genericLimit;

/**
 * 8.6.9 抛出一个检查型异常
 */
public class Test {

    public static void main(String[] args) {
        Thread thread = new Thread(Task.asRunnable(() -> {
            Thread.sleep(1000);
            System.out.println("hello world");
            throw new Exception("Check this out!");
        }));
        thread.start();
    }
}
