package com.wuhunyu.solution.od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最多团队
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-11 22:56
 */

public class MostTeam {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.nextLine();
        int limit = scanner.nextInt();
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        int count = 0;
        while (right >= 0 && arr[right] >= limit) {
            count++;
            right--;
        }
        while (left < right) {
            while (left < right && arr[left] + arr[right] < limit) {
                left++;
            }
            if (left < right--) {
                count++;
            }
        }
        System.out.println(count);
    }

}
