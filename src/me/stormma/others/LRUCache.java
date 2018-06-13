package me.stormma.others;

import java.util.HashMap;
import java.util.Map;

/**
 * @brief lru cache
 * @author stormma stormmaybin@gmail.com
 */
public class LRUCache<Key, Value> {
    private Map<Key, LRUCache.Entry<Key, Value>> map;

    /**the capacity of lru cache*/
    private final int capacity;

    /**cache not hint*/
    private final Value CACHE_NOT_HINT = null;

    /**the default capacity of lru cache*/
    private static final int DEFAULT_CAPACITY = 10;

    /**the cache head*/
    private Entry head;

    /**the cache tail*/
    private Entry tail;

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Illegal argument capacity [" + capacity + "]" );
        }
        this.capacity = capacity;
        map = new HashMap<>(this.capacity);
        head = new Entry(null, null);
        tail = new Entry(null, null);
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

    private void transferNodeToTail(Entry<Key, Value> entry) {
        // delete entry
        Entry<Key, Value> prev = entry.prev;
        Entry<Key, Value> next = entry.next;
        prev.next = next;
        next.prev = prev;
        // transfer node to tail
        Entry<Key, Value> last = tail.prev;
        last.next = entry;
        tail.prev = entry;
        entry.prev = last;
        entry.next = tail;
    }

    private Entry<Key, Value> removeFirstEntry() {
        Entry<Key, Value> first = head.next;
        Entry<Key, Value> second = first.next;
        head.next = second;
        second.prev = head;
        return first;
    }

    private void appendToTail(Entry<Key, Value> entry) {
        Entry<Key, Value> last = tail.prev;
        last.next = entry;
        tail.prev = entry;
        entry.prev = last;
        entry.next = tail;
    }

    public void put(Key key, Value value) {
        if (map.containsKey(key)) {
            LRUCache.Entry<Key, Value> entry = map.get(key);
            entry.val = value;
            transferNodeToTail(entry);
        } else {
            // create new node
            Entry<Key, Value> entry = new Entry<>(key, value);
            if (map.size() >= capacity) {
                Entry<Key, Value> first = removeFirstEntry();
                map.remove(first.key);
            }
            appendToTail(entry);
            map.put(key, entry);
        }
    }

    static class Entry<Key, Value> {
        Key key;
        Value val;
        Entry next;
        Entry prev;

        public Entry(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LRUCache<Integer, Integer> cache = new LRUCache<>(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(Integer.MAX_VALUE);
    }
}
