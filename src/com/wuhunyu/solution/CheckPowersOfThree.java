package com.wuhunyu.solution;

/**
 * 1780. 判断一个数字是否可以表示成三的幂的和
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/12/9 13:07
 */

public class CheckPowersOfThree {

    public boolean checkPowersOfThree(int n) {
        int[] arr = {1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969, 14348907};
        int limit = arr.length - 1;
        while (n > 0) {
            int index = this.findMaxNum(arr, n, limit);
            if (index == -1) {
                return false;
            }
            n -= arr[index];
            limit = index - 1;
        }
        return true;
    }

    private int findMaxNum(int[] arr, int target, int limit) {
        if (arr[0] > target || limit < 0) {
            return -1;
        }
        int left = 0;
        int right = limit;
        while (left < right) {
            int mid = ((right - left + 1) >> 1) + left;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        CheckPowersOfThree checkPowersOfThree = new CheckPowersOfThree();

        System.out.println(checkPowersOfThree.checkPowersOfThree(21));
    }

}
