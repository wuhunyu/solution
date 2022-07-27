package com.wuhunyu.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 731. 我的日程安排表 Ⅱ
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/7/19 8:54
 */

public class MyCalendarTwo {

    private final List<int[]> one;

    private final List<int[]> two;

    public MyCalendarTwo() {
        one = new ArrayList<>();
        two = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] arr : two) {
            if (start < arr[1] && end > arr[0]) {
                return false;
            }
        }
        for (int[] arr : one) {
            if (start < arr[1] && end > arr[0]) {
                two.add(new int[]{Math.max(start, arr[0]), Math.min(end, arr[1])});
            }
        }
        one.add(new int[]{start, end});
        return true;
    }

    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();

        System.out.println(myCalendarTwo.book(10, 20));
        System.out.println(myCalendarTwo.book(50, 60));
        System.out.println(myCalendarTwo.book(10, 40));
        System.out.println(myCalendarTwo.book(5, 15));
        System.out.println(myCalendarTwo.book(5, 10));
        System.out.println(myCalendarTwo.book(25, 55));
    }

}
