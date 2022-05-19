package leetcode._406;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/queue-reconstruction-by-height/
 */
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        // 从小到大排序
        Arrays.sort(people, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                // 身高相同，按p[1]降序排
                // 如果按升序排，身高相同的第1个人占了一个位置，第2个人计算前面几个空白时会空白会变少
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

    public int[][] reconstructQueueDown(int[][] people) {
        // 身高大到小排序
        Arrays.sort(people, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                // 身高相同，p[1]升序排序
                // 防止数组越界
                return p1[1] - p2[1];
            }
            return p2[0] - p1[0];
        });
        List<int[]> res = new ArrayList<>(people.length);
        for (int[] person : people) {
            // 直接加入，这样每次到满足前面有p[i]个大于等于p
            res.add(person[1], person);
        }
        return res.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        QueueReconstructionByHeight qr = new QueueReconstructionByHeight();
        int[][] people = new int[][] {{2,4},{3,4},{9,0},{0,6},{7,1},{6,0},{7,3},{2,5},{1,1},{8,0}};
        ArrayUtils.print2DArray(qr.reconstructQueue(people));
    }
}
