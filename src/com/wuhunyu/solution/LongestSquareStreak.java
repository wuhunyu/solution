package com.wuhunyu.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 6258. 数组中最长的方波
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/12/11 10:42
 */

public class LongestSquareStreak {

    public int longestSquareStreak(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>(length);
        for (int num : nums) {
            map.put(num, 1);
        }
        int maxLen = -1;
        for (int i = 1; i < length; i++) {
            int sqrt = (int) Math.sqrt(nums[i]);
            if (sqrt * sqrt != nums[i]) {
                continue;
            }
            Integer count = map.get(sqrt);
            if (count != null) {
                maxLen = Math.max(maxLen, ++count);
                map.put(nums[i], count);
            }
        }
        return maxLen;
    }

}
