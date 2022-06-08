package leetcode._448;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/
 */
public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            int abs = Math.abs(num);
            int idx = nums[abs - 1];
            if (idx > 0) {
                nums[abs - 1] = -nums[abs - 1];
            }
        }

//        ArrayUtils.printArray(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindAllNumbersDisappearedInAnArray fan = new FindAllNumbersDisappearedInAnArray();
        int[] nums = new int[] {4,3,2,7,8,2,3,1};
//        int[] nums = new int[] {1,1};
        System.out.println(fan.findDisappearedNumbers(nums));
    }
}
