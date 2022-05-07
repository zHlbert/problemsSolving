package contest.leetcode20220320;

import java.util.ArrayList;
import java.util.List;

public class CountHillsAndValleysInAnArray {
    public int countHillValley(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] == nums[i - 1]) {
                nums[i] = 0;
            }
        }
        List<Integer> trimNums = new ArrayList<>(nums.length);
        for (int num : nums) {
            if (num != 0) {
                trimNums.add(num);
            }
        }
        int cnt = 0;
        for (int i = 1; i < trimNums.size() - 1; i++) {
            if (trimNums.get(i) > trimNums.get(i - 1) && trimNums.get(i) > trimNums.get(i + 1)) {
                cnt++;
            } else if (trimNums.get(i) < trimNums.get(i - 1) && trimNums.get(i) < trimNums.get(i + 1)) {
                cnt++;
            }
        }
        return cnt;
    }

    public int countHillValley2(int[] nums) {
        // flag = 1 表示下降，flag = 2 表示上升
        int flag = 0;
        int cnt = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                if (flag == 2) {
                    cnt++;
                }
                flag = 1;
            } else if (nums[i] < nums[i - 1]) {
                if (flag == 1) {
                    cnt++;
                }
                flag = 2;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        CountHillsAndValleysInAnArray c = new CountHillsAndValleysInAnArray();
        int[] nums = new int[] {6,6,5,5,4,1};
        System.out.println(c.countHillValley(nums));
    }
}
