package com.wuhunyu.solution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 6161. 从字符串中移除星号
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-08-28 10:59
 */

public class RemoveStars {

    public String removeStars(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.poll());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        RemoveStars removeStars = new RemoveStars();

        System.out.println(removeStars.removeStars("leet**cod*e"));
    }

}
