package contest.leetcode20220424;

import utils.ArrayUtils;

import java.util.*;

public class NumberOfFlowersInFullBloom {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        Arrays.sort(flowers, (f1, f2) -> (f1[0] == f2[0] ? f1[1] - f2[1] : f1[0] - f2[0]));
        int pl = persons.length;
        int[] res = new int[pl];
        Map<Integer, Integer> pCountMap = new HashMap<>(pl);
        for (int i = 0; i < pl; i++) {
            int person = persons[i];
            if (pCountMap.containsKey(person)) {
                res[i] = pCountMap.get(person);
            } else {
                int fl = flowers.length;
                if (flowers[0][0] > person) {
                    pCountMap.put(person, 0);
                } else {
                    int cnt = 0;
                    int pf = 0, pe = fl - 1;
                    while (pf <= pe) {
                        while (pf < fl && flowers[pf][1] < person && pf <= pe) {
                            pf++;
                        }
                        if (pf < fl && flowers[pf][0] <= person && pf <= pe) {
                            cnt++;
                            pf++;
                        }
                        while (pe >= 0 && flowers[pe][0] > person && pf <= pe) {
                            pe--;
                        }
                        if (pe >= 0 && flowers[pe][1] >= person && pf <= pe) {
                            cnt++;
                            pe--;
                        }
                    }

                    res[i] = cnt;
                    pCountMap.put(person, res[i]);
                }
            }
        }
        return res;
    }

    public int[] fullBloomFlowersPriority(int[][] flowers, int[] persons) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Arrays.sort(flowers, Comparator.comparingInt(f -> f[0]));
        Integer[] index = new Integer[persons.length];
        for (int i = 0; i < persons.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, Comparator.comparingInt(i -> persons[i]));
        int[] res = new int[persons.length];
        for (int i = 0, j = 0; i < persons.length; i++) {
            for (; j < flowers.length && flowers[j][0] <= persons[index[i]]; j++) {
                queue.offer(flowers[j][1]);
            }
            while (!queue.isEmpty() && queue.peek() < persons[index[i]]) {
                queue.poll();
            }
            res[index[i]] = queue.size();
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOfFlowersInFullBloom nff = new NumberOfFlowersInFullBloom();
//        int[][] flowers = new int[][] {{1,6},{3,7},{9,12},{4,13}};
        int[][] flowers = new int[][]
                {{40,44},{13,48},{27,45},{17,42},{15,23},{33,33},{13,43},{26,26},{17,42},{8,32},{40,42},{21,50},{38,40},{7,12},{30,48},{43,49},{11,13},{26,44},{45,48},{32,50},{9,30},{9,46},{14,19},{10,29},{15,17},{32,35},{11,35},{37,49},{13,19},{35,39},{46,49},{25,26},{11,40},{28,29},{20,31},{48,49},{17,46},{36,47},{37,39},{31,35},{46,46}};
        int[] persons = new int[] {50};
        ArrayUtils.printArray(nff.fullBloomFlowers(flowers, persons));
    }

//    {{21,34},{17,37},{23,43},{17,46},{37,41},{44,45},{32,45]]
//            [31,41,10,12]

//    {{28,37},{23,33},{39,39},{49,50},{41,45},{14,47]]
//            [19,44,28,41,40,12,48,17,34,30]
}
