package com.wuhunyu.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 811. 子域名访问计数
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022-10-05 11:51
 */

public class SubdomainVisits {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            // 频次
            int count = 0;
            int index = 0;
            while (cpdomain.charAt(index) != ' ') {
                count = count * 10 + cpdomain.charAt(index++) - '0';
            }
            index = cpdomain.length() - 1;
            while (true) {
                char ch = cpdomain.charAt(index);
                if (ch == '.') {
                    String domain = cpdomain.substring(index + 1);
                    map.put(domain, map.getOrDefault(domain, 0) + count);
                } else if (ch == ' ') {
                    String domain = cpdomain.substring(index + 1);
                    map.put(domain, map.getOrDefault(domain, 0) + count);
                    break;
                }
                index--;
            }
        }
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue() + " " + entry.getKey());
        }
        return ans;
    }

}
