package leetcode._710;

import java.util.*;

/**
 * https://leetcode.cn/problems/random-pick-with-blacklist/
 */
public class RandomPickWithBlacklist {
    public static void main(String[] args) {
//        Solution1 solution = new Solution1(7, new int[] {2,3,5});
//        Solution1 solution = new Solution1(3, new int[] {0});
        Solution2 solution = new Solution2(4, new int[] {0,1});
        for (int i = 0; i < 100; i++) {
            System.out.println(solution.pick());
        }
    }
}

class Solution {
    Random random = new Random();
    int[] ans;
    int len;

    public Solution(int n, int[] blacklist) {
        int bl = blacklist.length;
        len = n - bl;
        ans = new int[len];
        Arrays.sort(blacklist);
        for (int i = 0, idx = 0, j = 0; i < n; i++) {
            if (j < bl && blacklist[j] == i) {
                j++;
            } else {
                ans[idx++] = i;
            }
        }
    }

    public int pick() {
        int i = random.nextInt(len);
        return ans[i];
    }
}

class Solution1 {
    Random random = new Random();
    int[] blacklist;
    Map<Integer, Integer> blackMap;
    int n, bl;

    public Solution1(int n, int[] blacklist) {
        this.n = n;
        this.bl = blacklist.length;
        Arrays.sort(blacklist);
        this.blacklist = blacklist;
        blackMap = new HashMap<>();
        for (int i = 0; i < bl; i++) {
            blackMap.put(blacklist[i], i);
        }
    }

    public int pick() {
        int num = random.nextInt(n);
        if (bl == 0 || !blackMap.containsKey(num)) {
            return num;
        }
        if (bl == 1) {
            int nb = random.nextInt(n - 1) + num + 1;
            return nb >= n ? nb - n : nb;
        }
        int idx = blackMap.get(num);
        for (int i = 1; i <= bl; i++) {
            boolean over = idx + i >= bl;
            int nb = blacklist[over ? idx + i - bl : idx + i];
            if (!over && nb - num > 1) {
                return random.nextInt(nb - num - 1) + num + 1;
            } else if (over && nb > 0) {
                return random.nextInt(nb);
            }
            num = nb;
        }

        return -1;
    }
}

class Solution2 {
    Random random = new Random();
    // 将 [ 0, n - m) 中黑名单数 映射到 [n - m, n) 中
    Map<Integer, Integer> b2w;
    int bound;

    public Solution2(int n, int[] blacklist) {
        int m = blacklist.length;
        bound = n - m;
        Set<Integer> black = new HashSet<>();
        for (int b : blacklist) {
            if (b >= bound) {
                black.add(b);
            }
        }
        b2w = new HashMap<>();
        int idx = bound;
        for (int b : blacklist) {
            if (b >= bound) {
                continue;
            }
            while (black.contains(idx)) {
                idx++;
            }
            b2w.put(b, idx++);
        }
    }

    public int pick() {
        int x = random.nextInt(bound);
        return b2w.getOrDefault(x, x);
    }
}
