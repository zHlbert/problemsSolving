package leetcode._2475;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberOfUnequalTripletsInArray {
    public int unequalTriplets(int[] nums) {
        int res = 0, n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] != nums[j] && nums[j] != nums[k] && nums[i] != nums[k])
                        res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] patterns = new String[] {"jdbc\\..+\\.password"};
        String[] strs = new String[] {"jdbc.dev.password", "jdbc.sit1.password", "jdbc.t4.password", "jdbc.prod.password", "jdbc.xd.password", "jdbc..password", "jdbc.password", "xjdbc.t4.password"};

        Pattern r = Pattern.compile(patterns[0]);
        for (String str : strs) {
            Matcher m = r.matcher(str);
            System.out.println(str + ", " + m.matches());
        }
    }
}
