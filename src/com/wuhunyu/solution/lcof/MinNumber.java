package com.wuhunyu.solution.lcof;

import java.util.Arrays;

/**
 * 面试题45. 把数组排成最小的数
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/12/22 11:03
 */

public class MinNumber {

    public String minNumber(int[] nums) {
        int length = nums.length;
        String[] strs = new String[length];
        for (int i = 0; i < length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (str1, str2) -> (str1 + str2).compareTo(str2 + str1));
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MinNumber minNumber = new MinNumber();

//        System.out.println(minNumber.minNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(minNumber.minNumber(new int[]{12, 121}));
        System.out.println(minNumber.minNumber(new int[]{121, 12}));
    }

}
