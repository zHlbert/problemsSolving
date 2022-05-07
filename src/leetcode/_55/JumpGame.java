package leetcode._55;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int curr = 0;
        while (true) {
            int max = curr;
            int maxI = curr;
            for (int step = nums[curr]; step > 0; step--) {
                int next = step + curr;
                if (next >= len - 1) {
                    return true;
                }
                if (nums[next] + next > max) {
                    max = nums[next] + next;
                    maxI = next;
                }
            }
            if (maxI >= len - 1) {
                return true;
            }
            if (max == curr) {
                return false;
            }
            curr = maxI;
        }
    }

    public boolean canJump1(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return true;
        }
        int cover = nums[0];
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, nums[i] + i);
            if (cover >= len - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JumpGame j = new JumpGame();
        int[] nums = new int[] {4,2,0,0,1,1,4,4,4,0,4,0};
        System.out.println(j.canJump1(nums));
    }
}
