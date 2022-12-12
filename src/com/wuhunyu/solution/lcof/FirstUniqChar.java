package com.wuhunyu.solution.lcof;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/12/12 22:57
 */

public class FirstUniqChar {

    public char firstUniqChar(String s) {
        Map<Integer, Integer> map = new HashMap<>(26);
        Queue<int[]> queue = new ArrayDeque<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int index = s.charAt(i) - 'a';
            if (map.containsKey(index)) {
                map.put(index, -1);
                while (!queue.isEmpty() && map.get(queue.peek()[0]) == -1) {
                    queue.poll();
                }
            } else {
                map.put(index, 1);
                queue.offer(new int[]{index, i});
            }
        }
        return queue.isEmpty() ? ' ' : s.charAt(queue.peek()[1]);
    }

}
