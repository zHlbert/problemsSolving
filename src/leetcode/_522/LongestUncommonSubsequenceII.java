package leetcode._522;

/**
 * https://leetcode.cn/problems/longest-uncommon-subsequence-ii/
 */
public class LongestUncommonSubsequenceII {
    public int findLUSlength(String[] strs) {
        int n = strs.length, res = -1;
        // 如果字符串s的子序列t是特殊序列，那么s就是特殊序列，并且至少比t长
        // 如果字符串t不是特殊序列，那么t是某个字符串s的子序列
        // 所以只用考虑整个字符串 是否为 其他字符串 的子串
        for (int i = 0; i < n; i++) {
            boolean unCommon = true;
            for (int j = 0; j < n; j++) {
                if (i != j && isSub(strs[i], strs[j])) {
                    unCommon = false;
                    break;
                }
            }
            // 如果 strs[i] 不是所有其他元素的子序列，则 strs[i] 为一个特殊序列
            if (unCommon) {
                res = Math.max(res, strs[i].length());
            }
        }
        return res;
    }

    /**
     * 判断 str1 是否是 str2 的子序列
     * @param str1
     * @param str2
     * @return
     */
    private boolean isSub(String str1, String str2) {
        int i = 0, j = 0, n = str1.length(), m = str2.length();
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        while (i < n && j < m) {
            if (chars1[i] == chars2[j]) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    public static void main(String[] args) {
        LongestUncommonSubsequenceII lus = new LongestUncommonSubsequenceII();
//        String[] strs = new String[] {"aba","cdc","eae"};
        String[] strs = new String[] {"aaa","aaa","aa"};
        System.out.println(lus.findLUSlength(strs));
    }
}
