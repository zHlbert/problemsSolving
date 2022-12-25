package leetcode._1759;

public class CountNumberOfHomogenousSubstrings {
    int mod = (int) (1e9 + 7);
    public int countHomogenous(String s) {
        char[] sc = s.toCharArray();
        int i = 0, n = sc.length;
        long res = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && sc[j] == sc[i]) {
                j++;
            }
            res = (res + (long) (j - i) * (j - i + 1) / 2) % mod;
            i = j;
        }
        return (int) res;
    }
}
