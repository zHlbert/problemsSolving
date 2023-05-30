package leetcode._2559;

public class CountVowelStringsInRanges {
    /**
     * 前缀和
     * @param words
     * @param queries
     * @return
     */
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int m = word.length();
            prefix[i + 1] = prefix[i] + (isVowel(word.charAt(0)) && isVowel(word.charAt(m - 1)) ? 1 : 0);
        }
        int q = queries.length;
        int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            res[i] = prefix[queries[i][1] + 1] - prefix[queries[i][0]];
        }
        return res;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
//        return "aeiou".contains(c + "");
    }
}
