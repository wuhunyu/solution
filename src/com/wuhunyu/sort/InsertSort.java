package com.wuhunyu.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/12 10:17
 */

public class InsertSort implements ArrSort {

    @Override
    public void sort(int[] arr) {
        if (!this.isNeedSort(arr)) {
            return;
        }
        this.insertSort(arr);
    }

    public void insertSort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int tmp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > tmp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        ArrSort insertSort = new InsertSort();

        int[] arr = {5, 4, 3, 2, 1};
        insertSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
