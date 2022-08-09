package com.wuhunyu.solution;

/**
 * 202. 快乐数
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/9 9:16
 */

public class IsHappy {

    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        while (fast != 1 && slow != 1) {
            fast = this.nextNum(this.nextNum(fast));
            slow = this.nextNum(slow);
            if (fast == slow) {
                return false;
            }
        }
        return true;
    }

    private int nextNum(int n) {
        int sum = 0;
        if (n != 1) {
            while (n != 0) {
                int tmp = n % 10;
                sum += tmp * tmp;
                n /= 10;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        IsHappy isHappy = new IsHappy();

        System.out.println(isHappy.isHappy(19));
        System.out.println(isHappy.isHappy(2));
    }

}
