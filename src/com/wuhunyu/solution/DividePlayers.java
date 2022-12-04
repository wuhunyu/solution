package com.wuhunyu.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 6254. 划分技能点相等的团队
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/12/4 10:39
 */

public class DividePlayers {

    public long dividePlayers(int[] skill) {
        long sum = 0L;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : skill) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            sum += num;
        }
        int len = skill.length;
        int half = len >> 1;
        if (sum % half != 0) {
            return -1;
        }
        int score = (int) (sum / half);
        long sumSkill = 0L;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            int another = score - num;
            if (count == 0) {
                continue;
            }
            if (num == another) {
                if ((count & 1) != 0) {
                    return -1;
                }
                sumSkill += (long) num * num * (count >> 1);
            } else {
                Integer anotherCount = map.getOrDefault(another, 0);
                if (!Objects.equals(count, anotherCount)) {
                    return -1;
                }
                sumSkill += (long) num * another * count;
                map.put(num, 0);
                map.put(another, 0);
            }
        }
        return sumSkill;
    }

    public static void main(String[] args) {
        DividePlayers dividePlayers = new DividePlayers();

        System.out.println(dividePlayers.dividePlayers(new int[]{3, 2, 5, 1, 3, 4}));
    }

}
