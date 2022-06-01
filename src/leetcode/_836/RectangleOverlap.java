package leetcode._836;

public class RectangleOverlap {
//    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
//        // rec2 的左下角在 rec1 范围内
//        boolean blOL = rec2[0] >= rec1[0] && rec2[1] >= rec1[1] && rec2[0] <= rec1[2] && rec2[1] <= rec1[3]
//                && !(rec2[0] == rec1[0] && rec2[1] == rec1[3]) && !(rec2[0] == rec1[2] && rec2[1] == rec1[1]);
//        // rec2 的右上角在 rec1 范围内
//        boolean trOL = rec2[2] >= rec1[0] && rec2[3] >= rec1[1] && rec2[2] <= rec1[2] && rec2[3] <= rec1[3]
//                && !(rec2[2] == rec1[0] && rec2[3] == rec1[3]) && !(rec2[2] == rec1[2] && rec2[3] == rec1[1]);
//
//        int midx2 = (rec2[0] + rec2[2]) >> 1, midy2 = (rec2[1] + rec2[3]) >> 1;
//        boolean midOL = midx2 >= rec1[0] && midy2 >= rec2[1] && midx2 <= rec1[2] && midy2 <= rec1[3];
//
//        return blOL || trOL || midOL;
//    }

    /**
     * 如果两个矩形重叠，那么它们重叠的区域一定也是一个矩形，
     * 那么这代表了两个矩形与 x 轴平行的边（水平边）投影到 x 轴上时会有交集，
     * 与 y 轴平行的边（竖直边）投影到 y 轴上时也会有交集
     *
     * @param rec1
     * @param rec2
     * @return
     */
    public boolean isRectangleOverlapProjection(int[] rec1, int[] rec2) {
        // 两个矩形的右上角 x/y 坐标最小值 需要大于 两个矩形的坐下角 x/y 坐标最大值
        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0])
                && Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));
    }

    public boolean isRectangleOverlapLoc(int[] rec1, int[] rec2) {
        // 其中一个面积为0
        if (rec1[0] == rec1[2] || rec1[1] == rec1[3] || rec2[0] == rec2[2] || rec2[1] == rec2[3]) {
            return false;
        }
        return !(rec1[2] <= rec2[0]
                || rec1[3] <= rec2[1]
                || rec1[0] >= rec2[2]
                || rec1[1] >= rec2[3]);
    }

    public static void main(String[] args) {
        RectangleOverlap r = new RectangleOverlap();
        int[] rec1 = new int[] {0,0,1,1};
        int[] rec2 = new int[] {1,0,2,1};
        System.out.println(r.isRectangleOverlapLoc(rec1, rec2));
    }
}
