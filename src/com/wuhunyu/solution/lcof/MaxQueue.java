package com.wuhunyu.solution.lcof;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 面试题59 - II. 队列的最大值
 *
 * @author gongzhiqiang
 * @date 2023/01/03 12:54
 **/

public class MaxQueue {

    private final Queue<Integer> queue;

    private final Deque<Integer> deque;

    public MaxQueue() {
        queue = new ArrayDeque<>();
        deque = new ArrayDeque<>();
    }

    public int max_value() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.offerLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        if (queue.peek().intValue() == deque.peekFirst().intValue()) {
            deque.pollFirst();
        }
        return queue.poll();
    }

}
