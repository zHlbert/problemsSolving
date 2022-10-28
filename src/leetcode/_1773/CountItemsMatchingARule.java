package leetcode._1773;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountItemsMatchingARule {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        Map<String, Map<String, Integer>> maps = new HashMap<>();
        String[] keys = new String[] {"type", "color", "name"};
        for (List<String> item : items) {
            for (int i = 0; i < 3; i++) {
                String key = keys[i];
                String val = item.get(i);
                Map<String, Integer> map = maps.getOrDefault(key, new HashMap<>());
                map.put(val, map.getOrDefault(val, 0) + 1);
                maps.put(key, map);
            }
        }

        if (!maps.containsKey(ruleKey)) {
            return 0;
        }
        Map<String, Integer> map = maps.get(ruleKey);
        return map.getOrDefault(ruleValue, 0);
    }

    public int countMatches1(List<List<String>> items, String ruleKey, String ruleValue) {
        Map<String, Integer> keys = new HashMap<>();
        keys.put("type", 0);
        keys.put("color", 1);
        keys.put("name", 2);

        Map<String, Integer>[] maps = new Map[3];
        for (int i = 0; i < 3; i++) {
            maps[i] = new HashMap<>();
        }

        for (List<String> item : items) {
            for (int i = 0; i < 3; i++) {
                Map<String, Integer> map = maps[i];
                map.put(item.get(i), map.getOrDefault(item.get(i), 0) + 1);
            }
        }

        return maps[keys.get(ruleKey)].getOrDefault(ruleValue, 0);
    }

    public int countMatches2(List<List<String>> items, String ruleKey, String ruleValue) {
        int idx = ruleKey.equals("type") ? 0 : ruleKey.equals("color") ? 1 : 2;
        int res = 0;
        for (List<String> item : items) {
            String val = item.get(idx);
            res += ruleValue.equals(val) ? 1 : 0;
        }
        return res;
    }
}
