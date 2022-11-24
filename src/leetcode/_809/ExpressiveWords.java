package leetcode._809;

public class ExpressiveWords {
    public int expressiveWords(String s, String[] words) {
        char[] sc = s.toCharArray();
        int[][] cc = chCnt(sc);
        int res = 0;
        for (String word : words) {
            char[] wc = word.toCharArray();
            int[][] wcc = chCnt(wc);
            if (cc.length != wcc.length) {
                continue;
            }
            boolean stretchy = true;
            for (int i = 0; i < cc.length; i++) {
                if (cc[i][0] != wcc[i][0] || cc[i][1] < wcc[i][1] || cc[i][1] > wcc[i][1] && cc[i][1] < 3) {
                    stretchy = false;
                    break;
                }
            }
//            System.out.println(word + " : " + stretchy);
            if (stretchy) {
                res++;
            }
        }
        return res;
    }

    private int[][] chCnt(char[] sc) {
        int[][] cc = new int[105][2];
        int m = 0;
        cc[0] = new int[] {sc[0] - 'a', 1};
        for (int i = 1; i < sc.length; i++) {
            int dv = sc[i] - 'a';
            if (dv == cc[m][0]) {
                cc[m][1]++;
            } else {
                cc[++m] = new int[] {dv, 1};
            }
        }
        return cc;
    }

    public static void main(String[] args) {
        ExpressiveWords ew = new ExpressiveWords();
//        String s = "heeellooo";
//        String[] words = new String[] {"hello", "hi", "helo"};
        String s = "zzzzzyyyyy";
        String[] words = new String[] {"zzyy","zy","zyy"};
        System.out.println(ew.expressiveWords(s, words));
    }
}
