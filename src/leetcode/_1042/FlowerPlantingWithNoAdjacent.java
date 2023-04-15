package leetcode._1042;

import java.util.*;

public class FlowerPlantingWithNoAdjacent {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] edges = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int[] path : paths) {
            edges[path[0] - 1].add(path[1] - 1);
            edges[path[1] - 1].add(path[0] - 1);
        }

//        System.out.println(Arrays.toString(edges));
        int[] res = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (res[i] == 0) {
                res[i] = 1;
                deque.offer(i);
                while (!deque.isEmpty()) {
                    int node = deque.poll();
                    for (int ne : edges[node]) {
                        if (res[ne] > 0) continue;
                        for (int j = 0; j < 4; j++) {
                            int f = (res[node] + j) % 4 + 1;
                            boolean same = true;
                            for (int ef : edges[ne]) {
                                if (f == res[ef]) {
                                    same = false;
                                    break;
                                }
                            }
                            if (same) {
                                res[ne] = f;
                                deque.offer(ne);
                                break;
                            }
                        }
//                        res[ne] = (res[node] + d) % 4 + 1;
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(res));

        return res;
    }

    public int[] gardenNoAdj1(int n, int[][] paths) {
        List<Integer>[] edges = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int[] path : paths) {
            edges[path[0] - 1].add(path[1] - 1);
            edges[path[1] - 1].add(path[0] - 1);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            boolean[] types = new boolean[5];
            for (int adj : edges[i]) {
                types[res[adj]] = true;
            }
            for (int j = 1; j < 5; j++) {
                if (!types[j]) {
                    res[i] = j;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FlowerPlantingWithNoAdjacent fp = new FlowerPlantingWithNoAdjacent();
        System.out.println(Arrays.toString(fp.gardenNoAdj1(3, new int[][] {{1,2},{2,3},{3,1}})));
        System.out.println(Arrays.toString(fp.gardenNoAdj1(4, new int[][] {{1,2},{3,4}})));
        System.out.println(Arrays.toString(fp.gardenNoAdj1(4, new int[][] {{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}})));
        System.out.println(Arrays.toString(fp.gardenNoAdj1(4, new int[][] {{1,2},{3,4},{3,2},{4,2},{1,4}})));
    }
}
