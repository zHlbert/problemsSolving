package leetcode._768;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/max-chunks-to-make-sorted-ii/
 */
public class MaxChunksToMakeSortedII {
//    public int maxChunksToSorted(int[] arr) {
//        int mx = 0, preMx = -1;
//        int res = 1;
//        int n = arr.length;
//        for (int i = 0; i < n; i++) {
//            if (i > 0) {
//                if (arr[i] >= mx) {
//                    res++;
//                    preMx = mx;
//                } else if (preMx != -1 && arr[i] < preMx) {
//                    return 1;
//                }
//            }
//            mx = Math.max(mx, arr[i]);
//        }
//        return res;
//    }

    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int a : arr) {
            if (stack.isEmpty() || a >= stack.peek()) {
                stack.push(a);
            } else {
                int mx = stack.pop();
                while (!stack.isEmpty() && stack.peek() > a) {
                    stack.pop();
                }
                stack.push(mx);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        MaxChunksToMakeSortedII mc = new MaxChunksToMakeSortedII();
//        int[] arr = new int[] {5,4,3,2,1};
//        int[] arr = new int[] {2,1,3,4,4};
        int[] arr = new int[] {3,2,1,5,4,7,6,0};
        System.out.println(mc.maxChunksToSorted(arr));
    }
}
