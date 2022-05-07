package leetcode._868;

public class BinaryGap {
    public int binaryGap(int n) {
        int pre = -1, curr = 0, gap = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                if (pre != -1) {
                    gap = Math.max(gap, curr - pre);
                }
                pre = curr;
            }
            curr++;
            n >>= 1;
        }
        return gap;
    }

    public static void main(String[] args) {
        BinaryGap bg = new BinaryGap();
        System.out.println(bg.binaryGap(22));
        System.out.println(bg.binaryGap(8));
        System.out.println(bg.binaryGap(5));
    }
}
