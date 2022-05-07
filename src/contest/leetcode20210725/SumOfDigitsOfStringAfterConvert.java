package contest.leetcode20210725;

/**
 * You are given a string s consisting of lowercase English letters, and an integer k.
 *
 * First, convert s into an integer by replacing each letter with its position in the alphabet (i.e., replace 'a' with 1, 'b' with 2, ..., 'z' with 26). Then, transform the integer by replacing it with the sum of its digits. Repeat the transform operation k times in total.
 *
 * For example, if s = "zbax" and k = 2, then the resulting integer would be 8 by the following operations:
 *
 * Convert: "zbax" ➝ "(26)(2)(1)(24)" ➝ "262124" ➝ 262124
 * Transform #1: 262124 ➝ 2 + 6 + 2 + 1 + 2 + 4 ➝ 17
 * Transform #2: 17 ➝ 1 + 7 ➝ 8
 * Return the resulting integer after performing the operations described above.
 */
public class SumOfDigitsOfStringAfterConvert {
    public int getLucky(String s, int k) {
        StringBuilder sb  = new StringBuilder();
        char[] chArr = s.toCharArray();
        for (char c : chArr) {
            sb.append((c - 'a') + 1);
        }
        String str = sb.toString();
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum = 0;
            for (char c : str.toCharArray()) {
                sum += c - '0';
            }
            str = String.valueOf(sum);
        }
        return sum;
    }
}
