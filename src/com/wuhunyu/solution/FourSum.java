package com.wuhunyu.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 18. 四数之和
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/7/29 16:50
 */

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    for (int m = k + 1; m < len; m++) {
                        if (nums[i] + nums[j] + nums[k] + nums[m] == target) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[m]);
                            res.add(list);
                        }
                    }
                }
            }
        }
        return res;
    }

}
