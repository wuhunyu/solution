package com.wuhunyu.solution;

/**
 * 6168. 恰好移动 k 步到达某一位置的方法数目
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-04 10:48
 */

public class NumberOfWays {

    private int res;

    public int numberOfWays(int startPos, int endPos, int k) {
        this.dfs(startPos, endPos, 0, k);
        return res;
    }

    private void dfs(int curPos, int endPos, int count, int k) {
        if (Math.abs(curPos - endPos) > k - count) {
            System.out.println(curPos);
            return;
        }
        if (count == k) {
            if (curPos == endPos) {
                res++;
            }
            return;
        }
        this.dfs(curPos + 1, endPos, count + 1, k);
        this.dfs(curPos - 1, endPos, count + 1, k);
    }

    public static void main(String[] args) {
        NumberOfWays numberOfWays = new NumberOfWays();

//        System.out.println(numberOfWays.numberOfWays(1, 1000, 999));
        System.out.println(numberOfWays.numberOfWays(989, 1000, 99));
    }

}
