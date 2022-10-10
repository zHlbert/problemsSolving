package leetcode._1790;

public class CheckIfOneStringSwapCanMakeStringsEqual {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        char[] sc1 = s1.toCharArray();
        char[] sc2 = s2.toCharArray();
        int n = s1.length();
        int i1 = -1, i2 = -1;
        for (int i = 0; i < n; i++) {
            if (sc1[i] != sc2[i]) {
                if (i1 == -1) {
                    i1 = i;
                } else if (i2 == -1) {
                    i2 = i;
                } else {
                    return false;
                }
            }
        }
        if (i2 == -1) {
            return false;
        }
        return sc1[i1] == sc2[i2] && sc2[i1] == sc1[i2];
    }
}
