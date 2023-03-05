package leetcode._1653;

public class MinimumDeletionsToMakeStringBalanced {
    public int minimumDeletions(String s) {
        char[] sc = s.toCharArray();
        int n = sc.length;
        int[] ca = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ca[i + 1] = ca[i] + ('b' - sc[i]);
        }
        int res = n;
        // 计算 [0,i) 的b数量和 [i, n) 的a数量
        for (int i = 0; i <= n; i++) {
            int headB = i - ca[i];
            int tailA = ca[n] - ca[i];
            res = Math.min(res, headB + tailA);
        }
        return res;
    }

    public int minimumDeletions1(String s) {
        char[] sc = s.toCharArray();
        int rightA = 0, leftB = 0;
        for (char c : sc) {
            rightA += ('b' - c);
        }

        int res = rightA;
        for (char c : sc) {
            if (c == 'a') rightA--;
            else leftB++;
            res = Math.min(res, leftB + rightA);
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumDeletionsToMakeStringBalanced md = new MinimumDeletionsToMakeStringBalanced();
        System.out.println(md.minimumDeletions("aababbab"));
        System.out.println(md.minimumDeletions("bbaaaaabb"));
    }
}
