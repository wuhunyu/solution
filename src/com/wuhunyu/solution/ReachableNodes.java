package com.wuhunyu.solution;

import java.util.*;

/**
 * 6139. 受限条件下可到达节点的数目
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/8/7 10:54
 */

public class ReachableNodes {

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int num : restricted) {
            set.add(num);
        }
        for (int[] edge : edges) {
            if (set.contains(edge[0]) || set.contains(edge[1])) {
                continue;
            }
            List<Integer> list1 = map.getOrDefault(edge[0], new ArrayList<>());
            list1.add(edge[1]);
            map.put(edge[0], list1);

            List<Integer> list2 = map.getOrDefault(edge[1], new ArrayList<>());
            list2.add(edge[0]);
            map.put(edge[1], list2);
        }
        int count = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            Integer num = queue.poll();
            set.add(num);
            List<Integer> list = map.get(num);
            if (list == null) {
                continue;
            }
            for (Integer el : list) {
                if (set.contains(el)) {
                    continue;
                }
                count++;
                queue.offer(el);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ReachableNodes reachableNodes = new ReachableNodes();

        System.out.println(reachableNodes.reachableNodes(7, new int[][]{
                {0, 1}, {1, 2}, {3, 1}, {4, 0}, {0, 5}, {5, 6}
        }, new int[]{
                4, 5
        }));
    }

}
