package com.wuhunyu.solution.od;

import java.util.Scanner;

/**
 * 最远足迹
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-11 19:58
 */

public class MaxDistance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int len = str.length();
        int index = 0;
        String maxDistance = "(0,0)";
        int maxVal = 0;
        while (index < len) {
            int x = 0;
            int y = 0;
            if (str.charAt(index++) == '(') {
                boolean isLeft = true;
                boolean isErr = false;
                while (index < len && str.charAt(index) != ')') {
                    char ch = str.charAt(index++);
                    if (ch == ',') {
                        isLeft = false;
                        continue;
                    }
                    if (isLeft) {
                        if (x == 0 && ch == '0') {
                            isErr = true;
                            break;
                        }
                        x = x * 10 + ch - '0';
                    } else {
                        if (y == 0 && ch == '0') {
                            isErr = true;
                            break;
                        }
                        y = y * 10 + ch - '0';
                    }
                }
                if (!isErr) {
                    if (x < 1000 && y < 1000) {
                        int curVal = x * x + y * y;
                        if (curVal > maxVal) {
                            maxVal = curVal;
                            maxDistance = "(" + x + "," + y + ")";
                        }
                    }
                }
            }
        }
        System.out.println(maxDistance);
    }

}
