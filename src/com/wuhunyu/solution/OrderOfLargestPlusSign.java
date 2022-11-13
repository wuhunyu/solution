package com.wuhunyu.solution;

/**
 * 764. 最大加号标志
 *
 * @author gongzhiqiang
 * @date 2022/11/09 12:58
 **/

public class OrderOfLargestPlusSign {

    private final int[] rows = {-1, 0, 1, 0};

    private final int[] cols = {0, 1, 0, -1};

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] grip = new int[n][n];
        for (int[] mine : mines) {
            grip[mine[0]][mine[1]] = 1;
        }
        int ans = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                ans = Math.max(ans, this.bfs(grip, n, r, c));
            }
        }
        return ans;
    }

    private int bfs(int[][] grip, int n, int row, int col) {
        if (grip[row][col] == 1) {
            return 0;
        }
        int add = 1;
        while (true) {
            for (int i = 0; i < 4; i++) {
                int curRow = row + add * rows[i];
                int curCol = col + add * cols[i];
                if (curRow < 0 || curRow >= n || curCol < 0 || curCol >= n || grip[curRow][curCol] == 1) {
                    return add;
                }
            }
            add++;
        }
    }

    public static void main(String[] args) {
        OrderOfLargestPlusSign orderOfLargestPlusSign = new OrderOfLargestPlusSign();

        System.out.println(orderOfLargestPlusSign.orderOfLargestPlusSign(5, new int[][]{{4, 2}}));
    }

}
