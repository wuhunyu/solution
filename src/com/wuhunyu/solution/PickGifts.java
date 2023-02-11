package com.wuhunyu.solution;

import java.util.PriorityQueue;

/**
 * 6348. 从数量最多的堆取走礼物
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2023-02-05 10:32
 */

public class PickGifts {

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((num1, num2) -> num2 - num1);
        for (int gift : gifts) {
            priorityQueue.offer(gift);
        }
        for (int i = 0; i < k; i++) {
            priorityQueue.offer((int) Math.sqrt(priorityQueue.poll()));
        }
        long sum = 0;
        for (Integer num : priorityQueue) {
            sum += num;
        }
        return sum;
    }

}
