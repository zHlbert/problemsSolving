package leetcode._503;

import utils.ArrayUtils;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/next-greater-element-ii/
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> deque = new ArrayDeque<>(n);
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!deque.isEmpty() && num > nums[deque.peek()]) {
                int top = deque.pop();
                if (res[top] == -1) {
                    res[top] = num;
                }
            }
            deque.push(i % n);
        }
//        System.out.println(deque);
        return res;
    }

    public int[] nextGreaterElements1(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            while (!deque.isEmpty() && num > nums[deque.peek()]) {
                res[deque.pop()] = num;
            }
            deque.push(i);
        }
        if (!deque.isEmpty()) {
            for (int num : nums) {
                while (!deque.isEmpty() && num > nums[deque.peek()]) {
                    res[deque.pop()] = num;
                }
                if (deque.isEmpty()) {
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NextGreaterElementII nge = new NextGreaterElementII();
        int[] nums = new int[] {1,2,3,4,3};
        ArrayUtils.printArray(nge.nextGreaterElements1(nums));
    }
}
