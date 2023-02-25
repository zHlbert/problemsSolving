package leetcode._1247;


public class MinimumSwapsToMakeStringsEqual {
    /**
     * 贪心
     * @param s1
     * @param s2
     * @return
     */
    public int minimumSwap(String s1, String s2) {
        char[] sc1 = s1.toCharArray();
        char[] sc2 = s2.toCharArray();
        int xy = 0, yx = 0;
        for (int i = 0; i < sc1.length; i++) {
            xy += sc1[i] == 'x' && sc2[i] == 'y' ? 1 : 0;
            yx += sc1[i] == 'y' && sc2[i] == 'x' ? 1 : 0;
        }
        if ((xy + yx) % 2 == 1) return -1;
        return xy / 2 + yx / 2 + xy % 2 + yx % 2;

    }
}
