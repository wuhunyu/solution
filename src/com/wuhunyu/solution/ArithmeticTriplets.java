package com.wuhunyu.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * 6136. 算术三元组的数目
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/8/7 10:32
 */

public class ArithmeticTriplets {

    public int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int doubleDiff = diff << 1;
        for (int num : nums) {
            if (set.contains(num + diff) && set.contains(num + doubleDiff)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ArithmeticTriplets arithmeticTriplets = new ArithmeticTriplets();

        System.out.println(arithmeticTriplets.arithmeticTriplets(new int[]{0, 1, 4, 6, 7, 10}, 3));
    }

}
