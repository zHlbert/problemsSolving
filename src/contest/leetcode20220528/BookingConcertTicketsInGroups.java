package contest.leetcode20220528;

import utils.ArrayUtils;

/**
 * https://leetcode.cn/contest/biweekly-contest-79/problems/booking-concert-tickets-in-groups/
 */
public class BookingConcertTicketsInGroups {
    public static void main(String[] args) {
        BookMyShow bms = new BookMyShow(2,5);
        ArrayUtils.printArray(bms.gather(4,0));
        ArrayUtils.printArray(bms.gather(2,0));
        System.out.println(bms.scatter(5,1));
        System.out.println(bms.scatter(5,1));
    }
}

class BookMyShow {
    int row, column;
    int[] used;
    long remains;
    public BookMyShow(int n, int m) {
        row = n;
        column = m;
        used = new int[n];
        remains = (long) row * column;
    }

    public int[] gather(int k, int maxRow) {
        if (k > column || k > remains) {
            return new int[0];
        }
        for (int i = 0; i <= maxRow; i++) {
            if (column - used[i] >= k) {
                int[] res = {i, used[i]};
                used[i] += k;
                remains -= k;
                return res;
            }
        }
        return new int[0];
    }

    public boolean scatter(int k, int maxRow) {
        if (k > remains) {
            return false;
        }
        int rem = k;
        boolean sitSuccess = false;
        int endRow = 0;
        for (int i = 0; i <= maxRow; i++) {
            rem -= column - used[i];
            if (rem <= 0) {
                sitSuccess = true;
                endRow = i;
                break;
            }
        }

        if (sitSuccess) {
            for (int i = 0; i < endRow; i++) {
                remains -= column - used[i];
                used[i] = column;
            }
            remains -= column + rem - used[endRow];
            used[endRow] = column + rem;
        }

        return sitSuccess;
    }
}
