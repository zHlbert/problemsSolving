package leetcode._641;

public class MyCircularDeque {
    int n, head, tail, size = 0;
    int[] nums;

    public MyCircularDeque(int k) {
        n = k + 1;
        nums = new int[n];
        tail = 0;
        head = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        head = (head - 1 + n) % n;
        nums[head] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        nums[tail] = value;
        tail = (tail + 1) % n;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % n;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tail = (tail - 1 + n) % n;
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return nums[head];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return nums[(tail - 1 + n) % n];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return (tail + 1) % n == head;
    }
}
