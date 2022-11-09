package com.wuhunyu.solution;

import java.util.PriorityQueue;

/**
 * 6231. 雇佣 K 位工人的总代价
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/11/6 11:06
 */

public class TotalCost {

    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> left = new PriorityQueue<>((num1, num2) -> num1 - num2);
        PriorityQueue<Integer> right = new PriorityQueue<>((num1, num2) -> num1 - num2);
        int len = costs.length;
        int leftIndex = 0;
        while (leftIndex < candidates) {
            left.offer(costs[leftIndex++]);
        }
        int rightIndex = len - 1;
        int count = candidates;
        while (rightIndex >= leftIndex && count-- > 0) {
            right.offer(costs[rightIndex--]);
        }
        long sum = 0L;
        count = 0;
        while (count++ < k) {
            if (right.isEmpty() || !left.isEmpty() && left.peek() <= right.peek()) {
                sum += left.poll();
                if (leftIndex <= rightIndex) {
                    left.offer(costs[leftIndex++]);
                }
            } else {
                sum += right.poll();
                if (leftIndex <= rightIndex) {
                    right.offer(costs[rightIndex--]);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TotalCost totalCost = new TotalCost();

        System.out.println(totalCost.totalCost(new int[]{17, 12, 10, 2, 7, 2, 11, 20, 8}, 3, 4));
        System.out.println(totalCost.totalCost(new int[]{57, 33, 26, 76, 14, 67, 24, 90, 72, 37, 30}, 11, 2));
    }

}
