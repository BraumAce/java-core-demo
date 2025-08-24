package com.yuan.chapter12.threads;

/**
 * 12.1 什么是线程 <p>
 * 12-1 如何并发地运行任务
 */
public class ThreadTest {

    public static final int DELAY = 10;

    public static final int STEPS = 100;

    private static final double MAX_AMOUNT = 1000;

    public static void main(String[] args) {
        Bank bank = new Bank(4, 100000);
        Runnable task1 = () -> {
            try {
                for (int i = 0; i < STEPS; i++) {
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(0, 1, amount);
                    Thread.sleep((int) (DELAY * Math.random()));
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        };

        Runnable task2 = () -> {
            try {
                for (int i = 0; i < STEPS; i++) {
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(2, 3, amount);
                    Thread.sleep((int) (DELAY * Math.random()));
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        };

        new Thread(task1).start();
        new Thread(task2).start();
    }
}
