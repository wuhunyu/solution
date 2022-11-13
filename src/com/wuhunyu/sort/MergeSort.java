package com.wuhunyu.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/12 14:08
 */

public class MergeSort implements ArrSort {

    @Override
    public void sort(int[] arr) {
        if (!this.isNeedSort(arr)) {
            return;
        }
        this.mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + ((end - start) >> 1);
        this.mergeSort(arr, start, mid);
        this.mergeSort(arr, mid + 1, end);
        this.mergeArr(arr, start, mid, mid + 1, end);
    }

    private void mergeArr(int[] arr, int left1, int right1, int left2, int right2) {
        int len = right2 - left1 + 1;
        int[] tmpArr = new int[len];
        int index1 = left1;
        int index2 = left2;
        int index = 0;
        while (index1 <= right1 && index2 <= right2) {
            tmpArr[index++] = arr[index1] <= arr[index2] ? arr[index1++] : arr[index2++];
        }
        if (index1 <= right1) {
            System.arraycopy(arr, index1, tmpArr, index, len - index);
        } else if (index2 <= right2) {
            System.arraycopy(arr, index2, tmpArr, index, len - index);
        }
        System.arraycopy(tmpArr, 0, arr, left1, len);
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();

        int[] arr = {8, 6, 2, 3, 1, 5, 7};

        mergeSort.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

}
