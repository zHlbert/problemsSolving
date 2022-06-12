package amazon202206.countDecreasing;

import java.util.*;

public class CountDecreasing {
    public static long countDecreasingRatings(List<Integer> ratings) {
        // Write your code here
        int n = ratings.size();
        long res = 0;
        for (int i = 0, j = 0; i < n; i++) {
            if (i > 0 && ratings.get(i) != ratings.get(i - 1) - 1) {
                j = i;
            }
            res += i - j + 1;
        }
        return res;
    }

    public static void main(String[] args) {
//        CountDecreasing cd = new CountDecreasing();
//        int[] rates = new int[] {4,3,5,4,3};
        int[] rates = new int[] {4,2,3,1};
        List<Integer> ratings = new ArrayList<>();
        for (int rate : rates) {
            ratings.add(rate);
        }
        System.out.println(countDecreasingRatings(ratings));
    }
}
