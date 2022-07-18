package contest.leetcode20220717;

public class MaximumNumberOfPairsInArray {
    public int[] numberOfPairs(int[] nums) {
        int[] cnts = new int[101];
        for (int num : nums) {
            cnts[num]++;
        }
        int[] res = new int[2];
        for (int cnt : cnts) {
            res[0] += cnt / 2;
            res[1] += cnt % 2;
        }
        return res;
    }
}
