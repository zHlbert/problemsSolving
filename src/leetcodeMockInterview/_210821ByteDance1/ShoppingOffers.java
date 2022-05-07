package leetcodeMockInterview._210821ByteDance1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * In LeetCode Store, there are n items to sell. Each item has a price. However, there are some special offers, and a special offer consists of one or more different kinds of items with a sale price.
 *
 * You are given an integer array price where price[i] is the price of the ith item, and an integer array needs where needs[i] is the number of pieces of the ith item you want to buy.
 *
 * You are also given an array special where special[i] is of size n + 1 where special[i][j] is the number of pieces of the jth item in the ith offer and special[i][n] (i.e., the last integer in the array) is the price of the ith offer.
 *
 * Return the lowest price you have to pay for exactly certain items as given, where you could make optimal use of the special offers. You are not allowed to buy more items than you want, even if that would lower the overall price. You could use any of the special offers as many times as you want.
 */
public class ShoppingOffers {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs);
    }

    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int res = 0;
        // 没有使用大礼包的时候，我们需要花多少钱
        for (int i = 0; i < needs.size(); i++) {
            res += needs.get(i) * price.get(i);
        }

        for (List<Integer> specialOne : special) {
            List<Integer> clone = new ArrayList<>(needs);
            int j;
            for (j = 0; j < needs.size(); j++) {
                // 需要个数 - 大礼包里的个数
                int diff = clone.get(j) - specialOne.get(j);
                if (diff < 0) {
                    break;
                }
                // 使用该大礼包后需要个数
                clone.set(j, diff);
            }
            // 若可以使用大礼包
            if (j == needs.size()) {
                res = Math.min(res, specialOne.get(j) + dfs(price, special, clone));
            }
        }
        return res;
    }

    // TODO: 2021/8/21 记忆化搜索

    public static void main(String[] args) {
        ShoppingOffers s = new ShoppingOffers();
        int[] priceArr = new int[] {2,5};
        int[][] specialArr = new int[][] {{3,0,5},{1,2,10}};
        int[] needArr = new int[] {3,2};

        List<Integer> price = Arrays.stream(priceArr).boxed().collect(Collectors.toCollection(ArrayList::new));
        List<List<Integer>> special = new ArrayList<>(specialArr.length);
        for (int[] ints : specialArr) {
            special.add(Arrays.stream(ints).boxed().collect(Collectors.toCollection(ArrayList::new)));
        }
        List<Integer> needs = Arrays.stream(needArr).boxed().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(s.shoppingOffers(price, special, needs));
    }
}
