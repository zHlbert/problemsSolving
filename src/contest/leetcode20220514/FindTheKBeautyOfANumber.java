package contest.leetcode20220514;

/**
 * https://leetcode.cn/contest/biweekly-contest-78/problems/find-the-k-beauty-of-a-number/
 */
public class FindTheKBeautyOfANumber {
    public int divisorSubstrings(int num, int k) {
        String numStr = String.valueOf(num);
        int cnt = 0;
        for (int i = 0; i <= numStr.length() - k; i++) {
            String subNumStr = numStr.substring(i, i + k);
            int subNum = Integer.parseInt(subNumStr);
            if (subNum != 0 && num % subNum == 0) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        FindTheKBeautyOfANumber fkb = new FindTheKBeautyOfANumber();
        int num = 430043;
        int k = 2;
        System.out.println(fkb.divisorSubstrings(num, k));
    }
}
