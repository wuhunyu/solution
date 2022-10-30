package com.wuhunyu.solution;

/**
 * 6220. 可被三整除的偶数的平均值
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/10/30 10:33
 */

public class AverageValue {

    public int averageValue(int[] nums) {
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            if (num % 6 == 0) {
                sum += num;
                count++;
            }
        }
        return count == 0 ? 0 : sum / count;
    }

}
