package contest.leetcode2022031301;

import java.util.ArrayList;
import java.util.List;

public class FindAllKDistantIndicesInAnArray {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        boolean[] indices = new boolean[nums.length];
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == key) {
                int diff = -Math.min(j, k);
                while (diff <= k && j + diff < nums.length) {
                    int i = j + diff;
                    indices[i] = true;
                    diff++;
                }
            }
        }
        List<Integer> iList = new ArrayList<>(nums.length);
        for (int i = 0; i < indices.length; i++) {
            if (indices[i]) {
                iList.add(i);
            }
        }
        return iList;
    }

    public static void main(String[] args) {
        FindAllKDistantIndicesInAnArray f = new FindAllKDistantIndicesInAnArray();
        int[] nums = new int[] {2,1,2,3,4,2,6,7,2,9,2};
        int key = 9;
        int k = 5;
        System.out.println(f.findKDistantIndices(nums, key, k));
    }
}
