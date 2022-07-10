package contest.leetcode20220710;

import java.util.*;

public class SmallestNumberInInfiniteSet {

    public static void main(String[] args) {
        SmallestInfiniteSet ss = new SmallestInfiniteSet();
        ss.addBack(2);
        System.out.println(ss.popSmallest());
        System.out.println(ss.popSmallest());
        System.out.println(ss.popSmallest());
        ss.addBack(1);
        System.out.println(ss.popSmallest());
        System.out.println(ss.popSmallest());
        System.out.println(ss.popSmallest());
    }
}

class SmallestInfiniteSet {

    TreeSet<Integer> notIn;

    public SmallestInfiniteSet() {
        notIn = new TreeSet<>();
    }

    public int popSmallest() {
        List<Integer> list = new ArrayList<>(notIn);
        int pre = 0;
        for (int cur : list) {
            if (cur - pre > 1) {
                break;
            }
            pre = cur;
        }
        int pop = pre + 1;
        notIn.add(pop);
        return pop;
    }

    public void addBack(int num) {
        notIn.remove(num);
    }
}