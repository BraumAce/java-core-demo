package com.yuan.chapter8.genericReflection;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * 8.9.2 使用Class<T>参数进行类型匹配
 * 8-4 使用泛型反射API打印一个给定类的有关信息
 */
public class GenericReflectionTest {

    public static void main(String[] args) {

        // 从命令行参数或用户输入获取类名
        String name;
        if (args.length > 0) {
            name = args[0];
        } else {
            try (Scanner in = new Scanner(System.in)) {
                System.out.println("Please enter class name (e.g. java.util.Collections): ");
                name = in.next();
            }
        }

        try {
            // 打印类的公共信息和方法
            Class<?> clazz = Class.forName(name);
            GenericReflection.printClass(clazz);
            for (Method method : clazz.getDeclaredMethods()) {
                GenericReflection.printMethod(method);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
