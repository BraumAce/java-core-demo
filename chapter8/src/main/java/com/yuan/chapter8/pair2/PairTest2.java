package com.yuan.chapter8.pair2;

import com.yuan.chapter8.pair1.Pair;

import java.time.LocalDate;

/**
 * 8.4 类型变量的限定 <p>
 * 8-2 泛型方法
 */
public class PairTest2 {
    public static void main(String[] args) {
        LocalDate[] birthdays = {
                LocalDate.of(1906, 12, 9),
                LocalDate.of(1815, 12, 10),
                LocalDate.of(1903, 12, 3),
                LocalDate.of(1912, 6, 22),
        };

        Pair<LocalDate> nm = ArrayAlg.minmax(birthdays);
        System.out.println("min = " + nm.getFirst());
        System.out.println("max = " + nm.getSecond());
    }
}

class ArrayAlg {
    public static <T extends Comparable> Pair<T> minmax(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        T min = a[0];
        T max = a[0];
        for (T num : a) {
            if (min.compareTo(num) > 0) {
                min = num;
            }
            if (max.compareTo(num) < 0) {
                max = num;
            }
        }
        return new Pair<>(min, max);
    }
}