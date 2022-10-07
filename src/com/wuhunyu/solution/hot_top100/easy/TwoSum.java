package com.wuhunyu.solution.hot_top100.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-07 9:00
 */

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) {
                return new int[]{index, i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
