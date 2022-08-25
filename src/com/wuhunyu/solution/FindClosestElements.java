package com.wuhunyu.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 658. 找到 K 个最接近的元素
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/8/25 13:40
 */

public class FindClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int len = arr.length;
        int right = this.binarySearch(arr, x);
        int left = right - 1;
        List<Integer> list = new ArrayList<>();
        int count = 0;
        while (count++ < k) {
            if (left >= 0 && right < len) {
                if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                    list.add(arr[left--]);
                } else {
                    list.add(arr[right++]);
                }
            } else if (left >= 0) {
                list.add(arr[left--]);
            } else {
                list.add(arr[right++]);
            }
        }
        list.sort((num1, num2) -> num1 - num2);
        return list;
    }

    public int binarySearch(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = ((right - left) >> 1) + left;
            if (arr[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        FindClosestElements findClosestElements = new FindClosestElements();

        System.out.println(findClosestElements.binarySearch(new int[]{1, 3, 5, 7, 9}, 0));  // 0
        System.out.println(findClosestElements.binarySearch(new int[]{1, 3, 5, 7, 9}, 1));  // 0
        System.out.println(findClosestElements.binarySearch(new int[]{1, 3, 5, 7, 9}, 2));  // 1
        System.out.println(findClosestElements.binarySearch(new int[]{1, 3, 5, 7, 9}, 3));  // 1
        System.out.println(findClosestElements.binarySearch(new int[]{1, 3, 5, 7, 9}, 4));  // 2
        System.out.println(findClosestElements.binarySearch(new int[]{1, 3, 5, 7, 9}, 5));  // 2
        System.out.println(findClosestElements.binarySearch(new int[]{1, 3, 5, 7, 9}, 6));  // 3
        System.out.println(findClosestElements.binarySearch(new int[]{1, 3, 5, 7, 9}, 6));  // 3
        System.out.println(findClosestElements.binarySearch(new int[]{1, 3, 5, 7, 9}, 7));  // 3
        System.out.println(findClosestElements.binarySearch(new int[]{1, 3, 5, 7, 9}, 8));  // 4
        System.out.println(findClosestElements.binarySearch(new int[]{1, 3, 5, 7, 9}, 9));  // 4
        System.out.println(findClosestElements.binarySearch(new int[]{1, 3, 5, 7, 9}, 10)); // 4
//        System.out.println(findClosestElements.binarySearch(new int[]{1, 3, 5, 7, 9}, 3));
//        System.out.println(findClosestElements.binarySearch(new int[]{1, 3, 5, 7, 9}, 7));
//        System.out.println(findClosestElements.binarySearch(new int[]{1, 3, 5, 7, 9}, 1));
//        System.out.println(findClosestElements.binarySearch(new int[]{1, 3, 5, 7, 9}, 9));
//        System.out.println(findClosestElements.binarySearch(new int[]{1, 3, 5, 7, 9}, 0));
//        System.out.println(findClosestElements.binarySearch(new int[]{1, 3, 5, 7, 9}, 10));
//        System.out.println(findClosestElements.binarySearch(new int[]{1, 3}, 2));

//        System.out.println(findClosestElements.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
//        System.out.println(findClosestElements.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1));
//        System.out.println(findClosestElements.findClosestElements(new int[]{1, 3}, 1, 2));
    }

}
