package leetcode._753;

import java.util.Arrays;

/**
 * 破解保险箱
 * https://leetcode.cn/problems/cracking-the-safe/
 */
public class CrackingTheSafe {
    /**
     * https://leetcode.cn/problems/cracking-the-safe/solution/yi-bu-yi-bu-tui-dao-chu-0ms-jie-fa-tan-xin-gou-zao/
     * 贪心 欧拉图
     * @param n
     * @param k
     * @return
     */
    public String crackSafe(int n, int k) {
        int edgesNum = (int) Math.pow(k, n), nodeNum = (int) Math.pow(k, n - 1);
        int[] paths = new int[nodeNum];
        Arrays.fill(paths, k - 1);
        StringBuilder sb = new StringBuilder();
        sb.append("0".repeat(Math.max(0, n)));
        int pos = 0;
        for (int i = 1; i < edgesNum; i++) {
            int addedNum = paths[pos]--;
            sb.append(addedNum);
            pos = pos * k + addedNum - (sb.charAt(sb.length() - n) - '0') * nodeNum;
        }
        return sb.toString();
    }
}
