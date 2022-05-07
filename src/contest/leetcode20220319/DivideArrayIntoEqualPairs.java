package contest.leetcode20220319;

import java.util.HashSet;
import java.util.Set;

public class DivideArrayIntoEqualPairs {
    public boolean divideArray(int[] nums) {
        Set<Integer> numSet = new HashSet<>(nums.length);
        for (int num : nums) {
            if (!numSet.contains(num)) {
                numSet.add(num);
            } else {
                numSet.remove(num);
            }
        }
        return numSet.isEmpty();
    }

    public boolean divideArray2(int[] nums) {
        int[] freq = new int[505];
        for (int num : nums) {
            freq[num]++;
        }
        for (int i : freq) {
            if (i % 2 == 1) {
                return false;
            }
        }
        return true;
    }
}
