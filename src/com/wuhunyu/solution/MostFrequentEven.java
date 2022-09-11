package com.wuhunyu.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 6176. 出现最频繁的偶数元素
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-11 10:31
 */

public class MostFrequentEven {

    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = -1;
        int maxCount = 0;
        for (int num : nums) {
            if ((num & 1) == 0) {
                Integer curCount = map.getOrDefault(num, 0);
                curCount++;
                map.put(num, curCount);
                if (curCount > maxCount) {
                    maxCount = curCount;
                    res = num;
                } else if (curCount == maxCount && res > num) {
                    res = num;
                }
            }
        }
        return res;
    }

}
