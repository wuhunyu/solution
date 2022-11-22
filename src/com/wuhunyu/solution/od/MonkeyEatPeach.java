package com.wuhunyu.solution.od;

import java.util.Scanner;

/**
 * 猴子吃桃
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-12 9:10
 */

public class MonkeyEatPeach {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strs = str.split(" ");
        int len = strs.length;
        int sumHour = Integer.parseInt(strs[len - 1]);
        int[] arr = new int[--len];
        int max = 0;
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(strs[i]);
            max = Math.max(max, arr[i]);
        }
        if (len > sumHour) {
            System.out.println(-1);
        }
        int left = len;
        int right = max;
        while (left < right) {
            int mid = ((right - left) >> 1) + left;
            int curHour = 0;
            for (int num : arr) {
                curHour += (num + mid - 1) / mid;
            }
            if (curHour > sumHour) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(left);
    }

}
