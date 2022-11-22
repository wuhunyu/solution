package com.wuhunyu.solution.od;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * k 对元素最小值
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-12 10:04
 */

public class MinValueOfK {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size1 = scanner.nextInt();
        int[] arr1 = new int[size1];
        for (int i = 0; i < size1; i++) {
            arr1[i] = scanner.nextInt();
        }
        scanner.nextLine();
        int size2 = scanner.nextInt();
        int[] arr2 = new int[size2];
        for (int i = 0; i < size2; i++) {
            arr2[i] = scanner.nextInt();
        }
        scanner.nextLine();
        int countSize = scanner.nextInt();

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                priorityQueue.add(arr1[i] + arr2[j]);
            }
        }
        int sum = 0;
        int count = 0;
        while (count++ < countSize) {
            sum += priorityQueue.poll();
        }
        System.out.println(sum);
    }

}
