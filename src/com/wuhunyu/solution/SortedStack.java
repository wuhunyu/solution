package com.wuhunyu.solution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 面试题 03.05. 栈排序
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/8/20 16:13
 */

public class SortedStack {

    private final Deque<Integer> stack;

    private final Deque<Integer> tmpStack;

    public SortedStack() {
        stack = new ArrayDeque<>();
        tmpStack = new ArrayDeque<>();
    }

    public void push(int val) {
        while (!stack.isEmpty() && stack.peek() < val) {
            tmpStack.push(stack.pop());
        }
        stack.push(val);
        while (!tmpStack.isEmpty()) {
            stack.push(tmpStack.pop());
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int peek() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

}
