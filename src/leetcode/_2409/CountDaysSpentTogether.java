package leetcode._2409;


public class CountDaysSpentTogether {
    static final int[] md = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int[] preSum = new int[13];

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        for (int i = 0; i < 12; i++) {
            preSum[i + 1] = preSum[i] + md[i];
        }
        int left = Math.max(days(arriveAlice), days(arriveBob));
        int right = Math.min(days(leaveAlice), days(leaveBob));
        return Math.max(0, right - left + 1);
    }

    private int days(String date) {
        int mm = (date.charAt(0) - '0') * 10 + (date.charAt(1) - '0');
        int dd = (date.charAt(3) - '0') * 10 + (date.charAt(4) - '0');
        return preSum[mm - 1] + dd;
    }

    public static void main(String[] args) {
        CountDaysSpentTogether cd = new CountDaysSpentTogether();
        System.out.println(cd.countDaysTogether("08-15", "08-18", "08-16", "08-19"));
        System.out.println(cd.countDaysTogether("10-01", "10-31", "11-01", "12-31"));
    }
}
