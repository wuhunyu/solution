package com.wuhunyu.solution.od;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * 最大嵌套括号深度
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-11 21:13
 */

public class KuohaoDepth {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        Deque<Character> stack = new ArrayDeque<>();
        int len = str.length();
        int index = 0;
        int maxDepth = 0;
        int curDepth = 0;
        boolean isEnd = false;
        while (index < len && !isEnd) {
            char ch = str.charAt(index++);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    maxDepth = Math.max(maxDepth, ++curDepth);
                    stack.push(ch);
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        isEnd = true;
                    } else {
                        curDepth--;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        isEnd = true;
                    } else {
                        curDepth--;
                    }
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        isEnd = true;
                    } else {
                        curDepth--;
                    }
                    break;
                default:
                    break;
            }
        }
        if (isEnd || !stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(maxDepth);
        }
    }

}
