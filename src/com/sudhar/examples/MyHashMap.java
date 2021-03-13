package com.sudhar.examples;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Pair<U, V> {
    public U key;
    public V value;

    public Pair(U first, V second) {
        this.key = first;
        this.value = second;
    }

    public U getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}


//class Bucket {
//    private List<Pair<Integer, Integer>> bucket;
//
//    public Bucket() {
//        this.bucket = new LinkedList<Pair<Integer, Integer>>();
//    }
//
//    public Integer get(Integer key) {
//        for (Pair<Integer, Integer> pair : this.bucket) {
//            if (pair.key.equals(key))
//                return pair.value;
//        }
//        return -1;
//    }
//
//    public void update(Integer key, Integer value) {
//        boolean found = false;
//        for (Pair<Integer, Integer> pair : this.bucket) {
//            if (pair.key.equals(key)) {
//                pair.value = value;
//                found = true;
//            }
//        }
//        if (!found)
//            this.bucket.add(new Pair<Integer, Integer>(key, value));
//    }
//
//    public void remove(Integer key) {
//        for (Pair<Integer, Integer> pair : this.bucket) {
//            if (pair.key.equals(key)) {
//                this.bucket.remove(pair);
//                break;
//            }
//        }
//    }
//}

class Bucket<K, V> {
    List<Pair<K,V>> list = new ArrayList<>();

    public V get(K key) {
        for (Pair<K, V> pair: list) {
            if (pair.getKey().equals(key)) {
                return pair.getValue();
            }
        }

        return null;
    }

    public void update(K key, V value) {
        boolean notFound = true;

        for (Pair<K, V> pair: list)  {
            if (pair.getKey().equals(key)) {
                pair.value = value;
                notFound = false;
            }
        }

        if (notFound) {
            list.add(new Pair<>(key, value));
        }
    }

    public void remove(K key) {
        if (key == null) {
            return;
        }

        for (Pair<K, V> pair: list) {
            if (pair.key.equals(key)) {
                list.remove(pair);
            }
        }
    }
}


public class MyHashMap {
    private int key_space;
    private List<Bucket<Integer, Integer>> hash_table;

    /** Initialize your data structure here. */
    public MyHashMap() {
        this.key_space = 2069;
        this.hash_table = new ArrayList<>();
        for (int i = 0; i < this.key_space; ++i) {
            this.hash_table.add(new Bucket());
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash_key = key % this.key_space;
        this.hash_table.get(hash_key).update(key, value);
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
     * for the key
     */
    public int get(int key) {
        int hash_key = key % this.key_space;
        return this.hash_table.get(hash_key).get(key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash_key = key % this.key_space;
        this.hash_table.get(hash_key).remove(key);
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();

        myHashMap.put(1, 1);
        myHashMap.put(2, 2);

        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(3));

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj = new MyHashMap();
 * obj.put(key,value); int param_2 = obj.get(key); obj.remove(key);
 */
