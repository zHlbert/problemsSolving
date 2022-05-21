package leetcode._464;

public class CanIWin {
    int maxChoosable, total;
    Boolean[] memo;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        if ((maxChoosableInteger + 1) * maxChoosableInteger < desiredTotal) {
            return false;
        }
        maxChoosable = maxChoosableInteger;
        total = desiredTotal;
        memo = new Boolean[1 << maxChoosableInteger];
        return dfs(0, 0);
    }

    /**
     * 记忆化搜索+状态压缩
     * @param usedIntegers 每一个二进制位 i 表示第 i 个数字是否使用过
     * @param curTotal 当前加和
     * @return 是否获胜
     */
    private boolean dfs(int usedIntegers, int curTotal) {
        if (memo[usedIntegers] != null) {
            return memo[usedIntegers];
        }
        for (int i = 0; i < maxChoosable; i++) {
            if (((usedIntegers >> i) & 1) == 1) {
                continue;
            }
            // 当前加和 >= 需要和 或 下一个人输掉，则赢
            if (curTotal + i + 1 >= total
                    || !dfs(usedIntegers | (1 << i), curTotal + i + 1)) {
                return memo[usedIntegers] = true;
            }
        }
        return memo[usedIntegers] = false;
    }

    public static void main(String[] args) {
        CanIWin cw = new CanIWin();
        int maxChoosableInteger = 6, desiredTotal = 1;
        System.out.println(cw.canIWin(maxChoosableInteger, desiredTotal));
//        for (int i = 0; i < cw.memo.length; i++) {
//            System.out.println(i + ": " + cw.memo[i]);
//        }
    }
}
