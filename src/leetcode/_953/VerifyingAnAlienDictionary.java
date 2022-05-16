package leetcode._953;

import utils.ArrayUtils;

public class VerifyingAnAlienDictionary {
    int[] chOrder;
    public boolean isAlienSorted(String[] words, String order) {
        char[] chars = order.toCharArray();
        chOrder = new int[26];
        for (int i = 0; i < 26; i++) {
            chOrder[chars[i] - 'a'] = i;
        }
//        ArrayUtils.printArray(chOrder);
        for (int i = 1; i < words.length; i++) {
            if (compareWords(words[i], words[i - 1]) < 0) {
                return false;
            }
        }
        return true;
    }

    private int compareWords(String w1, String w2) {
        if (w1.equals(w2)) {
            return 0;
        }
        char[] ch1 = w1.toCharArray();
        char[] ch2 = w2.toCharArray();
        for (int i = 0; i < ch1.length && i < ch2.length; i++) {
            int o1 = chOrder[ch1[i] - 'a'];
            int o2 = chOrder[ch2[i] - 'a'];
            if (o1 != o2) {
                return o1 < o2 ? -1 : 1;
            }
        }
        if (ch1.length == ch2.length) {
            return 0;
        }
        return ch1.length > ch2.length ? 1 : -1;
    }

    public static void main(String[] args) {
        VerifyingAnAlienDictionary vad = new VerifyingAnAlienDictionary();
        String[] words = new String[] {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(vad.isAlienSorted(words, order));
    }
}
