package com.wuhunyu.solution.od;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * 报文解压缩
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-11 20:18
 */

public class BaoWenJieYaSuo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        Deque<StringBuilder> strStack = new ArrayDeque<>();
        Deque<Integer> countStack = new ArrayDeque<>();

        int index = 0;
        int count = 0;
        int len = str.length();
        while (index < len) {
            char ch = str.charAt(index++);
            if (ch == '[') {
                countStack.push(count);
                strStack.push(new StringBuilder());
                count = 0;
            } else if (ch == ']') {
                int curCount = countStack.pop().intValue();
                StringBuilder curSb = new StringBuilder();
                StringBuilder repeat = strStack.pop();
                for (int i = 0; i < curCount; i++) {
                    curSb.append(repeat);
                }
                strStack.push((strStack.isEmpty() ? new StringBuilder() : strStack.pop()).append(curSb));
            } else if (ch >= '0' && ch <= '9') {
                count = count * 10 + ch - '0';
            } else {
                strStack.peek().append(ch);
            }
        }
        System.out.println(strStack.isEmpty() ? "" : strStack.peek());
    }

}
