package leetcode._908;

public class SmallestRangeI {
    public int smallestRangeI(int[] nums, int k) {
        int min = nums[0], max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return Math.max(0, max - min - k - k);
    }

    public static void main(String[] args) {
        SmallestRangeI sr = new SmallestRangeI();
        int[] nums = new int[] {1};
        int k = 0;
        System.out.println(sr.smallestRangeI(nums, k));
    }
}
