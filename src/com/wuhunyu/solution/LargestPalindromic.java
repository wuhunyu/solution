package com.wuhunyu.solution;

/**
 * 6166. 最大回文数字
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/8/21 11:19
 */

public class LargestPalindromic {

    public String largestPalindromic(String num) {
        int[] arr = new int[10];
        int len = num.length();
        for (int i = 0; i < len; i++) {
            arr[num.charAt(i) - '0']++;
        }
        StringBuilder doubleSb = new StringBuilder();
        for (int i = 9; i > 0; i--) {
            if (arr[i] > 1) {
                doubleSb.append(String.valueOf(i)
                        .repeat(Math.max(0, arr[i] >> 1)));
            }
        }
        // 0
        if (doubleSb.length() > 0 && arr[0] > 0) {
            doubleSb.append(String.valueOf('0')
                    .repeat(arr[0] >> 1));
        }
        StringBuilder singleSb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if ((arr[i] & 1) == 1) {
                singleSb.append(i);
                break;
            }
        }
        String res = doubleSb.toString();
        res = res + singleSb + doubleSb.reverse();
        return res.length() == 0 && arr[0] > 0 ? "0" : res;
    }

    public static void main(String[] args) {
        LargestPalindromic largestPalindromic = new LargestPalindromic();

        System.out.println(largestPalindromic.largestPalindromic("444947137"));
        System.out.println(largestPalindromic.largestPalindromic("000000"));
    }

}
