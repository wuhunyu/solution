package com.wuhunyu.solution.od;

import java.util.Scanner;

/**
 * 停车场车辆统计
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-12 9:52
 */

public class PrakingCar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int count = 0;
        int len = str.length();
        int carNum = 0;
        for (int i = 0; i < len; i += 2) {
            if (str.charAt(i) == '1') {
                if (carNum == 0 || carNum == 3) {
                    carNum = 0;
                    count++;
                }
                carNum++;
            } else {
                carNum = 0;
            }
        }
        System.out.println(count);
    }

}
