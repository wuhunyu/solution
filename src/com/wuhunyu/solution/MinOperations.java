package com.wuhunyu.solution;

/**
 * 1598. 文件夹操作日志搜集器
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-09 8:05
 */

public class MinOperations {

    public int minOperations(String[] logs) {
        int count = 0;
        for (String log : logs) {
            switch (log) {
                case "../":
                    count = Math.max(count - 1, 0);
                    break;
                case "./":
                    break;
                default:
                    count++;
                    break;
            }
        }
        return count;
    }

}
