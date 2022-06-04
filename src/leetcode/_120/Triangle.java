package leetcode._120;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/triangle/
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] pathSum = new int[n];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > -1; j--) {
                int curVal = triangle.get(i).get(j);
                if (j == 0) {
                    pathSum[j] = curVal + pathSum[j];
                } else if (j == i) {
                    pathSum[j] = curVal + pathSum[j - 1];
                } else {
                    pathSum[j] = curVal + Math.min(pathSum[j], pathSum[j - 1]);
                }
                if (i == n - 1) {
                    res = Math.min(res, pathSum[j]);
                }
            }
        }
//        ArrayUtils.printArray(pathSum);
        return res;
    }

    public static void main(String[] args) {
        Triangle tri = new Triangle();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(2)));
        triangle.add(new ArrayList<>(Arrays.asList(3,4)));
        triangle.add(new ArrayList<>(Arrays.asList(6,5,7)));
        triangle.add(new ArrayList<>(Arrays.asList(4,1,8,3)));
        System.out.println(tri.minimumTotal(triangle));
    }
}
