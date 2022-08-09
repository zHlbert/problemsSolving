package leetcode._1413;

public class MinimumValueToGetPositiveStepByStepSum {
    public int minStartValue(int[] nums) {
        int min = 0;
        int cur = 0;
        for (int num : nums) {
            cur += num;
            if (cur < 0) {
                min = Math.min(min, cur);
            }
        }
        return 1 - min;
    }
}
