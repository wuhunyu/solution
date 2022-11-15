package com.wuhunyu.solution;

import java.util.Arrays;

/**
 * 1710. 卡车上的最大单元数
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/11/15 12:43
 */

public class MaximumUnits {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (arr1, arr2) -> arr2[1] - arr1[1]);
        int len = boxTypes.length;
        int ans = 0;
        int index = 0;
        while (truckSize > 0 && index < len) {
            if (truckSize >= boxTypes[index][0]) {
                ans += boxTypes[index][0] * boxTypes[index][1];
                truckSize -= boxTypes[index][0];
            } else {
                ans += boxTypes[index][1] * truckSize;
                break;
            }
            index++;
        }
        return ans;
    }

}
