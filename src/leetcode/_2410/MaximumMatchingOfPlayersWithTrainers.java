package leetcode._2410;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/maximum-matching-of-players-with-trainers/
 */
public class MaximumMatchingOfPlayersWithTrainers {
    /**
     * 排序 + 双指针 + 贪心
     * @param players
     * @param trainers
     * @return
     */
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int cnt = 0;
        int m = trainers.length;
        for (int i = 0, j = 0; i < players.length; i++, j++) {
            while (j < m && trainers[j] < players[i]) {
                j++;
            }
            if (j >= m) {
                return cnt;
            }
            cnt++;
        }
        return cnt;
    }
}
