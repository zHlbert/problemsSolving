package leetcode._2367;

public class NumberOfArithmeticTriplets {
    public int arithmeticTriplets(int[] nums, int diff) {
        boolean[] occur = new boolean[210];
        int res = 0;
        for (int num : nums) {
            if (num >= diff + diff && occur[num - diff - diff] && occur[num - diff]) {
                res++;
            }
            occur[num] = true;
        }
        return res;
    }
}
