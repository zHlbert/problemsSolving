package leetcode._944;

/**
 * https://leetcode.cn/problems/delete-columns-to-make-sorted/
 */
public class DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] strs) {
        int l = strs[0].length();
        int n = strs.length;
        int notRanked = 0;
        for (int i = 0; i < l; i++) {
            char pre = strs[0].charAt(i);
            for (int j = 1; j < n; j++) {
                if (strs[j].charAt(i) < pre) {
                    notRanked++;
                    break;
                }
                pre = strs[j].charAt(i);
            }
        }
        return notRanked;
    }

    public static void main(String[] args) {
        DeleteColumnsToMakeSorted dcms = new DeleteColumnsToMakeSorted();
//        String[] strs = new String[] {"cba","daf","ghi"};
        String[] strs = new String[] {"zyx","wvu","tsr"};
        System.out.println(dcms.minDeletionSize(strs));
    }
}
