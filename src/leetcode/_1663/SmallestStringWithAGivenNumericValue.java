package leetcode._1663;

public class SmallestStringWithAGivenNumericValue {
    public String getSmallestString(int n, int k) {
        char[] res = new char[n];
        for (int i = 0; i < n; i++) {
            if (k - 1 < 26 * (n - i - 1)) {
                res[i] = 'a';
                k--;
            } else {
                res[i] = (char) ('a' + (k - 26 * (n - i - 1) - 1));
//                System.out.println(res[i]);
                k -= res[i] - 'a' + 1;
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        SmallestStringWithAGivenNumericValue ss = new SmallestStringWithAGivenNumericValue();
        System.out.println(ss.getSmallestString(5, 73));
        System.out.println(ss.getSmallestString(3, 27));
    }
}
