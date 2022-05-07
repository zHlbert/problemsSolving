package leetcode._433;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/solution/
 */
public class MinimumGeneticMutation {
    boolean[] used;
    String[] bank;
    int ans = Integer.MAX_VALUE;
    String end;

    public int minMutationBackTracking(String start, String end, String[] bank) {
        this.bank = bank;
        used = new boolean[bank.length];
        this.end = end;
        backtrack(start, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void backtrack(String cur, int t) {
        if (t >= ans) {
            return;
        }
        if (cur.equals(end)) {
            ans = Math.min(ans, t);
        } else {
            for (int i = 0, diff = 0; i < bank.length; i++, diff = 0) {
                if (used[i]) {
                    continue;
                }
                for (int j = 0; j < cur.length(); j++) {
                    diff += cur.charAt(j) != bank[i].charAt(j) ? 1 : 0;
                }
                if (diff == 1) {
                    used[i] = true;
                    backtrack(bank[i], t + 1);
                    used[i] = false;
                }
            }
        }
    }

    public int minMutationBFS(String start, String end, String[] bank) {
        char[] gen = new char[] {'A', 'C', 'G', 'T'};
        Set<String> usedSet = new HashSet<>();
        Set<String> bankSet = new HashSet<>();
        Collections.addAll(bankSet, bank);
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        usedSet.add(start);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(end)) {
                    return step;
                }
                for (int j = 0; j < cur.length(); j++) {
                    StringBuilder sb = new StringBuilder(cur);
                    for (char c : gen) {
                        sb.setCharAt(j, c);
                        String rep = sb.toString();
                        if (!usedSet.contains(rep) && bankSet.contains(rep)) {
                            usedSet.add(rep);
                            queue.offer(rep);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumGeneticMutation mgm = new MinimumGeneticMutation();
        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String[] bank = new String[] {"AACCGGTA"};
        System.out.println(mgm.minMutationBFS(start, end, bank));
    }
}
