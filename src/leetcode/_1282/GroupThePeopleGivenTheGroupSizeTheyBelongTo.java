package leetcode._1282;

import java.util.ArrayList;
import java.util.List;

public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        List<Integer>[] groups = new List[n + 1];

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int gs = groupSizes[i];
            if (groups[gs] == null) {
                groups[gs] = new ArrayList<>();
            }
            groups[gs].add(i);
            if (groups[gs].size() == gs) {
                res.add(new ArrayList<>(groups[gs]));
                groups[gs].clear();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        GroupThePeopleGivenTheGroupSizeTheyBelongTo gp = new GroupThePeopleGivenTheGroupSizeTheyBelongTo();
//        int[] groupSizes = new int[] {3,3,3,3,3,1,3};
        int[] groupSizes = new int[] {2,1,3,3,3,2};
        System.out.println(gp.groupThePeople(groupSizes));
    }
}
