package contest.leetcode20220918;

public class LengthOfTheLongestAlphabeticalContinuousSubstring {
    public int longestContinuousSubstring(String s) {
        int res = 1, cur = 1;
        char[] sc = s.toCharArray();
        for (int i = 1; i < sc.length; i++) {
            if (sc[i] - sc[i - 1] == 1) {
                cur++;
            } else {
                res = Math.max(res, cur);
                cur = 1;
            }
        }
        res = Math.max(res, cur);
        return res;
    }

    public static void main(String[] args) {
        LengthOfTheLongestAlphabeticalContinuousSubstring ll = new LengthOfTheLongestAlphabeticalContinuousSubstring();
        System.out.println(ll.longestContinuousSubstring("abcde"));
    }
}
