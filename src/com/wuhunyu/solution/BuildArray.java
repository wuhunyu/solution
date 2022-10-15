package com.wuhunyu.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 1441. 用栈操作构建数组
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/10/15 8:15
 */

public class BuildArray {

    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        int cur = 1;
        for (int num : target) {
            while (num > cur++) {
                list.add("Push");
                list.add("Pop");
            }
            list.add("Push");
        }
        return list;
    }

    public static void main(String[] args) {
        BuildArray buildArray = new BuildArray();

        System.out.println(buildArray.buildArray(new int[]{1, 3}, 3));
    }

}
