package com.wuhunyu.solution;

import java.util.Arrays;

/**
 * 640. 求解方程
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/10 8:43
 */

public class SolveEquation {

    public String solveEquation(String equation) {
        String[] strs = equation.split("=");
        int[] arr1 = this.solveExpression(strs[0]);
        int[] arr2 = this.solveExpression(strs[1]);

        int x = arr1[0] - arr2[0];
        int num = arr2[1] - arr1[1];
        if (x == 0 && num == 0) {
            return "Infinite solutions";
        } else if (x == 0) {
            return "No solution";
        }
        return "x=" + (num / x);
    }

    private int[] solveExpression(String expression) {
        int len = expression.length();
        int index = 0;
        Integer curNum = null;
        boolean isNeg = false;
        char pre = '0';

        int x = 0;
        int num = 0;

        while (index < len) {
            char ch = expression.charAt(index);
            if (ch == '+') {
                if (pre != 'x') {
                    curNum = curNum == null ? 0 : curNum;
                    num = isNeg ? num - curNum : num + curNum;
                    curNum = null;
                }
                isNeg = false;
            } else if (ch == '-') {
                if (pre != 'x') {
                    curNum = curNum == null ? 0 : curNum;
                    num = isNeg ? num - curNum : num + curNum;
                    curNum = null;
                }
                isNeg = true;
            } else if (ch == 'x') {
                curNum = curNum == null ? 1 : curNum;
                x = isNeg ? x - curNum : x + curNum;
                curNum = null;
            } else {
                curNum = curNum == null ? 0 : curNum;
                curNum = curNum * 10 + ch - '0';
            }
            pre = ch;
            index++;
        }
        if (curNum != null) {
            num = isNeg ? num - curNum : num + curNum;
        }
        return new int[]{x, num};
    }

    public static void main(String[] args) {
        SolveEquation solveEquation = new SolveEquation();

//        System.out.println(Arrays.toString(solveEquation.solveExpression("x+5-3+x")));
//        System.out.println(Arrays.toString(solveEquation.solveExpression("6+x-2")));
//        System.out.println(Arrays.toString(solveEquation.solveExpression("x")));
//        System.out.println(Arrays.toString(solveEquation.solveExpression("2x")));
//        System.out.println(Arrays.toString(solveEquation.solveExpression("0x")));
        System.out.println(solveEquation.solveEquation("x+5-3+x=6+x-2"));
        System.out.println(solveEquation.solveEquation("x=x"));
        System.out.println(solveEquation.solveEquation("2x=x"));
        System.out.println(solveEquation.solveEquation("x=x+2"));
        System.out.println(solveEquation.solveEquation("0x=0"));
    }

}
