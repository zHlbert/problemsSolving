package leetcode._912;

import java.util.Arrays;
import java.util.Random;

/**
 * Given an array of integers nums, sort the array in ascending order.
 */
public class SortAnArray {
    public int[] sortArray(int[] nums) {
//        heapSort(nums);
//        quickSort(nums);
//        mergeSort(nums);
//        bubbleSort(nums);
//        selectionSort(nums);
//        insertionSort(nums);
//        shellSort(nums);
        quickSortByMoving(nums);
        return nums;
    }

    public void heapSort(int[] nums) {
        int heapSize = nums.length - 1;
        buildMaxHeap(nums, nums.length - 1);
        for (int i = heapSize; i >= 1; --i) {
            swap(nums, 0, i);
            heapSize--;
            maxHeapify(nums, 0, heapSize);
        }
    }

    private void buildMaxHeap(int[] nums, int heapSize) {
        for (int i = nums.length / 2; i >= 0; i--) {
            maxHeapify(nums, i, heapSize);
        }
    }

    private void maxHeapify(int[] nums, int i, int heapSize) {
        int l = (i << 1) + 1, r = (i << 1) + 2, largest = i;
        if (l <= heapSize && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r <= heapSize && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(nums, i, largest);
            maxHeapify(nums, largest, heapSize);
        }
//        for (; (i << 1) + 1 <= heapSize;) {
//            int lson = (i << 1) + 1;
//            int rson = (i << 1) + 2;
//            int large = i;
//            if (lson <= heapSize && nums[lson] > nums[large]) {
//                large = lson;
//            }
//            if (rson <= heapSize && nums[rson] > nums[large]) {
//                large = rson;
//            }
//            if (large != i) {
//                swap(nums, i, large);
//                i = large;
//            } else {
//                break;
//            }
//        }
    }

    public void quickSort(int[] nums) {
        randomizedQuickSort(nums, 0, nums.length - 1);
    }

    private void randomizedQuickSort(int[] nums, int l, int r) {
        if (l < r) {
            int q = randomPartition(nums, l, r);
            randomizedQuickSort(nums, l, q - 1);
            randomizedQuickSort(nums, q + 1, r);
        }
    }

    private int randomPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums, i, r);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int x = nums[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (nums[j] <= x)
                swap(nums, ++i, j);
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void mergeSort(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
    }

    int[] tmp;

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r)
            return;
        int mid = (l + r) >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        int i = l, j = mid + 1;
        int cnt = 0;
        while (i <= mid && j <= r) {
            if (nums[i] < nums[j]) {
                tmp[cnt++] = nums[i++];
            } else {
                tmp[cnt++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[cnt++] = nums[i++];
        }
        while (j <= r) {
            tmp[cnt++] = nums[j++];
        }
        for (int k = 0; k < r - l + 1; k++) {
            nums[k + l] = tmp[k];
        }
    }

    public void bubbleSort(int[] nums) {
    }

    public void insertionSort(int[] nums) {
    }

    public void selectionSort(int[] nums) {
    }

    public void shellSort(int[] nums) {
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void quickSortByMoving(int[] nums) {
        quickSortByMoving(nums, 0, nums.length - 1);
    }

    public void quickSortByMoving(int[] nums, int l, int r) {
        if (l < r) {
            int mid = partitionByMoving(nums, l, r);
            quickSortByMoving(nums, l, mid - 1);
            quickSortByMoving(nums, mid + 1, r);
        }
    }

    private int partitionByMoving(int[] nums, int l, int r) {
        int temp = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= temp)
                r--;
            nums[l] = nums[r];
            while (l < r && nums[l] <= temp)
                l++;
            nums[r] = nums[l];
        }
        nums[l] = temp;
        return l;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {6,3,5,7,2,9,1,4,8};
        SortAnArray s = new SortAnArray();
        System.out.println(Arrays.toString(s.sortArray(nums)));
    }
}
