package contest.leetcode20210619;

import java.util.*;

/**
 * 有 N 位扣友参加了微软与力扣举办了「以扣会友」线下活动。主办方提供了 2*N 道题目，整型数组 questions 中每个数字对应了每道题目所涉及的知识点类型。
 * 若每位扣友选择不同的一题，请返回被选的 N 道题目至少包含多少种知识点类型。
 */
public class CompleteHalfProblems {
    public int halfQuestions(int[] questions) {
        int doubleN = questions.length;
        int n = doubleN / 2;
        int[] buckets = new int[1005];
        for (int i = 0; i < doubleN; i++) {
            buckets[questions[i]] ++;
        }
        Map<Integer, Integer> countMap = new HashMap<>(1000005);
        int maxOcc = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] > 0) {
                if (!countMap.containsKey(buckets[i])) {
                    countMap.put(buckets[i], 0);
                }
                countMap.replace(buckets[i], countMap.get(buckets[i]) + 1);
                maxOcc = Math.max(maxOcc, buckets[i]);
            }
        }

        int totalOcc = 0;
        int num = 0;
        for (int i = maxOcc; i > 0; i--) {
            if (countMap.containsKey(i)) {
                if (countMap.get(i) * i + totalOcc >= n) {
                    num += Math.ceil(((double) (n - totalOcc)) / i);
                    return num;
                } else {
                    totalOcc += i * countMap.get(i);
                    num += countMap.get(i);
                }
            }
            if (totalOcc >= n) {
                return num;
            }
        }
        return num;
    }

    public int halfQuestions1(int[] questions) {
        int doubleN = questions.length;
        int n = doubleN / 2;
        int[] buckets = new int[1005];
        for (int i = 0; i < doubleN; i++) {
            buckets[questions[i]] ++;
        }
        Arrays.sort(buckets);
        int totalOcc = 0;
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (totalOcc >= n) {
                return buckets.length - 1 - i;
            }
            totalOcc += buckets[i];
        }
        return n;
    }

    public static void main(String[] args) {
        CompleteHalfProblems c = new CompleteHalfProblems();
        System.out.println(c.halfQuestions1(new int[] {13,8,3,7,5,6,11,12,3,6,6,11}));
    }
}
