package com.wuhunyu.solution;

/**
 * 915. 分割数组
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/10/24 12:36
 */

public class PartitionDisjoint {

    public int partitionDisjoint(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len];
        int min = nums[len - 1];
        for (int i = len - 1; i >= 0; i--) {
            min = Math.min(nums[i], min);
            arr[i] = min;
        }
        int max = nums[0];
        int index = 0;
        while (index < len - 1) {
            if (max <= arr[index + 1]) {
                return index + 1;
            }
            max = Math.max(max, nums[index++]);
        }
        return -1;
    }

    public static void main(String[] args) {
        PartitionDisjoint partitionDisjoint = new PartitionDisjoint();

        System.out.println(partitionDisjoint.partitionDisjoint(new int[]{5, 0, 3, 8, 6}));
    }

}
