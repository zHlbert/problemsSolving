package leetcode._508;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/most-frequent-subtree-sum/
 */
public class MostFrequentSubtreeSum {
    Map<Integer, Integer> cntMap = new HashMap<>();
    int maxFreq = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        cntSubTreeSum(root);
        List<Integer> sumList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            int freq = entry.getValue();
            if (freq == maxFreq) {
                sumList.add(entry.getKey());
            }
        }

        int size = sumList.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = sumList.get(i);
        }
        return res;
    }

    private int cntSubTreeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = cntSubTreeSum(root.left);
        int rightSum = cntSubTreeSum(root.right);

        int curSum = leftSum + root.val + rightSum;
        int freq = cntMap.getOrDefault(curSum, 0);
        cntMap.put(curSum, freq + 1);
        maxFreq = Math.max(maxFreq, freq + 1);

        return curSum;
    }
}
