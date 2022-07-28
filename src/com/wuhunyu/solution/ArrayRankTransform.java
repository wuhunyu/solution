package com.wuhunyu.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1331. 数组序号转换
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/7/28 8:29
 */

public class ArrayRankTransform {

    public int[] arrayRankTransform(int[] arr) {
        int[] arrCopy = arr.clone();
        Arrays.sort(arrCopy);
        int len = arrCopy.length;
        Map<Integer, Integer> map = new HashMap<>(len);
        int pre = Integer.MIN_VALUE;
        int rank = 0;
        for (int num : arrCopy) {
            if (num == pre) {
                map.put(num, rank);
            } else {
                pre = num;
                map.put(num, ++rank);
            }
        }
        for (int i = 0; i < len; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }

}
