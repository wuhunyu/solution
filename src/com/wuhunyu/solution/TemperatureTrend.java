package com.wuhunyu.solution;

/**
 * 气温变化趋势
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-24 16:53
 */

public class TemperatureTrend {

    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int max = 0;
        int curCount = 0;
        int len = temperatureA.length;
        int index = 1;
        while (index < len) {
            int sub1 = temperatureA[index] - temperatureA[index - 1];
            int sub2 = temperatureB[index] - temperatureB[index - 1];
            if (sub1 > 0 && sub2 > 0 || sub1 == 0 && sub2 == 0 || sub1 < 0 && sub2 < 0) {
                max = Math.max(max, ++curCount);
            } else {
                curCount = 0;
            }
            index++;
        }
        return max;
    }

}
