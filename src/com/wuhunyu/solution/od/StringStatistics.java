package com.wuhunyu.solution.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 字符串统计（全量和占用字符集）
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-11 16:43
 */

public class StringStatistics {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int len = str.length();
        if (str.charAt(len - 1) == '@') {
            System.out.println(str);
            return;
        }

        List<Character> list = new ArrayList<>();
        int[] words = new int[128];

        boolean isAll = true;
        int index = 0;
        while (index < len) {
            char ch = str.charAt(index++);
            if (ch == ',') {
                continue;
            }
            if (ch == '@') {
                isAll = false;
                continue;
            }
            index++;
            int count = 0;
            while (index < len && str.charAt(index) != ',' && str.charAt(index) != '@') {
                count = count * 10 + str.charAt(index++) - '0';
            }
            if (isAll) {
                list.add(ch);
                words[ch] += count;
            } else {
                words[ch] -= count;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character ch : list) {
            if (words[ch] != 0) {
                sb.append(ch)
                        .append(':')
                        .append(words[ch])
                        .append(',');
            }
        }
        int sbLen = sb.length();
        if (sbLen == 0) {
            System.out.println();
            return;
        }
        sb.deleteCharAt(sbLen - 1);
        System.out.println(sb);
    }

}
