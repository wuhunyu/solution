package com.wuhunyu.solution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1475. 商品折扣后的最终价格
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-01 7:10
 */

public class FinalPrices {

    public int[] finalPrices(int[] prices) {
        int len = prices.length;
        int[] res = new int[len];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!deque.isEmpty() && deque.peek() >= prices[i]) {
                deque.pop();
            }
            res[i] = prices[i] - (deque.isEmpty() ? 0 : deque.peek());
            deque.push(prices[i]);
        }
        return res;
    }

}
