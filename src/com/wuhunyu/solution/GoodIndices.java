package com.wuhunyu.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 6190. 找到所有好下标
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-25 10:57
 */

public class GoodIndices {

    public List<Integer> goodIndices(int[] nums, int k) {
        int len = nums.length;
        List<Integer> ans = new ArrayList<>();
        if (len <= (k << 1)) {
            return ans;
        }
        boolean pre = false;
        for (int i = k; i < len - k; i++) {
            if (pre && nums[i] == nums[i - 1] && nums[i + k - 1] <= nums[i + k]) {
                ans.add(i);
                continue;
            }
            if (this.isGoodIndex(nums, i, k)) {
                pre = true;
                ans.add(i);
            } else {
                pre = false;
            }
        }
        return ans;
    }

    private boolean isGoodIndex(int[] nums, int index, int k) {
        for (int i = index - k + 1; i < index; i++) {
            if (nums[i] > nums[i - 1]) {
                return false;
            }
        }
        for (int i = index + 2; i <= index + k; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

}
