package com.wuhunyu.solution;

/**
 * 1779. 找到最近的有相同 X 或 Y 坐标的点
 *
 * @author gongzhiqiang
 * @date 2022/12/01 14:03
 **/

public class NearestValidPoint {

    public int nearestValidPoint(int x, int y, int[][] points) {
        int rLen = points.length;
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < rLen; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                int cur = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                if (cur < min) {
                    index = i;
                    min = cur;
                }
            }
        }
        return index;
    }

}
