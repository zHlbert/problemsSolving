package leetcode._1822;

public class SignOfTheProductOfAnArray {
    public int arraySign(int[] nums) {
        int res = 1;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            res = num < 0 ? -res : res;
        }
        return res;
    }
}
