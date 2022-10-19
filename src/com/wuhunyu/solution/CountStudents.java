package com.wuhunyu.solution;

/**
 * 1700. 无法吃午餐的学生数量
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/10/19 8:42
 */

public class CountStudents {

    public int countStudents(int[] students, int[] sandwiches) {
        int oneCount = 0;
        for (int student : students) {
            oneCount += student;
        }
        int zeroCount = students.length - oneCount;
        for (int sandwich : sandwiches) {
            if (sandwich == 0 && zeroCount > 0) {
                zeroCount--;
            } else if (sandwich == 1 && oneCount > 0) {
                oneCount--;
            } else {
                break;
            }
        }
        return oneCount + zeroCount;
    }

    public static void main(String[] args) {
        CountStudents countStudents = new CountStudents();

        System.out.println(countStudents.countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));
    }

}
