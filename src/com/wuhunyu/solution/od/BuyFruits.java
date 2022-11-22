package com.wuhunyu.solution.od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 购买水果
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-12 10:54
 */

public class BuyFruits {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = scanner.nextInt();
        scanner.nextLine();
        int n = scanner.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = scanner.nextInt();
            }
            scanner.nextLine();
        }

        Arrays.sort(arr, (arr1, arr2) -> arr1[2] - arr2[2]);
        int sum = 0;
        for (int i = 1; i <= hour; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[j][0] <= i && arr[j][1] >= i) {
                    sum += arr[j][2];
                    break;
                }
            }
        }
        System.out.println(sum);
    }

}
