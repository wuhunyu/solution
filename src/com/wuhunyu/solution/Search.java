package com.wuhunyu.solution;

/**
 * 704. 二分查找
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/7/18 12:13
 */

public class Search {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
