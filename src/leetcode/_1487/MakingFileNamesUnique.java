package leetcode._1487;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingFileNamesUnique {
    public String[] getFolderNames(String[] names) {
        int n = names.length;
        String[] res = new String[n];
        int i = 0;
        Map<String, Integer> files = new HashMap<>();
        for (String name : names) {
            if (!files.containsKey(name)) {
                res[i++] = name;
                files.put(name, 1);
            } else {
                int k = files.get(name);
                while (files.containsKey(addSuffix(name, k))) {
                    k++;
                }
                res[i++] = addSuffix(name, k);
                files.put(name, k + 1);
                files.put(addSuffix(name, k), 1);
            }
        }
        return res;
    }

    private String addSuffix(String name, int k) {
        return name + "(" + k + ")";
    }
}
