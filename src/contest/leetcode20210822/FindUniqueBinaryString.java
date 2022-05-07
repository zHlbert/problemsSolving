package contest.leetcode20210822;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length n that does not appear in nums. If there are multiple answers, you may return any of them.
 */
public class FindUniqueBinaryString {
    String[] exists;
    String diffString = "";
    char[] zeroOne = new char[] {'0', '1'};
    public String findDifferentBinaryString(String[] nums) {
        exists = nums;
        int n = nums.length;
        StringBuilder output = new StringBuilder(nums[0]);
        backtracking(n, output, 0);
        return diffString;
    }

    private void backtracking(int n, StringBuilder output, int i) {
        if (i == n) {
            String finalStr = output.toString();
            for (String exist : exists) {
                if (exist.equals(finalStr)) {
                    return;
                }
            }
            diffString = finalStr;
            return;
        }

        for (int j = i; j < n; j++) {
            if (diffString.length() > 0) {
                break;
            }
            char oChar = output.charAt(j);
            for (char c : zeroOne) {
                output.setCharAt(j, c);
                backtracking(n, output, i + 1);
                output.setCharAt(j, oChar);
            }
        }
    }

//    public String findDifferentBinaryString1(String[] nums) {
//        exists = nums;
//        int n = nums.length;
//        Set<String> set = new HashSet<>();
//        set.addAll(Arrays.asList(nums));
//        StringBuilder sb = new StringBuilder();
//        return sb.toString();
//    }

    /**
     * 康托对角线
     * 只要和第i个串下标i的字符nums[i][i]不同，构造出来的串就和所有的串都不同。
     * 只限于串数不超过串长的情况
     *
     * @param nums
     * @return
     */
    public String findDifferentBinaryStringContourDiag(String[] nums) {
        int len = nums.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        return sb.toString();
    }

    private void swap(StringBuilder output, int i, int j) {
        char tmp = output.charAt(i);
        output.setCharAt(i, output.charAt(j));
        output.setCharAt(j, tmp);
    }

    public static void main(String[] args) {
        FindUniqueBinaryString f = new FindUniqueBinaryString();
        String[] nums = new String[] {"01","10"};
        System.out.println(f.findDifferentBinaryStringContourDiag(nums));
    }
}
