package com.sudhar.examples;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Cache<K, V> {
    K key;
    V value;

    Cache pre;
    Cache next;
    Cache(K key, V value) {
        this.key = key;
        this.value = value;
    }
}


public class LRUCache<K, V> {

    private final Map<K, Cache> map = new HashMap<>();

    private static int capacity = 10;

    Cache head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public Cache get(K key) {
        if (map.get(key) != null) {
            Cache cache = map.get(key);
            remove(cache);
            setHead(cache);
            return cache;
        }
        return null;
    }


    public void remove(Cache cache) {
        if (cache.pre != null) {
            cache.pre.next = cache.next;
        } else {
            head = cache.next;
        }

        if (cache.next != null) {
            cache.next.pre = cache.pre;
        } else {
            tail = cache.pre;
        }
    }

    public void setHead(Cache cache) {
        cache.next = head;
        cache.pre = null;

        if (head != null) {
            head.pre = cache;
        }

        head = cache;

        if (tail == null) {
            tail = head;
        }
    }

    public void set(K key, V value) {
        if (map.get(key) != null) {
            Cache cache = map.get(key);
            cache.value = value;

            remove(cache);
            setHead(cache);
        } else {
            Cache newCache = new Cache(key, value);

            if (map.size() >= capacity) {
                remove(tail);
                map.remove(tail.key);
            }
            map.put(key, newCache);
            setHead(newCache);
        }
    }

    public int size() {
        return map.size();
    }

    public static void main(final String[] args) {
        LRUCache<Integer, Integer> cache = new LRUCache<>(1);

        cache.set(1, 1);
        //System.out.println(cache.get(1));

        cache.set(2, 2);
        //System.out.println(cache.get(2));

        System.out.println("Size : " + cache.size());

        System.out.println(cache.get(1));

        cache.set(3, 3);
        //System.out.println(cache.get(3));
        //System.out.println("Size : " + cache.size());
        System.out.println(cache.get(2));

        cache.set(4, 4);
        System.out.println("Size : " + cache.size());
    }
}
