package leetcode._622;

/**
 * https://leetcode.cn/problems/design-circular-queue/
 */
public class MyCircularQueue {
    int n, head = 0, tail = 0, size = 0;
    int[] nums;

    public MyCircularQueue(int k) {
        nums = new int[k];
        n = k;
        tail = n - 1;
        head = 0;
    }

    public boolean enQueue(int value) {
        if (size == n) {
            return false;
        }

        tail = (tail + 1) % n;
        nums[tail] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (size == 0) {
            return false;
        }
        head = (head + 1) % n;
        int res = nums[head];
        size--;
        return true;
    }

    public int Front() {
        return size == 0 ? -1 : nums[head];
    }

    public int Rear() {
        return size == 0 ? -1 : nums[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == n;
    }
}
