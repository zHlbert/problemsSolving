package leetcode._719;

import java.util.Arrays;
import java.util.Random;

/**
 * https://leetcode.cn/problems/find-k-th-smallest-pair-distance/
 */
public class FindKthSmallestPairDistance {
    Random random = new Random();
    public int smallestDistancePairQSelection(int[] nums, int k) {
        int n = nums.length;
        int pairN = (n * (n - 1)) >> 1;
        int[] pairs = new int[pairN];
        int idx = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                pairs[idx++] = Math.abs(nums[i] - nums[j]);
            }
        }
        return quickSelection(pairs, 0, pairs.length - 1, k - 1);
    }

    private int quickSelection(int[] nums, int l, int r, int index) {
        int q = randomPartition(nums, l, r);
        if (q == index) {
            return nums[index];
        }
        return q < index ? quickSelection(nums, q + 1, r, index) : quickSelection(nums, l, q - 1, index);
    }

    private int randomPartition(int[] nums, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(nums, i, r);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int x = nums[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (nums[j] <= x) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, ++i, r);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        FindKthSmallestPairDistance fks = new FindKthSmallestPairDistance();
        int[] nums = new int[] {1,3,1};
        int k = 3;
        System.out.println(fks.smallestDistancePairSortBinarySearchTwoPointers(nums, k));
    }

    public int smallestDistancePairSorting(int[] nums, int k) {
        int n = nums.length;
        int pairN = (n * (n - 1)) >> 1;
        int[] pairs = new int[pairN];
        int idx = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                pairs[idx++] = Math.abs(nums[i] - nums[j]);
            }
        }
        Arrays.sort(pairs);
        return pairs[k - 1];
    }

    public int smallestDistancePairSortBinarySearchTwoPointers(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, l = 0, r = nums[n - 1] - nums[0];
        while (l <= r) {
            int mid = (l + r) >> 1;
            // 找出有多少个差值小于等于mid的pair
            int cnt = 0;
            for (int i = 0, j = 0; i < n; i++) {
                while (nums[i] - nums[j] > mid) {
                    j++;
                }
                cnt += i - j;
            }
            if (cnt >= k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
