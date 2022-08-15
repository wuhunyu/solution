package com.wuhunyu.sort;

import java.util.Arrays;

/**
 * 希尔排序
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/12 10:51
 */

public class ShellSort implements ArrSort {

    @Override
    public void sort(int[] arr) {
        if (!this.isNeedSort(arr)) {
            return;
        }
        this.shellSort(arr);
    }

    private void shellSort(int[] arr) {
        int len = arr.length;
        int gep = len >> 1;
        while (gep >= 1) {
            for (int i = gep; i < len; i++) {
                int tmp = arr[i];
                int j = i;
                while (j >= gep && arr[j - gep] > tmp) {
                    arr[j] = arr[j - gep];
                    j -= gep;
                }
                arr[j] = tmp;
            }
            gep >>= 1;
        }
    }

    public static void main(String[] args) {
        ArrSort shellSort = new ShellSort();

        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
