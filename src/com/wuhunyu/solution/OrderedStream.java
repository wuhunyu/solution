package com.wuhunyu.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 1656. 设计有序流
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/8/16 8:46
 */

public class OrderedStream {

    private final String[] arr;

    private final int n;

    private int ptr;

    public OrderedStream(int n) {
        arr = new String[n + 1];
        this.n = n;
        ptr = 1;
    }

    public List<String> insert(int idKey, String value) {
        arr[idKey] = value;
        List<String> list = new ArrayList<>();
        while (ptr <= n && arr[ptr] != null) {
            list.add(arr[ptr++]);
        }
        return list;
    }

    public static void main(String[] args) {
        OrderedStream orderedStream = new OrderedStream(5);

    }

}
