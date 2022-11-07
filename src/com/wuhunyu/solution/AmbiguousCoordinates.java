package com.wuhunyu.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 816. 模糊坐标
 *
 * @author gongzhiqiang
 * @date 2022/11/07 12:52
 **/

public class AmbiguousCoordinates {

    public List<String> ambiguousCoordinates(String s) {
        String subStr = s.substring(1, s.length() - 1);
        int index = 1;
        int len = subStr.length();
        List<String> ans = new ArrayList<>();
        while (index < len) {
            for (String str1 : this.findStr(subStr.substring(0, index))) {
                for (String str2 : this.findStr(subStr.substring(index))) {
                    ans.add("(" + str1 + ", " + str2 + ")");
                }
            }
            index++;
        }
        return ans;
    }

    private List<String> findStr(String str) {
        List<String> list = new ArrayList<>();
        int len = str.length();
        int index = 1;
        while (index <= len) {
            String str1 = str.substring(0, index);
            String str2 = str.substring(index, len);
            index++;
            if (!Objects.equals(str1, "0") && str1.charAt(0) == '0' ||
                    str2.length() > 0 && str2.charAt(str2.length() - 1) == '0') {
                continue;
            }
            list.add(str2.length() > 0 ? (str1 + "." + str2) : str1);
        }
        return list;
    }

    public static void main(String[] args) {
        AmbiguousCoordinates ambiguousCoordinates = new AmbiguousCoordinates();

        System.out.println(ambiguousCoordinates.ambiguousCoordinates("(123)"));
    }

}
