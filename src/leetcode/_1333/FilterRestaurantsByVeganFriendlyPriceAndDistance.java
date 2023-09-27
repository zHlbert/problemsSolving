package leetcode._1333;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FilterRestaurantsByVeganFriendlyPriceAndDistance {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> res = new ArrayList<>();
        for (int[] restaurant : restaurants) {
            if ((veganFriendly == 1 && restaurant[2] == veganFriendly || veganFriendly == 0)
                    && restaurant[3] <= maxPrice && restaurant[4] <= maxDistance) {
                res.add(restaurant);
            }
        }
        return res.stream().sorted((a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]).map(a -> a[0]).collect(Collectors.toList());
    }
}
