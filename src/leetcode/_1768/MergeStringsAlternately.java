package leetcode._1768;

public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        int m = c1.length, n = c2.length, k = 0;
        char[] res = new char[m + n];
        int mm = Math.min(m, n);
        for (int i = 0; i < mm; i++) {
            res[k++] = c1[i];
            res[k++] = c2[i];
        }
        for (int i = mm; i < m; i++) {
            res[k++] = c1[i];
        }
        for (int i = mm; i < n; i++) {
            res[k++] = c2[i];
        }
        return new String(res);
    }

    public String mergeAlternately1(String word1, String word2) {
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        int m = c1.length, n = c2.length;
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < m || j < n) {
            if (i < m) {
                sb.append(c1[i++]);
            }
            if (j < n) {
                sb.append(c2[j++]);
            }
        }
        return sb.toString();
    }
}
