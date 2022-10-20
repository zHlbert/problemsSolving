package leetcode._779;

public class KthSymbolInGrammar {
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        boolean odd = (k & 1) == 1;
        int pre = kthGrammar(n - 1, (k + 1) / 2);
        return pre == 0 ? (odd ? 0 : 1) : (odd ? 1 : 0);
    }

    public static void main(String[] args) {
        KthSymbolInGrammar ks = new KthSymbolInGrammar();
        int n = 5;
        for (int i = 1; i <= 16; i++) {
            System.out.print(ks.kthGrammar(n, i));
        }
        System.out.println();
    }
}
