package chapter6.lambda;

import javax.swing.*;
import java.util.Arrays;
import java.util.Date;
import java.util.function.IntConsumer;

/**
 * 6.2.2 lambda 表达式的语法
 * 6-6 对一个比较器和一个监听器使用 lambda 表达式
 */
public class LambdaTest {
    public static void main(String[] args) {
        String[] strings = { "Mary", "Sue", "Kate", "Jane", "Jill", "Mike", "Jim", "Joe" };
        System.out.println(Arrays.toString(strings));

        System.out.println("Sorted in dictionary order: ");
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));

        System.out.println("Sorted by length: ");
        Arrays.sort(strings, (a, b) -> a.length() - b.length());
        System.out.println(Arrays.toString(strings));

        repeat(10, i -> System.out.println("Countdown: " + (9 - i)));

        Timer timer = new Timer(1000, event -> System.out.println("The time is " + new Date()));
        timer.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }

    public static void repeat(int n, IntConsumer action) {
        for (int i = 0; i < n; i++) {
            action.accept(i);
        }
    }
}
