package com.wuhunyu.solution;

import java.util.Arrays;

/**
 * 973. 最接近原点的 K 个点
 *
 * @author gongzhiqiang
 * @date 2022/11/01 13:05
 **/

public class KClosest {

    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points,
            (arr1, arr2) -> (arr1[0] * arr1[0] + arr1[1] * arr1[1] - arr2[0] * arr2[0] - arr2[1] * arr2[1]));
        int[][] ans = new int[k][2];
        System.arraycopy(points, 0, ans, 0, k);
        return ans;
    }

}
