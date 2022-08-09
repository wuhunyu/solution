package com.wuhunyu.solution;

/**
 * 43. 字符串相乘
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/9 11:12
 */

public class Multiply {

    public String multiply(String num1, String num2) {
        return this.calRes(this.storeToArr(num1, num2));
    }

    private int[][] storeToArr(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();

        int[][] arr = new int[len2][len1 + len2];

        int row = 0;
        int col = arr[0].length - 1;
        int colCopy = col;

        for (int index2 = len2 - 1; index2 >= 0; index2--) {
            int flag = 0;
            for (int index1 = len1 - 1; index1 >= 0; index1--) {
                int sum = flag + (num1.charAt(index1) - '0') * (num2.charAt(index2) - '0');

                flag = sum >= 10 ? (sum / 10) : 0;
                sum %= 10;

                arr[row][col--] = sum;
            }
            if (flag > 0) {
                arr[row][col] = flag;
            }
            row++;
            col = --colCopy;
        }

        return arr;
    }

    private String calRes(int[][] arr) {
        int rLen = arr.length;
        int cLen = arr[0].length;

        StringBuilder sb = new StringBuilder();
        int flag = 0;
        for (int i = cLen - 1; i >= 0; i--) {
            int sum = 0;
            for (int j = 0; j < rLen; j++) {
                sum += arr[j][i];
            }
            sum += flag;
            flag = sum >= 10 ? (sum / 10) : 0;
            sb.append(sum % 10);
        }
        if (flag > 0) {
            sb.append(flag);
        }
        int len = sb.length();
        for (int i = len - 1; i >= 1; i--) {
            if (sb.charAt(i) != '0') {
                break;
            }
            sb.deleteCharAt(i);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Multiply multiply = new Multiply();

        System.out.println(multiply.multiply("123", "456"));
        System.out.println(multiply.multiply("2", "3"));
        System.out.println(multiply.multiply("789", "789"));
//        System.out.println(multiply.multiply(str, str));
        // 15241578750190521
        // 15241578750190521
    }

}
