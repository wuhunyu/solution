package com.wuhunyu.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * 6205. 反转之后不同整数的数目
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/10/16 10:41
 */

public class CountDistinctIntegers {

    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            int newNum = 0;
            while (num != 0) {
                newNum = newNum * 10 + num % 10;
                num /= 10;
            }
            set.add(newNum);
        }
        return set.size();
    }

}
