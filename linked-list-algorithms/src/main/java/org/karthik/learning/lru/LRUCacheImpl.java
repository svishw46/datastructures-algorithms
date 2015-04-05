package org.karthik.learning.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * Implements the {@link LRUCache}.
 */
public class LRUCacheImpl implements LRUCache {
    private final int capacity;
    private final Map<Integer, Node> keyToNodeMap;
    private final DoublyLinkedList doublyLinkedList;

    /**
     * Constructs the {@link LRUCacheImpl}.
     *
     * @param capacity The initial capacity of the cache.
     */
    public LRUCacheImpl(final int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity cannot be negative");
        }

        this.capacity = capacity;
        this.keyToNodeMap = new HashMap<Integer, Node>(this.capacity);
        this.doublyLinkedList = new DoublyLinkedList();
    }

    @Override
    public int get(int key) {
        Node node = this.keyToNodeMap.get(key);
        if (node == null) {
            return -1;
        } else {
            this.doublyLinkedList.moveToTheFront(node);
            return node.getValue();
        }
    }

    @Override
    public void set(int key, int value) {
        if (this.keyToNodeMap.size() == this.capacity && !this.keyToNodeMap.containsKey(key)) {
            Node removedTail = this.doublyLinkedList.removeTailNode();
            this.keyToNodeMap.remove(removedTail.getKey());
        }

        if (!this.keyToNodeMap.containsKey(key)) {
            Node node = new Node(key, value);
            this.doublyLinkedList.addToTheFront(node);
            this.keyToNodeMap.put(key, node);
        } else {
            Node node = this.keyToNodeMap.get(key);
            this.doublyLinkedList.moveToTheFront(node);
            node.setValue(value);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCacheImpl(3);

        lruCache.set(1, 1);
        lruCache.set(2, 2);
        lruCache.set(3, 3);
        lruCache.set(4, 4);
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(1));
        lruCache.set(5, 5);
        System.out.println("ASD");
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(5));
    }
}