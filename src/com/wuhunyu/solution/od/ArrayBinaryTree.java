package com.wuhunyu.solution.od;

import java.util.*;

/**
 * 数组二叉树
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-12 11:36
 */

public class ArrayBinaryTree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] nodeStr = str.split(" ");
        int len = nodeStr.length;
        int[] nodes = new int[len];
        for (int i = 0; i < len; i++) {
            nodes[i] = Integer.parseInt(nodeStr[i]);
        }
        int minIndex = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int leftIndex = (i << 1) + 1;
            int rightIndex = leftIndex + 1;
            if (nodes[i] != -1 && (leftIndex >= len && rightIndex >= len || nodes[leftIndex] == -1 && nodes[rightIndex] == -1)) {
                if (min > nodes[i]) {
                    min = nodes[i];
                    minIndex = i;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        int index = minIndex + 1;
        while (index > 0) {
            list.add(nodes[index - 1]);
            index >>= 1;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            if (i != 0) {
                System.out.print(list.get(i) + " ");
            } else {
                System.out.println(list.get(i));
            }
        }
    }

}
