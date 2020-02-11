package com.sudhar.examples;

import java.util.HashMap;
import java.util.Map;

class Cache1 {
    public int key;
    public int value;

    Cache1 prev;
    Cache1 next;

    Cache1(int key, int value) {
        this.key = key;
        this.value = value;
    }

    private int getKey() {
        return this.key;
    }

    private int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Key : " + key  + " value: " + value;
    }
}

public class LRUCache1 {

    private int capacity;
    Map<Integer, Cache1> map = new HashMap<>();
    Cache1 head = null;
    Cache1 tail = null;

    public LRUCache1(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        System.out.println("Get : " +map);
        if (map.get(key) != null) {
            Cache1 node = map.get(key);
            remove(node);
            setHead(node);
            return node.value;
        }
        //System.out.println("Get : " +map);
        return -1;
    }

    private void remove(Cache1 node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }

        if (head != null) {
            System.out.println("remove head : " + head.key);
        }
        if (tail != null) {
            System.out.println("remove tail : " + tail.key);
        }
    }

    private void setHead(Cache1 node) {
        node.prev = null;
        node.next = head;

        if (head != null) {
            head.prev = node;
        }

        head = node;

        if (tail == null) {
            tail = head;
        }
    }

    public void put(int key, int value) {
        if (map.get(key) != null) {
            Cache1 node = map.get(key);
            node.value = value;

            remove(node);
            setHead(node);
        } else {
            Cache1 newNode = new Cache1(key, value);
            if (map.size() >= capacity) {
                map.remove(tail.key);
                remove(tail);
            }

            setHead(newNode);
            map.put(key, newNode);
        }
    }

    public static void main(String[] args) {
        LRUCache1 cache = new LRUCache1(2);

        cache.put(1, 1);
        cache.put(2, 2);

        cache.get(1);
        System.out.println(cache.map.size());

        cache.put(3,3);
        System.out.println(cache.map.size());

        System.out.println(cache.get(2));
    }
}
