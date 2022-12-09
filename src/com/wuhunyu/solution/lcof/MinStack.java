package com.wuhunyu.solution.lcof;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 30. 包含min函数的栈
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/12/9 22:02
 */

public class MinStack {

    private final Deque<int[]> stack;

    public MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new int[]{x, x});
            return;
        }
        stack.push(new int[]{x, Math.min(stack.peek()[1], x)});
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek()[0];
    }

    public int min() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek()[1];
    }

}
