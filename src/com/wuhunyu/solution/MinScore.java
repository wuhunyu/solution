package com.wuhunyu.solution;

import java.util.*;

/**
 * 6255. 两个城市间路径的最小分数
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/12/4 10:59
 */

public class MinScore {

    public int minScore(int n, int[][] roads) {
        Map<Integer, List<int[]>> map = new HashMap<>(n);
        for (int[] road : roads) {
            List<int[]> list1 = map.getOrDefault(road[0], new ArrayList<>());
            list1.add(new int[]{road[1], road[2]});
            map.put(road[0], list1);

            List<int[]> list2 = map.getOrDefault(road[1], new ArrayList<>());
            list2.add(new int[]{road[0], road[2]});
            map.put(road[1], list2);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            List<int[]> list = map.get(cur);
            for (int[] arr : list) {
                if (set.contains(arr[0])) {
                    continue;
                }
                queue.offer(arr[0]);
                min = Math.min(min, arr[1]);
            }
            set.add(cur);
        }
        return min;
    }

    public static void main(String[] args) {
        MinScore minScore = new MinScore();

        System.out.println(minScore.minScore(4, new int[][]{{1, 2, 9}, {2, 3, 6}, {2, 4, 5}, {1, 4, 7}}));
    }

}
