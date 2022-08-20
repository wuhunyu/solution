package com.wuhunyu.solution;

import java.util.PriorityQueue;

/**
 * 面试题 03.05. 栈排序
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/8/20 16:13
 */

public class SortedStack {

    private final PriorityQueue<Integer> priorityQueue;

    public SortedStack() {
        priorityQueue = new PriorityQueue<>((num1, num2) -> num1 - num2);
    }

    public void push(int val) {
        priorityQueue.offer(val);
    }

    public void pop() {
        priorityQueue.poll();
    }

    public int peek() {
        if (priorityQueue.isEmpty()) {
            return -1;
        }
        return priorityQueue.peek();
    }

    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

}
