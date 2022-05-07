package contest.leetcode20210725;

/**
 * You are given a string num, which represents a large integer. You are also given a 0-indexed integer array change of length 10 that maps each digit 0-9 to another digit. More formally, digit d maps to digit change[d].
 *
 * You may choose to mutate any substring of num. To mutate a substring, replace each digit num[i] with the digit it maps to in change (i.e. replace num[i] with change[num[i]]).
 *
 * Return a string representing the largest possible integer after mutating (or choosing not to) any substring of num.
 *
 * A substring is a contiguous sequence of characters within the string.
 */
public class LargestNumberAfterMutatingSubstring {
    public String maximumNumber(String num, int[] change) {
        boolean changed = false;
        boolean equals = false;
        char[] chars = num.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (changed) {
                break;
            }
            for (int j = i; j < chars.length; j++) {
                int n = chars[j] - '0';
                if (change[n] > n) {
                    chars[j] = (char) (change[n] + 48);
                    changed = true;
                } else if (change[n] == n) {
                    equals = true;
                } else if (changed || equals) {
                    break;
                }
            }
        }
        return new String(chars);
    }

    public String maximumNumber1(String num, int[] change) {
        char[] chars = num.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int n = chars[i] - '0';
            if (change[n] > n) {
                for (int j = i; j < chars.length && change[chars[j] - '0'] >= chars[j] - '0'; j++) {
                    chars[j] = (char) (change[chars[j] - '0'] + 48);
                }
                return new String(chars);
            }
        }
        return new String(chars);
    }

    /*
    "334111"
[0,9,2,3,3,2,5,5,5,5]
214010
6,7,9,7,4,0,3,4,4,7
            */

    public static void main(String[] args) {
        LargestNumberAfterMutatingSubstring l = new LargestNumberAfterMutatingSubstring();
        System.out.println(l.maximumNumber1("214010", new int[] {6,7,9,7,4,0,3,4,4,7}));
    }
}
