package com.wuhunyu.solution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 496. 下一个更大元素 I
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/11/8 20:39
 */

public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len = nums2.length;
        Map<Integer, Integer> map = new HashMap<>(len);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        len = nums1.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }

}
