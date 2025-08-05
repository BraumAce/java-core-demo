package com.yuan.chapter9.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * 9.3.3 散列集 <p>
 * 9-2 从 System.in 读取单词添加到 set 中，打印出前 25 个单词 <p>
 * 命令行运行：java SetTest < words.txt
 */
public class SetTest {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        long totalTime = 0;

        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNext()) {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                set.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }
        }

        Iterator<String> iter = set.iterator();
        for (int i = 1; i <= 25 && iter.hasNext(); i++) {
            System.out.println(iter.next());
        }
        System.out.println("...");
        System.out.println(set.size() + " distinct words; " + totalTime + " milliseconds.");
    }
}
