package chapter6.interfaces;

import java.util.Arrays;

/**
 * 6.1.1 接口的概念
 * 6-1 对 Employee 类实例数组进行排序
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Tom", 35000);
        staff[1] = new Employee("Dick", 75000);
        staff[2] = new Employee("Harry", 38000);

        Arrays.sort(staff);

        for (Employee e : staff) {
            System.out.println("name=" + e.getName() + ", salary=" + e.getSalary());
        }
    }
}
