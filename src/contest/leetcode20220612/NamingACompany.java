package contest.leetcode20220612;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/contest/weekly-contest-297/problems/naming-a-company/
 */
public class NamingACompany {
    public long distinctNames(String[] ideas) {
        Map<String, Integer> strCntMap = new HashMap<>();
        for (String idea : ideas) {
            String sub = idea.substring(1);
            char h = idea.charAt(0);
            strCntMap.put(sub, strCntMap.getOrDefault(sub, 0) | (1 << (h - 'a')));
        }

        int[][] cnt = new int[26][26];
        for (String idea : ideas) {
            String sub = idea.substring(1);
            char w = idea.charAt(0);
            int mask = strCntMap.get(sub);
            for (int i = 0; i < 26; i++) {
               if ((mask & (1 << i)) == 0) {
                   cnt[w - 'a'][i]++;
               }
            }
        }

        long res = 0;
        for (String idea : ideas) {
            String sub = idea.substring(1);
            char w = idea.charAt(0);
            int mask = strCntMap.get(sub);
            for (int i = 0; i < 26; i++) {
                if ((mask & (1 << i)) == 0) {
                    res += cnt[i][w - 'a'];
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        NamingACompany nc = new NamingACompany();
//        String[] ideas = new String[] {"coffee","donuts","time","toffee"};
        String[] ideas = new String[] {"lack","back"};
        System.out.println(nc.distinctNames(ideas));
    }
}
