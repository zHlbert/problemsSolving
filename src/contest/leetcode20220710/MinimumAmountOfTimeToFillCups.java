package contest.leetcode20220710;

import java.util.Arrays;

public class MinimumAmountOfTimeToFillCups {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int step = 0;
        while (amount[2] > 0) {
            amount[2]--;
            if (amount[1] > 0) {
                amount[1]--;
            }
            step++;
            Arrays.sort(amount);
        }
        return step;
    }


}
