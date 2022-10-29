package com.wuhunyu.solution;

import java.util.List;
import java.util.Objects;

/**
 * 1773. 统计匹配检索规则的物品数量
 *
 * @author wuhunyu
 * @date 2022/10/29 07:57
 **/

public class CountMatches {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = Objects.equals(ruleKey, "type") ? 0 : (Objects.equals(ruleKey, "color") ? 1 : 2);
        int count = 0;
        for (List<String> item : items) {
            if (Objects.equals(ruleValue, item.get(index))) {
                count++;
            }
        }
        return count;
    }

}
