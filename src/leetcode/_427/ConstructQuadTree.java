package leetcode._427;

/**
 * https://leetcode-cn.com/problems/construct-quad-tree/
 */
public class ConstructQuadTree {
//    boolean[][] boolGrid;
    int[][] grid;
    public Node construct(int[][] grid) {
        int n = grid.length;
//        boolGrid = new boolean[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                boolGrid[i][j] = (grid[i][j] == 1);
//            }
//        }
        this.grid = grid;
//        return dfs(0, n, 0, n);
        return dfs1(0, n, 0, n);
    }

//    private Node dfs(int rFrom, int rTo, int cFrom, int cTo) {
//        boolean b = boolGrid[rFrom][cFrom];
//        if (rTo == rFrom + 1) {
//            return new Node(b, true);
//        }
//
//        boolean whole = true;
//        for (int i = rFrom; i < rTo && whole; i++) {
//            for (int j = cFrom; j < cTo; j++) {
//                if (boolGrid[i][j] != b) {
//                    whole = false;
//                    break;
//                }
//            }
//        }
//        if (whole) {
//            return new Node(b, true);
//        }
//        int cHalf = (cFrom + cTo) / 2;
//        int rHalf = (rFrom + rTo) / 2;
//        return new Node(b, false
//                , dfs(rFrom, rHalf, cFrom, cHalf)
//                , dfs(rFrom, rHalf, cHalf, cTo)
//                , dfs(rHalf, rTo, cFrom, cHalf)
//                , dfs(rHalf, rTo, cHalf, cTo)
//        );
//    }

    private Node dfs1(int rFrom, int rTo, int cFrom, int cTo) {
        boolean b = (grid[rFrom][cFrom] == 1);
        if (rTo == rFrom + 1) {
            return new Node(b, true);
        }
        int cHalf = (cFrom + cTo) / 2;
        int rHalf = (rFrom + rTo) / 2;
        Node topL = dfs1(rFrom, rHalf, cFrom, cHalf);
        Node topR = dfs1(rFrom, rHalf, cHalf, cTo);
        Node bottomL = dfs1(rHalf, rTo, cFrom, cHalf);
        Node bottomR = dfs1(rHalf, rTo, cHalf, cTo);
        if (topL.val == topR.val && topR.val == bottomL.val && bottomL.val == bottomR.val
                && topL.isLeaf && topR.isLeaf && bottomL.isLeaf && bottomR.isLeaf) {
            return new Node(b, true);
        } else {
            return new Node(b, false, topL, topR, bottomL, bottomR);
        }
    }

    public static void main(String[] args) {
        ConstructQuadTree cqt = new ConstructQuadTree();
//        int[][] grid = new int[][] {{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}};
        int[][] grid = new int[][] {{0,1},{1,0}};
        Node node = cqt.construct(grid);
        System.out.println(1);
    }
}

// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
