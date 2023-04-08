package leetcode._1125;

import java.util.*;

public class SmallestSufficientTeam {

    /**
     * https://leetcode.cn/problems/smallest-sufficient-team/solution/zui-xiao-de-bi-yao-tuan-dui-by-leetcode-2mbmz/
     * 动态规划 + 状态压缩
     * @param req_skills
     * @param people
     * @return
     */
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length, m = people.size();
        Map<String, Integer> skillIdx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            skillIdx.put(req_skills[i], i);
        }

        int[] dp = new int[1 << n];
        Arrays.fill(dp, m);
        dp[0] = 0;
        int[] preSkill = new int[1 << n];
        int[] prePeople = new int[1 << n];
        for (int i = 0; i < m; i++) {
            List<String> p = people.get(i);
            int skill = 0;
            for (String s : p) {
                skill |= 1 << skillIdx.get(s);
            }
            for (int pre = 0; pre < (1 << n); pre++) {
                int comb = pre | skill;
                if (dp[comb] > dp[pre] + 1) {
                    dp[comb] = dp[pre] + 1;
                    preSkill[comb] = pre;
                    prePeople[comb] = i;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        int i = (1 << n) - 1;
        while (i > 0) {
            res.add(prePeople[i]);
            i = preSkill[i];
        }
        return res.stream().mapToInt(j -> j).toArray();
    }
}
