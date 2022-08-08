package com.wuhunyu.solution;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/8 14:34
 */

public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();

        System.out.println(findKthLargest.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

}
