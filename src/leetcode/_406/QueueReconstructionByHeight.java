package leetcode._406;

import utils.ArrayUtils;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/queue-reconstruction-by-height/
 */
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        // 从小到大排序
        Arrays.sort(people, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                return p2[1] - p1[1];
            }
            return p1[0] - p2[0];
        });
        int n = people.length;
        int[][] res = new int[n][];
        for (int[] person : people) {
            // 大于等于当前person的人数
            int spaces = person[1] + 1;
            for (int i = 0; i < n; i++) {
                // 没有填入表示 这个位置的人身高 大于等于当前person
                if (res[i] == null) {
                    spaces--;
                    if (spaces == 0) {
                        res[i] = person;
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        QueueReconstructionByHeight qr = new QueueReconstructionByHeight();
        int[][] people = new int[][] {{2,4},{3,4},{9,0},{0,6},{7,1},{6,0},{7,3},{2,5},{1,1},{8,0}};
        ArrayUtils.print2DArray(qr.reconstructQueue(people));
    }
}
