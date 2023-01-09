package com.wuhunyu.solution;

import java.util.PriorityQueue;

/**
 * 1801. 积压订单中的订单总数
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2023-01-02 9:09
 */

public class GetNumberOfBacklogOrders {

    private static final int MOD = ((int) Math.pow(10, 9)) + 7;

    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buyQueue = new PriorityQueue<>((arr1, arr2) -> arr2[0] - arr1[0]);
        PriorityQueue<int[]> saleQueue = new PriorityQueue<>((arr1, arr2) -> arr1[0] - arr2[0]);
        for (int[] order : orders) {
            if (order[2] == 0) {
                // 0 buy
                while (!saleQueue.isEmpty()) {
                    int[] arr = saleQueue.peek();
                    if (order[0] < arr[0]) {
                        break;
                    }
                    saleQueue.poll();
                    if (order[1] < arr[1]) {
                        arr[1] -= order[1];
                        order[1] = 0;
                        saleQueue.offer(arr);
                        break;
                    } else if (order[1] == arr[1]) {
                        order[1] = 0;
                        break;
                    }
                    order[1] -= arr[1];
                }
                if (order[1] > 0) {
                    buyQueue.offer(order);
                }
            } else {
                // 1 sale
                while (!buyQueue.isEmpty()) {
                    int[] arr = buyQueue.peek();
                    if (order[0] > arr[0]) {
                        break;
                    }
                    buyQueue.poll();
                    if (order[1] < arr[1]) {
                        arr[1] -= order[1];
                        order[1] = 0;
                        buyQueue.offer(arr);
                        break;
                    } else if (order[1] == arr[1]) {
                        order[1] = 0;
                        break;
                    }
                    order[1] -= arr[1];
                }
                if (order[1] > 0) {
                    saleQueue.offer(order);
                }
            }
        }
        int count = 0;
        while (!buyQueue.isEmpty()) {
            count = (buyQueue.poll()[1] + count) % MOD;
        }
        while (!saleQueue.isEmpty()) {
            count = (saleQueue.poll()[1] + count) % MOD;
        }
        return count;
    }

    private void handle(PriorityQueue<int[]> queue, int[] order) {
        while (!queue.isEmpty()) {
            int[] arr = queue.peek();
            if (order[0] > arr[0]) {
                break;
            }
            queue.poll();
            if (order[1] < arr[1]) {
                arr[1] -= order[1];
                order[1] = 0;
                queue.offer(arr);
                break;
            } else if (order[1] == arr[1]) {
                order[1] = 0;
                break;
            }
            order[1] -= arr[1];
        }
    }

    public static void main(String[] args) {
        GetNumberOfBacklogOrders getNumberOfBacklogOrders = new GetNumberOfBacklogOrders();

        System.out.println(getNumberOfBacklogOrders.getNumberOfBacklogOrders(new int[][]{
                {16, 24, 0}, {16, 2, 1}, {23, 28, 1}, {21, 6, 0}, {17, 8, 0}, {25, 7, 0}
        }));
    }

}
