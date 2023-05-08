package leetcode._2437;

public class NumberOfValidClockTimes {
    public int countTime(String time) {
        char a = time.charAt(0), b = time.charAt(1), c = time.charAt(3), d = time.charAt(4);
        int l = 1, r = 1;
        if (a == '?' && b == '?') {
            l = 24;
        } else if (a == '?') {
            l = b > '3' ? 2 : 3;
        } else if (b == '?') {
            l = a < '2' ? 10 : 4;
        }

        if (c == '?' && d == '?') {
            r = 60;
        } else if (c == '?') {
            r = 6;
        } else if (d == '?') {
            r = 10;
        }
        return l * r;
    }

    public static void main(String[] args) {
        NumberOfValidClockTimes nv = new NumberOfValidClockTimes();
        System.out.println(nv.countTime("?5:00"));
        System.out.println(nv.countTime("0?:0?"));
        System.out.println(nv.countTime("??:??"));
    }
}
