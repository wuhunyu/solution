package com.wuhunyu.sort;

/**
 * 排序
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/12 9:37
 */

public interface ArrSort {

    /**
     * 排序方法
     *
     * @param arr 待排序数组
     */
    void sort(int[] arr);

    /**
     * 校验待排序数组是否需要排序
     *
     * @param arr 待排序数组
     * @return 是否需要排序(false : 不需要排序 ; true : 需要排序)
     */
    default boolean isNeedSort(int[] arr) {
        return arr != null && arr.length > 1;
    }

    /**
     * 交换数组元素
     *
     * @param arr    待排序数组
     * @param index1 待交换元素下标1
     * @param index2 待交换元素下标2
     */
    default void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

}
