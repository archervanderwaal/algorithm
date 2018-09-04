package me.stormma.others;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class XieCheng {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int capacity = in.nextInt();
        LRUCache<Integer, Integer> cache = new LRUCache<>(capacity);
        while (in.hasNext()) {
            String command = in.next();
            if (command.equals("p")) {
                cache.put(in.nextInt(), in.nextInt());
            } else if (command.equals("g")) {
                Integer res = cache.get(in.nextInt());
                System.out.println(res == null ? -1 : res);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    static class LRUCache<Key, Value> {
        private Map<Key, LRUCache.Entry<Key, Value>> map;

        /**
         * the capacity of lru cache
         */
        private final int capacity;

        /**
         * cache not hint
         */
        private final Value CACHE_NOT_HINT = null;

        /**
         * the default capacity of lru cache
         */
        private static final int DEFAULT_CAPACITY = 10;

        /**
         * the cache head
         */
        private LRUCache.Entry head;

        /**
         * the cache tail
         */
        private LRUCache.Entry tail;

        public LRUCache(int capacity) {
            if (capacity <= 0) {
                throw new IllegalArgumentException("Illegal argument capacity [" + capacity + "]");
            }

            this.capacity = capacity;
            map = new HashMap<>(this.capacity);
            head = new LRUCache.Entry(null, null);
            tail = new LRUCache.Entry(null, null);
            head.next = tail;
            tail.prev = head;
        }

        public LRUCache() {
            this(DEFAULT_CAPACITY);
        }

        public Value get(Key key) {
            if (map.containsKey(key)) {
                LRUCache.Entry<Key, Value> entry = map.get(key);
                // transfer node to tail
                transferNodeToTail(entry);
                return entry.val;
            }
            return null;
        }

        private void transferNodeToTail(LRUCache.Entry<Key, Value> entry) {
            // delete entry
            LRUCache.Entry<Key, Value> prev = entry.prev;
            LRUCache.Entry<Key, Value> next = entry.next;
            prev.next = next;
            next.prev = prev;
            // transfer node to tail
            LRUCache.Entry<Key, Value> last = tail.prev;
            last.next = entry;
            tail.prev = entry;
            entry.prev = last;
            entry.next = tail;
        }

        private LRUCache.Entry<Key, Value> removeFirstEntry() {
            LRUCache.Entry<Key, Value> first = head.next;
            LRUCache.Entry<Key, Value> second = first.next;
            head.next = second;
            second.prev = head;
            return first;
        }

        private void appendToTail(LRUCache.Entry<Key, Value> entry) {
            LRUCache.Entry<Key, Value> last = tail.prev;
            last.next = entry;
            tail.prev = entry;
            entry.prev = last;
            entry.next = tail;
        }

        public void put(Key key, Value value) {
            if (map.containsKey(key)) {
                LRUCache.Entry<Key, Value> entry = map.get(key);
                entry.val = value;
//                transferNodeToTail(entry);
            } else {
                // create new node
                LRUCache.Entry<Key, Value> entry = new LRUCache.Entry<>(key, value);
                if (map.size() >= capacity) {
                    LRUCache.Entry<Key, Value> first = removeFirstEntry();
                    map.remove(first.key);
                }
                appendToTail(entry);
                map.put(key, entry);
            }
        }

        static class Entry<Key, Value> {
            Key key;
            Value val;
            LRUCache.Entry next;
            LRUCache.Entry prev;

            public Entry(Key key, Value val) {
                this.key = key;
                this.val = val;
            }
        }
    }
}
