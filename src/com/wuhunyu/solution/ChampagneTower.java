package com.wuhunyu.solution;

/**
 * 799. 香槟塔
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/12/4 8:46
 */

public class ChampagneTower {

    public double champagneTower(int poured, int queryRow, int queryGlass) {
        double[] row = {poured};
        for (int i = 1; i <= queryRow; i++) {
            double[] nextRow = new double[i + 1];
            for (int j = 0; j < i; j++) {
                if (row[j] > 1d) {
                    double val = row[j] - 1d;
                    nextRow[j] += val / 2d;
                    nextRow[j + 1] += val / 2d;
                }
            }
            row = nextRow;
        }
        return Math.min(1d, row[queryGlass]);
    }

    public static void main(String[] args) {
        ChampagneTower champagneTower = new ChampagneTower();

//        System.out.println(champagneTower.champagneTower(1, 1, 1));
//        System.out.println(champagneTower.champagneTower(2, 1, 1));
        System.out.println(champagneTower.champagneTower(10, 33, 17));
    }

}
