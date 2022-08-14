package contest.leetcode20220814;

public class NodeWithHighestEdgeScore {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] scores = new long[n];
        for (int i = 0; i < n; i++) {
            scores[edges[i]] += i;
        }
        int maxI = 0;
        for (int i = 0; i < n; i++) {
            if (scores[i] > scores[maxI]) {
                maxI = i;
            }
        }
        return maxI;
    }

    public static void main(String[] args) {
        NodeWithHighestEdgeScore nh = new NodeWithHighestEdgeScore();
//        int[] edges = new int[] {1,0,0,0,0,7,7,5};
        int[] edges = new int[] {2,0,0,2};
        System.out.println(nh.edgeScore(edges));
    }
}
