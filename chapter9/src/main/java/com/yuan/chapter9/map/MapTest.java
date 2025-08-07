package com.yuan.chapter9.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Susan", 95);
        map.put("Jay", 85);
        map.put("Jane", 75);
        map.put("Kim", 90);
        System.out.println(map);

        map.remove("Jay");
        System.out.println("map is contain Jay? result: " + map.containsKey("Jay"));

        System.out.println("Jane old value is: " + map.get("Jane"));
        map.put("Jane", 95);
        System.out.println("Jane new value is: " + map.get("Jane"));

        System.out.println(map);

        map.forEach((k, v) -> System.out.println("key=" + k + ", value=" + v));
    }
}
