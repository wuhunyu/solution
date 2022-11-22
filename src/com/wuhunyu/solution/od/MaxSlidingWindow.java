package com.wuhunyu.solution.od;

import java.util.Scanner;

/**
 * 滑动窗口最大值
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-11 21:03
 */

public class MaxSlidingWindow {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.nextLine();
        int size = scanner.nextInt();

        int maxSum = 0;
        for (int i = 0; i < size; i++) {
            maxSum += arr[i];
        }
        int curSum = maxSum;
        for (int i = size; i < n; i++) {
            curSum -= arr[i - size];
            curSum += arr[i];
            maxSum = Math.max(maxSum, curSum);
        }
        System.out.println(maxSum);
    }

}
