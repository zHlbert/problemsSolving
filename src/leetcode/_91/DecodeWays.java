package leetcode._91;


public class DecodeWays {
    public int numDecodings(String s) {
        return numDecodings(s, 0, s.length() - 1);
    }

    private int numDecodings(String str, int s, int e) {
        int len = str.length();
        if (e >= len || s > e || str.charAt(s) == '0') {
            return 0;
        }
        if (e == s) {
            return 1;
        }

        int tmp = Integer.parseInt(str.substring(s, s + 2));
        // 头两位是否可解码
        int firstTwoValid = tmp <= 26 ? 1 : 0;
        if (e - s == 1) {
            return firstTwoValid + (str.charAt(e) != '0' ? 1 : 0);

        }
        return numDecodings(str, s + 1, e) + firstTwoValid * numDecodings(str, s + 2, e);
    }

    public int numDecodings1(String s) {
        int n = s.length();
        int[] nums = new int[n + 1];
        nums[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                nums[i] += nums[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0')) <= 26) {
                nums[i] += nums[i - 2];
            }
        }
        return nums[n];
    }

    public int numDecodings2(String s) {
        int n = s.length();
        // a = f[i-2], b = f[i-1], c = f[i]
        int a = 0, b = 1, c = 0;
        for (int i = 1; i <= n; i++) {
            c = 0;
            if (s.charAt(i - 1) != '0') {
                c += b;
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0')) <= 26) {
                c += a;
            }
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        DecodeWays d = new DecodeWays();
        String[] strings = new String[] {"12"};
        for (String string : strings) {
            int num = d.numDecodings2(string);
            System.out.println(string + ": " + num);
        }
    }
}
