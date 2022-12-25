package com.wuhunyu.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 295. 数据流的中位数
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/12/23 8:25
 */

public class MedianFinder {

    private final List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
        int size = list.size();
        for (int i = size - 1; i > 0; i--) {
            if (list.get(i) >= list.get(i - 1)) {
                break;
            }
            Integer tmp = list.get(i);
            list.set(i, list.get(i - 1));
            list.set(i - 1, tmp);
        }
    }

    public double findMedian() {
        int size = list.size();
        return (size & 1) == 0 ?
                (list.get(size >> 1) + list.get((size - 1) >> 1)) / 2.0D :
                list.get(size >> 1).doubleValue();
    }

}
