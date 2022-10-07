package com.wuhunyu.solution.hot_top100.easy;

/**
 * 121. 买卖股票的最佳时机
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-07 10:04
 */

public class MaxProfit {

    public int maxProfit(int[] prices) {
        int ans = 0;
        int min = prices[0];
        int len = prices.length;
        for (int i = 1; i < len; i++) {
            if (min > prices[i]) {
                min = prices[i];
            } else {
                ans = Math.max(ans, prices[i] - min);
            }
        }
        return ans;
    }

}
