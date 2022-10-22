package leetcode._915;

public class PartitionArrayIntoDisjointIntervals {
//    public int partitionDisjoint(int[] nums) {
//        int i = 0, j = nums.length - 1, max = nums[i];
//        while (i < j) {
//            while (i < j && nums[j] >= max) {
//                j--;
//            }
//            if (i == j) {
//                break;
//            }
//            while (i < j && max > nums[j]) {
//                max = Math.max(max, nums[++i]);
//            }
//        }
//        return i + 1;
//    }

    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] mx = new int[n];
        mx[0] = nums[0];
        for (int i = 1; i < n; i++) {
            mx[i] = Math.max(mx[i - 1], nums[i]);
        }
        int[] mn = new int[n];
        mn[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            mn[i] = Math.min(mn[i + 1], nums[i]);
        }
        int i = 0;
        for (; i < n - 1; i++) {
            if (mx[i] <= mn[i + 1]) {
                break;
            }
        }
        return i + 1;
    }

    public int partitionDisjoint1(int[] nums) {
        int n = nums.length;
        int[] mn = new int[n];
        mn[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            mn[i] = Math.min(mn[i + 1], nums[i]);
        }
        int i = 0, mx = 0;
        for (; i < n - 1; i++) {
            mx = Math.max(mx, nums[i]);
            if (mx <= mn[i + 1]) {
                break;
            }
        }
        return i + 1;
    }

    public int partitionDisjoint2(int[] nums) {
        int n = nums.length;
        int oMax = nums[0], lMax = nums[0], lPos = 0;
        for (int i = 1; i < n - 1; i++) {
            oMax = Math.max(oMax, nums[i]);
            if (nums[i] < lMax) {
                lMax = oMax;
                lPos = i;
            }
        }
        return lPos + 1;
    }

    public static void main(String[] args) {
        PartitionArrayIntoDisjointIntervals p = new PartitionArrayIntoDisjointIntervals();
        int[] nums = new int[] {32,57,24,19,0,24,49,67,87,87};
        System.out.println(p.partitionDisjoint(nums));
    }
}
