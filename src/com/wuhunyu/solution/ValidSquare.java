package com.wuhunyu.solution;

/**
 * 593. 有效的正方形
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/7/29 8:36
 */

public class ValidSquare {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return this.doValidSquare(p1, p2, p3, p4) ||
                this.doValidSquare(p1, p3, p2, p4) ||
                this.doValidSquare(p1, p4, p2, p3);
    }

    private boolean doValidSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // 点是否重合重合
        if (p1[0] == p3[0] && p1[1] == p3[1] || p2[0] == p4[0] && p2[1] == p4[1]) {
            return false;
        }

        // 中点是否相等
        double midRow1 = (p1[0] + p2[0]) / 2.0D;
        double midCol1 = (p1[1] + p2[1]) / 2.0D;

        double midRow2 = (p3[0] + p4[0]) / 2.0D;
        double midCol2 = (p3[1] + p4[1]) / 2.0D;
        if (Double.compare(midRow1, midRow2) != 0 || Double.compare(midCol1, midCol2) != 0) {
            return false;
        }

        // 中线长度是否相等
        double len1 = Math.sqrt((Math.abs(p2[0] - p1[0])) * (Math.abs(p2[1] - p1[1])));
        double len2 = Math.sqrt((Math.abs(p4[0] - p3[0])) * (Math.abs(p4[1] - p3[1])));
        if (Double.compare(len1, len2) != 0) {
            return false;
        }

        // 中线是否相互垂直
        return Double.compare(0D, (p2[0] - p1[0]) * (p4[0] - p3[0]) + (p2[1] - p1[1]) * (p4[1] - p3[1])) == 0;
    }

    public static void main(String[] args) {
        ValidSquare validSquare = new ValidSquare();

//        System.out.println(validSquare.validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 1}));
//        System.out.println(validSquare.validSquare(new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1}));

        System.out.println(validSquare.validSquare(new int[]{1, 0}, new int[]{0, 1}, new int[]{0, -1}, new int[]{-1, 0}));
    }


}
