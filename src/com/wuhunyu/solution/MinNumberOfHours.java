package com.wuhunyu.solution;

/**
 * 6152. 赢得比赛需要的最少训练时长
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/8/21 10:43
 */

public class MinNumberOfHours {

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int sumEnergy = 1;
        int sumExperience = 0;
        int curExperience = 0;
        int len = energy.length;
        for (int i = 0; i < len; i++) {
            sumEnergy += energy[i];
            if (curExperience <= experience[i]) {
                int add = experience[i] - curExperience + 1;
                sumExperience += add;
                curExperience += add + experience[i];
            } else {
                curExperience += experience[i];
            }
        }
        return Math.max(0, sumEnergy - initialEnergy) + Math.max(0, sumExperience - initialExperience);
    }

    public static void main(String[] args) {
        MinNumberOfHours minNumberOfHours = new MinNumberOfHours();

//        System.out.println(minNumberOfHours.minNumberOfHours(5, 3, new int[]{1, 4, 3, 2}, new int[]{2, 6, 3, 1}));
        System.out.println(minNumberOfHours.minNumberOfHours(30, 78, new int[]{24, 91, 63, 38, 31, 63, 22, 35, 91, 54, 88, 46, 80, 14, 12, 19, 57, 92}, new int[]{18, 43, 36, 88, 84, 21, 82, 54, 61, 80, 68, 54, 75, 27, 99, 14, 86, 95}));
    }

}
