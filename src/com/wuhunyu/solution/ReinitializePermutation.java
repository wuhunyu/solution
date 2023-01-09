package com.wuhunyu.solution;

/**
 * 1806. 还原排列的最少操作步数
 *
 * @author gongzhiqiang
 * @date 2023/01/09 08:05
 **/

public class ReinitializePermutation {

    public int reinitializePermutation(int n) {
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }
        int[] cloneArr = perm.clone();
        int[] arr = new int[n];
        int count = 0;
        int half = n >> 1;
        while (true) {
            count++;
            for (int i = 0; i < n; i++) {
                arr[i] = (i & 1) == 0 ? perm[i >> 1] : perm[half + ((i - 1) >> 1)];
            }
            boolean isEqual = true;
            for (int i = 0; i < n; i++) {
                if (cloneArr[i] != arr[i]) {
                    isEqual = false;
                    break;
                }
            }
            if (isEqual) {
                return count;
            }
            int[] tmp = perm;
            perm = arr;
            arr = tmp;
        }
    }

    public static void main(String[] args) {
        ReinitializePermutation reinitializePermutation = new ReinitializePermutation();

        System.out.println(reinitializePermutation.reinitializePermutation(2));
        System.out.println(reinitializePermutation.reinitializePermutation(4));
    }

}
