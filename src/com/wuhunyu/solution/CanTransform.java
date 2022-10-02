package com.wuhunyu.solution;

/**
 * 777. 在LR字符串中交换相邻字符
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-02 10:02
 */

public class CanTransform {

    public boolean canTransform(String start, String end) {
        int len = start.length();
        int i = 0;
        int j = 0;
        while (i < len && j < len) {
            while (i < len && start.charAt(i) == 'X') {
                i++;
            }
            while (j < len && end.charAt(j) == 'X') {
                j++;
            }
            if (i >= len || j >= len) {
                break;
            }
            if (start.charAt(i) != end.charAt(j)) {
                return false;
            }
            if (start.charAt(i) == 'L') {
                if (i < j) {
                    return false;
                }
            } else {
                if (i > j) {
                    return false;
                }
            }
            i++;
            j++;
        }
        while (i < len) {
            if (start.charAt(i++) != 'X') {
                return false;
            }
        }
        while (j < len) {
            if (end.charAt(j++) != 'X') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CanTransform canTransform = new CanTransform();

        System.out.println(canTransform.canTransform("RXXLRXRXL", "XRLXXRRLX"));
        System.out.println(canTransform.canTransform("XLXRRXXRXX", "LXXXXXXRRR"));
    }

}
