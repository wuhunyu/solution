package com.wuhunyu.solution;

/**
 * 6201. 找出前缀异或的原始数组
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-09 10:45
 */

public class FindArray {

    public int[] findArray(int[] pref) {
        int len = pref.length;
        int[] ans = new int[len];
        ans[0] = pref[0];
        for (int i = 1; i < len; i++) {
            ans[i] = pref[i - 1] ^ pref[i];
        }
        return ans;
    }

}
