package leetcode._2011;

public class FinalValueOfVariableAfterPerformingOperations {
    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (String op : operations)
            if (op.charAt(1) == '+') res ++;
            else res --;
        return res;
    }

    public static void main(String[] args) {
        FinalValueOfVariableAfterPerformingOperations fv = new FinalValueOfVariableAfterPerformingOperations();
        System.out.println(fv.finalValueAfterOperations(new String[] {"++X"}));
    }
}
