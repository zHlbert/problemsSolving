package contest.leetcode2022031302;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个链表的头结点 head，判断链表删除一个节点后是否可以成为「回文链表」。
 * 若可以，则返回 true；否则返回 false
 *
 * 注意：
 *
 * 输入用例均保证链表长度 大于等于 3
 * 示例 1：
 *
 * 输入：head = [1,2,2,3,1]
 *
 * 输出：true
 *
 * 解释：如下图所示，蓝色结点为删除的结点
 * 删除该节点后，链表为「回文链表」 [1,2,2,1]，返回 true
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        for (ListNode tmp = head; tmp != null; tmp = tmp.next) {
            list.add(tmp.val);
        }
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            if (!list.get(i).equals(list.get(j))) {
                return check(list, i, j - 1) || check(list, i + 1, j);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean check(List<Integer> list, int i, int j) {
        while (i < j) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
