package com.wuhunyu.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 1460. 通过翻转子数组使两个数组相等
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/8/24 8:35
 */

public class CanBeEqual {

    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>(target.length);
        for (int num : target) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : arr) {
            Integer val = map.get(num);
            if (val == null || val == 0) {
                return false;
            }
            map.put(num, val - 1);
        }
        return true;
    }

}
