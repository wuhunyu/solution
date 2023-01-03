package com.wuhunyu.solution.lcof;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 *
 * @author gongzhiqiang
 * @date 2023/01/03 21:06
 **/

public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if (length == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            if (deque.isEmpty() || deque.peekLast() >= nums[i]) {
                deque.offerLast(nums[i]);
            }
        }
        int[] ans = new int[length - k + 1];
        ans[0] = deque.peekFirst();
        for (int i = k; i < length; i++) {
            if (deque.peekFirst() == nums[i - k]) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            if (deque.isEmpty() || deque.peekLast() >= nums[i]) {
                deque.offerLast(nums[i]);
            }
            ans[i - k + 1] = deque.peekFirst();
        }
        return ans;
    }

}
