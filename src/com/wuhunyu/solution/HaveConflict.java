package com.wuhunyu.solution;

/**
 * 6214. 判断两个事件是否存在冲突
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/10/23 10:31
 */

public class HaveConflict {

    public boolean haveConflict(String[] event1, String[] event2) {
        int num1Start = Integer.parseInt(event1[0].substring(0, 2)) * 100 + Integer.parseInt(event1[0].substring(3, 5));
        int num1End = Integer.parseInt(event1[1].substring(0, 2)) * 100 + Integer.parseInt(event1[1].substring(3, 5));

        int num2Start = Integer.parseInt(event2[0].substring(0, 2)) * 100 + Integer.parseInt(event2[0].substring(3, 5));
        int num2End = Integer.parseInt(event2[1].substring(0, 2)) * 100 + Integer.parseInt(event2[1].substring(3, 5));

        return !(num1End < num2Start || num2End < num1Start);
    }

    public static void main(String[] args) {
        HaveConflict haveConflict = new HaveConflict();

        System.out.println(haveConflict.haveConflict(new String[]{"01:15", "02:00"}, new String[]{"02:00", "03:00"}));
    }

}
