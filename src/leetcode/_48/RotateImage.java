package leetcode._48;

import java.util.stream.IntStream;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
            for (int i = 0; i < len / 2; i++)
                for (int j = 0; j < (len + 1) / 2; j++)
                    swap4Clock(matrix, wrapCd(i, j), wrapCd(j, len - 1 - i)
                            , wrapCd(len - 1 - i, len - 1 - j), wrapCd(len - 1 - j, i));
    }

    private void swap4Clock(int[][] matrix, int[] lt, int[] rt, int[] rb, int[] lb) {
        int temp = matrix[lt[0]][lt[1]];
        matrix[lt[0]][lt[1]] = matrix[lb[0]][lb[1]];
        matrix[lb[0]][lb[1]] = matrix[rb[0]][rb[1]];
        matrix[rb[0]][rb[1]] = matrix[rt[0]][rt[1]];
        matrix[rt[0]][rt[1]] = temp;
    }

    /**
     * 形成坐标数组
     * @return
     */
    private int[] wrapCd(int x, int y) {
        int[] coordinate = new int[2];
        coordinate[0] = x;
        coordinate[1] = y;
        return coordinate;
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = new int[][] {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
//        int[][] matrix = new int[][] {{1}};
//        int[][] matrix = new int[][] {{1,2},{3,4}};

//        [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
        for (int[] ints : matrix) {
            IntStream.range(0, matrix.length).mapToObj(j -> ints[j] + " ").forEach(System.out::print);
            System.out.println();
        }
        System.out.println();
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(matrix);
        for (int[] ints : matrix) {
            IntStream.range(0, matrix.length).mapToObj(j -> ints[j] + " ").forEach(System.out::print);
            System.out.println();
        }
    }
}
