package contest.leetcode20220319;

public class MaximizeNumberOfSubsequencesInAString {
    public long maximumSubsequenceCount(String text, String pattern) {
        long sum = 0;
        int fCnt = 0, bCnt = 0;
        for (char c : text.toCharArray()) {
            if (c == pattern.charAt(1)) {
                sum += fCnt;
                bCnt++;
            }
            if (c == pattern.charAt(0)) {
                fCnt++;
            }
        }
        return sum + Math.max(fCnt, bCnt);
    }
}
