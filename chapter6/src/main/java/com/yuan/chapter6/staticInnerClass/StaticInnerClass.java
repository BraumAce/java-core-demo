package com.yuan.chapter6.staticInnerClass;

import lombok.Getter;

/**
 * 6.3.7 静态内部类
 * 6-9 静态内部类
 */
public class StaticInnerClass {
    public static void main(String[] args) {
        double[] values = new double[20];
        for (int i = 0; i < values.length; i++) {
            values[i] = 100 * Math.random();
        }

        ArrayAlg.Pair minmax = ArrayAlg.minmax(values);
        System.out.println("min = " + minmax.getFirst());
        System.out.println("max = " + minmax.getSecond());
    }
}

class ArrayAlg {
    @Getter
    public static class Pair {
        private final double first;
        private final double second;

        public Pair(double f, double s) {
            first = f;
            second = s;
        }

    }

    public static Pair minmax(double[] values) {
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;

        for (double v : values) {
            if (min > v) {
                min = v;
            }
            if (max < v) {
                max = v;
            }
        }

        return new Pair(min, max);
    }
}
