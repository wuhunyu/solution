package com.wuhunyu.solution;

import java.util.Arrays;

/**
 * 1385. 两个数组间的距离值
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-11 22:11
 */

public class FindTheDistanceValue {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for (int num : arr1) {
            int mid = this.halfSearch(arr2, num);
            if (mid > 0 && Math.abs(arr2[mid - 1] - num) <= d || Math.abs(arr2[mid] - num) <= d) {
                continue;
            }
            count++;
        }
        return count;
    }

    private int halfSearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
