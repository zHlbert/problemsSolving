package leetcode._396;

public class RotateFunction {
//    public int maxRotateFunction(int[] nums) {
//        int maxVal = Integer.MIN_VALUE;
//        int length = nums.length;
//        for (int k = 0; k < length; k++) {
//            int val = 0;
//            for (int i = 1; i < length; i++) {
//                val += nums[(i + length - k) % length] * i;
//            }
//            maxVal = Math.max(maxVal, val);
//        }
//        return maxVal;
//    }

    public int maxRotateFunction(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int f = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            f += i * nums[i];
        }

        int maxF = f;
        for (int k = 1; k < len; k++) {
            f += sum - len * nums[len - k];
            maxF = Math.max(maxF, f);
        }
        return maxF;
    }

    public static void main(String[] args) {
        RotateFunction rf = new RotateFunction();
        int[] nums = new int[] {4,3,2,6};
        System.out.println(rf.maxRotateFunction(nums));
    }
}
