package com.wuhunyu.solution.lcof;

import java.util.Arrays;

/**
 * 面试题61. 扑克牌中的顺子
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/12/22 13:46
 */

public class IsStraight {

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int pre = -1;
        int count = 0;
        for (int num : nums) {
            if (num == 0) {
                count++;
                continue;
            }
            if (pre == -1) {
                pre = num;
                continue;
            }
            int sub = num - pre - 1;
            if (sub > 0 && count < sub) {
                return false;
            }
            pre = num;
            count -= sub;
        }
        return true;
    }

    public static void main(String[] args) {
        IsStraight isStraight = new IsStraight();
        System.out.println(isStraight.isStraight(new int[]{1, 2, 3, 4, 5}));
    }

}
