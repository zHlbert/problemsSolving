package leetcode._1704;

public class DetermineIfStringHalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        char[] sc = s.toCharArray();
        int lc = 0, rc = 0;
        for (int i = 0, j = n >> 1; j < n; i++, j++) {
            lc += isVowel(sc[i]) ? 1 : 0;
            rc += isVowel(sc[j]) ? 1 : 0;
        }
        return lc == rc;
    }

    public boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
