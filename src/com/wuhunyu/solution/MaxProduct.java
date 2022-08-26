package com.wuhunyu.solution;

/**
 * 1464. 数组中两元素的最大乘积
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/8/26 8:41
 */

public class MaxProduct {

    public int maxProduct(int[] nums) {
        int len = nums.length;
        int index = 0;
        int max = 0;
        int secondMax = 0;
        while (index < len) {
            if (nums[index] >= max) {
                secondMax = max;
                max = nums[index];
            } else if (nums[index] > secondMax) {
                secondMax = nums[index];
            }
            index++;
        }
        return (max - 1) * (secondMax - 1);
    }

    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();

        System.out.println(maxProduct.maxProduct(new int[]{10, 2, 5, 2}));
    }

}
