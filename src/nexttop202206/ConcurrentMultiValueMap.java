package nexttop202206;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 基于 ConcurrentHashmap 写一个并发的 ConcurrentMultiValueMap<K, V>,
 * 支持一个 key 对应多个 value (例如一个key对应List<V>),
 * 并实现以下三个方法, 要求不额外加锁且线程安全。
 *
 * @param <K>
 * @param <V>
 */
public class ConcurrentMultiValueMap<K, V> {
    private Map<K, List<V>> map = new ConcurrentHashMap<>();
    private static final int STATE_INIT = 0;
    private static final int STATE_PROGRESSING = 1;
    private static final int STATE_PROCESSED = 2;

    public List<V> get(K key) {
        List<V> res = map.get(key);
        if (res == null) {
            throw new NullPointerException("Does not contain the key");
        }
        return res;
    }

    public boolean put(K key, V value) {
        AtomicStampedReference<Boolean> ref = new AtomicStampedReference<>(false, STATE_INIT);
        if (ref.compareAndSet(false, true, STATE_INIT, STATE_PROGRESSING)) {
            List<V> list = map.getOrDefault(key, new ArrayList<>());
            list.add(value);
            map.put(key, list);
            ref.compareAndSet(true, false, STATE_PROGRESSING, STATE_PROCESSED);
            return true;
        }
        return false;
    }

    public boolean remove(K key, V value) {
        AtomicStampedReference<Boolean> ref = new AtomicStampedReference<>(false, STATE_INIT);
        if (ref.compareAndSet(false, true, STATE_INIT, STATE_PROGRESSING)) {
            List<V> list = map.get(key);
            if (list == null) {
                ref.compareAndSet(true, false, STATE_PROGRESSING, STATE_PROCESSED);
                return false;
            }
            int index = 0;
            for (; index < list.size(); index++) {
                if (list.get(index).equals(value)) {
                    break;
                }
            }
            if (index == list.size()) {
                ref.compareAndSet(true, false, STATE_PROGRESSING, STATE_PROCESSED);
                return false;
            }
            list.remove(index);
            map.put(key, list);
            ref.compareAndSet(true, false, STATE_PROGRESSING, STATE_PROCESSED);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ConcurrentMultiValueMap<String, Integer> concurrentMultiValueMap = new ConcurrentMultiValueMap<>();
        Random random = new Random();
        String[] strings = new String[] {"aaa", "bbb", "ccc"};


        ExecutorService es = Executors.newFixedThreadPool(50);
//            int finalI = i;
        for (int j = 0; j < 10; j++) {
            es.submit(() -> {
                try {
                    for (int i = 0; i < 10; i++) {
                        concurrentMultiValueMap.put(strings[random.nextInt(strings.length)], i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

//        }

        es.shutdown();
        try {
            boolean b = es.awaitTermination(500, TimeUnit.MILLISECONDS);
            System.out.println(b);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Map<String, List<Integer>> map = concurrentMultiValueMap.map;
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            System.out.println(entry.getKey() + " size: " + value.size() + " : " + value);
        }
    }
}
