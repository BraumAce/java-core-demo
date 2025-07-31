package com.yuan.chapter8.genericReflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class GenericReflection {
    public static void printClass(Class<?> clazz) {
        System.out.print(clazz);
        printTypes(clazz.getTypeParameters(), "<", ", ", ">", true);
        Type genericSuperclass = clazz.getGenericSuperclass();
        if (genericSuperclass != null) {
            System.out.print(" extends ");
            printType(genericSuperclass, false);
        }
        printTypes(clazz.getGenericInterfaces(), " implements ", ", ", "", false);
        System.out.println();
    }

    public static void printMethod(Method method) {
        String name = method.getName();
        System.out.print(Modifier.toString(method.getModifiers()));
        System.out.print(" ");
        printTypes(method.getTypeParameters(), "<", ", ", ">", true);

        printType(method.getGenericReturnType(), false);
        System.out.print(" " + name + "(");
        printTypes(method.getGenericParameterTypes(), "", ", ", "", false);
        System.out.println(")");
    }

    public static void printTypes(Type[] types, String pre, String sep, String suf, boolean isDefinition) {
        if (" extends ".equals(pre) && Arrays.equals(types, new Type[] { Object.class })) {
            return;
        }
        if (types.length > 0) {
            System.out.print(pre);
        }
        for (int i = 0; i < types.length; i++) {
            if (i > 0) {
                System.out.print(sep);
            }
            printType(types[i], isDefinition);
        }
        if (types.length > 0) {
            System.out.print(suf);
        }
    }

    public static void printType(Type type, boolean isDefinition) {
        if (type instanceof Class t) {
            System.out.print(t.getName());
        } else if (type instanceof TypeVariable t) {
            System.out.print(t.getName());
            if (isDefinition) {
                printTypes(t.getBounds(), " extends ", " & ", "", false);
            }
        } else if (type instanceof WildcardType t) {
            System.out.print("?");
            printTypes(t.getUpperBounds(), " extends ", " & ", "", false);
            printTypes(t.getLowerBounds(), " super ", " & ", "", false);
        } else if (type instanceof ParameterizedType t) {
            Type owner = t.getOwnerType();
            if (owner != null) {
                printType(owner, false);
                System.out.print(".");
            }
            printType(t.getRawType(), false);
            printTypes(t.getActualTypeArguments(), "<", ", ", ">", false);
        } else if (type instanceof GenericArrayType t) {
            System.out.print("");
            printType(t.getGenericComponentType(), isDefinition);
            System.out.print("[]");
        }
    }
}
