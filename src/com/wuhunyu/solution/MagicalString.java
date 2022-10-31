package com.wuhunyu.solution;

/**
 * 481. 神奇字符串
 *
 * @author wuhunyu
 * @date 2022/10/31 07:45
 **/

public class MagicalString {

    public int magicalString(int n) {
        if (n <= 3) {
            return 1;
        }
        char[] chars = new char[n];
        chars[0] = '1';
        chars[1] = '2';
        chars[2] = '2';
        int left = 2;
        int right = 3;
        char curCh = '1';
        int count = 1;
        while (right < n) {
            int curCount = chars[left++] - '0';
            int add = curCh == '1' ? 1 : 0;
            while (right < n && curCount-- > 0) {
                count += add;
                chars[right++] = curCh;
            }
            curCh = curCh == '1' ? '2' : '1';
        }
        return count;
    }

    public static void main(String[] args) {
        MagicalString magicalString = new MagicalString();

        System.out.println(magicalString.magicalString(10));
    }

}
