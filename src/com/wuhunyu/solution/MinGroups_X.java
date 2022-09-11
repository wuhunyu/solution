package com.wuhunyu.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 6178. 将区间分为最少组数
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-11 10:54
 */

public class MinGroups_X {

    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (arr1, arr2) -> arr1[0] - arr2[0]);
        int count = 0;
        Set<Integer> set = new HashSet<>();
        int len = intervals.length;
        for (int i = 0; i < len; i++) {
            if (set.contains(i)) {
                continue;
            }
            set.add(i);
            count++;
            int j = i;
            int search = 0;
            while (j < len && (search = this.search(intervals, j, intervals[j][1])) != -1) {
                set.add(search);
                j = search;
            }
        }
        return count;
    }

    private int search(int[][] intervals, int left, int num) {
        int right = intervals.length - 1;
        while (left < right) {
            int mid = ((right - left) >> 1) + left;
            if (intervals[mid][0] <= num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return num < intervals[left][0] ? left : -1;
    }

    private int halfSearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = ((right - left) >> 1) + left;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        MinGroups_X minGroups = new MinGroups_X();

//        System.out.println(minGroups.minGroups(new int[][]{{5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}}));
//        System.out.println(minGroups.minGroups(new int[][]{{1, 3}, {5, 6}, {8, 10}, {11, 13}}));

        int[] arr = {1, 3, 5, 7, 9};
        System.out.println(minGroups.halfSearch(arr, 0));   // 0
        System.out.println(minGroups.halfSearch(arr, 1));   // 1
        System.out.println(minGroups.halfSearch(arr, 2));   // 1
        System.out.println(minGroups.halfSearch(arr, 3));   // 2
        System.out.println(minGroups.halfSearch(arr, 4));   // 2
        System.out.println(minGroups.halfSearch(arr, 5));   // 3
        System.out.println(minGroups.halfSearch(arr, 6));   // 3
        System.out.println(minGroups.halfSearch(arr, 7));   // 4
        System.out.println(minGroups.halfSearch(arr, 8));   // 4
        System.out.println(minGroups.halfSearch(arr, 9));   // 4
        System.out.println(minGroups.halfSearch(arr, 10));  // 4
    }

}
