package com.wuhunyu.solution;

import java.util.Arrays;

/**
 * 1619. 删除某些元素后的数组均值
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-14 8:18
 */

public class TrimMean {

    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int distance = (int) (arr.length * 0.05D);
        int start = distance;
        int end = arr.length - distance - 1;
        int sum = 0;
        while (start <= end) {
            sum += arr[start++];
        }
        return sum / (arr.length * 0.9D);
    }

    public static void main(String[] args) {
        TrimMean trimMean = new TrimMean();

        System.out.println(trimMean.trimMean(new int[]{1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3}));
    }

}
