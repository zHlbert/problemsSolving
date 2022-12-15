package leetcode._1785;

public class MinimumElementsToAddToFormAGivenSum {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long diff = Math.abs(goal - sum);
        // 向上取整
        return (int) ((diff + limit - 1) / limit);
    }

    public static void main(String[] args) {
        MinimumElementsToAddToFormAGivenSum me = new MinimumElementsToAddToFormAGivenSum();
//        int[] nums = new int[] {1,-1,1};
//        int limit = 3;
//        int goal = -4;
        int[] nums = new int[] {1,-10,9,1};
        int limit = 100;
        int goal = 0;
        System.out.println(me.minElements(nums, limit, goal));
    }
}
