package contest.leetcode20220723;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/shortest-impossible-sequence-of-rolls/
 */
public class ShortestImpossibleSequenceOfRolls {
    public int shortestSequence(int[] rolls, int k) {
        // Tips1：假设一种情况，当前这个数字子序列可以再变长一位的充要条件是什么？
        // 答案是后面必须都要有从1到k的数字，缺一不可。
        //
        // Tips2：可以证明在打包序列中重复的数字是没有意义的，因为里面总是会缺少你需要的序列。
        // 那么在Tips1的情况下，从后往前遍历，将从1到k的数字第一遍出现进行打包，每有一组打包，ans就+1，如此往复。
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int r : rolls) {
            set.add(r);
            if (set.size() == k) {
                res++;
                set.clear();
            }
        }
        return res + 1;
    }

    public static void main(String[] args) {
        ShortestImpossibleSequenceOfRolls ss = new ShortestImpossibleSequenceOfRolls();
        int[] rolls = new int[] {4,1,2,3,4,1,2,3};
        int k = 4;
        System.out.println(ss.shortestSequence(rolls, k));
    }
}
