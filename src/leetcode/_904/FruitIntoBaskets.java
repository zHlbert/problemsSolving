package leetcode._904;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
//    public int totalFruit(int[] fruits) {
//        int res = 0, n = fruits.length;
//        int f1 = -1, f2 = -1;
//        int i1 = -1, i2 = -1;
//        for (int i = 0; i < n; i++) {
//            int fruit = fruits[i];
//            if (fruit != f1 && fruit != f2) {
//                if (i1 == -1) {
//                    i1 = i;
//                    f1 = fruit;
//                } else if (i2 == -1) {
//                    i2 = i;
//                    f2 = fruit;
//                } else {
//                    res = Math.max(res, i - i1 + 1);
//                    i1 = i2;
//                    i2 = i;
//                    f1 = f2;
//                    f2 = fruit;
//                }
//            } else {
//                res = Math.max(res, i - i1 + 1);
//            }
//        }
//        res = Math.max(res, n - i1);
//        return res;
//    }

    /**
     * 滑动窗口
     * @param fruits
     * @return
     */
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int res = 0, left = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            cnt.put(fruits[i], cnt.getOrDefault(fruits[i], 0) + 1);
            while (cnt.size() > 2) {
                int lf = fruits[left];
                int count = cnt.get(lf);
                count--;
                if (count == 0) {
                    cnt.remove(lf);
                } else {
                    cnt.put(lf, count);
                }
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    public int totalFruit1(int[] fruits) {
        int n = fruits.length;
        int res = 0, l = 0;
        int[] cnts = new int[n];
        int cnt = 0;
        for (int r = 0; r < n; r++) {
            cnts[fruits[r]]++;
            if (cnts[fruits[r]] == 1) {
                cnt++;
            }
            while (cnt > 2) {
                cnts[fruits[l]]--;
                if (cnts[fruits[l]] == 0) {
                    cnt--;
                }
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        FruitIntoBaskets fb = new FruitIntoBaskets();
        System.out.println(fb.totalFruit(new int[]{1, 2, 1}));
        System.out.println(fb.totalFruit(new int[]{0, 1, 2, 2}));
        System.out.println(fb.totalFruit(new int[]{1, 2, 3, 2, 2}));
        System.out.println(fb.totalFruit(new int[]{1}));
        System.out.println(fb.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }
}
