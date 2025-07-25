package com.yuan.chapter6.clone;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 6-5 Employee 类
 */
public class Employee implements Cloneable {

    private String name;

    private double salary;

    private Date hireDay;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        hireDay = new Date();
    }

    @Override
    public Employee clone() throws CloneNotSupportedException {
        // 调用Object的clone方法
        Employee cloned = (Employee) super.clone();

        // 创建一个新对象，然后把hireDay字段的值复制给它
        cloned.hireDay = (Date) hireDay.clone();

        return cloned;
    }

    public void setHireDay(int year, int month, int day) {
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
        hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public String toString() {
        return "Employee[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
    }
}
