package contest.leetcode20210808;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * You want to build some obstacle courses. You are given a 0-indexed integer array obstacles of length n, where obstacles[i] describes the height of the ith obstacle.
 *
 * For every index i between 0 and n - 1 (inclusive), find the length of the longest obstacle course in obstacles such that:
 *
 * You choose any number of obstacles between 0 and i inclusive.
 * You must include the ith obstacle in the course.
 * You must put the chosen obstacles in the same order as they appear in obstacles.
 * Every obstacle (except the first) is taller than or the same height as the obstacle immediately before it.
 * Return an array ans of length n, where ans[i] is the length of the longest obstacle course for index i as described above.
 */
public class FindTheLongestValidObstacleCourseAtEachPosition {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int len = obstacles.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }
        List<Integer> obList = new ArrayList<>();
        obList.add(obstacles[0]);
        for (int i = 1; i < len; i++) {
            if (obstacles[i] >= obList.get(obList.size() - 1)) {
                obList.add(obstacles[i]);
                dp[i] = obList.size();
            } else {
                int left = 0, right = obList.size() - 1;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (obList.get(mid) <= obstacles[i])
                        left = mid + 1;
                    else
                        right = mid;
                }
                obList.set(left, obstacles[i]);
                dp[i] = left + 1;
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        FindTheLongestValidObstacleCourseAtEachPosition f = new FindTheLongestValidObstacleCourseAtEachPosition();
        int[] nums = new int[] {2,2,1};
        int[] ints = f.longestObstacleCourseAtEachPosition(nums);
        ArrayUtils.printArray(ints);
    }
}
