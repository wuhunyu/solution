package com.wuhunyu.solution;

/**
 * 6167. 检查相同字母间的距离
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-04 10:32
 */

public class CheckDistances {

    public boolean checkDistances(String s, int[] distance) {
        Integer[] arr = new Integer[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int index = s.charAt(i) - 'a';
            arr[index] = arr[index] == null ? i : i - arr[index] - 1;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] != null && arr[i] != distance[i]) {
                return false;
            }
        }
        return true;
    }

}
