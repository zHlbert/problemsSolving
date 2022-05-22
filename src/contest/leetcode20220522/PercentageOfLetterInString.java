package contest.leetcode20220522;

public class PercentageOfLetterInString {
    public int percentageLetter(String s, char letter) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int cnt = 0;
        for (char aChar : chars) {
            if (aChar == letter) {
                cnt++;
            }
        }
        return cnt * 100 / n;
    }
}
