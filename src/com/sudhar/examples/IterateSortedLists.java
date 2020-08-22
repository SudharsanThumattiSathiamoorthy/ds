package com.sudhar.examples;

import java.util.List;

public class IterateSortedLists {

    List<List<Integer>> lists;

    int[] indices;
    int total;
    int curr_index;

    public IterateSortedLists(List<List<Integer>> lists) {
        this.lists = lists;
        if (lists != null) {
            indices = new int[lists.size()];
            for (List<Integer> l : lists)
                total += l.size();

        }
        curr_index = 0;
    }

    public boolean hasNext() {
        return curr_index < total;
    }

    public int next() {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < indices.length; i++) {
            if (indices[i] < lists.get(i).size()) {
                if (lists.get(i).get(indices[i]) < min) {
                    index = i;
                    min = lists.get(i).get(indices[i]);
                }
            }
        }
        if (min != Integer.MAX_VALUE) {
            indices[index]++;

        }
        curr_index++;
        return min;
    }
}
