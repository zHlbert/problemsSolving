package leetcode._1144;

public class DecreaseElementsToMakeArrayZigzag {
    public int movesToMakeZigzag(int[] nums) {
        if (nums.length == 1) return 0;
        int s0 = sum(nums, 0);
        int s1 = Math.max(nums[0] - nums[1] + 1, 0) + sum(nums, 1);
        return Math.min(s0, s1);
    }

    private int sum(int[] nums, int start) {
        int s = 0, n = nums.length;
        for (int i = start; i < n - 1; i += 2) {
            int right = i < n - 2 ? nums[i + 2] : nums[i];
            int mn = Math.min(nums[i], right);
            s += Math.max(0, nums[i + 1] - mn + 1);
        }
        return s;
    }

    public static void main(String[] args) {
        DecreaseElementsToMakeArrayZigzag de = new DecreaseElementsToMakeArrayZigzag();
        System.out.println(de.movesToMakeZigzag(new int[] {1,2,3}));
        System.out.println(de.movesToMakeZigzag(new int[] {9,6,1,6,2}));
        System.out.println(de.movesToMakeZigzag(new int[] {2,7,10,9,8,9}));
//        System.out.println(de.movesToMakeZigzag(new int[] {3,10,7,9,9,3,6,9,4}));
    }
}
