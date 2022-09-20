package leetcode._672;

import java.util.HashSet;
import java.util.Set;

public class BulbSwitchII {

    /**
     * https://leetcode.cn/problems/bulb-switcher-ii/solution/deng-pao-kai-guan-ii-by-leetcode-solutio-he7o/
     *
     * 位运算
     * @param n
     * @param presses
     * @return
     */
    public int flipLights(int n, int presses) {
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < 1 << 4; i++) {
            int[] pressArr = new int[4];
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                pressArr[j] = (i >> j) & 1;
                sum += pressArr[j];
            }
            if (sum % 2 == presses % 2 && sum <= presses) {
                int status = pressArr[0] ^ pressArr[2] ^ pressArr[3];
                if (n >= 2) {
                    status |= (pressArr[0] ^ pressArr[1]) << 1;
                }
                if (n >= 3) {
                    status |= (pressArr[0] ^ pressArr[2]) << 2;
                }
                if (n >= 4) {
                    status |= (pressArr[0] ^ pressArr[1] ^ pressArr[3]) << 3;
                }
                seen.add(status);
            }
        }
        return seen.size();
    }

    public static void main(String[] args) {
        BulbSwitchII bs = new BulbSwitchII();
        System.out.println(bs.flipLights(2, 1));
    }
}
