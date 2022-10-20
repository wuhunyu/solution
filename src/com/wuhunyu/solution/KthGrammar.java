package com.wuhunyu.solution;

/**
 * 779. 第K个语法符号
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/10/20 18:35
 */

public class KthGrammar {

    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int halfLen = 1 << (n - 2);
        return k <= halfLen ? this.kthGrammar(n - 1, k) : (1 ^ this.kthGrammar(n - 1, k - halfLen));
    }

    public static void main(String[] args) {
        KthGrammar kthGrammar = new KthGrammar();

        System.out.println(kthGrammar.kthGrammar(4, 6));
        System.out.println(kthGrammar.kthGrammar(1, 1));
        System.out.println(kthGrammar.kthGrammar(2, 1));
        System.out.println(kthGrammar.kthGrammar(2, 2));
        System.out.println(kthGrammar.kthGrammar(30, 434991989));
    }

}
