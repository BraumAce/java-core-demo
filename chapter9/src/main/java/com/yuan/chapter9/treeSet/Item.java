package com.yuan.chapter9.treeSet;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 9-4 Item 比较对象
 */
@Data
@AllArgsConstructor
public class Item implements Comparable<Item> {

    private String description;

    private int partNumber;

    @Override
    public int compareTo(Item other) {
        int diff = Integer.compare(partNumber, other.partNumber);
        return diff != 0 ? diff : description.compareTo(other.description);
    }
}
