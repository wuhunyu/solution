package com.wuhunyu.solution;

import java.util.Arrays;

/**
 * 1620. 网络信号最好的坐标
 *
 * @author gongzhiqiang
 * @date 2022/11/02 13:08
 **/

public class BestCoordinate {

    public int[] bestCoordinate(int[][] towers, int radius) {
        int len = towers.length;
        int x = 0;
        int y = 0;
        int maxValue = 0;
        int doubleRadius = radius * radius;
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                int curValue = 0;
                for (int k = 0; k < len; k++) {
                    int distance = (i - towers[k][0]) * (i - towers[k][0]) + (j - towers[k][1]) * (j - towers[k][1]);
                    if (distance > doubleRadius) {
                        continue;
                    }
                    curValue += towers[k][2] / (1 + Math.sqrt(distance));
                }
                if (curValue > maxValue) {
                    maxValue = curValue;
                    x = i;
                    y = j;
                } else if (curValue == maxValue) {
                    if (x > i || (x == i && y > j)) {
                        x = i;
                        y = j;
                    }
                }
            }
        }
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        BestCoordinate bestCoordinate = new BestCoordinate();

        System.out.println(Arrays
                .toString(bestCoordinate.bestCoordinate(new int[][]{{0, 1, 2}, {2, 1, 2}, {1, 0, 2}, {1, 2, 2}}, 1)));
    }

}
