package leetcode._1051;

/**
 * https://leetcode.cn/problems/compare-version-numbers/
 */
public class HeightChecker {
    /**
     * 计数排序
     * @param heights
     * @return
     */
    public int heightChecker(int[] heights) {
        int[] cnt = new int[101];
        for (int height : heights) {
            cnt[height]++;
        }

        int mIdx = 0, res = 0;
        for (int i = 1; i < 101; i++) {
            int c = cnt[i];
            for (int j = 0; j < c; j++) {
                if (heights[mIdx + j] != i) {
                    res++;
                }
            }
            mIdx += c;
        }
        return res;
    }

    public static void main(String[] args) {
        HeightChecker hc = new HeightChecker();
//        int[] heights = new int[] {5,1,2,3,4};
        int[] heights = new int[] {1,2,3,4,5};
        System.out.println(hc.heightChecker(heights));
    }
}
