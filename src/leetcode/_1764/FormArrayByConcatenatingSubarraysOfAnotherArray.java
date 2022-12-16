package leetcode._1764;

/**
 * 通过连接另一个数组的子数组得到一个数组
 * https://leetcode.cn/problems/form-array-by-concatenating-subarrays-of-another-array/
 */
public class FormArrayByConcatenatingSubarraysOfAnotherArray {
    /**
     * 贪心 + 双指针
     * @param groups
     * @param nums
     * @return
     */
    public boolean canChoose(int[][] groups, int[] nums) {
        int n = nums.length, g = groups.length;
        for (int i = 0, j = 0, k = 0; i < n; i++) {
            if (j == g) {
                return true;
            }
            int i0 = i, k0 = k;
            while (i < n && k < groups[j].length && nums[i] == groups[j][k]) {
                i++;
                k++;
            }
            if (k == groups[j].length) {
                j++;
                if (j == g) {
                    return true;
                }
                k = 0;
                i--;
            } else if (i == n) {
                return false;
            } else {
                i = i0;
                k = k0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FormArrayByConcatenatingSubarraysOfAnotherArray fa = new FormArrayByConcatenatingSubarraysOfAnotherArray();
//        int[][] groups = new int[][] {{1,-1,-1},{3,-2,0}};
//        int[] nums = new int[] {1,-1,0,1,-1,-1,3,-2,0};
        int[][] groups = new int[][] {{10,-2},{1,2,3,4}};
        int[] nums = new int[] {1,2,3,4,10,-2};
//        int[][] groups = new int[][] {{1,2,3},{3,4}};
//        int[] nums = new int[] {7,7,1,2,3,4,7,7};
//        int[][] groups = new int[][] {{1,2,3},{3,4}};
//        int[] nums = new int[] {1,2,3,3,4,5};
//        int[][] groups = new int[][] {{-5,0}};
//        int[] nums = new int[] {2,0,-2,5,-1,2,4,3,4,-5,-5};
//        int[][] groups = new int[][] {{1,2}};
//        int[] nums = new int[] {1,3,2};
        System.out.println(fa.canChoose(groups, nums));
    }
}
