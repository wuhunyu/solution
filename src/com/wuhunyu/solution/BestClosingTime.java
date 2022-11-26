package com.wuhunyu.solution;

/**
 * 6250. 商店的最少代价
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-11-26 22:44
 */

public class BestClosingTime {

    public int bestClosingTime(String customers) {
        int len = customers.length();
        int minValue = 0;
        for (int i = 0; i < len; i++) {
            minValue += customers.charAt(i) == 'Y' ? 1 : 0;
        }
        int minIndex = 0;
        int curValue = minValue;
        for (int i = 0; i < len; i++) {
            curValue += customers.charAt(i) == 'Y' ? -1 : 1;
            if (curValue < minValue) {
                minIndex = i + 1;
                minValue = curValue;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        BestClosingTime bestClosingTime = new BestClosingTime();

        System.out.println(bestClosingTime.bestClosingTime("YYNY"));
    }

}
