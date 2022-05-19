package leetcode._75;

import utils.ArrayUtils;

/**
 * https://leetcode.cn/problems/sort-colors/
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int zeroCnt = 0, oneCnt = 0, twoCnt = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCnt++;
            } else if (num == 1) {
                oneCnt++;
            } else {
                twoCnt++;
            }
        }
        int i = 0;
        while (zeroCnt > 0) {
            if (nums[i] != 0) {
                nums[i] = 0;
            }
            zeroCnt--;
            i++;
        }
        while (oneCnt > 0) {
            if (nums[i] != 1) {
                nums[i] = 1;
            }
            oneCnt--;
            i++;
        }
        while (twoCnt > 0) {
            if (nums[i] != 2) {
                nums[i] = 2;
            }
            twoCnt--;
            i++;
        }
    }

    public void sortColorsArr(int[] nums) {
        int[] cnt = new int[3];
        for (int num : nums) {
            cnt[num]++;
        }
        int i = 0;
        for (int c = 0; c < 3; c++) {
            while (cnt[c] > 0) {
                if (nums[i] != c) {
                    nums[i] = c;
                }
                cnt[c]--;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        SortColors sc = new SortColors();
        int[] nums = new int[] {2,0,2,1,1,0};
//        int[] nums = new int[] {2,0,1};
        sc.sortColorsArr(nums);
        ArrayUtils.printArray(nums);
    }
}
