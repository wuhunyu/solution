package com.wuhunyu.solution;

/**
 * 33. 搜索旋转排序数组
 *
 * @author gongzhiqiang
 * @date 2022/11/16 14:14
 **/

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[mid] >= nums[left]) {
                    // 左侧有序
                    if (nums[left] <= target && nums[mid] > target) {
                        // 结果在此处
                        right = mid - 1;
                    } else {
                        // 结果在右侧
                        left = mid + 1;
                    }
                } else {
                    // 右侧有序
                    if (nums[right] >= target && nums[mid] < target) {
                        // 结果在此处
                        left = mid + 1;
                    } else {
                        // 结果在左侧
                        right = mid - 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();

//        System.out.println(searchInRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4));
//        System.out.println(searchInRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
//        System.out.println(searchInRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6));
//        System.out.println(searchInRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 7));
//        System.out.println(searchInRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
//        System.out.println(searchInRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1));
//        System.out.println(searchInRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2));
//        System.out.println(searchInRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
//        System.out.println(searchInRotatedSortedArray.search(new int[]{1, 3, 5}, 2));
//        System.out.println(searchInRotatedSortedArray.search(new int[]{5, 1, 3}, 1));
        System.out.println(searchInRotatedSortedArray.search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8));
    }

}
