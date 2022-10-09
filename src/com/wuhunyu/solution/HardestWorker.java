package com.wuhunyu.solution;

/**
 * 6200. 处理用时最长的那个任务的员工
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-09 10:34
 */

public class HardestWorker {

    public int hardestWorker(int n, int[][] logs) {
        int len = logs.length;
        int score = logs[0][1];
        int id = logs[0][0];
        for (int i = 1; i < len; i++) {
            int sub = logs[i][1] - logs[i - 1][1];
            if (sub > score) {
                score = sub;
                id = logs[i][0];
            } else if (sub == score && id > logs[i][0]) {
                id = logs[i][0];
            }
        }
        return id;
    }

    public static void main(String[] args) {
        HardestWorker hardestWorker = new HardestWorker();

        System.out.println(hardestWorker.hardestWorker(10, new int[][]{{0, 3}, {2, 5}, {0, 9}, {1, 15}}));
    }

}
