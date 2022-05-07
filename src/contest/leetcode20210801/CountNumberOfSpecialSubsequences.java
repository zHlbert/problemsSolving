package contest.leetcode20210801;

import java.util.*;

/**
 * A sequence is special if it consists of a positive number of 0s, followed by a positive number of 1s, then a positive number of 2s.
 *
 * For example, [0,1,2] and [0,0,1,1,1,2] are special.
 * In contrast, [2,1,0], [1], and [0,1,2,0] are not special.
 * Given an array nums (consisting of only integers 0, 1, and 2), return the number of different subsequences that are special. Since the answer may be very large, return it modulo 109 + 7.
 *
 * A subsequence of an array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements. Two subsequences are different if the set of indices chosen are different.
 */
public class CountNumberOfSpecialSubsequences {
    int mod = 1000000007;
    int count = 0;
    Deque<Integer> seq = new ArrayDeque<>();
    static List<List<Integer>> res = new ArrayList<>();
    public int countSpecialSubsequences(int[] nums) {
        backtrack(nums, 0);
        return count;
    }

    private void backtrack(int[] nums, int i) {
        if (seq.size() >= 3 && seq.peekLast() == 2) {
            count = (count + 1) % mod;
            res.add(new ArrayList<>(seq));
//            return;
        }
        if (i == nums.length) {
            return;
        }
        while (i < nums.length) {
             if (seq.isEmpty() && nums[i] == 0
                    || (!seq.isEmpty() && (nums[i] == seq.peekLast() || nums[i] == seq.peekLast() + 1))) {
                seq.offerLast(nums[i]);
                backtrack(nums, i + 1);
                seq.pollLast();
            }
            i++;
        }
    }

    public int countSpecialSubsequencesDP(int[] nums) {
        int A = 0, B = 0, C = 0;
        for (int num : nums) {
            if (num == 0) {
                A = (2 * A + 1) % mod;
            } else if (num == 1) {
                B = (2 * B % mod + A) % mod;
            } else if (num == 2) {
                C = (2 * C % mod + B) % mod;
            }
        }
        return C;
    }

    public static void main(String[] args) {
//        int[] nums = new int[] {0,1,2,0,1,2};
        int[] nums = new int[] {0,1,2,2};
//        int[] nums = new int[] {2,0,0,1,2,0,2,1,2,2,2,2,2,2,1,0,2,0,2,2,1,1,2,1,1,0,1,0,2,1,2,0,1,2,1,2,0,0,2,0,2,1,0,0,0,1,1,0,1,2,1,2,2,0,1,2,0,0,1,2,1,1,2,0,1,2,1,0,1,0,1,1,2,0,0,0,1,1,1,2,1,0,0,0,0,2,2,1,1,1,2,1,2,0,1,0,0,1,0,1,1,0,0,1,1,1,1,1,0,2,1,1,0,0,2,0,2,2,1,0,2,2,2,0,0,1,2,1,1,2,1,2,1,1,1,1,2,0,2,0,1,0,2,0,2,0,0,1,2,1,1,0,2,0,1,0,2,1,1,0,0,1,1,0,1,0,2,1,2,0,0,0,1,1,1,1,1,1,2,2,0,2,2,2,1,0,0,0,1,1,0,2,1,1,2,1,0,1,0,0,2,1,0,2,1,1,1,0,2,2,2,1,1,0,2,1,0,1,0,0,2,1,2,0,0,2,1,1,0,1,1,1,1,1,1,2,1,2,1,1,0,0,2,0,1,0,0,0,2,1,1,2,1,1,0,0,2,0,1,2,1,1,1,0,2,1,1,0,0,1,2,1,1,1,2,0,1,0,2,2,2,2,0,2,2,2,2,0,1,0,2,1,1,2,1,2,1,2,2,1,2,0,2,2,0,0,2,0,1,2,2,2,2,0,1,1,0,0,1,2,0,2,2,1,1,1,0,1,1,0,1,1,2,0,2,0,1,1,0,0,2,0,2,1,2,1,1,0,0,2,2,1,0,0,0,0,0,1,2,0,0,0,1,1,1,1,2,0,1,1,0,0,0,1,0,2,1,0,2,0,1,0,2,0,1,1,2,2,0,1,0,0,2,1,1,2,1,1,2,2,0,1,2,0,2,2,0,0,2,0,0,2,2,2,2,2,0,1,2,0,1,0,1,1,0,1,1,2,1,0,1,2,1,2,1,1,1,2,2,1,0,1,1,2,2,2,0,0,1,2,1,2,2,1,1,0,2,2,2,2,2,1,1,2,2,2,0,0,0,2,2,0,1,1,1,1,0,1,0,0,1,2,0};
        CountNumberOfSpecialSubsequences c = new CountNumberOfSpecialSubsequences();
        System.out.println(c.countSpecialSubsequencesDP(nums));
//        System.out.println(res);
    }
}
