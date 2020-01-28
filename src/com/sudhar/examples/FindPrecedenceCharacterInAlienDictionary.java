package com.sudhar.examples;

import java.util.LinkedList;
import java.util.Stack;

public class FindPrecedenceCharacterInAlienDictionary {

    public static void main(String[] args) {

        addWords(new String[] {"caa", "aaa", "aab"}, 3);
    }

    private static void addWords(String[] words, int no) {
        DictionaryGraph dictGraph = new DictionaryGraph(no);

        for (int i = 0; i < words.length -1; i++) {
            String s1 = words[i];
            String s2 = words[i+1];

            int min = Math.min(s1.length(), s2.length());
            for (int j = 0; j < min; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    dictGraph.addEdge(s1.charAt(j) - 'a', s2.charAt(j) - 'a');
                    break;
                }
            }
        }

        Stack<Integer> stack = dictGraph.findPrecedence();

        while (!stack.isEmpty()) {
            System.out.print((char)('a' + stack.pop()) + " ");
        }
    }
}

class DictionaryGraph {
    LinkedList<Integer>[] list;
    int vertices;

    public DictionaryGraph(int no) {
        this.vertices = no;
        list = new LinkedList[3];

        for (int i = 0; i < no; i++) {
            list[i] = new LinkedList<>();
        }
    }

    public void addEdge(int from, int to) {
        list[from].add(to);
    }

    public Stack<Integer> findPrecedence() {
        Stack<Integer> result = new Stack<>();

        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(i, visited, result);
            }
        }

        return result;
    }

    private void dfs(int vertex, boolean[] visited, Stack<Integer> result) {
        visited[vertex] = true;

        for (Integer adjacantVertex: list[vertex]) {
            if (!visited[adjacantVertex]) {
                dfs(adjacantVertex, visited, result);
            }
        }
        result.add(vertex);
    }
}
