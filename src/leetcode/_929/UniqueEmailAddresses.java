package leetcode._929;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/unique-email-addresses/
 */
public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for (String email : emails) {
            int domainStart = email.indexOf('@');
            String localName = email.substring(0, domainStart);
            String domainName = email.substring(domainStart);
            if (localName.contains("+")) {
                localName = localName.substring(0, localName.indexOf('+'));
            }
            if (!localName.contains(".")) {
                emailSet.add(localName + domainName);
            }
            emailSet.add(localName.replace(".","") + domainName);
        }
        return emailSet.size();
    }

    public static void main(String[] args) {
//        String s = "ss@qq.com";
//        int i = s.indexOf("@");
//        System.out.println(s.substring(0, i));
//        System.out.println(s.substring(i));
        UniqueEmailAddresses uea = new UniqueEmailAddresses();
        String[] emails = new String[] {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(uea.numUniqueEmails(emails));
    }
}
