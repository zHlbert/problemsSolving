package leetcode._1825;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.TreeMap;

/**
 * 求出 MK 平均值
 * https://leetcode.cn/problems/finding-mk-average/
 */
public class FindingMKAverage {

}

/**
 * 有序集合
 * https://leetcode.cn/problems/finding-mk-average/solution/qiu-chu-mk-ping-jun-zhi-by-leetcode-solu-sos6/
 */
class MKAverage {

    int m, k;
    Queue<Integer> q = new ArrayDeque<>();
    TreeMap<Integer, Integer> s1 = new TreeMap<>(), s2 = new TreeMap<>(), s3 = new TreeMap<>();
    int size1, size2, size3;
    long sum2;

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        size1 = size2 = size3 = 0;
        sum2 = 0;
    }

    public void addElement(int num) {
        q.offer(num);
        if (q.size() <= m) {
            s2.put(num, s2.getOrDefault(num, 0) + 1);
            size2++;
            sum2 += num;
            if (q.size() == m) {
                while (size1 < k) {
                    int firstNum = s2.firstKey();
                    s1.put(firstNum, s1.getOrDefault(firstNum, 0) + 1);
                    size1++;
                    sum2 -= firstNum;
                    s2.put(firstNum, s2.get(firstNum) - 1);
                    if (s2.get(firstNum) == 0) s2.remove(firstNum);
                    size2--;
                }
                while (size3 < k) {
                    int lastNum = s2.lastKey();
                    s3.put(lastNum, s3.getOrDefault(lastNum, 0) + 1);
                    size3++;
                    sum2 -= lastNum;
                    s2.put(lastNum, s2.get(lastNum) - 1);
                    if (s2.get(lastNum) == 0) s2.remove(lastNum);
                    size2--;
                }
            }
            return;
        }

        if (num < s1.lastKey()) {
            s1.put(num, s1.getOrDefault(num, 0) + 1);
            int lastNum = s1.lastKey();
            s2.put(lastNum, s2.getOrDefault(lastNum, 0) + 1);
            size2++;
            sum2 += lastNum;
            s1.put(lastNum, s1.get(lastNum) - 1);
            if (s1.get(lastNum) == 0) s1.remove(lastNum);
        } else if (num > s3.firstKey()) {
            s3.put(num, s3.getOrDefault(num, 0) + 1);
            int firstNum = s3.firstKey();
            s2.put(firstNum, s2.getOrDefault(firstNum, 0) + 1);
            size2++;
            sum2 += firstNum;
            s3.put(firstNum, s3.get(firstNum) - 1);
            if (s3.get(firstNum) == 0) s3.remove(firstNum);
        } else {
            s2.put(num, s2.getOrDefault(num, 0) + 1);
            size2++;
            sum2 += num;
        }

        int x = q.poll();
        if (s1.containsKey(x)) {
            s1.put(x, s1.get(x) - 1);
            if (s1.get(x) == 0) s1.remove(x);
            int firstNum = s2.firstKey();
            s1.put(firstNum, s1.getOrDefault(firstNum, 0) + 1);
            sum2 -= firstNum;
            s2.put(firstNum, s2.get(firstNum) - 1);
            if (s2.get(firstNum) == 0) s2.remove(firstNum);
            size2--;
        } else if (s3.containsKey(x)) {
            s3.put(x, s3.get(x) - 1);
            if (s3.get(x) == 0) s3.remove(x);
            int lastNum = s2.lastKey();
            s3.put(lastNum, s3.getOrDefault(lastNum, 0) + 1);
            sum2 -= lastNum;
            s2.put(lastNum, s2.get(lastNum) - 1);
            if (s2.get(lastNum) == 0) s2.remove(lastNum);
            size2--;
        } else {
            s2.put(x, s2.get(x) - 1);
            if (s2.get(x) == 0) s2.remove(x);
            size2--;
            sum2 -= x;
        }
    }

    public int calculateMKAverage() {
        return q.size() < m ? -1 : (int) (sum2 / (m - 2 * k));
    }
}
