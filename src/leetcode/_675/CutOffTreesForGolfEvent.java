package leetcode._675;

import utils.ArrayUtils;

import java.util.*;

/**
 * https://leetcode.cn/problems/cut-off-trees-for-golf-event/
 */
public class CutOffTreesForGolfEvent {
    int[][] d = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
    int[][] f;
    int m, n;
    public int cutOffTree(List<List<Integer>> forest) {
        m = forest.size();
        n = forest.get(0).size();
        List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1) {
                    trees.add(new int[] {i, j});
                }
            }
        }
        trees.sort(Comparator.comparing(t -> forest.get(t[0]).get(t[1])));

        int sx = 0, sy = 0;
        int res = 0;
        for (int[] tree : trees) {
            int steps = bfs(sx, sy, tree[0], tree[1]);
            System.out.println("(" + sx + "," + sy + "), (" + tree[0] + "," + tree[1] + "), step = " + steps);
            if (steps == -1) {
                return -1;
            }
            res += steps;
            sx = tree[0];
            sy = tree[1];
        }

        return res;
    }

    /**
     * (sx, sy) -> (tx, ty) 的最短距离
     * @param sx
     * @param sy
     * @param tx
     * @param ty
     * @return
     */
    private int bfs(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) {
            return 0;
        }
        int step = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(new int[] {sx, sy});
        visited[sx][sy] = true;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nextX = cur[0] + d[j][0];
                    int nextY = cur[1] + d[j][1];
                    if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || visited[nextX][nextY]) {
                        continue;
                    }
                    if (f[nextX][nextY] > 0) {
                        if (nextX == tx && nextY == ty) {
                            return step;
                        }
                        queue.offer(new int[] {nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
        return -1;
    }

    public int cutOffTreePriorityQueue(List<List<Integer>> forest) {
        m = forest.size();
        n = forest.get(0).size();
        f = new int[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(t -> t[2]));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int h = forest.get(i).get(j);
                f[i][j] = h;
                if (h > 1) {
                    pq.offer(new int[] {i, j, h});
                }
            }
        }

        int sx = 0, sy = 0;
        int res = 0;
        // 从(0, 0)开始依次找到高度从小到大排列的数之间距离，加和即为结果
        while (!pq.isEmpty()) {
            int[] target = pq.poll();
            int steps = bfs(sx, sy, target[0], target[1]);
//            System.out.println("(" + sx + "," + sy + "), (" + target[0] + "," + target[1] + "), step = " + steps);
            if (steps == -1) {
                return -1;
            }
            res += steps;
            sx = target[0];
            sy = target[1];
        }

        return res;
    }

    public static void main(String[] args) {
        CutOffTreesForGolfEvent cot = new CutOffTreesForGolfEvent();
        List<List<Integer>> forest = new ArrayList<>();
        forest.add(new ArrayList<>(Arrays.asList(4,2,3)));
        forest.add(new ArrayList<>(Arrays.asList(0,0,1)));
        forest.add(new ArrayList<>(Arrays.asList(7,6,5)));
        System.out.println(cot.cutOffTreePriorityQueue(forest));
    }
}
