package leetcode._699;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/falling-squares/
 */
public class FallingSquares {
    public List<Integer> fallingSquares(int[][] positions) {
        int n = positions.length;
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            int left1 = positions[i][0];
            int h1 = positions[i][1];
            int right1 = left1 + h1;
            heights[i] = h1;
            for (int j = 0; j < i; j++) {
                int left2 = positions[j][0], right2 = positions[j][0] + positions[j][1];
                if (right1 > left2 && right2 > left1) {
                    heights[i] = Math.max(heights[i], heights[j] + h1);
                }
            }
        }
//        ArrayUtils.printArray(heights);
        List<Integer> res = new ArrayList<>(n);

        res.add(heights[0]);
        for (int i = 1; i < n; i++) {
            res.add(Math.max(res.get(i - 1), heights[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        FallingSquares fs = new FallingSquares();
        int[][] positions = new int[][] {{9,10},{4,1},{2,1},{7,4},{6,10}};
        System.out.println(fs.fallingSquares(positions));
    }
}
