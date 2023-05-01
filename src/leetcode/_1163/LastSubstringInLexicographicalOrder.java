package leetcode._1163;

public class LastSubstringInLexicographicalOrder {
    /**
     * 双指针
     * @param s
     * @return
     */
    public String lastSubstring(String s) {
        char[] sc = s.toCharArray();
        int n = sc.length;
        int i = 0, j = 1;
        while (j < n) {
            int k = 0;
            while (j + k < n && sc[i + k] == sc[j + k]) {
                k++;
            }
            if (j + k < n && sc[i + k] < sc[j + k]) {
                int t = i;
                i = j;
                j = Math.max(j + 1, t + k + 1);
            } else {
                j = j + k + 1;
            }
        }
        return s.substring(i);
    }
}
