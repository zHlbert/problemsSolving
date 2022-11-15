package leetcode._775;

/**
 * 全局倒置与局部倒置
 * https://leetcode.cn/problems/global-and-local-inversions/
 */
public class GlobalAndLocalInversions {
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length;
        long liv = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                liv++;
            }
        }
        long giv = mergeSort(nums, 0, n - 1);
        return liv == giv;
    }

    private long mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int mid = l + r >> 1;
        long cnt = mergeSort(nums, l , mid) + mergeSort(nums, mid + 1, r);

        int i = l, j = mid + 1, k = 0;
        int[] tmp = new int[r - l + 1];
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
                cnt += mid - i + 1;
            }
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= r) {
            tmp[k++] = nums[j++];
        }

        for (i = l, k = 0; i <= r; k++, i++) {
            nums[i] = tmp[k];
        }

        return cnt;
    }

    /**
     * 一个局部倒置一定是一个全局倒置，因此要判断数组中局部倒置的数量是否与全局倒置的数量相等，
     * 只需要检查有没有非局部倒置就可以了。这里的非局部倒置指的是 nums[i] > nums[j]，其中 i < j - 1。
     * 等价于 nums[i] > min(nums[i + 2], nums[i + 3], ...)
     *
     * @param nums
     * @return
     */
    public boolean isIdealPermutation1(int[] nums) {
        int n = nums.length, minSuff = nums[n - 1];
        for (int i = n - 3; i >= 0; i--) {
            if (nums[i] > minSuff) {
                return false;
            }
            minSuff = Math.min(minSuff, nums[i + 1]);
        }
        return true;
    }

    /**
     * 归纳
     * @param nums
     * @return
     */
    public boolean isIdealPermutation2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] - i > 1 || i - nums[i] > 1) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        GlobalAndLocalInversions gl = new GlobalAndLocalInversions();
        System.out.println(gl.isIdealPermutation2(new int[] {0, 2, 1}));
    }
}
