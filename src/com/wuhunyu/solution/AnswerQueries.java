package com.wuhunyu.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 6160. 和有限的最长子序列
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-08-28 10:45
 */

public class AnswerQueries {

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int len1 = nums.length;
        for (int i = 1; i < len1; i++) {
            nums[i] += nums[i - 1];
        }
        int len2 = queries.length;
        int[] arr = new int[len2];
        for (int i = 0; i < len2; i++) {
            int index = this.halfSearch(nums, queries[i]);
            arr[i] = (nums[index] <= queries[i] ? 1 : 0) + index;
        }
        return arr;
    }

    private int halfSearch(int[] nums, int search) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] >= search) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        AnswerQueries answerQueries = new AnswerQueries();

        System.out.println(answerQueries.halfSearch(new int[]{1, 3, 5, 7}, 0));
        System.out.println(answerQueries.halfSearch(new int[]{1, 3, 5, 7}, 1));
        System.out.println(answerQueries.halfSearch(new int[]{1, 3, 5, 7}, 2));
        System.out.println(answerQueries.halfSearch(new int[]{1, 3, 5, 7}, 3));
        System.out.println(answerQueries.halfSearch(new int[]{1, 3, 5, 7}, 4));
        System.out.println(answerQueries.halfSearch(new int[]{1, 3, 5, 7}, 5));
        System.out.println(answerQueries.halfSearch(new int[]{1, 3, 5, 7}, 6));
        System.out.println(answerQueries.halfSearch(new int[]{1, 3, 5, 7}, 7));
        System.out.println(answerQueries.halfSearch(new int[]{1, 3, 5, 7}, 8));
    }

}
