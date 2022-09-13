package acwing._789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberRange {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nq = reader.readLine().split(" ");
        int n = Integer.parseInt(nq[0]);
        int q = Integer.parseInt(nq[1]);
        String[] strs = reader.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        int[] qs = new int[q];
        for (int i = 0; i < q; i++) {
            qs[i] = Integer.parseInt(reader.readLine());
        }
        for (int i = 0; i < q; i++) {
            int[] res = numberRange(nums, qs[i]);
            System.out.println(res[0] + " " + res[1]);
        }
    }

    /**
     * 二分
     * @param nums
     * @param q
     * @return
     */
    private static int[] numberRange(int[] nums, int q) {
        int[] res = new int[2];
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= q) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        res[0] = nums[l] == q ? l : -1;

        l = 0;
        r = nums.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= q) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        res[1] = nums[l] == q ? l : -1;
        return res;
    }
}
