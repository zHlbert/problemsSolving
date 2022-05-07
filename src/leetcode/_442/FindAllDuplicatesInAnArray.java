package leetcode._442;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
 */
public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        boolean[] occur = new boolean[n + 2];
        List<Integer> duplicates = new ArrayList<>();
        for (int num : nums) {
            if (occur[num]) {
                duplicates.add(num);
            } else {
                occur[num] = true;
            }
        }
        return duplicates;
    }

    public List<Integer> findDuplicatesMark(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            // 原地哈希，nums[i] -> -nums[nums[i] - 1]
            int tmp = Math.abs(num);
            // 大于0，说明没出现过，取相反数
            // 小于0，说明num出现过，添加到结果
            if (nums[tmp - 1] > 0) {
                nums[tmp - 1] = -nums[tmp - 1];
            } else {
                res.add(tmp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindAllDuplicatesInAnArray fad = new FindAllDuplicatesInAnArray();
        int[] nums = new int[] {4,3,2,7,8,2,3,1};
        System.out.println(fad.findDuplicatesMark(nums));
    }
}
