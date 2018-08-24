package me.stormma.leetcode.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author stormma stormmaybin@gmail.com
 * @description find median from data stream
 */
public class Question295 {

    /**
     * runtime time O(nlogn)
     */
    static class MedianFinder {

        private Queue<Integer> smaller;

        private Queue<Integer> larger;

        /** initialize your data structure here. */
        public MedianFinder() {
            smaller = new PriorityQueue<>((i1, i2) -> i2 - i1);
            larger = new PriorityQueue<>();
        }

        public void addNum(int num) {
            // if num less than max num of smaller (max heap), and add num into smaller
            if (smaller.isEmpty() || num <= smaller.peek()) {
                smaller.add(num);
            } else { // if num greater than max num of smaller (max heap), and add num into larger (min heap)
                larger.add(num);
            }

            // step 2. balance smaller and larger heap
            if (smaller.size() < larger.size()) {
                smaller.add(larger.poll());
            } else if (smaller.size() - larger.size() == 2) {
                larger.add(smaller.poll());
            }
        }

        public double findMedian() {
            if (smaller.size() > larger.size()) {
                return smaller.peek();
            }
            if (smaller.isEmpty()) {
                throw new RuntimeException();
            }
            return (smaller.peek() + larger.peek()) / 2.0d;
        }
    }

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.findMedian());
    }
}
