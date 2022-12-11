package com.wuhunyu.solution;

import java.util.Arrays;

/**
 * 6257. 删除每行中的最大值
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/12/11 10:35
 */

public class DeleteGreatestValue {

    public int deleteGreatestValue(int[][] grid) {
        int rLen = grid.length;
        int cLen = grid[0].length;
        for (int[] arr : grid) {
            Arrays.sort(arr);
        }
        int ans = 0;
        for (int c = 0; c < cLen; c++) {
            int max = 0;
            for (int r = 0; r < rLen; r++) {
                max = Math.max(grid[r][c], max);
            }
            ans += max;
        }
        return ans;
    }

}
