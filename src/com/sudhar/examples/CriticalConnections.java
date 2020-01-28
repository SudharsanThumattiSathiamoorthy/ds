package com.sudhar.examples;

import java.util.ArrayList;
import java.util.List;

public class CriticalConnections {

    private int[] ids;
    private int[] low;

    private boolean[] visited;
    private static int i = -1;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        low = new int[n];
        ids = new int[n];
        visited = new boolean[n];

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (List<Integer> connection : connections) {
            int from = connection.get(0);
            int to = connection.get(1);
            graph[from].add(to);
            graph[to].add(from);
        }

        List<List<Integer>> bridges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, i, -1, bridges);
            }
        }

        return bridges;
    }

    private void dfs(List<Integer>[] graph, int at, int parent, List<List<Integer>> bridges) {
        visited[at] = true;
        low[at] = ids[at] = ++i;
        if (graph[at] == null)
            return;
        for (Integer to : graph[at]) {
            if (to == parent) {
                continue;
            }
            if (!visited[to]) {
                dfs(graph, to, at, bridges);
                low[at] = Math.min(low[at], low[to]);
                if (ids[at] < low[to]) {
                    bridges.add(List.of(at, to));
                }
            } else {
                low[at] = Math.min(low[at], ids[to]);
            }
        }
    }

    public static void main(final String[] args) {
        CriticalConnections cc = new CriticalConnections();

        List<List<Integer>> conn = new ArrayList<>();
        conn.add(List.of(0, 1));
        conn.add(List.of(1, 2));
        conn.add(List.of(2, 0));
        conn.add(List.of(1, 3));

        System.out.println(cc.criticalConnections(4, conn));
    }
}
