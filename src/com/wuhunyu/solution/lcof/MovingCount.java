package com.wuhunyu.solution.lcof;

/**
 * 面试题13. 机器人的运动范围
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/12/21 11:22
 */

public class MovingCount {

    public int movingCount(int m, int n, int k) {
        int[][] arr = new int[m][n];
        arr[0][0] = 1;
        int[][] score = new int[m][n];
        score[0][0] = 1;
        int count = 1;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                score[r][c] = this.calSum(r) + this.calSum(c);
                boolean movable = false;
                if (r > 0 || c > 0) {
                    int sum = score[r][c];
                    if (sum > k) {
                        continue;
                    }
                    if (r > 0) {
                        movable = arr[r - 1][c] == 1;
                    }
                    if (c > 0) {
                        movable |= arr[r][c - 1] == 1;
                    }
                }
                if (movable) {
                    count++;
                    arr[r][c] = 1;
                }
            }
        }
        return count;
    }

    private int calSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        MovingCount movingCount = new MovingCount();

        System.out.println(movingCount.movingCount(2, 3, 1));
    }

}
