package com.wuhunyu.solution;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 6178. 将区间分为最少组数
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-11 10:54
 */

public class MinGroups {

    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (arr1, arr2) -> arr1[0] != arr2[0] ? arr1[0] - arr2[0] : arr1[1] - arr2[1]);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((num1, num2) -> num1 - num2);
        int len = intervals.length;
        priorityQueue.offer(intervals[0][1]);
        for (int i = 1; i < len; i++) {
            int[] interval = intervals[i];
            if (interval[0] > priorityQueue.peek()) {
                priorityQueue.poll();
            }
            priorityQueue.offer(interval[1]);
        }
        return priorityQueue.size();
    }

    public static void main(String[] args) {
        MinGroups minGroups = new MinGroups();

        System.out.println(minGroups.minGroups(new int[][]{{5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}}));
        System.out.println(minGroups.minGroups(new int[][]{{1, 3}, {5, 6}, {8, 10}, {11, 13}}));
    }

}
