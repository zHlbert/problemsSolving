package leetcode._481;

import utils.ArrayUtils;

public class MagicalString {
    public int magicalString(int n) {
        int[] mg = new int[n + 5];
        int flag = 1;
        mg[0] = 1;
        mg[1] = 2;
        int res = 0;
        for (int i = 0, j = 0; j < n; i++) {
            for (int k = 0; k < mg[i] && j < n; k++) {
                mg[j++] = flag;
                res += 2 - flag;
            }
            flag = 3 - flag;
        }

        return res;
    }

    public static void main(String[] args) {
        MagicalString ms = new MagicalString();
        System.out.println(ms.magicalString(6));
        System.out.println(ms.magicalString(100));
    }
}
