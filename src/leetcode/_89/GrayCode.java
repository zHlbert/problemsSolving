package leetcode._89;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/gray-code/
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>(1 << n);
        res.add(0);
        for (int i = 1; i <= n; i++) {
            int size = res.size();
            // 已经生成[0, 2^(n-1) - 1],后面一半从后往前遍历，每个元素添加2^(n-1)，依次加入数组，满足了相邻两位只有一个二进制变化
            for (int j = size - 1; j >= 0; j--) {
                res.add(res.get(j) | (1 << (i - 1)));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        GrayCode gc = new GrayCode();
        System.out.println(gc.grayCode(3));
    }
}
