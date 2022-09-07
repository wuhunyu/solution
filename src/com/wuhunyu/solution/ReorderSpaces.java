package com.wuhunyu.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 1592. 重新排列单词间的空格
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-09-07 8:35
 */

public class ReorderSpaces {

    public String reorderSpaces(String text) {
        int len = text.length();
        int wordNum = 0;
        int blankNum = 0;
        int index = 0;

        List<String> list = new ArrayList<>();

        while (index < len) {
            if (text.charAt(index) == ' ') {
                index++;
                blankNum++;
                continue;
            }
            wordNum++;
            StringBuilder sb = new StringBuilder();
            while (index < len && text.charAt(index) != ' ') {
                sb.append(text.charAt(index++));
            }
            list.add(sb.toString());
        }
        int perBlank = wordNum <= 1 ? 0 : (blankNum / (wordNum - 1));
        int subBlank = blankNum - perBlank * (wordNum - 1);
        StringBuilder sb = new StringBuilder();
        String blankStr = " ".repeat(perBlank);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append(list.get(i));
            if (i == size - 1) {
                sb.append(" ".repeat(subBlank));
            } else {
                sb.append(blankStr);
            }
        }
        return sb.toString();
    }

}
