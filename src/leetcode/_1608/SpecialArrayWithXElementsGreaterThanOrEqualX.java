package leetcode._1608;

import java.util.Arrays;

public class SpecialArrayWithXElementsGreaterThanOrEqualX {
    public int specialArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i <= n; i++) {
            int ceil = i == 0 ? Integer.MAX_VALUE : nums[n - i];
            int floor = i == n ? Integer.MIN_VALUE : nums[n - i - 1];
            if (ceil >= i && i > floor) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SpecialArrayWithXElementsGreaterThanOrEqualX sx = new SpecialArrayWithXElementsGreaterThanOrEqualX();
        System.out.println(sx.specialArray(new int[] {3,5}));
        System.out.println(sx.specialArray(new int[] {0,0}));
        System.out.println(sx.specialArray(new int[] {0,4,3,0,4}));
    }
}
