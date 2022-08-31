package com.wuhunyu.solution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 946. 验证栈序列
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-08-31 8:18
 */

public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = pushed.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0, j = 0; i < len; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                j++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidateStackSequences validateStackSequences = new ValidateStackSequences();

        System.out.println(validateStackSequences.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
    }

}
