package leetcode._652;

import utils.TreeNode;

import java.util.*;

/**
 * https://leetcode.cn/problems/find-duplicate-subtrees/submissions/
 */
public class FindDuplicateSubtrees {
    Map<String, Pair<TreeNode, Integer>> seen = new HashMap<>();
    Set<TreeNode> repeat = new HashSet<>();
    int idx = 0;

    /**
     * 编码 哈希
     *
     * https://leetcode.cn/problems/find-duplicate-subtrees/solution/xun-zhao-zhong-fu-de-zi-shu-by-leetcode-zoncw/
     *
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<>(repeat);
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int[] tri = {node.val, dfs(node.left), dfs(node.right)};
        String hash = Arrays.toString(tri);
        if (seen.containsKey(hash)) {
            Pair<TreeNode, Integer> pair = seen.get(hash);
            repeat.add(pair.key);
            return pair.value;
        } else {
            seen.put(hash, new Pair<>(node, ++idx));
            return idx;
        }
    }

    private class Pair<K, V> {
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
