package com.sudhar.examples;

import java.util.*;

class NAryTree {
    int data;

    List<NAryTree> children;

    NAryTree(int data, List<NAryTree> children) {
        this.data = data;
        this.children = new ArrayList<>(children);
    }
}

public class SerializeNArrayTree {
    private static final String NULL = "#";
    private static final String SPLIT = ",";

    public String serialize(NAryTree root) {
        StringBuilder sb =  new StringBuilder();

        serialize(root, sb);

        return sb.toString();
    }

    private void serialize(NAryTree root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SPLIT);
        } else {
            sb.append(root.data);
            sb.append(SPLIT);

            sb.append(root.children.size());
            for (NAryTree child: root.children) {
                serialize(child, sb);
            }
        }
    }

    public NAryTree deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(SPLIT)));

        return deserialize(queue);
    }

    public NAryTree deserialize(Queue<String> queue) {
        String curr = queue.poll();

        if (NULL.equals(curr)) {
            return null;
        }

        NAryTree root = new NAryTree(Integer.parseInt(curr), new ArrayList<>());
        int childrenSize = Integer.parseInt(queue.poll());

        for (int i = 0; i < childrenSize; i++) {
            root.children.add(deserialize(queue));
        }

        return root;
    }
}
