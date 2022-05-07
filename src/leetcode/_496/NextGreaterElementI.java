package leetcode._496;

import utils.ArrayUtils;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/next-greater-element-i/
 */
public class NextGreaterElementI {
    // 单调栈
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        // nums1数组值与下标关系
        Map<Integer, Integer> val2Idx = new HashMap<>(n1);
        for (int i = 0; i < n1; i++) {
            val2Idx.put(nums1[i], i);
        }
        int[] result = new int[n1];
        Arrays.fill(result, -1);
        int n2 = nums2.length;

        // 单调栈 保存数组值
        Deque<Integer> deque = new ArrayDeque<>(n2);
        deque.push(nums2[0]);
        for (int i = 1; i < n2; i++) {
            int cur = nums2[i];
            // 保持栈顶到栈底是递增的
            while (!deque.isEmpty() && cur > deque.peek()) {
                int top = deque.pop();
                if (val2Idx.containsKey(top)) {
                    result[val2Idx.get(top)] = cur;
                }
            }
            deque.push(cur);
        }
        return result;
    }

    public static void main(String[] args) {
        NextGreaterElementI nge = new NextGreaterElementI();
//        int[] nums1 = new int[] {4,1,2};
        int[] nums1 = new int[] {2,4};
//        int[] nums2 = new int[] {1,3,4,2};
        int[] nums2 = new int[] {1,2,3,4};
        ArrayUtils.printArray(nge.nextGreaterElement(nums1, nums2));
    }
}
