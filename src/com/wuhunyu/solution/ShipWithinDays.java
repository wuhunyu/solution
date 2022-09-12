package com.wuhunyu.solution;

/**
 * 1011. 在 D 天内送达包裹的能力
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-12 8:57
 */

public class ShipWithinDays {

    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
        }
        int low = 1;
        int high = sum;
        while (low <= high) {
            int mid = ((high - low) >> 1) + low;
            if (this.isEnabled(weights, days, mid)) {
                if (high == mid) {
                    return mid;
                }
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean isEnabled(int[] weights, int days, int todayWeight) {
        int count = 1;
        int loss = todayWeight;
        for (int weight : weights) {
            if (loss < weight) {
                if (++count > days) {
                    return false;
                }
                loss = todayWeight - weight;
                if (loss < 0) {
                    return false;
                }
            } else {
                loss -= weight;
            }
        }
        return true;
    }

}
