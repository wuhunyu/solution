package com.wuhunyu.solution;

import java.util.PriorityQueue;

/**
 * 2335. 装满杯子需要的最短总时长
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2023-02-11 8:36
 */

public class FillCups {

    public int fillCups(int[] amount) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((num1, num2) -> num2 - num1);
        for (int num : amount) {
            priorityQueue.offer(num);
        }
        int count = 0;
        int[] arr = new int[2];
        while (!priorityQueue.isEmpty()) {
            if (priorityQueue.size() == 1) {
                count += priorityQueue.poll();
                break;
            }
            boolean valid = false;
            for (int i = 0; i < 2; i++) {
                arr[i] = priorityQueue.poll();
                valid |= arr[i] > 0;
            }
            if (valid) {
                count++;
            }
            for (int i = 0; i < 2; i++) {
                if (arr[i] > 0) {
                    priorityQueue.offer(arr[i] - 1);
                }
            }
        }
        return count;
    }

}
