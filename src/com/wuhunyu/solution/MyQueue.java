package com.wuhunyu.solution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 232. 用栈实现队列
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/8 14:41
 */

public class MyQueue {

    private final Deque<Integer> inStack;

    private final Deque<Integer> outStack;

    public MyQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            this.in2Out();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            this.in2Out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2Out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
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
