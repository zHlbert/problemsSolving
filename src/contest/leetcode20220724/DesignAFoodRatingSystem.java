package contest.leetcode20220724;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class DesignAFoodRatingSystem {

    public static void main(String[] args) {
        String[] foods = new String[] {"czopaaeyl","lxoozsbh","kbaxapl"};
        String[] cuisines = new String[] {"dmnuqeatj","dmnuqeatj","dmnuqeatj"};
        int[] ratings = new int[] {11,2,15};
        FoodRatings fr = new FoodRatings(foods, cuisines, ratings);
        fr.changeRating("czopaaeyl",12);
        System.out.println(fr.highestRated("dmnuqeatj"));
        fr.changeRating("kbaxapl",8);
        fr.changeRating("lxoozsbh",5);
        System.out.println(fr.highestRated("dmnuqeatj"));
//        System.out.println(fr.highestRated("korean"));
//        System.out.println(fr.highestRated("japanese"));
//        fr.changeRating("sushi",16);
//        System.out.println(fr.highestRated("japanese"));
//        fr.changeRating("ramen",16);
//        System.out.println(fr.highestRated("japanese"));
    }

}

class FoodRatings {

    Map<String, TreeSet<String>> cs2food;
    Map<String, Integer> food2rt;
    Map<String, String> food2cs;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        food2rt = new HashMap<>();
        food2cs = new HashMap<>();
        int n = foods.length;
        for (int i = 0; i < n; i++) {
            food2rt.put(foods[i], ratings[i]);
            food2cs.put(foods[i], cuisines[i]);
        }
        cs2food = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String cuisine = cuisines[i];
            TreeSet<String> set = cs2food.getOrDefault(cuisine, new TreeSet<>((a, b) -> {
                if (food2rt.get(a).compareTo(food2rt.get(b)) == 0) {
                    return a.compareTo(b);
                }
//                System.out.println("a: " + a + ", b: " + b
//                        + ", food2rt.get(b) = " + food2rt.get(b) + ", food2rt.get(a) = " + food2rt.get(a)
//                        + ", food2rt.get(b).compareTo(food2rt.get(a)) : " + food2rt.get(b).compareTo(food2rt.get(a)));
                return food2rt.get(b).compareTo(food2rt.get(a));
            }));
            set.add(foods[i]);
//            System.out.println(cuisine + " : " + set);
            cs2food.put(cuisine, set);
        }
    }

    public void changeRating(String food, int newRating) {
//        food2rt.remove(food);
        String cuisine = food2cs.get(food);
        TreeSet<String> set = cs2food.get(cuisine);
//        System.out.println(set);
//        System.out.println(food + " : contains " + set.contains(food));
        set.remove(food);
        food2rt.put(food, newRating);
        set.add(food);
        cs2food.put(food, set);
    }

    public String highestRated(String cuisine) {
        if (!cs2food.containsKey(cuisine)) {
            return "";
        }
        return cs2food.get(cuisine).first();
    }
}
