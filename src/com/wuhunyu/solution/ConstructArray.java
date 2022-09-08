package com.wuhunyu.solution;

import java.util.Arrays;

/**
 * 667. 优美的排列 II
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-08 8:10
 */

public class ConstructArray {

    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int limit = n - k;
        for (int i = 0; i < limit; i++) {
            res[i] = i + 1;
        }
        int i = n - k + 1;
        int j = n;
        int index = limit;
        while (index < n) {
            res[index++] = j;
            if (i != j--) {
                res[index++] = i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ConstructArray constructArray = new ConstructArray();

        System.out.println(Arrays.toString(constructArray.constructArray(6, 1)));
        System.out.println(Arrays.toString(constructArray.constructArray(6, 2)));
        System.out.println(Arrays.toString(constructArray.constructArray(6, 3)));
        System.out.println(Arrays.toString(constructArray.constructArray(6, 4)));
        System.out.println(Arrays.toString(constructArray.constructArray(6, 5)));
    }

}
