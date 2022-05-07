package contest.leetcode20210724;

import java.util.Stack;

/**
 * There are n people standing in a queue, and they numbered from 0 to n - 1 in left to right order. You are given an array heights of distinct integers where heights[i] represents the height of the ith person.
 *
 * A person can see another person to their right in the queue if everybody in between is shorter than both of them. More formally, the ith person can see the jth person if i < j and min(heights[i], heights[j]) > max(heights[i+1], heights[i+2], ..., heights[j-1]).
 *
 * Return an array answer of length n where answer[i] is the number of people the ith person can see to their right in the queue.
 */
public class NumberOfVisiblePeopleInAQueue {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[][] highest = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            highest[i][i] = heights[i];
            highest[i][i + 1] = Math.max(heights[i], heights[i + 1]);
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 2; j < n; j++) {
                highest[i][j] = Math.max(heights[j], highest[i][j - 1]);
            }
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.min(heights[i], heights[j]) > highest[i + 1][j - 1]) {
                    res[i]++;
                }
            }
        }
        return res;
    }

    public int[] canSeePersonsCountStack(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.empty() && heights[stack.peek()] < heights[i]) {
                stack.pop();
                res[i]++;
            }
            if (!stack.empty()) {
                res[i]++;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOfVisiblePeopleInAQueue nu = new NumberOfVisiblePeopleInAQueue();
        int[] res = nu.canSeePersonsCountStack(new int[] {5,1,2,3,10});
        for (int re : res) {
            System.out.print(re + " ");
        }
        System.out.println();
    }
}
