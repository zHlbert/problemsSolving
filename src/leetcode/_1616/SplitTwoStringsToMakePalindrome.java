package leetcode._1616;

public class SplitTwoStringsToMakePalindrome {
    int n;

    public boolean checkPalindromeFormation(String a, String b) {
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        n = ac.length;
        return selfPalindrome(ac, 0, n - 1) || selfPalindrome(bc, 0, n - 1)
                || palindromeConcatenation(ac, bc) || palindromeConcatenation(bc, ac);
    }

    private boolean palindromeConcatenation(char[] ac, char[] bc) {
        int left = 0, right = n - 1;
        for (; left < right; left++, right--)
            if (ac[left] != bc[right]) break;
        if (left >= right) return true;
        return selfPalindrome(ac, left, right) || selfPalindrome(bc, left, right);
    }

    private boolean selfPalindrome(char[] sc, int left, int right) {
        int i = left, j = right;
        for (; i < j; i++, j--)
            if (sc[i] != sc[j]) break;
        return i >= j;
    }

    public static void main(String[] args) {
        SplitTwoStringsToMakePalindrome st = new SplitTwoStringsToMakePalindrome();
        System.out.println(st.checkPalindromeFormation("x", "y"));
        System.out.println(st.checkPalindromeFormation("xbdef", "xecab"));
        System.out.println(st.checkPalindromeFormation("ulacfd", "jizalu"));
    }
}
