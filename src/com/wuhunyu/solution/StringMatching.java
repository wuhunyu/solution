package com.wuhunyu.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 1408. 数组中的字符串匹配
 *
 * @author gongzhiqiang
 * @version 1.0
 * @date 2022/8/6 8:28
 */

public class StringMatching {

    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for (String curWord : words) {
            for (String word : words) {
                if (curWord.length() < word.length() && word.contains(curWord)) {
                    res.add(curWord);
                    break;
                }
            }
        }
        return res;
    }

}
