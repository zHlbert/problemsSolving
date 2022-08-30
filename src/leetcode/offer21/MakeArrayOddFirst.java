package leetcode.offer21;

public class MakeArrayOddFirst {
    public int[] exchange(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int i = 0, j = n - 1;
        for (int num : nums) {
            if ((num & 1) == 1) {
                res[i++] = num;
            } else {
                res[j--] = num;
            }
        }
        return res;
    }

    public int[] exchange1(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            while (l < r && nums[l] % 2 == 1) {
                l++;
            }
            while (l < r && nums[r] % 2 == 0) {
                r--;
            }
            if (l < r) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
                l++;
                r--;
            }
        }
        return nums;
    }
}
