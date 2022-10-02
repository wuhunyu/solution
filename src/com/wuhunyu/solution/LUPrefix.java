package com.wuhunyu.solution;

/**
 * 6197. 最长上传前缀
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-01 23:24
 */

public class LUPrefix {

    private int[] prefix;

    private int limit;

    public LUPrefix(int n) {
        prefix = new int[n + 1];
    }

    public void upload(int video) {
        prefix[video] = 1;
    }

    public int longest() {
        int len = prefix.length;
        while (limit < len && prefix[limit] != 0) {
            limit++;
        }
        return limit;
    }

}
