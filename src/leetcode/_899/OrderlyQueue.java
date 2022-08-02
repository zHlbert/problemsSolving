package leetcode._899;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/orderly-queue/
 */
public class OrderlyQueue {
//    public String orderlyQueue(String s, int k) {
//        int n = s.length();
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < k; j++) {
//                char c = s.charAt(j);
//                boolean hasSmaller = false;
//                for (int l = j + 1; l < n; l++) {
//                    if (s.charAt(l) < c) {
//                        hasSmaller = true;
//                        s = s.substring(0, j) + s.substring(j + 1) + c;
//                        break;
//                    }
//                }
//                if (hasSmaller) {
//                    break;
//                }
//            }
//        }
//        return s;
//    }

    /**
     * 计算字典序最小的字符串时，需要分别考虑 k = 1k=1 和 k > 1k>1 的两种情况。
     *
     * 当 k = 1 时，每次只能取 ss 的首个字符并将其移动到末尾，因此对于给定的字符串，可能的移动方法是唯一的，移动后的结果也是唯一的。
     * 对于长度为 n 的字符串 s，经过 0 次到 n - 1 次移动之后分别得到 n 个字符串，这 n 个字符串中的字典序最小的字符串即为答案。
     *
     * 当 k > 1 时，一定可以经过移动将 ss 变成升序字符串，因此将字符串 s 升序排序之后得到的字符串即为答案
     *
     * https://leetcode.cn/problems/orderly-queue/solution/you-xu-dui-lie-by-leetcode-solution-p6gv/
     *
     * @param s
     * @param k
     * @return
     */
    public String orderlyQueue(String s, int k) {
        if (k != 1) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
        String res = s;
        StringBuilder cur = new StringBuilder(s);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = cur.charAt(0);
            cur.deleteCharAt(0).append(c);
            if (cur.toString().compareTo(res) < 0) {
                res = cur.toString();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        OrderlyQueue oq = new OrderlyQueue();
        String s = "cba";
        int k = 1;
//        String s = "baaca";
//        int k = 3;
//        String s = "gzulcin";
//        int k = 7;
        System.out.println(oq.orderlyQueue(s, k));
    }
}
