package com.wuhunyu.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * 6171. 和相等的子数组
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-03 22:31
 */

public class FindSubarrays {

    public boolean findSubarrays(int[] nums) {
        int len = nums.length;
        Set<Long> set = new HashSet<>();
        for (int i = 1; i < len; i++) {
            long sum = (long) nums[i] + nums[i - 1];
            if (set.contains(sum)) {
                return true;
            }
            set.add(sum);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println((long) Integer.MAX_VALUE + Integer.MAX_VALUE);
    }

}
