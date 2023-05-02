package leetcode._970;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        int xc = x == 1 ? 1 : (int) Math.ceil(Math.log(bound) / Math.log(x));
        int yc = y == 1 ? 1 : (int) Math.ceil(Math.log(bound) / Math.log(y));
        Set<Integer> set = new HashSet<>();
        int xs = 1;
        for (int i = 0; i < xc; i++) {
            int ys = 1;
            for (int j = 0; j < yc; j++) {
                int s = xs + ys;
                if (s > bound) break;
                set.add(s);
                ys *= y;
            }
            xs *= x;
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        PowerfulIntegers p = new PowerfulIntegers();
        System.out.println(p.powerfulIntegers(2,3,10));
        System.out.println(p.powerfulIntegers(3,5,15));
    }
}
