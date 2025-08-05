package com.yuan.chapter9.treeSet;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 9.3.4 树集 <p>
 * 9-3 定制比较器比较元素
 */
public class TreeSetTest {

    public static void main(String[] args) {
        TreeSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster", 1234));
        parts.add(new Item("Widget", 4562));
        parts.add(new Item("Modem", 9912));
        System.out.println(parts);

        TreeSet<Item> sortByDescription = new TreeSet<>(Comparator.comparing(Item::getDescription));

        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}
