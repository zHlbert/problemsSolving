package contest.leetcode20210725;

import utils.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * There is a survey that consists of n questions where each question's answer is either 0 (no) or 1 (yes).
 *
 * The survey was given to m students numbered from 0 to m - 1 and m mentors numbered from 0 to m - 1. The answers of the students are represented by a 2D integer array students where students[i] is an integer array that contains the answers of the ith student (0-indexed). The answers of the mentors are represented by a 2D integer array mentors where mentors[j] is an integer array that contains the answers of the jth mentor (0-indexed).
 *
 * Each student will be assigned to one mentor, and each mentor will have one student assigned to them. The compatibility score of a student-mentor pair is the number of answers that are the same for both the student and the mentor.
 *
 * For example, if the student's answers were [1, 0, 1] and the mentor's answers were [0, 0, 1], then their compatibility score is 2 because only the second and the third answers are the same.
 * You are tasked with finding the optimal student-mentor pairings to maximize the sum of the compatibility scores.
 *
 * Given students and mentors, return the maximum compatibility score sum that can be achieved.
 */
public class MaximumCompatibilityScoreSum {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length;
        int n = students[0].length;
        Map<Integer, Integer> used = new HashMap<>();
        Map<Integer, Integer> usedR = new HashMap<>();
        int totalScore = 0;
        for (int i = 0; i < m; i++) {
            if (used.containsKey(i))
                continue;
            int maxScore = 0;
            for (int j = 0; j < m; j++) {
                if (usedR.containsKey(i) && usedR.get(i) == j)
                    continue;
                int score = 0;
                for (int k = 0; k < n; k++) {
                    if (students[i][k] == mentors[j][k]) {
                        score++;
                    }
                }
                if (score > maxScore ) {
                    maxScore = score;
                    used.put(i, j);
                    usedR.put(j, i);
                }
            }
            totalScore += maxScore;
        }
        return totalScore;
    }

    int[] permutions = new int[10];
    public int maxCompatibilitySumPermutation(int[][] students, int[][] mentors) {
        int m = students.length;
        int n = students[0].length;
        for (int i = 0; i < m; i++) {
            permutions[i] = i;
        }
        int result = 0;
        do {
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (students[i][j] == mentors[permutions[i]][j]) {
                        count++;
                    }
                }
            }
            result = Math.max(result, count);
        } while (ArrayUtils.nextPermutation(permutions, 0, m));
        return result;
    }

    /*
    * [[1,1,0],[1,0,1],[0,0,1]]
    * [[1,0,0],[0,0,1],[1,1,0]]
    *
    * [[0,1,0,1,1,1],[1,0,0,1,0,1],[1,0,1,1,0,0]]
    * [[1,0,0,0,0,1],[0,1,0,0,1,1],[0,1,0,0,1,1]]
    *
    * [[1,1,0,1,0],[1,0,1,0,0],[0,1,0,0,0],[1,1,0,1,0]]
    * [[0,1,1,1,0],[1,0,0,0,1],[0,0,1,1,0],[1,1,0,0,0]]
    * */

    public static void main(String[] args) {
        MaximumCompatibilityScoreSum m = new MaximumCompatibilityScoreSum();
        int[][] stu = new int[][] {{0,1,0,1,1,1},{1,0,0,1,0,1},{1,0,1,1,0,0}};
        int[][] men = new int[][] {{1,0,0,0,0,1},{0,1,0,0,1,1},{0,1,0,0,1,1}};
        System.out.println(m.maxCompatibilitySumPermutation(stu, men));
    }
}
