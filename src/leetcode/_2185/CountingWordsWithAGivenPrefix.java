package leetcode._2185;

public class CountingWordsWithAGivenPrefix {
    public int prefixCount(String[] words, String pref) {
        int res = 0;
        char[] pf = pref.toCharArray();
        for (String word : words) {
            if (word.length() < pf.length)
                continue;

            char[] wc = word.toCharArray();
            boolean isPf = true;
            for (int i = 0; i < pf.length; i++) {
                if (wc[i] != pf[i]) {
                    isPf = false;
                    break;
                }
            }
            res += isPf ? 1 : 0;
        }
        return res;
    }
}
