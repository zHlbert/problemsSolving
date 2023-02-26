package leetcode._1255;

public class MaximumScoreWordsFormedByLetters {
    /**
     * 动态规划 + 状态压缩
     * @param words
     * @param letters
     * @param score
     * @return
     */
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int n = words.length;
        int res = 0;
        int[] cnt = new int[26];
        for (char c : letters) {
            cnt[c - 'a']++;
        }
        for (int s = 1; s < (1 << n); s++) {
            int[] wordCnt = new int[26];
            for (int k = 0; k < n; k++) {
                if ((s & (1 << k)) == 0) continue;
                char[] chars = words[k].toCharArray();
                for (char c : chars) {
                    wordCnt[c - 'a']++;
                }
            }
            boolean ok = true;
            int sum = 0;
            for (int i = 0; i < 26; i++) {
                sum += score[i] * wordCnt[i];
                if (wordCnt[i] > cnt[i]) {
                    ok = false;
                    break;
                }
            }
            if (ok) res = Math.max(res, sum);
        }
        return res;
    }
}
