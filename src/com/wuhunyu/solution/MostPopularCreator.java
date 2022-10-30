package com.wuhunyu.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 6221. 最流行的视频创作者
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2022/10/30 10:39
 */

public class MostPopularCreator {

    private static class Pair {

        private String id;

        private long curMaxView;

        private long sumView;

        public Pair(String id, long curMaxView, long sumView) {
            this.id = id;
            this.curMaxView = curMaxView;
            this.sumView = sumView;
        }
    }

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        int n = creators.length;
        Map<String, Pair> map = new HashMap<>();
        long maxView = 0L;
        for (int i = 0; i < n; i++) {
            Pair pair = map.get(creators[i]);
            if (pair == null) {
                pair = new Pair(ids[i], views[i], views[i]);
                map.put(creators[i], pair);
            } else {
                pair.sumView += views[i];
                if (pair.curMaxView < views[i]) {
                    pair.id = ids[i];
                    pair.curMaxView = views[i];
                } else if (pair.curMaxView == views[i] && pair.id.compareTo(ids[i]) > 0) {
                    pair.id = ids[i];
                }
            }
            maxView = Math.max(maxView, pair.sumView);
        }
        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String, Pair> entry : map.entrySet()) {
            Pair pair = entry.getValue();
            if (pair.sumView == maxView) {
                List<String> list = new ArrayList<>();
                list.add(entry.getKey());
                list.add(pair.id);
                ans.add(list);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MostPopularCreator mostPopularCreator = new MostPopularCreator();

        System.out.println(mostPopularCreator.mostPopularCreator(new String[]{"a", "a"}, new String[]{"a", "a"}, new int[]{1, 1}));
    }

}
