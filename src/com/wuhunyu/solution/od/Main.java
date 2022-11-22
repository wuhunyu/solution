package com.wuhunyu.solution.od;

import java.util.*;

/**
 * 主程序
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-12 16:18
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int size = scanner.nextInt();
        scanner.nextLine();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();
            List<Integer> list1 = map.getOrDefault(node1, new ArrayList<>());
            list1.add(node2);
            map.put(node1, list1);

            List<Integer> list2 = map.getOrDefault(node2, new ArrayList<>());
            list2.add(node1);
            map.put(node2, list2);
            scanner.nextLine();
        }
        int startNode = scanner.nextInt();
        Set<Integer> set = new HashSet<>();
        set.add(startNode);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(startNode);
        int depth = 0;
        while (set.size() < n) {
            int qSize = queue.size();
            depth++;
            while (qSize-- > 0) {
                Integer curNode = queue.poll();
                List<Integer> list = map.get(curNode);
                for (Integer num : list) {
                    if (!set.contains(num)) {
                        queue.offer(num);
                        set.add(num);
                    }
                }
            }
        }
        System.out.println(depth << 1);
    }

}
