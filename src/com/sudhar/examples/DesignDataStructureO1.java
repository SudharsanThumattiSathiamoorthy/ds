package com.sudhar.examples;

import java.util.*;

public class DesignDataStructureO1 {

    public static void main(final String[] args) {
        O1 o1 = new O1();

        o1.add(1);
        o1.add(2);
        o1.add(3);

        o1.remove(4);
        o1.remove(3);

        System.out.println("Random : " + o1.getRandom());


    }
}


class O1 {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();

    private static Random random = new Random();

    public O1() {

    }

    public void add(Integer value) {
        if (map.get(value) != null) {
            return;
        }

        int size = list.size();
        list.add(value);

        map.put(value, size);
    }

    public void remove(Integer value) {
        if (map.get(value) == null) {
            return;
        }

        int index = map.get(value);
        map.remove(value);

        Integer last = list.get(list.size() - 1);
        Collections.swap(list, index, list.size() - 1);
        list.remove(list.size() - 1);

        map.put(last, index);
    }

    public int getRandom() {
        int rand = random.nextInt(list.size() - 1);

        return list.get(rand);
    }

    public Integer search(Integer value) {
        return map.get(value);
    }
}