package com.wuhunyu.solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 54. 螺旋矩阵
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/9 9:34
 */

public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        int rLen = matrix.length;
        int cLen = matrix[0].length;

        int[] rows = {0, 1, 0, -1};
        int[] cols = {1, 0, -1, 0};

        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();

        int direction = 0;
        int count = 0;
        int limit = rLen * cLen;

        int row = 0;
        int col = 0;

        while (count++ < limit) {
            res.add(matrix[row][col]);
            set.add(row * cLen + col);

            if (count >= limit) {
                break;
            }
            while (true) {
                int rowCopy = row + rows[direction];
                int colCopy = col + cols[direction];
                int sum = rowCopy * cLen + colCopy;
                if (set.contains(sum) || rowCopy < 0 || rowCopy >= rLen || colCopy < 0 || colCopy >= cLen) {
                    direction = (direction + 1) % 4;
                } else {
                    row = rowCopy;
                    col = colCopy;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();

//        System.out.println(spiralOrder.spiralOrder(new int[][]{
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        }));

//        System.out.println(spiralOrder.spiralOrder(new int[][]{
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12}
//        }));

        System.out.println(spiralOrder.spiralOrder(new int[][]{
                {1},
                {5},
                {9}
        }));

        System.out.println(spiralOrder.spiralOrder(new int[][]{
                {1, 2, 3}
        }));
    }

}
