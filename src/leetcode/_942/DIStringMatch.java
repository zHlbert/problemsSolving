package leetcode._942;


import utils.ArrayUtils;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/di-string-match/
 */
public class DIStringMatch {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] res = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            res[i] = i;
        }
        char[] chars = s.toCharArray();
        int i = 0;
        while (i < n) {
            int i0 = i;
            while (i < n && chars[i] == 'D') {
                i++;
            }
            reverse(res, i0, i + 1);
            i++;
        }
        return res;
    }

    private void reverse(int[] nums, int begin, int end) {
        for (int i = begin; i < (begin + end) >> 1; i++) {
            swap(nums, i, end - 1 + begin - i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        DIStringMatch dism = new DIStringMatch();
        String s = "IIIDDIDII";
        ArrayUtils.printArray(dism.diStringMatch(s));
    }
}
