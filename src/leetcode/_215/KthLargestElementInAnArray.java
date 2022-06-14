package leetcode._215;

import java.util.Random;

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KthLargestElementInAnArray {
    Random random = new Random();

    // 快速选择
    public int findKthLargestWithQuickSeletion(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int l, int r, int index) {
        int q = randomPartition(nums, l, r);
        if (q == index) {
            return nums[q];
        } else {
            return q < index ? quickSelect(nums, q + 1, r, index) : quickSelect(nums, l, q - 1, index);
        }
    }

    private int randomPartition(int[] nums, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(nums, i, r);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int x = nums[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (nums[j] <= x) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int findKthLargestWithMaxHeap(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            swap(nums, 0, i);
            heapSize--;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    private void maxHeapify(int[] nums, int i, int heapSize) {
        int l = 2 * i + 1, r = 2 * i + 2, largest = i;
        if (l < heapSize && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < heapSize && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(nums, i, largest);
            maxHeapify(nums, largest, heapSize);
        }
    }

    private void buildMaxHeap(int[] nums, int heapSize) {
        for (int i = nums.length / 2; i >= 0; i--) {
            maxHeapify(nums, i, heapSize);
        }
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray kthLargestElementInAnArray = new KthLargestElementInAnArray();
        int[] nums = new int[] {3,2,1,5,6,4};
        System.out.println(kthLargestElementInAnArray.findKthLargestWithMaxHeap(nums, 2));
        System.out.println(kthLargestElementInAnArray.findKthLargestWithQuickSeletion(nums, 2));

    }
}
