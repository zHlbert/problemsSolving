package leetcode._1114;

import java.util.concurrent.atomic.AtomicInteger;

public class Foo {
    private final AtomicInteger atomic = new AtomicInteger(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        atomic.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (atomic.get() != 1) {

        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        atomic.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (atomic.get() != 2) {

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        atomic.incrementAndGet();
    }
}
