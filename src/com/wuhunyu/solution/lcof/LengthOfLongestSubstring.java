package com.wuhunyu.solution.lcof;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/12/17 14:45
 */

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        Set<Character> set = new HashSet<>();
        Queue<Character> queue = new ArrayDeque<>();
        int max = 0;
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                while (queue.peek() != ch) {
                    set.remove(queue.poll());
                }
                queue.poll();
            }
            set.add(ch);
            queue.offer(ch);
            max = Math.max(queue.size(), max);
        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();

        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("dvdf"));
    }

}
