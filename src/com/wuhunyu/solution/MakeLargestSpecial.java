package com.wuhunyu.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 761. 特殊的二进制序列
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/8 11:45
 */

public class MakeLargestSpecial {

    public String makeLargestSpecial(String s) {
        int len = s.length();
        if (len == 0) {
            return "";
        }
        List<String> list = new ArrayList<>();
        int flag = 0;
        int index = 0;
        int preIndex = 0;
        while (index < len) {
            flag += s.charAt(index) == '1' ? 1 : -1;
            if (flag == 0) {
                list.add("1" + this.makeLargestSpecial(s.substring(preIndex + 1, index)) + "0");
                preIndex = index + 1;
            }
            index++;
        }
        list.sort((str1, str2) -> (str2 + str1).compareTo(str1 + str2));
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }
        return sb.toString();
    }

}
