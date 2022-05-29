package contest.leetcode20220529;

import java.util.*;

/**
 * https://leetcode.cn/contest/weekly-contest-295/problems/steps-to-make-array-non-decreasing/
 */
public class StepsToMakeArrayNonDecreasing {
//    public int totalSteps(int[] nums) {
//        int n = nums.length;
//        Deque<Integer> stack = new ArrayDeque<>(n);
//        int redCnt = 0;
////        int reducedIdx = -1;
////        for (int i = 0; i < nums.length; i++) {
////            int num = nums[i];
////            if (stack.isEmpty() || num >= nums[stack.peek()]) {
////                stack.push(i);
////            } else {
////                if (i - reducedIdx > 1) {
////                    redCnt++;
////                }
////                reducedIdx = i;
////            }
////        }
//        boolean[] rems = new boolean[n];
//        Arrays.fill(rems, true);
//        for (int i = 1; i < n; i++) {
//            if (rems[i]) {
//                int preIdx = i - 1;
//                while (preIdx >= 0 && !rems[preIdx]) {
//                    preIdx--;
//                }
//                if (preIdx >= 0) {
//                    if (nums[i] >= preIdx) {
//
//                    }
//                }
//            }
//        }
//        System.out.println(stack);
//        return redCnt;
//    }

    public int totalSteps(int[] nums) {
        int n = nums.length;
        // 栈顶元素最小，第二位保存移除该位时所需步数
        Deque<int[]> stack = new ArrayDeque<>(n);
        int res = 0;
        for (int num : nums) {
            // 移除该位数所需步数
            int rmCnt = 0;
            while (!stack.isEmpty() && stack.peek()[0] <= num) {
                // 移除步数单调不减
                rmCnt = Math.max(rmCnt, stack.pop()[1]);
            }
            // 如果栈非空，表明还有元素比当前数大，所需步数 +1
            rmCnt += stack.isEmpty() ? 0 : 1;
            res = Math.max(res, rmCnt);
            stack.push(new int[] {num, rmCnt});
        }
        return res;
    }

    public static void main(String[] args) {
        StepsToMakeArrayNonDecreasing sm = new StepsToMakeArrayNonDecreasing();
        int[] nums = new int[] {10,1,2,3,4,5,6,1,2,3};
//        int[] nums = new int[] {5,3,4,4,7,3,6,11,8,5,11};
//        int[] nums = new int[] {4,5,7,7,13};
        System.out.println(sm.totalSteps(nums));
    }
}
