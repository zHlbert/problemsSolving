package leetcode._1108;

/**
 * https://leetcode.cn/problems/defanging-an-ip-address/
 */
public class DefangingAnIPAddress {
    public String defangIPaddr(String address) {
//        String[] addrs = address.split("\\.");
//
        return String.join("[.]", address.split("\\."));
//        return address.replaceAll("\\.", "[.]");
    }
}
