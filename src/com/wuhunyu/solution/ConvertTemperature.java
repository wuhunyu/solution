package com.wuhunyu.solution;

/**
 * 6233. 温度转换
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/11/13 10:32
 */

public class ConvertTemperature {

    public double[] convertTemperature(double celsius) {
        // 开氏度 = 摄氏度 + 273.15
        // 华氏度 = 摄氏度 * 1.80 + 32.00
        return new double[]{celsius + 273.15, celsius * 1.8 + 32.0};
    }

}
