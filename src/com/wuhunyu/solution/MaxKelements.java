package com.wuhunyu.solution;

import java.util.PriorityQueue;

/**
 * 6285. 执行 K 次操作后的最大分数
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2023-01-08 10:37
 */

public class MaxKelements {

    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((num1, num2) -> num2 - num1);
        for (int num : nums) {
            priorityQueue.offer(num);
        }
        long sum = 0L;
        for (int i = 0; i < k; i++) {
            int num = priorityQueue.poll().intValue();
            sum += num;
            priorityQueue.offer((num + 2) / 3);
        }
        return sum;
    }

}
