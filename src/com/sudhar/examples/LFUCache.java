package com.sudhar.examples;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class CacheNode<K, V> {
    K key;
    V value;
    int frequency;

    CacheNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.getKey();
    }

    public V getValue() {
        return this.getValue();
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public void incrementFrequency() {
        this.frequency++;
    }

    @Override
    public String toString() {
        return key + " " + value;
    }
}

public class LFUCache<K, V> {
    Map<K, CacheNode<K, V>> map = new HashMap<>();
    Comparator<CacheNode<K, V>> comparator = Comparator.comparing(CacheNode::getFrequency);
    PriorityQueue<CacheNode<K, V>> queue = new PriorityQueue<>(comparator);

    int maxEntries;

    public LFUCache(int maxEntries) {
        this.maxEntries = maxEntries;
    }

    public CacheNode<K, V> get(K key) {
        CacheNode<K, V> value = map.get(key);
        if (value == null) {
            return null;
        }

        value.incrementFrequency();

        queue.remove(value);
        queue.add(value);

        return value;
    }

    public void set(K key, V value) {
        CacheNode<K, V> curr = map.get(key);

        if (curr != null) {
            curr.setValue(value);
            curr.incrementFrequency();

            queue.remove(curr);
            queue.add(curr);
        }

        CacheNode<K, V> newEntry = new CacheNode<>(key, value);
        if (map.size() >= maxEntries) {
            CacheNode<K, V> remove = queue.poll();

            map.remove(remove.key);
        }

        newEntry.incrementFrequency();
        map.put(key, newEntry);
        queue.add(newEntry);
    }

    public static void main(String[] args) {
        LFUCache<Integer, Integer> cache = new LFUCache<>(3);

        cache.set(1, 1);
        cache.set(2, 2);
        cache.set(3, 3);

        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

        cache.set(4, 4);

        System.out.println("Queue is " + cache.queue);
        System.out.println("Queue is " + cache.map);

        // 3 should be evicted since 3 has the least frequency.
        System.out.println(cache.get(3));
    }
}
