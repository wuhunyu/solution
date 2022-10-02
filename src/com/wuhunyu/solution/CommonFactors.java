package com.wuhunyu.solution;

/**
 * 6192. 公因子的数目
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-02 10:31
 */

public class CommonFactors {

    public int commonFactors(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int count = 1;
        for (int i = 2; i <= min; i++) {
            if (min % i == 0 && max % i == 0) {
                count++;
            }
        }
        return count;
    }

}
