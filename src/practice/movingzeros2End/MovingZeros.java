package practice.movingzeros2End;

import utils.ArrayUtils;

public class MovingZeros {
    public void movingZeros(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                continue;
            }
            int j = i + 1;
            while (j < n && nums[j] == 0) {
                j++;
            }
            if (j == n) {
                break;
            }
            nums[i] = nums[j];
            nums[j] = 0;
        }
    }

    public static void main(String[] args) {
        MovingZeros mz = new MovingZeros();
        int[] nums = new int[] {0,0,1,-1,3,0,0,2,0,1,0};
        mz.movingZeros(nums);
        ArrayUtils.printArray(nums);
    }
}
