package leetcode._1595;

import java.util.Arrays;
import java.util.List;

public class MinimumCostToConnectTwoGroupsOfPoints {
    /**
     * https://leetcode.cn/problems/minimum-cost-to-connect-two-groups-of-points/solution/lian-tong-liang-zu-dian-de-zui-xiao-chen-6qoj/
     * 状态压缩 + 动态规划
     * @param cost
     * @return
     */
    public int connectTwoGroups(List<List<Integer>> cost) {
        int sz1 = cost.size(), sz2 = cost.get(0).size(), m = 1 << sz2;
        int[][] dp = new int[sz1 + 1][m];
        for (int i = 0; i <= sz1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= sz1; i++) {
            for (int s = 0; s < m; s++) {
                for (int k = 0; k < sz2; k++) {
                    if ((s & (1 << k)) == 0) continue;
                    dp[i][s] = Math.min(dp[i][s], dp[i][s ^ (1 << k)] + cost.get(i - 1).get(k));
                    dp[i][s] = Math.min(dp[i][s], dp[i - 1][s] + cost.get(i - 1).get(k));
                    dp[i][s] = Math.min(dp[i][s], dp[i - 1][s ^ (1 << k)] + cost.get(i - 1).get(k));
                }
            }
        }
        return dp[sz1][m - 1];
    }
}
