package leetcode._811;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> cntMap = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] cd = cpdomain.split(" ");
            String[] domains = cd[1].split("\\.");
            int n = domains.length;
            StringBuilder domain = new StringBuilder();
            for (int i = n - 1; i >= 0; i--) {
                if (i != n - 1) {
                    domain.insert(0, domains[i] + ".");
                } else {
                    domain.insert(0, domains[i]);
                }
                cntMap.put(domain.toString(), cntMap.getOrDefault(domain.toString(), 0) + Integer.parseInt(cd[0]));
            }
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : cntMap.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }
}
