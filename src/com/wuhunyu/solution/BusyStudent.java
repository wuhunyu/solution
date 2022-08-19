package com.wuhunyu.solution;

/**
 * 1450. 在既定时间做作业的学生人数
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/8/19 8:36
 */

public class BusyStudent {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int len = startTime.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                count++;
            }
        }
        return count;
    }

}
