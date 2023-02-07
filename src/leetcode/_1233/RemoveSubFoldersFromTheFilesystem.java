package leetcode._1233;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveSubFoldersFromTheFilesystem {
    /**
     * 排序
     * @param folder
     * @return
     */
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> res = new ArrayList<>();
        res.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            String s = folder[i];
            String last = res.get(res.size() - 1);
            if (s.startsWith(last + '/')) continue;
            res.add(s);
        }
        return res;
    }

    public static void main(String[] args) {
        RemoveSubFoldersFromTheFilesystem rs = new RemoveSubFoldersFromTheFilesystem();
//        String[] folder = new String[] {"/a","/a/b","/c/d","/c/d/e","/c/f"};
//        String[] folder = new String[] {"/a","/a/b/c","/a/b/d"};
        String[] folder = new String[] {"/a/b/c","/a/b/ca","/a/b/d"};
        System.out.println(rs.removeSubfolders(folder));
    }
}
