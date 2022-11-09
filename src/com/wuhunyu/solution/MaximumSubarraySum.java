package com.wuhunyu.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * 6230. 长度为 K 子数组中的最大和
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/11/6 10:44
 */

public class MaximumSubarraySum {

    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>(k);
        long maxSum = 0L;
        long curSum = 0L;

        int index = 0;
        while (index < k) {
            set.add(nums[index]);
            curSum += nums[index];
            index++;
        }
        if (set.size() == k) {
            maxSum = Math.max(maxSum, curSum);
        }

        int len = nums.length;
        while (index < len) {
            set.remove(nums[index - k]);
            set.add(nums[index - k + 1]);
            set.add(nums[index]);

            curSum -= nums[index - k];
            curSum += nums[index];

            if (set.size() == k) {
                maxSum = Math.max(maxSum, curSum);
            }
            index++;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubarraySum maximumSubarraySum = new MaximumSubarraySum();

        System.out.println(maximumSubarraySum.maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9}, 3));
        System.out.println(maximumSubarraySum.maximumSubarraySum(new int[]{4, 4, 4}, 3));
        System.out.println(maximumSubarraySum.maximumSubarraySum(new int[]{9, 9, 9, 1, 2, 3}, 3));
    }

}
