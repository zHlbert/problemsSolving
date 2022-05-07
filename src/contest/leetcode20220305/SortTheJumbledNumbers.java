package contest.leetcode20220305;

import java.util.*;

/**
 * 给你一个下标从 0 开始的整数数组 mapping ，它表示一个十进制数的映射规则，mapping[i] = j 表示这个规则下将数位 i 映射为数位 j 。
 *
 * 一个整数 映射后的值 为将原数字每一个数位 i （0 <= i <= 9）映射为 mapping[i] 。
 *
 * 另外给你一个整数数组 nums ，请你将数组 nums 中每个数按照它们映射后对应数字非递减顺序排序后返回。
 *
 * 注意：
 *
 * 如果两个数字映射后对应的数字大小相同，则将它们按照输入中的 相对顺序 排序。
 * nums 中的元素只有在排序的时候需要按照映射后的值进行比较，返回的值应该是输入的元素本身。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-the-jumbled-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortTheJumbledNumbers {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<Integer> numList = new ArrayList<>(nums.length);
        Map<Integer, Integer> numMap = new HashMap<>(nums.length);
        for (Integer num : nums) {
            numList.add(num);
            numMap.put(num, mapNum(mapping, num));
        }
        numList.sort(Comparator.comparingInt(numMap::get));
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numList.get(i);
        }
        return nums;
    }

    private int mapNum(int[] mapping, int num) {
        String numStr = String.valueOf(num);
        int newNum = 0;
        for (int i = 0; i < numStr.length(); i++) {
            newNum = 10 * newNum + mapping[numStr.charAt(i) - '0'];
        }
        return newNum;
    }
}
