package contest.leetcode20220319;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * You are given an array nums of positive integers. In one operation, you can choose any number from nums and reduce it to exactly half the number. (Note that you may choose this reduced number in future operations.)
 *
 * Return the minimum number of operations to reduce the sum of nums by at least half.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-operations-to-halve-array-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumOperationsToHalveArraySum {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> queue = new PriorityQueue<>(nums.length, Comparator.reverseOrder());
        double sum = 0.0;
        for (int num : nums) {
            queue.offer((double) num);
            sum += num;
        }

        double reducedSum = 0.0;
        int cnt = 0;
        while (2 * reducedSum < sum) {
            double poll = queue.poll();
            double half = poll / 2;
            reducedSum += half;
            queue.offer(half);
            cnt++;
        }
        return cnt;
    }
}
