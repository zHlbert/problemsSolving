package leetcode._556;

/**
 * https://leetcode.cn/problems/next-greater-element-iii/
 */
public class NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        String numStr = String.valueOf(n);
        char[] chars = numStr.toCharArray();
        int l = chars.length;
        int i = l - 2;
        while (i >= 0 && chars[i] >= chars[i + 1]) {
            i--;
        }
        if (i < 0) {
            return -1;
        }
        int j = l - 1;
        while (i < j && chars[i] >= chars[j]) {
            j--;
        }
        swap(chars, i, j);
        reverse(chars, i + 1, l);
        long res = Long.parseLong(new String(chars));
        if (res > Integer.MAX_VALUE) {
            return -1;
        }
        return (int) res;
    }

    private void reverse(char[] chars, int begin, int end) {
        for (int i = begin, j = end - 1; i < j; i++, j--) {
            swap(chars, i, j);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }

    public static void main(String[] args) {
        NextGreaterElementIII ng = new NextGreaterElementIII();
        System.out.println(ng.nextGreaterElement(12));
        System.out.println(ng.nextGreaterElement(21));
        System.out.println(ng.nextGreaterElement(46352));
        System.out.println(ng.nextGreaterElement(54312));
        System.out.println(ng.nextGreaterElement(54332));
    }
}
