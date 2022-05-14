package leetcode._11;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/container-with-most-water/
 */
public class ContainerWithMostWater {
//    public int maxArea(int[] height) {
//        int maxVolume = 0;
//        int n = height.length;
//        Deque<Integer> deque = new ArrayDeque<>(n);
//        deque.push(0);
//        for (int i = 1; i < n; i++) {
//            if (!deque.isEmpty() && height[i] > height[deque.peek()]) {
//                int top = deque.pop();
//                maxVolume = Math.max(maxVolume, height[top] * (i - top));
//                deque.push(i);
//            } else if (!deque.isEmpty() && height[i] <= height[deque.peek()]) {
//                int top = deque.peek();
//                maxVolume = Math.max(maxVolume, height[i] * (i - top));
//            }
//        }
//        return maxVolume;
//    }

    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int maxVolume = 0;
        while (left < right) {
            int width = right - left;
            int min = Math.min(height[left], height[right]);
            maxVolume = Math.max(maxVolume, min * width);
            while (height[left] <= min && left < right) {
                left++;
            }
            while (height[right] <= min && left < right) {
                right--;
            }
        }
        return maxVolume;
    }

    public static void main(String[] args) {
        ContainerWithMostWater cmw = new ContainerWithMostWater();
//        int[] height = new int[] {1,8,6,2,5,4,8,3,7};
//        int[] height = new int[] {1,1};
        int[] height = new int[] {1,2,1};
        System.out.println(cmw.maxArea(height));
    }
}
