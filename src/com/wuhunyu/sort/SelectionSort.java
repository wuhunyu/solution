package com.wuhunyu.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/12 9:37
 */

public class SelectionSort implements ArrSort {

    @Override
    public void sort(int[] arr) {
        if (!this.isNeedSort(arr)) {
            return;
        }
        this.selectionSort(arr);
    }

    private void selectionSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            this.swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        ArrSort selectionSort = new SelectionSort();

        int[] arr = {5, 4, 3, 2, 1};
        selectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
