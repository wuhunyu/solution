package com.wuhunyu.solution;

import java.util.*;

/**
 * 636. 函数的独占时间
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/8/7 7:26
 */

public class ExclusiveTime {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Deque<int[]> deque = new LinkedList<>();
        for (String log : logs) {
            String[] strs = log.split(":");
            int cur = Integer.parseInt(strs[0]);
            boolean isStart = "start".equals(strs[1]);
            int val = Integer.parseInt(strs[2]);

            if (isStart) {
                if (!deque.isEmpty()) {
                    int[] arr = deque.peek();
                    res[arr[0]] += val - arr[1];
                    arr[1] = val;
                }
                deque.push(new int[]{cur, val});
            } else {
                int[] arr = deque.pop();
                res[arr[0]] += val - arr[1] + 1;
                if (!deque.isEmpty()) {
                    deque.peek()[1] = val + 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ExclusiveTime exclusiveTime = new ExclusiveTime();

        System.out.println(Arrays.toString(exclusiveTime.exclusiveTime(2, new ArrayList<String>() {{
            add("0:start:0");
            add("1:start:2");
            add("1:end:5");
            add("0:end:6");
        }})));
    }

}
