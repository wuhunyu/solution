package com.wuhunyu.solution;

/**
 * 33. 搜索旋转排序数组
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/8/19 8:43
 */

public class RotationSearch {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] == target) {
                return mid;
            }
            // 右侧有序
            if (nums[mid] < nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // 左侧有序
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RotationSearch rotationSearch = new RotationSearch();

        System.out.println(rotationSearch.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(rotationSearch.search(new int[]{3, 5, 1}, 3));
        System.out.println(rotationSearch.search(new int[]{5, 1, 3}, 5));
    }

}
