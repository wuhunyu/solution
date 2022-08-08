package com.wuhunyu.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 232. 用栈实现队列
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/8 14:41
 */

public class MyQueue {

    private final Queue<Integer> queue;

    public MyQueue() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        return queue.poll();
    }

    public int peek() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();

        myQueue.push(1);
        myQueue.push(2);

        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());

//        myQueue.push(1);
//        System.out.println(myQueue.pop());
//        System.out.println(myQueue.empty());
    }

}
