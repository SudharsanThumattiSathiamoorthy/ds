package com.sudhar.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {
    Map<String, List<Pair<Integer, String>>> M;

    public TimeMap() {
        M = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!M.containsKey(key))
            M.put(key, new ArrayList<>());

        M.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!M.containsKey(key)) return "";

        List<Pair<Integer, String>> A = M.get(key);
        int i = Collections.binarySearch(A, new Pair<>(timestamp, "{"),
                                         Comparator.comparingInt(Pair::getKey));

        if (i >= 0)
            return A.get(i).getValue();
        else if (i == -1)
            return "";
        else
            return A.get(-i-2).getValue();
    }

    public static void main(String[] args) {
        TimeMap tm = new TimeMap();

        tm.set("foo","bar",1);
        System.out.println(tm.get("foo",1));

        System.out.println(tm.get("foo",3));
        tm.set("foo","bar2",4);

        System.out.println(tm.get("foo",4));
        System.out.println(tm.get("foo",5));
    }
}