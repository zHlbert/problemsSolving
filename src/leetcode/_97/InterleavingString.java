package leetcode._97;

/**
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 *
 * An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 * Note: a + b is the concatenation of strings a and b.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/interleaving-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InterleavingString {
//    public boolean isInterleave(String s1, String s2, String s3) {
//        boolean interleave = true;
//        int i1 = 0, i2 = 0, i = 0;
//        while (i < s3.length()) {
//            boolean in1 = i1 < s1.length() && s3.charAt(i) == s1.charAt(i1);
//            boolean in2 = i2 < s2.length() && s3.charAt(i) == s2.charAt(i2);
//            if (!in1 && !in2) {
//                interleave = false;
//                break;
//            } else if (in1 && !in2) {
//                i1++;
//            } else if (!in1) {
//                i2++;
//            } else {
//
//            }
//            i++;
//        }
//        if (i1 < s1.length() || i2 < s2.length()) {
//            interleave = false;
//        }
//        return interleave;
//    }

    // 记忆化dfs
    String s1, s2, s3;
    int l1, l2, l3;
    boolean[][] visited;
    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        l1 = s1.length();
        l2 = s2.length();
        l3 = s3.length();
        if (l1 + l2 != l3) {
            return false;
        }
        visited = new boolean[l1 + 1][l2 + 1];
        return dfs(0, 0, 0);
    }

    private boolean dfs(int i, int j, int k) {
        if (k == l3) {
            return true;
        }
        if (visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (i < l1 && s1.charAt(i) == s3.charAt(k) && dfs(i + 1, j, k + 1))
            return true;
        return j < l2 && s2.charAt(j) == s3.charAt(k) && dfs(i, j + 1, k + 1);
    }

    // 动态规划
    // f(i,j) = (f(i-1,j) && s1[i-1] = s3[p]) || (f(i,j-1) && s2[j-1] = s3[p])
    // 其中 p = i + j - 1

    public boolean isInterleaveDP(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if (l1 + l2 != l3) {
            return false;
        }
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        dp[0][0] = true;
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                int p = i + j - 1;
                if (i > 0) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p);
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p);
                }
            }
        }
        return dp[l1][l2];
    }

//    private void dfs(int i1, int i2, int i3) {
//        if (i3 == s3.length() || (i1 == s1.length() && i2 == s2.length()) || interleave) {
//            interleave = (i3 == s3.length() && (i1 == s1.length() && i2 == s2.length())) || interleave;
//            return;
//        }
//        boolean in1 = i1 < s1.length() && s3.charAt(i3) == s1.charAt(i1);
//        boolean in2 = i2 < s2.length() && s3.charAt(i3) == s2.charAt(i2);
//        if (!in1 && !in2) {
//            dfs(i1, i2, i3 + 1);
//        } else if (in1 && !in2) {
//            i1++;
//            dfs(i1, i2, i3 + 1);
//            i1--;
//        } else if (!in1) {
//            i2++;
//            dfs(i1, i2, i3 + 1);
//            i2--;
//        } else {
//            i1++;
//            dfs(i1, i2, i3 + 1);
//            i1--;
//            i2++;
//            dfs(i1, i2, i3 + 1);
//            i2--;
//        }
//
//    }

    public static void main(String[] args) {
        InterleavingString in = new InterleavingString();
        System.out.println(in.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
