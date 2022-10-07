package com.wuhunyu.solution.hot_top100.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 20. 有效的括号
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-07 9:01
 */

public class IsValid {

    public boolean isValid(String s) {
        int len = s.length();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                default:
                    stack.push(ch);
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();

        System.out.println(isValid.isValid("(])"));
        System.out.println(isValid.isValid("()"));
    }

}
