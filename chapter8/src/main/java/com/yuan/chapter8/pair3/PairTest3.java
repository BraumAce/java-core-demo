package com.yuan.chapter8.pair3;

import com.yuan.chapter8.pair1.Pair;

public class PairTest3 {

    public static void main(String[] args) {
        Manager ceo = new Manager("Gus Greedy", 800000);
        Manager cfo = new Manager("Sid Sneaky", 600000);
        Pair<Manager> buddies = new Pair<>(ceo, cfo);
        printBuddies(buddies);

        ceo.setBonus(1000000);
        cfo.setBonus(500000);
        Manager[] managers = { ceo, cfo };

        Pair<Employee> result = new Pair<>();
        minmaxBonus(managers, result);
        System.out.println("first: " + result.getFirst().getName() +
                ", second: " + result.getSecond().getName());
        maxminBonus(managers, result);
        System.out.println("first: " + result.getFirst().getName() +
                ", second: " + result.getSecond().getName());
    }

    public static void printBuddies(Pair<? extends Employee> p) {
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
    }

    public static void minmaxBonus(Manager[] a, Pair<? super Manager> result) {
        if (a.length == 0) {
            return;
        }

        Manager min = a[0];
        Manager max = a[0];
        for (Manager manager : a) {
            if (min.getBonus() > manager.getBonus()) {
                min = manager;
            }
            if (max.getBonus() < manager.getBonus()) {
                max = manager;
            }
        }
        result.setFirst(min);
        result.setSecond(max);
    }

    public static void maxminBonus(Manager[] a, Pair<? super Manager> result) {
        minmaxBonus(a, result);
        PairAlg.swapHelper(result);
    }
}
