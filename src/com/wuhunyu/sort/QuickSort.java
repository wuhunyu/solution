package com.wuhunyu.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/11/14 20:37
 */

public class QuickSort implements ArrSort {

    @Override
    public void sort(int[] arr) {
        if (!this.isNeedSort(arr)) {
            return;
        }
        this.quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int flag = arr[end];
        int left = start;
        int right = start;
        while (right < end) {
            if (arr[right] < flag) {
                this.swap(arr, left++, right);
            }
            right++;
        }
        this.swap(arr, left, end);
        this.quickSort(arr, start, left - 1);
        this.quickSort(arr, left + 1, end);
    }

    public static void main(String[] args) {
        ArrSort quickSort = new QuickSort();
        int[] arr = {8, 6, 2, 3, 1, 5, 7};

        quickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
