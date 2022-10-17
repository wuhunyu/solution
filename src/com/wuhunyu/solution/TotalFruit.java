package com.wuhunyu.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 904. 水果成篮
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/10/17 8:15
 */

public class TotalFruit {

    public int totalFruit(int[] fruits) {
        int len = fruits.length;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while (right < len) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) {
                Integer curVal = map.get(fruits[left]);
                if (curVal == 1) {
                    map.remove(fruits[left]);
                } else {
                    map.put(fruits[left], curVal - 1);
                }
                left++;
            }
            max = Math.max(max, right++ - left + 1);
        }
        return max;
    }

}
