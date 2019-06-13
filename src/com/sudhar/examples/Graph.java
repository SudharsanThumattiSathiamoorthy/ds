package com.sudhar.examples;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    private LinkedList<Integer> adjacancyList[];
    int vertices;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacancyList = new LinkedList[vertices];

        for (int i =0; i < vertices; i++) {
            adjacancyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int edge) {
        adjacancyList[v].add(edge);
    }

    public void bfs(final Integer e, int noOfVertices) {

        final boolean[] visited = new boolean[noOfVertices];

        final Queue<Integer> queue = new LinkedList<>();
        queue.add(e);

        while (!queue.isEmpty()) {
            int vertice = queue.poll();

            if (!visited[vertice]) {
                System.out.print(vertice + " ");
            }
            visited[vertice] = true;


            for (final Integer integer: adjacancyList[vertice]) {
                if (!visited[integer]) {
                    queue.add(integer);
                }
            }
        }
    }

    public void dfs(int vertice, boolean[] visited) {
        if (visited[vertice]) {
            return;
        }

        visited[vertice] = true;
        System.out.print(vertice + " ");

        for (Integer integer : adjacancyList[vertice]) {
            if (!visited[integer]) {
                dfs(integer, visited);
            }
        }
    }

    private void printAllPaths(Graph g, int start, int end) {
        boolean[] visited = new boolean[g.vertices];
        // visited[start] = true;

        printAllPaths(start, end, visited, "");
    }

//    private void printAllPaths(Graph g, boolean[] visited, String path, int start, int end) {
//        String newPath = path + " -> " + start;
//
//        visited[start] = true;
//
//        LinkedList<Integer> list = g.adjacancyList[start];
//
//        for (int i = 0; i < list.size(); i++) {
//            int edge = list.get(i);
//
//            if (edge != end && !visited[edge]) {
//                printAllPaths(g, visited, newPath, edge, end);
//            } else if (edge == end){
//                System.out.println(newPath + " -> " + edge);
//            }
//        }
//        visited[start] = false;
//    }

    private void printAllPaths(Integer start, Integer end, boolean[] visited, String path) {
        String newPath = path + " -> " + start;

        visited[start] = true;

        for (Integer edge: adjacancyList[start]) {
            if (edge == end) {
                System.out.println(newPath + " -> " + edge);
            } else if (!visited[edge]) {
                printAllPaths(edge, end, visited, newPath);
            }
        }
    }

    public static void main(final String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 3);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(4, 5);

        graph.bfs(2, graph.vertices);
        System.out.println();

        graph.dfs(2, new boolean[graph.vertices]);

        System.out.println();
        graph.printAllPaths(graph, 0, 5);
    }
}
