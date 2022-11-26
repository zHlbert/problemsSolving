package leetcode._1752;

import java.util.Arrays;

public class CheckIfArrayIsSortedAndRotated {
    public boolean check(int[] nums) {
        int n = nums.length, front = nums[0];
        boolean rotated = false;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                if (rotated || nums[i] > front) {
                    return false;
                }
                rotated = true;
            }
            if (rotated && nums[i] > front) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckIfArrayIsSortedAndRotated ca = new CheckIfArrayIsSortedAndRotated();
        System.out.println(ca.check(new int[] {2,1,3,4}));
        System.out.println(ca.check(new int[] {1,2,3,4}));
        System.out.println(ca.check(new int[] {4,1,2,3}));
        System.out.println(ca.check(new int[] {4,1,3,2}));
        System.out.println(ca.check(new int[] {4,1,3,3}));
        System.out.println(ca.check(new int[] {4,1,3,5}));
        System.out.println(ca.check(new int[] {1,2,3,2}));
        System.out.println(ca.check(new int[] {1,2,3,3}));
        System.out.println(ca.check(new int[] {5,6,7,7,4}));
    }
}
