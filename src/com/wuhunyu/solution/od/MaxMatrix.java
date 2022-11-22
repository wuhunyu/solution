package com.wuhunyu.solution.od;

import java.util.Scanner;

/**
 * 矩阵最大值
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-11 19:32
 */

public class MaxMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] matrix = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                matrix[j] = line.charAt(j << 1) - '0';
            }
            sum += maxMatrixLine(matrix, n);
        }
        System.out.println(sum);
    }

    private static int maxMatrixLine(int[] matrix, int n) {
        int maxNum = 0;
        for (int i = 0; i < n; i++) {
            int num = 0;
            if (matrix[i] == 1) {
                for (int j = i; j < n; j++) {
                    num <<= 1;
                    num |= matrix[j];
                }
                for (int j = 0; j < i; j++) {
                    num <<= 1;
                    num |= matrix[j];
                }
            }
            maxNum = Math.max(maxNum, num);
        }
        return maxNum;
    }
}
