package com.wuhunyu.solution;

/**
 * 1422. 分割字符串的最大得分
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/8/14 9:01
 */

public class MaxScore {

    public int maxScore(String s) {
        int len = s.length();
        int oneCount = 0;
        for (int i = 1; i < len; i++) {
            oneCount += s.charAt(i) == '1' ? 1 : 0;
        }
        int zeroCount = s.charAt(0) == '0' ? 1 : 0;
        int max = oneCount + zeroCount;
        for (int i = 1; i < len - 1; i++) {
            if (s.charAt(i) == '1') {
                oneCount--;
            } else {
                zeroCount++;
            }
            max = Math.max(max, oneCount + zeroCount);
        }
        return max;
    }

}
