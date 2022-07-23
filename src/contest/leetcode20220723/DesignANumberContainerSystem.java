package contest.leetcode20220723;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class DesignANumberContainerSystem {
    public static void main(String[] args) {
        NumberContainers nc = new NumberContainers();
        System.out.println(nc.find(10));
        nc.change(2,10);
        nc.change(1,10);
        nc.change(3,10);
        nc.change(5,10);
        System.out.println(nc.find(10));
        nc.change(1,20);
        System.out.println(nc.find(10));
    }
}

class NumberContainers {

    Map<Integer, Integer> i2n;
    Map<Integer, TreeSet<Integer>> n2i;

    public NumberContainers() {
        i2n = new HashMap<>();
        n2i = new HashMap<>();
    }

//    public void change(int index, int number) {
//        if (!i2n.containsKey(index)) {
//            i2n.put(index, number);
//            TreeSet<Integer> indices = n2i.getOrDefault(number, new TreeSet<>());
//            indices.add(index);
//            n2i.put(number, indices);
//            return;
//        }
//        Integer pre = i2n.get(index);
//        TreeSet<Integer> preSet = n2i.get(pre);
//        preSet.remove(index);
//        TreeSet<Integer> set = n2i.getOrDefault(number, new TreeSet<>());
//        set.add(index);
//        n2i.put(number, set);
//        i2n.put(index, number);
//    }

    public void change(int index, int number) {
        if (i2n.containsKey(index)) {
            int preNum = i2n.get(index);
            TreeSet<Integer> preSet = n2i.get(preNum);
            preSet.remove(index);
            n2i.put(preNum, preSet);
        }
        i2n.put(index, number);
        TreeSet<Integer> set = n2i.getOrDefault(number, new TreeSet<>());
        set.add(index);
        n2i.put(number, set);
    }

    public int find(int number) {
        TreeSet<Integer> indices = n2i.getOrDefault(number, new TreeSet<>());
        if (indices.isEmpty()) {
            return -1;
        }
        return indices.first();
    }


}
