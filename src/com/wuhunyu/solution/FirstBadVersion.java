package com.wuhunyu.solution;

/**
 * 278. 第一个错误的版本
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/7/18 13:20
 */

public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (isBadVersion(mid)) {
                if (left == mid) {
                    return left;
                }
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private boolean isBadVersion(int version) {
        return version >= 4;
    }

    public static void main(String[] args) {
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        System.out.println(firstBadVersion.firstBadVersion(5));
    }

}
