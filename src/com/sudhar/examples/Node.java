package com.sudhar.examples;

class Node {
    Node left;
    Node right;

    int data;

    Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "data=" + data;
    }
}
