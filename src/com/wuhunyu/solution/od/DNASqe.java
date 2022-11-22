package com.wuhunyu.solution.od;

import java.util.Scanner;

/**
 * DNA序列
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-11 21:46
 */

public class DNASqe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int n = scanner.nextInt();

        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch == 'C' || ch == 'G') {
                maxCount++;
            }
        }
        int index = 0;
        int curCount = maxCount;
        int limit = str.length() - n;
        for (int i = 1; i <= limit; i++) {
            char pre = str.charAt(i - 1);
            char now = str.charAt(i + n - 1);
            if (pre == 'C' || pre == 'G') {
                curCount--;
            }
            if (now == 'C' || now == 'G') {
                curCount++;
            }
            if (curCount > maxCount) {
                maxCount = curCount;
                index = i;
            }
        }
        System.out.println(str.substring(index, index + n));
    }

}
