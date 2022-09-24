package leetcode._1652;

import java.util.Arrays;

public class DefuseTheBomb {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if (k == 0) {
            return res;
        }
        int sum = 0;
        int ak = Math.abs(k);
        for (int i = 0; i < ak; i++) {
            sum += code[i];
        }
        if (k > 0) {
            for (int i = n - 1; i >= 0; i--) {
                res[i] = sum;
                sum += code[i] - code[(i + k) % n];
            }
        } else {
            for (int i = 0; i < n; i++) {
                res[(i - k) % n] = sum;
                sum += code[(i - k) % n] - code[i];
            }
        }
        return res;
    }

    public int[] decrypt1(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if (k == 0) return res;
        int sum = 0;
        if (k < 0)
            for (int i = n + k; i < n; i++)
                sum += code[i];
        else
            for (int i = 0; i < k; i++)
                sum += code[(i + 1) % n];
        for (int i = 0; i < n; i++) {
            res[i] = sum;
            sum += k < 0 ? code[i] - code[(i + k + n) % n] : code[(i + k + 1) % n] - code[(i + 1) % n];
        }
        return res;
    }

    public static void main(String[] args) {
        DefuseTheBomb db = new DefuseTheBomb();
//        int[] code = {2,4,9,3};
//        int k = -2;
//        int[] code = {5,7,1,4};
//        int k = 3;
//        int[] code = {1,2,3,4};
//        int k = 0;
        int[] code = {5,2,2,3,1};
        int k = 3;
        System.out.println(Arrays.toString(db.decrypt1(code, k)));
    }
}
