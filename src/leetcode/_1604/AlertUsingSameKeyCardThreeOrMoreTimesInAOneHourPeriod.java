package leetcode._1604;

import java.util.*;

public class AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        int n = keyName.length;
        Map<String, List<Integer>> keyTimes = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String s = keyName[i];
            List<Integer> times = keyTimes.getOrDefault(s, new ArrayList<>());
            String time = keyTime[i];
            String[] hhmm = time.split(":");
            char[] hh = hhmm[0].toCharArray(), mm = hhmm[1].toCharArray();
            int mins = ((hh[0] - '0') * 10 + hh[1] - '0') * 60 + (mm[0] - '0') * 10 + mm[1] - '0';
            times.add(mins);
            keyTimes.put(s, times);
        }

        List<String> res = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : keyTimes.entrySet()) {
            if (entry.getValue().size() < 3) continue;
            List<Integer> times = entry.getValue();
            times.sort(Comparator.comparingInt(a -> a));
            for (int i = 2; i < times.size(); i++) {
                if (times.get(i) - times.get(i - 2) <= 60) {
                    res.add(entry.getKey());
                    break;
                }
            }
        }
        return res;
    }

    public List<String> alertNames1(String[] keyName, String[] keyTime) {
        int n = keyName.length;
        Map<String, List<Integer>> keyTimes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = keyName[i];
            List<Integer> times = keyTimes.getOrDefault(s, new ArrayList<>());
            char[] time = keyTime[i].toCharArray();
            int mins = (time[0] - '0') * 600 + (time[1] - '0') * 60 + (time[3] - '0') * 10 + time[4] - '0';
            times.add(mins);
            keyTimes.put(s, times);
        }

        List<String> res = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : keyTimes.entrySet()) {
            if (entry.getValue().size() < 3) continue;
            List<Integer> times = entry.getValue();
            times.sort(Comparator.comparingInt(a -> a));
            for (int i = 2; i < times.size(); i++) {
                if (times.get(i) - times.get(i - 2) <= 60) {
                    res.add(entry.getKey());
                    break;
                }
            }
        }

        Collections.sort(res);
        return res;
    }
}
