package com.wuhunyu.solution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 901. 股票价格跨度
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/10/21 8:24
 */

public class StockSpanner {

    private final Deque<int[]> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int count = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            count += stack.pop()[1];
        }
        stack.push(new int[]{price, count});
        return count;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();

        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }

}
