package leetcode._385;

import java.util.List;

public interface NestedInteger {
    // Constructor initializes an empty nested list.
    boolean isInteger();

    Integer getInteger();

    void setInteger(int value);

    void add(NestedInteger ni);

    List<NestedInteger> getList();

}
