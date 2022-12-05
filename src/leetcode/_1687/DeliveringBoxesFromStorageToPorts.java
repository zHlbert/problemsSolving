package leetcode._1687;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/delivering-boxes-from-storage-to-ports/
 * 从仓库到码头运输箱子
 */
public class DeliveringBoxesFromStorageToPorts {
    /**
     * 动态规划 + 单调队列
     * 区间DP
     * https://leetcode.cn/problems/delivering-boxes-from-storage-to-ports/solution/cong-cang-ku-dao-ma-tou-yun-shu-xiang-zi-4uya/
     *
     * @param boxes
     * @param portsCount
     * @param maxBoxes
     * @param maxWeight
     * @return
     */
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.length, dp = 0;
        Deque<int[]> q = new ArrayDeque<>();
        int dif = 0, w = 0;
        for (int i = 1; i <= n; i++) {
            int cur = dp + 2;
            dif += i >= 2 && boxes[i - 1][0] != boxes[i - 2][0] ? 1 : 0;
            w += boxes[i - 1][1];
            while (!q.isEmpty() && q.peekLast()[1] + dif >= cur) {
                q.pollLast();
            }
            q.offerLast(new int[] {i, cur - dif, boxes[i - 1][1] - w});
            while (q.peekFirst()[0] <= i - maxBoxes || q.peekFirst()[2] + w > maxWeight) {
                q.pollFirst();
            }
            dp = q.peekFirst()[1] + dif;
        }
        return dp;
    }
}
