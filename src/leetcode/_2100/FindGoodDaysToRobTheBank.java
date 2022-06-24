package leetcode._2100;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/find-good-days-to-rob-the-bank/
 */
public class FindGoodDaysToRobTheBank {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        List<Integer> res = new ArrayList<>();
        if (time == 0) {
            for (int i = 0; i < n; i++) {
                res.add(i);
            }
            return res;
        }

        int[] nonIncrDays = new int[n];
        for (int i = 1; i < n; i++) {
            nonIncrDays[i] = security[i] <= security[i - 1] ? nonIncrDays[i - 1] + 1 : 0;
        }

        int[] nonDecrDays = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            nonDecrDays[i] = security[i] <= security[i + 1] ? nonDecrDays[i + 1] + 1 : 0;
        }


        for (int i = 0; i < n; i++) {
            if (nonDecrDays[i] >= time && nonIncrDays[i] >= time) {
                res.add(i);
            }
        }
        return res;
    }
    public List<Integer> goodDaysToRobBank1(int[] security, int time) {
        int n = security.length;
        List<Integer> res = new ArrayList<>();
        if (time == 0) {
            for (int i = 0; i < n; i++) {
                res.add(i);
            }
            return res;
        }

        int[] nonIncrDays = new int[n];
        for (int i = 1; i < n; i++) {
            nonIncrDays[i] = security[i] <= security[i - 1] ? nonIncrDays[i - 1] + 1 : 0;
        }

        int[] nonDecrDays = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            nonDecrDays[i] = security[i] <= security[i + 1] ? nonDecrDays[i + 1] + 1 : 0;
            if (nonDecrDays[i] >= time && nonIncrDays[i] >= time) {
                res.add(i);
            }
        }
        return res;
    }

    public List<Integer> goodDaysToRobBank2(int[] security, int time) {
        int n = security.length;
        List<Integer> res = new ArrayList<>();
        if (time == 0) {
            res.add(0);
        }

        for (int i = 1, l = 0, r = 0; i < n - time; i++) {
            l = security[i] <= security[i - 1] ? l + 1 : 0;
            r = security[i + time - 1] <= security[i + time] ? r + 1 : 0;
            if (l >= time && r >= time) {
                res.add(i);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        FindGoodDaysToRobTheBank fgd = new FindGoodDaysToRobTheBank();
//        int[] security = new int[] {5,3,3,3,5,6,2};
//        int time = 2;
//        int[] security = new int[] {1,1,1,1,1};
//        int time = 0;
        int[] security = new int[] {1,2,3,4,5,6};
        int time = 2;
        System.out.println(fgd.goodDaysToRobBank2(security, time));
    }
}
