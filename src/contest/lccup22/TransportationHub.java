package contest.lccup22;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TransportationHub {
    public int transportationHub(int[][] path) {
        Set<Integer>[] graph = new HashSet[1005];
        Set<Integer>[] ind = new HashSet[1005];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new HashSet<>();
            ind[i] = new HashSet<>();
        }

        Set<Integer> nodes = new HashSet<>();
        for (int[] ints : path) {
            graph[ints[0]].add(ints[1]);
            ind[ints[1]].add(ints[0]);
            nodes.add(ints[0]);
            nodes.add(ints[1]);
        }
        int n = nodes.size();
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].size() == 0 && ind[i].size() == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
