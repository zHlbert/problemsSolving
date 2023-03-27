package leetcode._1638;

public class CountSubstringsThatDifferByOneCharacter {
    public int countSubstrings(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int res = 0;
        int sn = sc.length;
        for (int i = 0; i < sn; i++) {
            int tn = tc.length;
            for (int j = 0; j < tn; j++) {
                int diff = 0;
                for (int k = 0; i + k < sn && j + k < tn; k++) {
                    if (sc[i + k] != tc[j + k]) diff++;
                    if (diff == 1) res++;
                    else if (diff > 1) break;
                }
            }
        }
        return res;
    }
}
