package com.wuhunyu.solution.hot_top100.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-07 16:09
 */

public class FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        for (int num : nums) {
            nums[(num - 1) % len] += len;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] <= len) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindDisappearedNumbers findDisappearedNumbers = new FindDisappearedNumbers();

        System.out.println(findDisappearedNumbers.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

}
