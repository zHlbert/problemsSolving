package leetcode._1460;

public class MakeTwoArraysEqualByReversingSubArrays {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] cnts = new int[1005];
        int n = target.length;
        for (int i = 0; i < n; i++) {
            cnts[target[i]]++;
            cnts[arr[i]]--;
        }

        for (int i = 0; i < cnts.length; i++) {
            if (cnts[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
