package me.stormma.others;

import java.util.HashMap;
import java.util.Map;
/**
 * @brief lfu cache
 * @author stormma stormmaybin@gmail.com
 */
public class LFUCache {

    private final transient Map<Integer, Node> cache;

    private final transient Map<Integer, FreqNode> freqNodeMap;

    private final transient int capacity;

    private final FreqNode head;

    private final FreqNode tail;

    private static final int CACHE_NOT_HINT = -1;

    public LFUCache(final int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.freqNodeMap = new HashMap<>();
        this.head = new FreqNode(-1);
        this.tail = new FreqNode(0);
        head.next = tail;
        tail.prev = head;
        freqNodeMap.put(-1, head);
        freqNodeMap.put(0, tail);
    }

    private void refreshFreqNode() {

    }

    class Node {
        int key;
        int value;
        int freq;
        Node next;
        Node prev;
        public Node (final int key, final int value, final int freq) {
            this.key = key;
            this.value = value;
            this.freq = freq;
            this.prev = this.next = null;
        }
    }

    class FreqNode {
        int freq;
        FreqNode next;
        FreqNode prev;
        Node head;
        Node tail;
        public FreqNode(final int freq) {
            this.freq = freq;
            this.next = this.prev = null;
            Node head = new Node(0, 0, 0);
            Node tail = new Node(0, 0, 0);
            head.next = tail;
            tail.prev = head;
        }
    }
}
