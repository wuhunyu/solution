package com.wuhunyu.solution.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * VLAN资源池
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-11 15:37
 */

public class VLANResource {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String vLanPool = scanner.nextLine();
        int removeLan = scanner.nextInt();
        String[] vlanes = vLanPool.split(",");
        List<Integer> list = new ArrayList<>();
        for (String vlane : vlanes) {
            int[] arr = new int[2];
            int index = 0;
            int len = vlane.length();
            for (int i = 0; i < len; i++) {
                char ch = vlane.charAt(i);
                if (ch == '-') {
                    index++;
                    continue;
                }
                arr[index] = arr[index] * 10 + ch - '0';
            }
            if (index == 0) {
                list.add(arr[index]);
            } else {
                for (int i = arr[0]; i <= arr[1]; i++) {
                    list.add(i);
                }
            }
        }
        list.sort((num1, num2) -> num1 - num2);
        int size = list.size();
        int index = 0;
        while (index < size) {
            if (list.get(index) == removeLan) {
                list.remove(index);
                break;
            }
            index++;
        }
        StringBuilder sb = new StringBuilder();
        index = 0;
        size = list.size();
        while (index < size) {
            int preValue = list.get(index++);
            sb.append(preValue);
            int endValue = preValue;
            while (index < size && list.get(index) - endValue == 1) {
                endValue++;
                index++;
            }
            if (preValue != endValue) {
                sb.append('-')
                        .append(endValue);
            }
            sb.append(',');
        }
        int strLen = sb.length();
        if (strLen == 0) {
            System.out.println("");
            return;
        }
        sb.deleteCharAt(strLen - 1);
        System.out.println(sb.toString());
    }

}
