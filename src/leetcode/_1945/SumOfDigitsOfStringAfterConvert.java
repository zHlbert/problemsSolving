package leetcode._1945;

public class SumOfDigitsOfStringAfterConvert {
    public int getLucky(String s, int k) {
        char[] sc = s.toCharArray();
        int res = 0;
        for (char c : sc) {
            int x = c - 'a' + 1;
            res += x / 10 + x % 10;
        }

        for (int i = 0; i < k - 1; i++) {
            res = trans(res);
        }

        return res;
    }

    private int trans(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x/= 10;
        }
        return res;
    }


    public static void main(String[] args) {
        SumOfDigitsOfStringAfterConvert sd = new SumOfDigitsOfStringAfterConvert();
        System.out.println(sd.getLucky("leetcode" ,2));
    }
}
