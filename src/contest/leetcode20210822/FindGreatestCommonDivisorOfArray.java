package contest.leetcode20210822;

import java.util.Arrays;

public class FindGreatestCommonDivisorOfArray {
    public int findGCD(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int largest = 0;
        for (int num : nums) {
            if (num < smallest) {
                smallest = num;
            }
            if (num > largest) {
                largest = num;
            }
        }
        int maxGcd = 0;
        for (int i = smallest; i >= 1; i--) {
            if (smallest % i == 0 && largest % i == 0) {
                maxGcd = i;
                break;
            }
        }
        return maxGcd;
    }

    public static void main(String[] args) {
        FindGreatestCommonDivisorOfArray f = new FindGreatestCommonDivisorOfArray();
        System.out.println(f.findGCD(new int[] {3,3}));
    }
}
