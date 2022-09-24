package com.wuhunyu.solution;

import java.util.Arrays;

/**
 * 1652. 拆炸弹
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-24 8:36
 */

public class Decrypt {

    public int[] decrypt(int[] codes, int k) {
        int len = codes.length;
        int[] ans = new int[len];
        if (k == 0) {
            return ans;
        } else if (k > 0) {
            int sum = 0;
            for (int i = 1; i <= k; i++) {
                sum += codes[i];
            }
            ans[0] = sum;
            int index = 1;
            while (index < len) {
                sum -= codes[index];
                sum += codes[(index + k) % len];
                ans[index++] = sum;
            }
            return ans;
        }
        int sum = 0;
        for (int i = len + k; i < len; i++) {
            sum += codes[i];
        }
        ans[0] = sum;
        int index = 1;
        while (index < len) {
            sum += codes[index - 1];
            sum -= codes[(index + len + k - 1) % len];
            ans[index++] = sum;
        }
        return ans;
    }

    public static void main(String[] args) {
        Decrypt decrypt = new Decrypt();

        System.out.println(Arrays.toString(decrypt.decrypt(new int[]{2, 4, 9, 3}, -2)));
    }

}
