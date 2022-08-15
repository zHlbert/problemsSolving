package leetcode._1656;

import java.util.ArrayList;
import java.util.List;

public class DesignAnOrderedStream {

}

class OrderedStream {

    String[] values;
    int ptr;

    public OrderedStream(int n) {
        values = new String[n + 1];
        ptr = 1;
    }

    public List<String> insert(int idKey, String value) {
        values[idKey] = value;
        List<String> res = new ArrayList<>();
        while (ptr < values.length && values[ptr] != null) {
            res.add(values[ptr++]);
        }
        return res;
    }
}
