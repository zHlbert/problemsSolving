package leetcode._1813;

public class SentenceSimilarityIII {
    /**
     * 双指针
     * @param sentence1
     * @param sentence2
     * @return
     */
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.equals(sentence2)) return true;
        String[] sc1 = sentence1.split(" "), sc2 = sentence2.split(" ");
        if (sc1.length == sc2.length) return false;
        return sc1.length < sc2.length ? similar(sc1, sc2) : similar(sc2, sc1);
    }

    /**
     * 获取 最长公共前缀 和 最长公共后缀
     * @param ss
     * @param ll
     * @return
     */
    private boolean similar(String[] ss, String[] ll) {
        int l = 0;
        int n = ss.length;
        for (int i = 0; i < n && ss[i].equals(ll[i]); i++) {
            l++;
        }
        if (l == n) return true;
        int r = 0;
        for (int i = n - 1, j = ll.length - 1; i >= 0 && ss[i].equals(ll[j]); i--, j--) {
            r ++;
        }
        return r + l >= n;
    }
}
