package leetcode._1130;

public class MinimumCostTreeFromLeafValues {
    /**
     * 单调栈
     * @param arr
     * @return
     */
    public int mctFromLeafValues(int[] arr) {
        int[] stack = new int[50];
        int top = -1;
        int res = 0;
        for (int x : arr) {
            while (top > -1 && stack[top] <= x) {
                int y = stack[top--];
                if (top == -1 || stack[top] > x) res += y * x;
                else res += stack[top] * y;
            }
            stack[++top] = x;
        }
        while (top > 0) {
            int x = stack[top--];
            res += stack[top] * x;
        }
        return res;
    }
}
