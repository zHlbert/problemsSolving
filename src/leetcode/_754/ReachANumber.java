package leetcode._754;

public class ReachANumber {
    /**
     * 二分
     * @param target
     * @return
     */
    public int reachNumber(int target) {
        int att = Math.abs(target);
        int l = lower(att);
        int ls = l * (l + 1) / 2;
        return ((ls - att) & 1) == 0 ? l : (l & 1) == 0 ? l + 1 : l + 2;
    }

    private int lower(int target) {
        int l = 0, r = target;
        while (l < r) {
            int mid = l + (r - l >> 1);
            if ((long) mid * (mid + 1) / 2 >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println("l: " + l);
        return l;
    }

    public static void main(String[] args) {
        ReachANumber rn = new ReachANumber();
        System.out.println(rn.reachNumber(2));
        System.out.println(rn.reachNumber(3));
        System.out.println(rn.reachNumber(100));
        System.out.println(rn.reachNumber(-44));
        System.out.println(rn.reachNumber(-1000000000));
    }
}
