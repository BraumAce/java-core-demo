package com.yuan.chapter6.clone;

/**
 * 6.1.9 对象克隆
 * 6-4 克隆 Employee 类
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee original = new Employee("Harry", 50000);
        original.setHireDay(2025, 1, 1);

        Employee copy = original.clone();
        copy.raiseSalary(10);
        copy.setHireDay(2025, 12, 31);

        System.out.println("original=" + original);
        System.out.println("copy=" + copy);
    }
}
