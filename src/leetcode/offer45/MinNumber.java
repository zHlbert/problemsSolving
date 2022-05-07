package leetcode.offer45;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 */
public class MinNumber {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, strs.length - 1);
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    private void quickSort(String[] strs, int l, int r) {
        if (l < r) {
            int mid = partition(strs, l, r);
            quickSort(strs, l, mid - 1);
            quickSort(strs, mid + 1, r);
        }
    }

    private int partition(String[] strs, int l, int r) {
        // 基准选第一个
        String temp = strs[l];
        while (l < r) {
            // 从后向前找比基准小的数
            while (l < r && (strs[r] + temp).compareTo(temp + strs[r]) >= 0)
                r--;
            // 把比基准小的数移到低端
            strs[l] = strs[r];
            // 从前向后找比基准大的数
            while (l < r && (strs[l] + temp).compareTo(temp + strs[l]) <= 0)
                l++;
            //把比基准大的数移到高端
            strs[r] = strs[l];
        }
        strs[l] = temp;
        return l;
    }

    public static void main(String[] args) {
        MinNumber m = new MinNumber();
        int[] nums = new int[] {3,30,34,5,9};
        System.out.println(m.minNumber(nums));
    }
}
