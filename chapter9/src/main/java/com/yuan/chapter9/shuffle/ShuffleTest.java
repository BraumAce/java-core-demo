package com.yuan.chapter9.shuffle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 9.6.2 排序与混排 <p>
 * 9-7 随机地混排列表，并从混排后的列表中选择前几个值，排序后打印出来
 */
public class ShuffleTest {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 49; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        System.out.println(numbers);

        List<Integer> winningCombination = numbers.subList(0, 6);
        Collections.sort(winningCombination);
        System.out.println(winningCombination);
    }
}
