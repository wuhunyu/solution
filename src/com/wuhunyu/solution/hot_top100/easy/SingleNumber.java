package com.wuhunyu.solution.hot_top100.easy;

/**
 * 136. 只出现一次的数字
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-07 10:04
 */

public class SingleNumber {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

}
