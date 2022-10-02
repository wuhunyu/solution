package com.wuhunyu.solution;

/**
 * 6193. 沙漏的最大总和
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-02 10:37
 */

public class MaxSum {

    public int maxSum(int[][] grid) {
        int rLen = grid.length;
        int cLen = grid[0].length;
        int[][] arr = {
                {0, 0},
                {0, 1},
                {0, 2},
                {1, 1},
                {2, 0},
                {2, 1},
                {2, 2}
        };
        int[][] sub = {
                {0, -1},
                {1, 0},
                {2, -1}
        };
        int[][] add = {
                {0, 2},
                {1, 1},
                {2, 2}
        };
        int sum = 0;
        for (int i = 0; i < rLen - 2; i++) {
            int curSum = 0;
            for (int[] a : arr) {
                curSum += grid[i + a[0]][a[1]];
            }
            sum = Math.max(sum, curSum);
            for (int j = 1; j < cLen - 2; j++) {
                for (int k = 0; k < 3; k++) {
                    curSum -= grid[i + sub[k][0]][j + sub[k][1]];
                    curSum += grid[i + add[k][0]][j + add[k][1]];
                }
                sum = Math.max(sum, curSum);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        MaxSum maxSum = new MaxSum();

        System.out.println(maxSum.maxSum(new int[][]{
                {6, 2, 1, 3}, {4, 2, 1, 5}, {9, 2, 8, 7}, {4, 1, 2, 9}
        }));
    }

}
