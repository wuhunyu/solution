package com.wuhunyu.sort;

/**
 * 冒泡排序
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/12 9:25
 */

public class BubbleArrSort implements ArrSort {

    @Override
    public void sort(int[] arr) {
        if (!this.isNeedSort(arr)) {
            return;
        }
        this.bubbleSort(arr);
    }

    private void bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            boolean isSorted = true;
            for (int j = 1; j < len - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    this.swap(arr, j, j - 1);
                    isSorted = false;
                }
            }
            if (isSorted) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        BubbleArrSort bubbleSort = new BubbleArrSort();

//        bubbleSort.sort(new int[]{5, 4, 3, 2, 1});
        bubbleSort.sort(new int[]{2, 1});
    }

}
