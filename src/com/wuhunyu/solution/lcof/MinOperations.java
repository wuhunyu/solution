package com.wuhunyu.solution.lcof;

/**
 * 1658. 将 x 减到 0 的最小操作数
 *
 * @author gongzhiqiang
 * @date 2023/01/07 08:00
 **/

public class MinOperations {

    public int minOperations(int[] nums, int x) {
        int length = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        sum -= x;
        int maxLength = -1;
        int left = 0;
        int right = 0;
        int curSum = 0;
        while (right < length) {
            curSum += nums[right++];
            while (left < right && curSum > sum) {
                curSum -= nums[left++];
            }
            if (curSum == sum) {
                maxLength = Math.max(maxLength, right - left);
            }
        }
        return maxLength == -1 ? -1 : length - maxLength;
    }

    public static void main(String[] args) {
        MinOperations minOperations = new MinOperations();
        System.out.println(minOperations.minOperations(new int[]{1, 1, 4, 2, 3}, 5));
        System.out.println(minOperations.minOperations(new int[]{5, 6, 7, 22, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 8, 9}, 4));
        System.out.println(minOperations.minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10));
        System.out.println(minOperations.minOperations(new int[]{8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231, 6309}, 134365));
        System.out.println(minOperations.minOperations(new int[]{5, 2, 3, 1, 1}, 5));
    }

}
