package com.wuhunyu.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 交通枢纽
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-24 17:03
 */

public class TransportationHub {

    public int transportationHub(int[][] path) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] p : path) {
            Integer count = map.get(p[1]);
            map.put(p[0], -1);
            if (count != null) {
                if (count != -1) {
                    map.put(p[1], count + 1);
                }
            } else {
                map.put(p[1], 1);
            }
        }
        int target = map.size() - 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == target) {
                return entry.getKey();
            }
        }
        return -1;
    }

}
