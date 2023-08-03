package leetcode._822;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CardFlippingGame {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> set = new HashSet<>();
        int n = fronts.length;
        int res = 3000;
        for (int i = 0; i < n; i ++) {
            if (fronts[i] == backs[i])
                set.add(fronts[i]);
        }
        for (int x : fronts) {
            if (x < res && !set.contains(x))
                res = x;
        }
        for (int x : backs) {
            if (x < res && !set.contains(x))
                res = x;
        }
        return res % 3000;
    }
}
