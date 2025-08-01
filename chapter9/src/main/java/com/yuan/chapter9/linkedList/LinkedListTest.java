package com.yuan.chapter9.linkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * 9.3.1 链表 <p>
 * 9-1 创建两个列表，将其合并，再从第二个列表中每隔一个元素删除一个元素，最后全部删除
 */
public class LinkedListTest {

    public static void main(String[] args) {
        List<String> list1 = new LinkedList<>();
        list1.add("Amy");
        list1.add("Carl");
        list1.add("Erica");

        List<String> list2 = new LinkedList<>();
        list2.add("Bob");
        list2.add("Doug");
        list2.add("Frances");
        list2.add("Gloria");

        // 将list2合并到list1中
        ListIterator<String> iter1 = list1.listIterator();
        Iterator<String> iter2 = list2.iterator();
        while (iter2.hasNext()) {
            if (iter1.hasNext()) {
                iter1.next();
            }
            iter1.add(iter2.next());
        }
        System.out.println(list1);

        // 删除list2中的元素
        iter2 = list2.iterator();
        while (iter2.hasNext()) {
            iter2.next();
            if (iter2.hasNext()) {
                iter2.next();
                iter2.remove();
            }
        }
        System.out.println(list2);

        // 从list1中删除list2中的全部元素
        list1.removeAll(list2);

        System.out.println(list1);
    }
}