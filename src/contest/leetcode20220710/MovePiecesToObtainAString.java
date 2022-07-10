package contest.leetcode20220710;

public class MovePiecesToObtainAString {
    public boolean canChange(String start, String target) {
        char[] s = start.toCharArray();
        char[] t = target.toCharArray();
        int n = s.length;
        int i1 = 0, i2 = 0;
        while (i2 < n) {
            while (i2 < n && t[i2] != 'L')
                i2++;
            if (i2 < n) {
                while (i1 < n && s[i1] != 'L') {
                    if (s[i1] == 'R') {
                        return false;
                    }
                    i1++;
                }
                if (i1 == n || i1 < i2) {
                    return false;
                }
                i1++;
            }
            i2++;
        }
        i2 = n - 1;
        i1 = n - 1;
        while (i2 >= 0) {
            while (i2 >= 0 && t[i2] != 'R')
                i2--;
            if (i2 >= 0) {
                while (i1 >= 0 && s[i1] != 'R') {
                    if (s[i1] == 'L') {
                        return false;
                    }
                    i1--;
                }
                if (i1 == -1 || i1 > i2) {
                    return false;
                }
                i1--;
            }
            i2--;
        }
        return true;
    }

    public boolean canChange1(String start, String target) {
        if (start.equals(target)) {
            return true;
        }
        char[] s = start.toCharArray();
        char[] t = target.toCharArray();
        int n = s.length;
        int i1 = 0, i2 = 0;
        int d = 0;
        while (i2 < n) {
            while (i2 < n && t[i2] != 'L') {
                if (t[i2] == 'R') {
                    d++;
                }
                i2++;
            }
            if (i2 < n) {
                while (i1 < n && s[i1] != 'L') {
                    if (s[i1] == 'R') {
                        d--;
                    }
                    i1++;
                }
                if (i1 == n || i1 < i2 || d != 0) {
                    return false;
                }
                i1++;
            }
            i2++;
            d = 0;
        }
        i2 = n - 1;
        i1 = n - 1;
        d = 0;
        while (i2 >= 0) {
            while (i2 >= 0 && t[i2] != 'R') {
                if (t[i2] == 'L') {
                    d++;
                }
                i2--;
            }
            if (i2 >= 0) {
                while (i1 >= 0 && s[i1] != 'R') {
                    if (s[i1] == 'L') {
                        d--;
                    }
                    i1--;
                }
                if (i1 == -1 || i1 > i2 || d != 0) {
                    return false;
                }
                i1--;
            }
            i2--;
            d = 0;
        }
        return true;
    }

    public static void main(String[] args) {
        MovePiecesToObtainAString mp = new MovePiecesToObtainAString();
        // "__R_R_R_L"
        // "____RRR_L"
        String start = "__R_R_R_L";
        String target = "____RRR_L";
        System.out.println(mp.canChange1(start, target));
    }
}
