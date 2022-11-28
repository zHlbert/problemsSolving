package leetcode._1758;

public class MinimumChangesToMakeAlternatingBinaryString {
    public int minOperations(String s) {
        char[] sc = s.toCharArray();
        int res0 = 0, res1 = 0;
        boolean odd = false;
        for (char c : sc) {
            boolean b = c == (odd ? '1' : '0');
            res0 += b ? 0 : 1;
            res1 += b ? 1 : 0;
            odd = !odd;
        }
        return Math.min(res0, res1);
    }
}
