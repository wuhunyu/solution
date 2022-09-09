package com.wuhunyu.solution;

import java.util.*;

/**
 * 128. 最长连续序列
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-09 19:21
 */

public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxCount = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curCount = 1;
                int curNum = num + 1;
                while (set.contains(curNum)) {
                    curCount++;
                    curNum++;
                }
                maxCount = Math.max(maxCount, curCount);
            }
        }
        return maxCount;
    }

}
