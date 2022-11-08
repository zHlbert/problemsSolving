package leetcode._421;

/**
 * 数组中两个数的最大异或值
 * https://leetcode.cn/problems/maximum-xor-of-two-numbers-in-an-array/
 */
public class MaximumXOROfTwoNumbersInAnArray {
    int[][] trie;

    int idx = 0;

    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        trie = new int[31 * n + 10][2];

        for (int x : nums) {
            insert(x);
        }

        int res = 0;
        for (int x : nums) {
            res = Math.max(res, search(x));
        }
        return res;
    }

    public void insert(int x) {
        int p = 0;
        for (int i = 30; i >= 0; i--) {
            int s = x >> i & 1;
            if (trie[p][s] == 0) {
                trie[p][s] = ++idx;
            }
            p = trie[p][s];
        }
    }

    public int search(int x) {
        int p = 0, res = 0;
        for (int i = 30; i >= 0; i--) {
            int s = x >> i & 1;
            if (trie[p][s ^ 1] != 0) {
                res |= 1 << i;
                p = trie[p][s ^ 1];
            } else {
                p = trie[p][s];
            }
        }
        return res;
    }
}
