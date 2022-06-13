package leetcode._380;

import java.util.*;

/**
 * https://leetcode.cn/problems/insert-delete-getrandom-o1/
 */
public class InsertDeleteGetRandomO1 {
    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        rs.insert(1);
        rs.insert(10);
        rs.insert(20);
        rs.insert(30);
        for (int i = 0; i < 5; i++) {
            System.out.println(rs.getRandom());
        }
    }
}

class RandomizedSet {
    Random random;
    Set<Integer> set;
    int insCnt = 0, rmCnt = 0;
    int gInsCnt = 0, gRmCnt = 0;
    Integer[] nums = null;

    public RandomizedSet() {
        random = new Random();
        set = new HashSet<>();
    }

    public boolean insert(int val) {
        boolean existed = set.contains(val);
        if (!existed) {
            set.add(val);
            insCnt++;
        }
        return !existed;
    }

    public boolean remove(int val) {
        boolean existed = set.contains(val);
        if (existed) {
            set.remove(val);
            rmCnt++;
        }
        return existed;
    }

    public int getRandom() {
//        System.out.println(set);
        if (nums == null || gInsCnt != insCnt || gRmCnt != rmCnt) {
            nums = set.toArray(new Integer[0]);
        }

        int res = nums[random.nextInt(nums.length)];

        gInsCnt = insCnt;
        gRmCnt = rmCnt;

        return res;
    }
}

class RandomizedSet1 {
    Random random;
    Map<Integer, Integer> map;
    List<Integer> list;

    public RandomizedSet1() {
        random = new Random();
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int idx = map.get(val);
        int last = list.get(list.size() - 1);
        list.set(idx, last);
        map.put(last, idx);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
