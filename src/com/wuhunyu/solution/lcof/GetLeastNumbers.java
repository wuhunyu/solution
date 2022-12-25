package com.wuhunyu.solution.lcof;

import java.util.PriorityQueue;

/**
 * 剑指 Offer 40. 最小的k个数
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/12/23 8:17
 */

public class GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        int length = arr.length;
        if (length == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((num1, num2) -> num2 - num1);
        for (int num : arr) {
            priorityQueue.offer(num);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = priorityQueue.poll();
        }
        return ans;
    }

}
