package com.wuhunyu.solution.od;

import java.util.Scanner;

/**
 * 拼接URL
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-11 18:14
 */

public class URLPre {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        String[] strs = str.split(",");
        int strLen = strs.length;
        if (strLen == 0) {
            System.out.println("/");
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (strs[0] == null || strs[0].length() == 0) {
            sb.append("/");
        } else {
            sb.append(strs[0]);
            if (strs[0].charAt(strs[0].length() - 1) != '/') {
                sb.append("/");
            }
        }
        if (strs.length > 1 && strs[1] != null && strs[1].length() > 0) {
            if (strs[1].charAt(0) == '/') {
                sb.append(strs[1].substring(1));
            } else {
                sb.append(strs[1]);
            }
        }
        System.out.println(sb);
    }

}
