package contest.leetcode20220417;

public class CalculateDigitSumOfAString {
    public String digitSum(String s, int k) {
        StringBuilder resBuilder = new StringBuilder(s);
        while (resBuilder.length() > k) {
            char[] chars = resBuilder.toString().toCharArray();
            StringBuilder tmpBuilder = new StringBuilder();
            for (int i = 0; i < chars.length; i += k) {
                int kSum = 0;
                for (int j = i; j < Math.min(i + k, chars.length); j++) {
                    kSum += chars[j] - '0';
                }
                tmpBuilder.append(kSum);
            }
            resBuilder = tmpBuilder;
        }
        return resBuilder.toString();
    }

    public static void main(String[] args) {
        CalculateDigitSumOfAString c = new CalculateDigitSumOfAString();
        String s = "00000000";
        int k = 3;
        System.out.println(c.digitSum(s, k));
    }
}
