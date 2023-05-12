package leetcode._2441;

public class LargestPositiveIntegerThatExistsWithItsNegative {
    public int findMaxK(int[] nums) {
        boolean[] exists = new boolean[2010];
        int res = -1;
        for (int num : nums) {
            exists[num + 1000] = true;
            if (exists[-num + 1000]) res = Math.max(res, Math.abs(num));
        }
        return res;
    }

    public static void main(String[] args) {
        LargestPositiveIntegerThatExistsWithItsNegative lp = new LargestPositiveIntegerThatExistsWithItsNegative();
        System.out.println(lp.findMaxK(new int[] {-1,2,-3,3}));
        System.out.println(lp.findMaxK(new int[] {-1,10,6,7,-7,1}));
        System.out.println(lp.findMaxK(new int[] {-10,8,6,7,-2,-3}));
    }
}
