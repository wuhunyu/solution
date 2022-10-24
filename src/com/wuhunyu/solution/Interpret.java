package com.wuhunyu.solution;

/**
 * 1678. 设计 Goal 解析器
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/10/24 18:45
 */

public class Interpret {

    public String interpret(String command) {
        int len = command.length();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < len) {
            char ch = command.charAt(index);
            if (ch == 'G') {
                sb.append('G');
                index++;
            } else if (command.charAt(index + 1) == ')') {
                sb.append('o');
                index += 2;
            } else {
                sb.append("al");
                index += 4;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Interpret interpret = new Interpret();

        System.out.println(interpret.interpret("G()(al)"));
    }

}
