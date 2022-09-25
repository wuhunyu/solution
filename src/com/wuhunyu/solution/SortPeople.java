package com.wuhunyu.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 6188. 按身高排序
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-25 10:30
 */

public class SortPeople {

    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = heights.length;
        for (int i = 0; i < len; i++) {
            map.put(heights[i], i);
        }
        Arrays.sort(heights);
        String[] ans = new String[len];
        for (int i = len - 1; i >= 0; i--) {
            ans[len - i - 1] = names[map.get(heights[i])];
        }
        return ans;
    }

}
