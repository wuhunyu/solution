package com.wuhunyu.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 792. 匹配子序列的单词数
 *
 * @author gongzhiqiang
 * @date 2022/11/17 08:06
 **/

public class NumMatchingSubseq {

    public int numMatchingSubseq(String s, String[] words) {
        List<Integer>[] lists = new List[26];
        for (int i = 0; i < 26; i++) {
            lists[i] = new ArrayList<>();
        }
        int sLen = s.length();
        for (int i = 0; i < sLen; i++) {
            lists[s.charAt(i) - 'a'].add(i);
        }
        int count = 0;
        for (String word : words) {
            int wLen = word.length();
            if (wLen > sLen) {
                continue;
            }
            int pre = -1;
            boolean isMatch = true;
            for (int i = 0; i < wLen; i++) {
                int index = word.charAt(i) - 'a';
                if (lists[index].isEmpty() || lists[index].get(lists[index].size() - 1) <= pre) {
                    isMatch = false;
                    break;
                }
                pre = this.binarySearch(lists[index], pre);
            }
            count += isMatch ? 1 : 0;
        }
        return count;
    }

    private int binarySearch(List<Integer> list, int pre) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (list.get(mid) > pre) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return list.get(left);
    }

    public static void main(String[] args) {
        NumMatchingSubseq numMatchingSubseq = new NumMatchingSubseq();

        System.out.println(numMatchingSubseq.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
    }

}
