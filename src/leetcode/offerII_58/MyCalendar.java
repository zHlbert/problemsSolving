package leetcode.offerII_58;

import java.util.*;

public class MyCalendar {
    TreeMap<Integer, int[]> calendar;
    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        SortedMap<Integer, int[]> tailMap = calendar.tailMap(start);
        if (tailMap.isEmpty()) {
            calendar.put(end, new int[] {start, end});
            return true;
        }
        List<Map.Entry<Integer, int[]>> entries = new ArrayList<>(tailMap.entrySet());
        int ceilingKey = entries.get(0).getKey();
        int[] interval = entries.get(0).getValue();
        if (interval[0] < end) {
            if (interval[1] > start) {
                return false;
            }
            if (entries.size() > 1) {
                Map.Entry<Integer, int[]> entry1 = entries.get(1);
                int[] nextItv = entry1.getValue();
                int nextStart = nextItv[0];
                if (nextStart < end) {
                    return false;
                }
                if (nextStart == end) {
                    calendar.remove(ceilingKey);
                    nextItv[0] = interval[0];
                    calendar.put(entry1.getKey(), nextItv);
                    return true;
                }
            }
            interval[1] = end;
            calendar.put(end, interval);
        }
        if (interval[0] == end) {
            interval[0] = start;
            calendar.put(ceilingKey, interval);
        } else {
            calendar.put(end, new int[] {start, end});
        }
        return true;
    }

    public static void main(String[] args) {
        MyCalendar mc = new MyCalendar();
        // ["MyCalendar","book","book","book","book","book","book","book","book","book","book"]
        //[[],[47,50],[33,41],[39,45],[33,42],[25,32],[26,35],[19,25],[3,8],[8,13],[18,27]]
        // [[],[23,32],[42,50],[6,14],[0,7],[21,30],[26,31],[46,50],[28,36],[0,6],[27,36],[6,11],[20,25],[32,37],[14,20],[7,16],[13,22],[39,47],[37,46],[42,50],[9,17],[49,50],[31,37],[43,49],[2,10],[3,12],[8,14],[14,21],[42,47],[43,49],[36,43]]
        int[][] cal = new int[][] {{23,32},{42,50},{6,14},{0,7},{21,30},{26,31},{46,50},{28,36},{0,6},{27,36},{6,11},{20,25},{32,37},{14,20},{7,16},{13,22},{39,47},{37,46},{42,50},{9,17},{49,50},{31,37},{43,49},{2,10},{3,12},{8,14},{14,21},{42,47},{43,49},{36,43}};
        for (int i = 0; i < cal.length; i++) {
            System.out.println(i + " : [" + cal[i][0] + ", " + cal[i][1] + ") : " + mc.book(cal[i][0], cal[i][1]));
        }
//        System.out.println(mc.book(47,50));
//        System.out.println(mc.book(33,41));
//        System.out.println(mc.book(39,45));
//        System.out.println(mc.book(33,42));
//        System.out.println(mc.book(25,32));
//        System.out.println(mc.book(26,35));
    }
}

class MyCalendar1 {
    TreeSet<int[]> booked;

    public MyCalendar1() {
        booked = new TreeSet<>(Comparator.comparingInt(a -> a[0]));
    }

    public boolean book(int start, int end) {
        if (booked.isEmpty()) {
            booked.add(new int[] {start, end});
            return true;
        }
        int[] tmp = new int[] {end, 0};
        int[] ceiling = booked.ceiling(tmp);
        if (ceiling == booked.first() || booked.lower(tmp)[1] <= start) {
            booked.add(new int[] {start, end});
            return true;
        }
        return false;
    }
}

class MyCalendar2 {
    TreeMap<Integer, Integer> booked;

    public MyCalendar2() {
        booked = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> entry = booked.floorEntry(start);
        if (entry != null && entry.getValue() > start) {
            return false;
        }
        entry = booked.ceilingEntry(start);
        if (entry != null && entry.getKey() < end) {
            return false;
        }
        booked.put(start, end);
        return true;
    }
}
