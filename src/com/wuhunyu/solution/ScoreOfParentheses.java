package com.wuhunyu.solution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 856. 括号的分数
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-09 8:27
 */

public class ScoreOfParentheses {

    public int scoreOfParentheses(String s) {
        int len = s.length();
        Deque<Integer> stack = new ArrayDeque<>();
        // ( <=> 0
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                stack.push(0);
            } else {
                int num;
                if (stack.peek() == 0) {
                    stack.pop();
                    num = 1;
                } else {
                    num = stack.pop() << 1;
                    stack.pop();
                }
                while (!stack.isEmpty() && stack.peek() != 0) {
                    num += stack.pop();
                }
                stack.push(num);
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        ScoreOfParentheses scoreOfParentheses = new ScoreOfParentheses();

        System.out.println(scoreOfParentheses.scoreOfParentheses("(()(()))"));
    }

}
