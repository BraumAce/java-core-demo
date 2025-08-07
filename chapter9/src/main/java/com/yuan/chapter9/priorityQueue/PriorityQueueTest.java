package com.yuan.chapter9.priorityQueue;

import java.time.LocalDate;
import java.util.PriorityQueue;

/**
 * 9.3.6 优先队列 <p>
 * 9-5 一个优先队列的具体使用
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<LocalDate> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(LocalDate.of(1906, 12, 9));
        priorityQueue.add(LocalDate.of(1815, 12, 10));
        priorityQueue.add(LocalDate.of(1903, 12, 3));
        priorityQueue.add(LocalDate.of(1912, 6, 22));

        System.out.println("Iterating over elements ...");
        for (LocalDate date : priorityQueue) {
            System.out.println(date);
        }
        System.out.println("Removing elements ...");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.remove());
        }
    }
}
