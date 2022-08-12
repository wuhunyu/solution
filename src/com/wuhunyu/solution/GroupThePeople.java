package com.wuhunyu.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1282. 用户分组
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/12 8:33
 */

public class GroupThePeople {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int len = groupSizes.length;
        for (int i = 0; i < len; i++) {
            List<Integer> list = map.getOrDefault(groupSizes[i], new ArrayList<>());
            list.add(i);
            if (list.size() == groupSizes[i]) {
                res.add(list);
                map.remove(groupSizes[i]);
            } else {
                map.put(groupSizes[i], list);
            }
        }
        return res;
    }

}
