package contest.leetcode20220327;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/contest/weekly-contest-286/problems/find-palindrome-with-fixed-length/
 */
public class FindPalindromeWithFixedLength {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int pow = (intLength - 1) / 2;
        int base = 1;
        for (int i = 0; i < pow; i++) {
            base *= 10;
        }
        int num = base * 9;
        int len = queries.length;
        long[] res = new long[len];
        for (int i = 0; i < len; i++) {
            if (queries[i] > num) {
                res[i] = -1;
            } else {
                int preHalf = base + queries[i] - 1;
                long cur = getFull(preHalf, intLength);
                res[i] = cur;
            }
        }
        return res;
    }

    private long getFull(int preHalf, int intLength) {
        int cur = preHalf;
        long res = 0;
        List<Integer> nums = new ArrayList<>();
        while (cur > 0) {
            nums.add(cur % 10);
            cur /= 10;
        }
        int start = (intLength % 2 == 1) ? 1 : 0;
        for (int i = nums.size() - 1; i >= start; i--) {
            res *= 10;
            res += nums.get(i);
        }
        for (int num : nums) {
            res *= 10;
            res += num;
        }
        return res;
    }

    public static void main(String[] args) {
        FindPalindromeWithFixedLength fp = new FindPalindromeWithFixedLength();
        int[] queries = new int[] {2,4,6,10};
        int intLength = 1;
        long[] res = fp.kthPalindrome(queries, intLength);
        for (long re : res) {
            System.out.print(re + " ");
        }
        System.out.println();
    }
}
