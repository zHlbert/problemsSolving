package contest.leetcode20220619;

public class LongestBinarySubsequenceLessThanOrEqualToK {
    public int longestSubsequence(String s, int k) {
        char[] chars = s.toCharArray();
        int i = chars.length - 1;
        int num = 1;
        for (; i >= 0 && num <= k; i--) {
            if (chars[i] == '1') {
                k -= num;
            }
            if (k < 0) {
                break;
            }
            num *= 2;
        }
        int leading1 = 0;
        for (; i >= 0; i--) {
            if (chars[i] == '1') {
                leading1++;
            }
        }
        return chars.length - leading1;
    }

    public static void main(String[] args) {
        LongestBinarySubsequenceLessThanOrEqualToK lbs = new LongestBinarySubsequenceLessThanOrEqualToK();
//        String s = "1001010";
//        int k = 5;
//        String s = "00101001";
//        int k = 1;
        String s = "101100011000010101011100011111111001011101000101000010001100101110010010011000100010001110011111000100100101110000100010010010100010";
        int k = 978095074;
//        "101100011000010101011100011111111001011101000101000010001100101110010010011000100010001110011111000100100101110000100010010010100010"
//        978095074
        System.out.println(lbs.longestSubsequence(s, k));
    }
}
