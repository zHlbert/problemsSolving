package leetcode.offerII_115;

import java.util.*;

/**
 * https://leetcode.cn/problems/ur2n8P/
 */
public class SequenceReconstruction {

    /**
     * 拓扑排序 BFS
     * @param nums
     * @param sequences
     * @return
     */
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int n = nums.length;
        Set<Integer>[] edges = new HashSet[n + 1];
        Set<Integer>[] ind = new HashSet[n + 1];
        for (int i = 0; i < n + 1; i++) {
            edges[i] = new HashSet<>();
            ind[i] = new HashSet<>();
        }
        Set<Integer> vSet = new HashSet<>();
        for (int[] sequence : sequences) {
            vSet.add(sequence[0]);
            for (int i = 1; i < sequence.length; i++) {
                edges[sequence[i - 1]].add(sequence[i]);
                ind[sequence[i]].add(sequence[i - 1]);
                vSet.add(sequence[i]);
            }
        }

        int idx = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        Integer chosenV = null;
        boolean valid = true;
        for (int v : vSet) {
            if (ind[v].isEmpty()) {
                if (chosenV == null) {
                    chosenV = v;
                } else {
                    valid = false;
                    break;
                }
            }
        }
        if (!valid || chosenV != null && !chosenV.equals(nums[idx])) {
            return false;
        }
        queue.offer(chosenV);
        idx++;

        while (valid && !queue.isEmpty()) {
            Integer u = queue.poll();
            chosenV = null;
            for (Integer v : edges[u]) {
                ind[v].remove(u);
                if (ind[v].isEmpty()) {
                    if (chosenV == null) {
                        chosenV = v;
                    } else {
                        valid = false;
                        break;
                    }
                }
            }
            if (chosenV != null && !chosenV.equals(nums[idx])) {
                valid = false;
                break;
            }
            if (valid && chosenV != null) {
                queue.offer(chosenV);
                idx++;
            }
        }
        return valid && idx == n;
    }

    public boolean sequenceReconstruction1(int[] nums, int[][] sequences) {
        int n = nums.length;
        Set<Integer>[] edges = new HashSet[n + 1];
        for (int i = 0; i < n + 1; i++) {
            edges[i] = new HashSet<>();
        }
        int[] ind = new int[n + 1];
        Set<Integer> vSet = new HashSet<>();
        for (int[] sequence : sequences) {
            vSet.add(sequence[0]);
            for (int i = 1; i < sequence.length; i++) {
                if (edges[sequence[i - 1]].add(sequence[i])) {
                    ind[sequence[i]]++;
                }
                vSet.add(sequence[i]);
            }
        }

        int idx = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        Integer chosenV = null;
        boolean valid = true;
        for (int v : vSet) {
            if (ind[v] == 0) {
                if (chosenV == null) {
                    chosenV = v;
                } else {
                    valid = false;
                    break;
                }
            }
        }
        if (!valid || chosenV != null && !chosenV.equals(nums[idx])) {
            return false;
        }
        queue.offer(chosenV);
        idx++;

        while (valid && !queue.isEmpty()) {
            Integer u = queue.poll();
            chosenV = null;
            for (Integer v : edges[u]) {
                ind[v]--;
                if (ind[v] == 0) {
                    if (chosenV == null) {
                        chosenV = v;
                    } else {
                        valid = false;
                        break;
                    }
                }
            }
            if (chosenV != null && !chosenV.equals(nums[idx])) {
                valid = false;
                break;
            }
            if (valid && chosenV != null) {
                queue.offer(chosenV);
                idx++;
            }
        }
        return valid && idx == n;
    }

    public boolean sequenceReconstruction2(int[] nums, int[][] sequences) {
        int n = nums.length;
        Set<Integer>[] edges = new HashSet[n + 1];
        for (int i = 0; i < n + 1; i++) {
            edges[i] = new HashSet<>();
        }
        int[] ind = new int[n + 1];
        for (int[] sequence : sequences) {
            for (int i = 1; i < sequence.length; i++) {
                if (edges[sequence[i - 1]].add(sequence[i])) {
                    ind[sequence[i]]++;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (ind[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false;
            }
            Integer u = queue.poll();
            for (Integer v : edges[u]) {
                ind[v]--;
                if (ind[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SequenceReconstruction sr = new SequenceReconstruction();
//        int[] nums = new int[] {4,1,5,2,6,3};
//        int[][] seq = new int[][] {{5,2,6,3},{4,1,5,2}};
        int[] nums = new int[] {1,2,3};
        int[][] seq = new int[][] {{1,2}};
        System.out.println(sr.sequenceReconstruction2(nums, seq));
    }
}
