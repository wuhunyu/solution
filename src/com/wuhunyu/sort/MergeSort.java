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
//        this.mergeSort(arr);
    }

//    public int[] mergeSort(int[] sourceArray) {
//        // 对 arr 进行拷贝，不改变参数内容
//        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
//
//        if (arr.length < 2) {
//            return arr;
//        }
//        int middle = (int) Math.floor(arr.length / 2);
//
//        int[] left = Arrays.copyOfRange(arr, 0, middle);
//        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
//
//        return merge(mergeSort(left), mergeSort(right));
//    }
//
//    protected int[] merge(int[] left, int[] right) {
//        int[] result = new int[left.length + right.length];
//        int i = 0;
//        while (left.length > 0 && right.length > 0) {
//            if (left[0] <= right[0]) {
//                result[i++] = left[0];
//                left = Arrays.copyOfRange(left, 1, left.length);
//            } else {
//                result[i++] = right[0];
//                right = Arrays.copyOfRange(right, 1, right.length);
//            }
//        }
//
//        while (left.length > 0) {
//            result[i++] = left[0];
//            left = Arrays.copyOfRange(left, 1, left.length);
//        }
//
//        while (right.length > 0) {
//            result[i++] = right[0];
//            right = Arrays.copyOfRange(right, 1, right.length);
//        }
//
//        return result;
//    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = ((right - left) >> 1) + left;
        this.mergeSort(arr, left, mid - 1);
        this.mergeSort(arr, mid, right);
        this.mergeArr(arr, left, mid - 1, mid, right);
    }

    private void mergeArr(int[] arr, int left1, int right1, int left2, int right2) {
        int len = right2 - left1 + 1;
        int index = 0;
        int[] tmpArr = new int[len];
        int index1 = left1;
        int index2 = left2;
        while (index1 <= right1 || index2 <= right2) {
            if (index1 <= right1 && index2 <= right2) {
                if (arr[index1] <= arr[index2]) {
                    tmpArr[index] = arr[index1++];
                } else {
                    tmpArr[index] = arr[index2++];
                }
                index++;
            } else if (index1 <= right1) {
                while (index1 <= right1) {
                    tmpArr[index++] = arr[index1++];
                }
                break;
            } else {
                while (index2 <= right2) {
                    tmpArr[index++] = arr[index2++];
                }
                break;
            }
        }
        System.arraycopy(tmpArr, 0, arr, left1, len);
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();

        int[] arr = {8, 6, 2, 3,
                1, 5, 7};

        mergeSort.mergeSort(arr, 0, 7);

        System.out.println(Arrays.toString(arr));
    }

}
