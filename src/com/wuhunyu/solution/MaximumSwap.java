package com.wuhunyu.solution;

/**
 * 670. 最大交换
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-13 8:21
 */

public class MaximumSwap {

    public int maximumSwap(int num) {
        char[] numChar = String.valueOf(num).toCharArray();
        int len = numChar.length;
        int low = -1;
        int high = -1;
        int maxIndex = len - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (numChar[i] > numChar[maxIndex]) {
                maxIndex = i;
            } else if (numChar[i] < numChar[maxIndex]) {
                low = maxIndex;
                high = i;
            }
        }
        if (low > -1) {
            char tmp = numChar[low];
            numChar[low] = numChar[high];
            numChar[high] = tmp;
            return Integer.parseInt(new String(numChar));
        }
        return num;
    }

    public static void main(String[] args) {
        MaximumSwap maximumSwap = new MaximumSwap();

        System.out.println(maximumSwap.maximumSwap(98368));
        System.out.println(maximumSwap.maximumSwap(1993));
    }

}
