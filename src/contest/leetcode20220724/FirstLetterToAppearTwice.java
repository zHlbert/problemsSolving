package contest.leetcode20220724;

public class FirstLetterToAppearTwice {
    public char repeatedCharacter(String s) {
        int[] cnt = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (cnt[c - 'a'] == 1) {
                return c;
            }
            cnt[c - 'a']++;
        }
        return 'a';
    }
}
