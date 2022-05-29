package contest.leetcode20220529;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/contest/weekly-contest-295/problems/rearrange-characters-to-make-target-string/
 */
public class RearrangeCharactersToMakeTargetString {
    public int rearrangeCharacters(String s, String target) {
        char[] sChars = s.toCharArray();
        int[] count = new int[26];
        for (char sChar : sChars) {
            count[sChar - 'a']++;
        }
        char[] tChars = target.toCharArray();
        Map<Character, Integer> tMap = new HashMap<>();
        for (char tChar : tChars) {
            int cnt = tMap.getOrDefault(tChar, 0);
            tMap.put(tChar, cnt + 1);
        }
        int minTimes = 200;
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            int sCount = count[entry.getKey() - 'a'];
            int times = sCount / entry.getValue();
            minTimes = Math.min(minTimes, times);
        }
        return minTimes;
    }
}
