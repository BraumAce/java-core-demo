package com.yuan.chapter9.sieve;

import java.util.BitSet;

/**
 * 9.7.5 位集  <p>
 * 9-8 素数筛
 */
public class Sieve {

    public static void main(String[] args) {
        int n = 2000000;
        long start = System.currentTimeMillis();

        BitSet bitSet = new BitSet(n + 1);
        for (int i = 2; i <= n; i++) {
            bitSet.set(i);
        }

        for (int i = 2; i * i <= n; i++) {
            if (bitSet.get(i)) {
                for (int j = i * i; j <= n; j += i) {
                    bitSet.clear(j);
                }
            }
        }

        long end = System.currentTimeMillis();
        System.out.println(bitSet.cardinality() + " primes");
        System.out.println("time = " + (end - start));
    }
}
