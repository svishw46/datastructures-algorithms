package org.karthik.learning.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations:
 * get and set.
 * <p/>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 */
public interface LRUCache {

    /**
     * Gets the value from the cache.
     *
     * @param key The key to retrieve value from.
     * @return The value in the key. -1 if not found.
     */
    int get(int key);

    /**
     * Sets the given value in the given key.
     *
     * @param key   The key to be set.
     * @param value The value to be set.
     */
    void set(int key, int value);


}
