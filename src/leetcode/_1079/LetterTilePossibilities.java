package leetcode._1079;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LetterTilePossibilities {
    public int numTilePossibilities(String tiles) {
        int[] cnt = new int[26];
        Set<Character> set = new HashSet<>();
        for (char c : tiles.toCharArray()) {
            cnt[c - 'A']++;
            set.add(c);
        }
//        System.out.println(set);
//        System.out.println(Arrays.toString(cnt));
        return backtrack(tiles.length(), cnt, set) - 1;
    }

    /**
     * 回溯
     * @param i
     * @param cnt
     * @param set
     * @return
     */
    private int backtrack(int i, int[] cnt, Set<Character> set) {
        if (i == 0) return 1;
        int res = 1;
        for (char c : set) {
            if (cnt[c - 'A'] > 0) {
                cnt[c - 'A']--;
                res += backtrack(i - 1, cnt, set);
                cnt[c - 'A']++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LetterTilePossibilities ltp = new LetterTilePossibilities();
        System.out.println(ltp.numTilePossibilities("AAB"));
//        System.out.println(ltp.numTilePossibilities("AAABBC"));
    }
}
