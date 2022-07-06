package leetcode._283;

public class MoveZeroes {
    // 双指针
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[idx++] = nums[i];
            }
        }
        for (; idx < n; idx++) {
            nums[idx] = 0;
        }
    }
}
