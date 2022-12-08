package com.wuhunyu.solution;

/**
 * 1812. 判断国际象棋棋盘中一个格子的颜色
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/12/8 12:51
 */

public class SquareIsWhite {

    public boolean squareIsWhite(String coordinates) {
        return ((coordinates.charAt(0) + coordinates.charAt(1)) & 1) == 1;
    }

}
