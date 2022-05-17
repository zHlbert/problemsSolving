package leetcode._128;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode.cn/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>(nums.length);
        for (int num : nums) {
            numSet.add(num);
        }

        int longestSeq = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int len = 1;
                int cur = num;
                while (numSet.contains(cur + 1)) {
                    cur++;
                    len++;
                }
                longestSeq = Math.max(longestSeq, len);
            }
        }
        return longestSeq;
    }
}
