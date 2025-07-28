package com.yuan.chapter8.pair1;

/**
 * 8.2 定义简单泛型类
 * 8-1 创建一个简单的泛型类
 */
public class pairTest1 {

    public static void main(String[] args) {
        String[] words = { "Mary", "had", "a", "little", "lamb" };
        Pair<String> nm = ArrayAlg.minmax(words);
        System.out.println("min = " + nm.getFirst());
        System.out.println("max = " + nm.getSecond());
    }
}

class ArrayAlg {

    public static Pair<String> minmax(String[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        String min = a[0];
        String max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }
        return new Pair<>(min, max);
    }
}
