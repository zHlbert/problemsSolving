package contest.leetcode20220611;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MatchSubstringAfterReplacement {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        Map<Character, Set<Character>> map = new HashMap<>();
        for (char[] mapping : mappings) {
            Set<Character> chSet = map.getOrDefault(mapping[0], new HashSet<>());
            chSet.add(mapping[1]);
            map.put(mapping[0], chSet);
        }
        int n = s.length(), m = sub.length();
        char[] sCh = s.toCharArray();
        char[] subCh = sub.toCharArray();
        for (int i = 0; i + m <= n; i++) {
            boolean canRep = true;
            for (int j = 0; j < m; j++) {
                if (sCh[i + j] != subCh[j] && (!map.containsKey(subCh[j]) || !map.get(subCh[j]).contains(sCh[i + j])) ) {
                    canRep = false;
                    break;
                }
            }
            if (canRep) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MatchSubstringAfterReplacement ms = new MatchSubstringAfterReplacement();
        String s = "fool3e7bar";
        String sub = "leet";
        char[][] mappings = new char[][] {{'e','3'},{'t','7'},{'t','8'}};
        System.out.println(ms.matchReplacement(s, sub, mappings));
    }
}
