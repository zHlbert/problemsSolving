package leetcode._1003;

public class CheckIfWordIsValidAfterSubstitutions {
    /**
     * 栈
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        char[] sc = s.toCharArray();
        int n = sc.length;
        int top = 0;
        int[] st = new int[n];
        for (char c : sc) {
            st[top++] = c;
            while (top > 2 && st[top - 1] == 'c' && st[top - 2] == 'b' && st[top - 3] == 'a') {
                top -= 3;
            }
        }
        return top == 0;
    }

    public static void main(String[] args) {
        CheckIfWordIsValidAfterSubstitutions cw = new CheckIfWordIsValidAfterSubstitutions();
        System.out.println(cw.isValid("aabcbc"));
        System.out.println(cw.isValid("abcabcababcc"));
        System.out.println(cw.isValid("abccba"));
    }
}
