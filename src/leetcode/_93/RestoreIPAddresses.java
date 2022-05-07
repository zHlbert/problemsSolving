package leetcode._93;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s containing only digits, return all possible valid IP addresses that can be obtained from s. You can return them in any order.
 *
 * A valid IP address consists of exactly four integers, each integer is between 0 and 255, separated by single dots and cannot have leading zeros. For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses. 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RestoreIPAddresses {
    static final int SEG_COUNT = 4;
    List<String> result = new ArrayList<>();
    String[] segments = new String[SEG_COUNT];
    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0, 0);
        return result;
    }

    /**
     * 回溯
     * @param s
     * @param segNo ip段位置
     * @param segStart 遍历s的位置
     */
    private void backtrack(String s, int segNo, int segStart) {
        // 第四段且遍历到s的最后，则加入结果
        if (segNo == SEG_COUNT && segStart == s.length()) {
            result.add(String.join(".", segments));
            return;
        }
        // 遍历到s的末尾或到达第四段，返回
        if (segStart == s.length() || segNo == SEG_COUNT) {
            return;
        }
        // 当前位为0，那么这一段 IP 地址只能为 0
        if (s.charAt(segStart) == '0') {
            segments[segNo] = "0";
            backtrack(s, segNo + 1, segStart + 1);
        }

        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); segEnd++) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 0xFF) {
                segments[segNo] = String.valueOf(addr);
                backtrack(s, segNo + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        RestoreIPAddresses r = new RestoreIPAddresses();
//        System.out.println(r.restoreIpAddresses("25525511135"));
//        System.out.println(r.restoreIpAddresses("0000"));
//        System.out.println(r.restoreIpAddresses("1111"));
//        System.out.println(r.restoreIpAddresses("010010"));
        System.out.println(r.restoreIpAddresses("101023"));
    }
}
