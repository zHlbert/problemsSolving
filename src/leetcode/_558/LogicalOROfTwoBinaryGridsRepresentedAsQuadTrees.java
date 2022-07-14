package leetcode._558;

/**
 * https://leetcode.cn/problems/logical-or-of-two-binary-grids-represented-as-quad-trees/
 */
public class LogicalOROfTwoBinaryGridsRepresentedAsQuadTrees {
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf && quadTree2.isLeaf) {
            return new Node(quadTree1.val || quadTree2.val, true, null, null, null, null);
        }
        if (quadTree1.isLeaf) {
            if (quadTree1.val) {
                return new Node(true, true, null, null, null, null);
            }
            return new Node(quadTree2.val, false, quadTree2.topLeft, quadTree2.topRight, quadTree2.bottomLeft, quadTree2.bottomRight);
        }
        if (quadTree2.isLeaf) {
            if (quadTree2.val) {
                return new Node(true, true, null, null, null, null);
            }
            return new Node(quadTree1.val, false, quadTree1.topLeft, quadTree1.topRight, quadTree1.bottomLeft, quadTree1.bottomRight);
        }

        Node tl = intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node tr = intersect(quadTree1.topRight, quadTree2.topRight);
        Node bl = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node br = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        if (tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf && tl.val == tr.val && tl.val == bl.val && tl.val == br.val) {
            return new Node(tl.val, true, null, null, null, null);
        }

        return new Node(quadTree1.val || quadTree2.val, false, tl, tr, bl, br);
    }

    public static void main(String[] args) {
        LogicalOROfTwoBinaryGridsRepresentedAsQuadTrees lot = new LogicalOROfTwoBinaryGridsRepresentedAsQuadTrees();
        Node node1 = new Node();
        node1.isLeaf = false;
        node1.val = true;
        node1.topLeft = new Node(true, true, null, null, null, null);
        node1.topRight = new Node(true, true, null, null, null, null);
        node1.bottomLeft = new Node(false, true, null, null, null, null);
        node1.bottomRight = new Node(false, true, null, null, null, null);
        Node node2 = new Node();
        node2.isLeaf = false;
        node2.val = true;
        node2.topLeft = new Node(true, true, null, null, null, null);
        node2.topRight = new Node();
        node2.topRight.val = true;
        node2.topRight.isLeaf = false;
        node2.topRight.topLeft = new Node(false, true, null, null, null, null);
        node2.topRight.topRight = new Node(false, true, null, null, null, null);
        node2.topRight.bottomLeft = new Node(false, true, null, null, null, null);
        node2.topRight.bottomRight = new Node(false, true, null, null, null, null);
        node2.bottomLeft = new Node(true, true, null, null, null, null);
        node2.bottomRight = new Node(false, true, null, null, null, null);
        Node node = lot.intersect(node1, node2);
        System.out.println(node.val);
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

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
