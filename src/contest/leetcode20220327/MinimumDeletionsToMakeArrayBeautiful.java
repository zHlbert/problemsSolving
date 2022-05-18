package contest.leetcode20220327;

/**
 * https://leetcode.cn/contest/weekly-contest-286/problems/minimum-deletions-to-make-array-beautiful/
 */
public class MinimumDeletionsToMakeArrayBeautiful {
    public int minDeletion(int[] nums) {
        int i = 0;
        int cnt = 0;
        int n = nums.length;
        while (i < n) {
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
                cnt++;
            }
            i += 2;
        }
        if ((n - cnt) % 2 == 1) {
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        MinimumDeletionsToMakeArrayBeautiful md = new MinimumDeletionsToMakeArrayBeautiful();
//        int[] nums = new int[] {1,1,2,2,3,3};
//        int[] nums = new int[] {1,1,2,3,5};
        int[] nums = new int[] {0,1,1,1,2,6};
        System.out.println(md.minDeletion(nums));
    }
}
