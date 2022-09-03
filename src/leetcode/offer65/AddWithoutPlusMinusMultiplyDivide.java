package leetcode.offer65;

/**
 * https://leetcode.cn/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 */
public class AddWithoutPlusMinusMultiplyDivide {
    public int add(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        AddWithoutPlusMinusMultiplyDivide aw = new AddWithoutPlusMinusMultiplyDivide();
        int a = 3, b = 3;
        System.out.println(aw.add(a, b));
    }
}
