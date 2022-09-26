package leetcode.interview0102;

public class CheckPermutationLCCI {
    public boolean CheckPermutation(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m != n) {
            return false;
        }
        char[] sc1 = s1.toCharArray(), sc2 = s2.toCharArray();
        int[] cnt = new int[128];
        for (int i = 0; i < n; i++) {
            cnt[sc1[i]]++;
            cnt[sc2[i]]--;
        }
        for (int c : cnt) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
