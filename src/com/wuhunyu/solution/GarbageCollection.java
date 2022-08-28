package com.wuhunyu.solution;

/**
 * 6162. 收集垃圾的最少总时间
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-08-28 11:10
 */

public class GarbageCollection {

    public int garbageCollection(String[] garbage, int[] travel) {
        int len1 = garbage.length;
        int len2 = len1 - 1;
        for (int i = 1; i < len2; i++) {
            travel[i] += travel[i - 1];
        }
        int min = 0;
        int mIndex = 0;
        int pIndex = 0;
        int gIndex = 0;
        for (int i = 0; i < len1; i++) {
            int mCount = 0;
            int pCount = 0;
            int gCount = 0;
            int strLen = garbage[i].length();
            for (int j = 0; j < strLen; j++) {
                switch (garbage[i].charAt(j)) {
                    case 'M':
                        mCount++;
                        break;
                    case 'P':
                        pCount++;
                        break;
                    default:
                        gCount++;
                        break;
                }
            }
            int cost = i == 0 ? 0 : travel[i - 1];
            if (mCount > 0) {
                min += mCount + cost - (mIndex == 0 ? 0 : travel[mIndex - 1]);
                mIndex = i;
            }
            if (pCount > 0) {
                min += pCount + cost - (pIndex == 0 ? 0 : travel[pIndex - 1]);
                pIndex = i;
            }
            if (gCount > 0) {
                min += gCount + cost - (gIndex == 0 ? 0 : travel[gIndex - 1]);
                gIndex = i;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        GarbageCollection garbageCollection = new GarbageCollection();

        System.out.println(garbageCollection.garbageCollection(new String[]{"G", "P", "GP", "GG"}, new int[]{2, 4, 3}));
    }

}
