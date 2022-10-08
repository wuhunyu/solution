package com.wuhunyu.solution;

import java.util.Arrays;

/**
 * 870. 优势洗牌
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-08 8:23
 */

public class AdvantageCount {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        int len = nums2.length;
        Integer[] idx = new Integer[len];
        for (int i = 0; i < len; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (i, j) -> nums2[i] - nums2[j]);
        int left = 0;
        int right = len - 1;
        int[] ans = new int[len];
        for (int num : nums1) {
            ans[nums2[idx[left]] < num ? idx[left++] : idx[right--]] = num;
        }
        return ans;
    }

}
