package com.sudhar.examples;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    private LinkedList<Integer> adjacancyList[];

    public Graph(int vertices) {
        adjacancyList = new LinkedList[vertices];

        for (int i =0; i < vertices ;i++) {
            adjacancyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, Integer e) {
        adjacancyList[v].add(e);
    }

    public void bfs(final Integer e, int noOfVertices) {

        final boolean[] visited = new boolean[noOfVertices];

        visited[e] = true;

        final Queue<Integer> queue = new LinkedList<>();
        queue.add(e);

        while (!queue.isEmpty()) {
            int vertice = queue.poll();

            visited[vertice] = true;
            System.out.print(vertice + " ");

            for (final Integer integer: adjacancyList[vertice]) {
                if (!visited[integer]) {
                    queue.add(integer);
                }
            }
        }
    }

    public void dfs(int vertice, boolean[] visited, Stack<Integer> stack) {
        if (visited[vertice]) {
            return;
        }

        visited[vertice] = true;
        stack.add(vertice);
        System.out.print(vertice + " ");

        while(!stack.isEmpty()) {
            final Integer edge = stack.pop();

            for (Integer integer: adjacancyList[edge]) {
                dfs(integer, visited, stack);
            }
        }
    }

    public static void main(final String[] args) {
        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        graph.bfs(2, 4);
        System.out.println();

        graph.dfs(2, new boolean[4], new Stack<Integer>());
    }
}
