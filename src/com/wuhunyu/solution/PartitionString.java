package com.wuhunyu.solution;

/**
 * 6177. 子字符串的最优划分
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-11 10:39
 */

public class PartitionString {

    public int partitionString(String s) {
        int len = s.length();
        int flag = 0;
        int count = 0;
        for (int i = 0; i < len; i++) {
            int index = s.charAt(i) - 'a';
            if (((flag >> index) & 1) != 0) {
                count++;
                flag = 0;
            }
            flag |= 1 << index;
        }
        return count + 1;
    }

    public static void main(String[] args) {
        PartitionString partitionString = new PartitionString();

        System.out.println(partitionString.partitionString("hdklqkcssgxlvehva"));
    }

}
