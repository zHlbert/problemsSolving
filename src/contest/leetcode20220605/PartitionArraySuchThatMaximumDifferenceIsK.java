package contest.leetcode20220605;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/contest/weekly-contest-296/problems/partition-array-such-that-maximum-difference-is-k/
 */
public class PartitionArraySuchThatMaximumDifferenceIsK {
//    public int partitionArray(int[] nums, int k) {
//        List<int[]> intList = new ArrayList<>();
//        for (int num : nums) {
//            if (intList.isEmpty()) {
//                intList.add(new int[] {num, num});
//                continue;
//            }
//            int size = intList.size();
//            if (intList.get(size - 1)[0] + k < num) {
//                intList.add(new int[] {num, num});
//            } else {
//                for (int i = 0; i < size; i++) {
//                    int[] ints = intList.get(i);
//                    if (ints[1] - k > num) {
//                        intList.add(i, new int[] {num, num});
//                        break;
//                    } else if (ints[0] + k >= num && ints[1] - k <= num) {
//                        if (num > ints[1]) {
//                            ints[1] = num;
//                        } else if (num < ints[0]) {
//                            ints[0] = num;
//                        }
//                        break;
//                    }
//                }
//            }
//        }
//        return intList.size();
//    }

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 1, pre = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] - pre > k) {
                pre = nums[i];
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        PartitionArraySuchThatMaximumDifferenceIsK pa = new PartitionArraySuchThatMaximumDifferenceIsK();
//        int[] nums = new int[] {3,6,1,2,5};
//        int[] nums = new int[] {5,2,6,8,12,10};
//        int k = 2;
//        int[] nums = new int[] {1,2,3};
//        int k = 2;
//        int[] nums = new int[] {2,2,4,5};
//        int k = 0;
        int[] nums = new int[] {16,8,17,0,3,17,8,20};
        int k = 10;
        System.out.println(pa.partitionArray(nums, k));
    }
}
