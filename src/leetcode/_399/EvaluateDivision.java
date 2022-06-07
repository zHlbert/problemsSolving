package leetcode._399;

import java.util.*;

/**
 * https://leetcode.cn/problems/evaluate-division/
 */
public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<Pair, Double> equationVals = new HashMap<>();
        Set<String> varSet = new HashSet<>();
        List<Pair> pairList = new ArrayList<>();
        int n = values.length;
        for (int i = 0; i < n; i++) {
            List<String> divs = equations.get(i);
            equationVals.put(new Pair(divs.get(0), divs.get(1)), values[i]);
            equationVals.put(new Pair(divs.get(1), divs.get(0)), 1.0 / values[i]);
            varSet.add(divs.get(0));
            varSet.add(divs.get(1));
            pairList.add(new Pair(divs.get(0), divs.get(1)));
            pairList.add(new Pair(divs.get(1), divs.get(0)));
        }

        int size = queries.size();
        double[] res = new double[size];
        for (int i = 0; i < size; i++) {
            List<String> query = queries.get(i);
            String var1 = query.get(0);
            String var2 = query.get(1);
            if (!varSet.contains(var1) || !varSet.contains(var2)) {
                res[i] = -1.0;
            } else if (var1.equals(var2)) {
                res[i] = 1.0;
            } else {
                Pair p = new Pair(var1, var2);
                if (equationVals.containsKey(p)) {
                    res[i] = equationVals.get(p);
                } else {
                    res[i] = getByBFS(p, equationVals, pairList);
                }
            }
        }
        return res;
    }

    private double getByBFS(Pair p, Map<Pair, Double> pairMap, List<Pair> pairList) {
        String left = p.left;
        Map<String, Double> map = new HashMap<>();
        Set<String> used = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();
        used.add(left);
        for (Map.Entry<Pair, Double> entry : pairMap.entrySet()) {
            if (left.equals(entry.getKey().left)) {
                map.put(entry.getKey().right, entry.getValue());
                used.add(entry.getKey().right);
                queue.offer(entry.getKey().right);
            }
        }

        String right = p.right;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String var2 = queue.poll();
                if (var2.equals(right)) {
                    return map.get(right);
                }
                for (Pair nPair : pairList) {
                    if (!used.contains(nPair.right) && nPair.left.equals(var2)) {
                        map.put(nPair.right, map.get(var2) * pairMap.get(nPair));
                        used.add(nPair.right);
                        queue.offer(nPair.right);
                    }
                }
            }
        }
        return -1.0;
    }

    public double[] calcEquationUnion(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int eqSize = equations.size();
        // 并查集
        UnionFind unionFind = new UnionFind(2 * eqSize);
        // 变量与id关系
        Map<String, Integer> varIdxMap = new HashMap<>();
        int id = 0;
        for (int i = 0; i < eqSize; i++) {
            List<String> eq = equations.get(i);
            String var1 = eq.get(0);
            String var2 = eq.get(1);
            if (!varIdxMap.containsKey(var1)) {
                varIdxMap.put(var1, id++);
            }
            if (!varIdxMap.containsKey(var2)) {
                varIdxMap.put(var2, id++);
            }
            unionFind.union(varIdxMap.get(var1), varIdxMap.get(var2), values[i]);
        }

        int qSize = queries.size();
        double[] res = new double[qSize];
        for (int i = 0; i < qSize; i++) {
            List<String> q = queries.get(i);
            String var1 = q.get(0);
            String var2 = q.get(1);

            Integer id1 = varIdxMap.get(var1);
            Integer id2 = varIdxMap.get(var2);
            if (id1 == null || id2 == null) {
                res[i] = -1.0d;
            } else {
                res[i] = unionFind.isConnected(id1, id2);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        EvaluateDivision ed = new EvaluateDivision();
        String[][] eqs = new String[][] {{"a","b"},{"b","c"}};
        List<List<String>> equations = new ArrayList<>();
        for (String[] eq : eqs) {
            equations.add(new ArrayList<>(Arrays.asList(eq)));
        }
        double[] values = new double[] {2.0,3.0};
        String[][] qs = new String[][] {{"a","c"},{"b","a"},{"a","e"},{"a","a"},{"x","x"}};
        List<List<String>> queries = new ArrayList<>();
        for (String[] q : qs) {
            queries.add(new ArrayList<>(Arrays.asList(q)));
        }
        double[] res = ed.calcEquationUnion(equations, values, queries);
        for (double re : res) {
            System.out.println(re);
        }
    }
}

class Pair {
    String left;
    String right;

    public Pair(String left, String right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return left.equals(pair.left) && right.equals(pair.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}

class UnionFind {
    private int[] parent;

    private double[] weight;

    public UnionFind(int n) {
        parent = new int[n];
        weight = new double[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            weight[i] = 1.0d;
        }
    }

    public void union(int x, int y, double value) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        parent[rootX] = rootY;
        // weight[rootX] * weight[x] == weight[y] * value
        weight[rootX] = weight[y] * value / weight[x];
    }

    private int find(int x) {
        if (x != parent[x]) {
            int o = parent[x];
            // x的父节点指向根节点
            parent[x] = find(parent[x]);
            // 权重为到根节点链路上权重之积
            weight[x] *= weight[o];
        }
        return parent[x];
    }

    public double isConnected(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return weight[x] / weight[y];
        }
        return -1.0d;
    }
}
