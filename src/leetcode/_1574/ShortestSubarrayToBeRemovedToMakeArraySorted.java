package leetcode._1574;

public class ShortestSubarrayToBeRemovedToMakeArraySorted {
    /**
     * 双指针
     * @param arr
     * @return
     */
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int j = n - 1;
        while (j > 0 && arr[j - 1] <= arr[j])
            j--;
        if (j == 0) return 0;
        int res = j;
        for (int i = 0; i < n; i++) {
            while (j < n && arr[i] > arr[j])
                j++;
            res = Math.min(res, j - i - 1);
            if (i + 1 < n && arr[i] > arr[i + 1])
                break;
        }
        return res;
    }
}
