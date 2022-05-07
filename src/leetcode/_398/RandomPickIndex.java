package leetcode._398;

import java.util.*;

public class RandomPickIndex {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(3));
        }
    }
}

class Solution {
    Map<Integer, List<Integer>> intIndexMap;
    Random random;

    public Solution(int[] nums) {
        intIndexMap = new HashMap<>(nums.length);
        random = new Random();
        for (int i = 0; i < nums.length; i++) {
            intIndexMap.putIfAbsent(nums[i], new ArrayList<>());
            intIndexMap.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> indices = intIndexMap.get(target);
        return indices.get(random.nextInt(indices.size()));
    }
}