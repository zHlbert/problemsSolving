package leetcode._1774;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/closest-dessert-cost/
 */
public class ClosestDessertCost {
    int closestCost = 10005;
    int minDiff = Integer.MAX_VALUE;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        Arrays.sort(baseCosts);
        Arrays.sort(toppingCosts);
        for (int baseCost : baseCosts) {
            if (baseCost - target > minDiff) {
                break;
            }
            backtrack(toppingCosts, target, baseCost, 0);
        }
        return closestCost;
    }

    // 回溯
    private void backtrack(int[] toppingCosts, int target, int cost, int ti) {
        int curDiff = Math.abs(cost - target);
        if (curDiff < minDiff || curDiff == minDiff && cost < closestCost) {
            closestCost = cost;
            minDiff = curDiff;
        }
        if (ti == toppingCosts.length) {
            return;
        }

        for (int i = ti; i < toppingCosts.length; i++) {
            for (int j = 1; j < 3; j++) {
                int nCost = cost + toppingCosts[i] * j;
                if (nCost - target > minDiff) {
                    break;
                }
                backtrack(toppingCosts, target, nCost, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        ClosestDessertCost cdc = new ClosestDessertCost();
//        int[] baseCosts = new int[] {1,7};
//        int[] toppingCosts = new int[] {3,4};
//        int target = 10;
//        int[] baseCosts = new int[] {2,3};
//        int[] toppingCosts = new int[] {4,5,100};
//        int target = 18;
        int[] baseCosts = new int[] {3,10};
        int[] toppingCosts = new int[] {2,5};
        int target = 9;
        System.out.println(cdc.closestCost(baseCosts, toppingCosts, target));
    }
}
