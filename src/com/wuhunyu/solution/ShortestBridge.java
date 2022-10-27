package com.wuhunyu.solution;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 934. 最短的桥
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/10/25 7:55
 */

public class ShortestBridge {

    public int shortestBridge(int[][] grid) {
        int rLen = grid.length;
        int cLen = grid[0].length;
        int r = 0;
        int c = 0;
        boolean isContinue = true;
        for (; r < rLen; r++) {
            c = 0;
            for (; c < cLen; c++) {
                if (grid[r][c] == 1) {
                    isContinue = false;
                    break;
                }
            }
            if (!isContinue) {
                break;
            }
        }
        int[] rows = {-1, 0, 1, 0};
        int[] cols = {0, 1, 0, -1};
        Queue<int[]> queue = new ArrayDeque<>();
        this.dye(grid, rows, cols, r, c, queue);
        return this.bfs(grid, rows, cols, queue);
    }

    private void dye(int[][] grid, int[] rows, int[] cols, int row, int col, Queue<int[]> queue) {
        int rLen = grid.length;
        int cLen = grid[0].length;
        Queue<int[]> curQueue = new ArrayDeque<>();
        curQueue.offer(new int[] {row, col});
        while (!curQueue.isEmpty()) {
            int[] arr = curQueue.poll();
            grid[arr[0]][arr[1]] = -1;
            for (int i = 0; i < 4; i++) {
                int newRow = arr[0] + rows[i];
                int newCol = arr[1] + cols[i];
                if (newRow >= 0 && newRow < rLen && newCol >= 0 && newCol < cLen) {
                    if (grid[newRow][newCol] == 0) {
                        grid[newRow][newCol] = -1;
                        queue.offer(new int[] {newRow, newCol});
                    } else if (grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = -1;
                        curQueue.offer(new int[] {newRow, newCol});
                    }
                }
            }
        }
    }

    private int bfs(int[][] grid, int[] rows, int[] cols, Queue<int[]> queue) {
        int rLen = grid.length;
        int cLen = grid[0].length;
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            while (size-- > 0) {
                int[] arr = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int newRow = arr[0] + rows[i];
                    int newCol = arr[1] + cols[i];
                    if (newRow >= 0 && newRow < rLen && newCol >= 0 && newCol < cLen) {
                        if (grid[newRow][newCol] == 0) {
                            grid[newRow][newCol] = -1;
                            queue.offer(new int[] {newRow, newCol});
                        } else if (grid[newRow][newCol] == 1) {
                            return depth;
                        }
                    }
                }
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        ShortestBridge shortestBridge = new ShortestBridge();

        System.out.println(shortestBridge.shortestBridge(new int[][] {{0, 1}, {1, 0}}));
        System.out.println(shortestBridge.shortestBridge(new int[][] {{0, 1, 0}, {0, 0, 0}, {0, 0, 1}}));
        System.out.println(shortestBridge.shortestBridge(new int[][] {{0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 0}, {0, 0, 1, 1, 0, 0, 1, 1}, {0, 0, 0, 1, 1, 0, 0, 1},
            {0, 0, 1, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}}));
        System.out.println(shortestBridge.shortestBridge(new int[][] {{0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 0}, {0, 0, 1, 1, 0, 0, 1, 1}, {0, 0, 0, 1, 1, 0, 0, 1},
            {0, 0, 1, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}}));

    }

}
