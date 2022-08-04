package com.wuhunyu.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1403. 非递增顺序的最小子序列
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/4 12:04
 */

public class MinSubsequence {

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        List<Integer> list = new ArrayList<>();
        int cur = 0;
        int len = nums.length;
        for (int i = len - 1; i >= 0; i--) {
            cur += nums[i];
            list.add(nums[i]);
            if (cur >= (sum >> 1)) {
                break;
            }
        }
        return list;
    }

}
