package com.wuhunyu.solution;

/**
 * 1832. 判断句子是否为全字母句
 *
 * @author gongzhiqiang
 * @date 2022/12/13 12:53
 **/

public class CheckIfPangram {

    public boolean checkIfPangram(String sentence) {
        int count = 0;
        int length = sentence.length();
        for (int i = 0; i < length; i++) {
            count |= 1 << (sentence.charAt(i) - 'a');
        }
        return count == ((1 << 26) - 1);
    }

}
