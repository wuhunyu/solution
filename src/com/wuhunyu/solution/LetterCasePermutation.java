package com.wuhunyu.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. 字母大小写全排列
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/10/30 9:19
 */

public class LetterCasePermutation {

    public List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>();
        this.dfs(s, new StringBuilder(), 0, list);
        return list;
    }

    private void dfs(String s, StringBuilder sb, int index, List<String> list) {
        if (sb.length() == s.length()) {
            list.add(sb.toString());
            return;
        }
        char ch = s.charAt(index);
        if (Character.isLetter(ch)) {
            StringBuilder sb2 = new StringBuilder(sb);

            sb.append(ch);
            this.dfs(s, sb, index + 1, list);

            sb2.append((char) (ch ^ 32));
            this.dfs(s, sb2, index + 1, list);
        } else {
            sb.append(ch);
            this.dfs(s, sb, index + 1, list);
        }
    }

    public static void main(String[] args) {
        LetterCasePermutation letterCasePermutation = new LetterCasePermutation();

        System.out.println(letterCasePermutation.letterCasePermutation("a1b2"));
    }

}
