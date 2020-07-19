package com.sudhar.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/search-suggestions-system/ - Amazon
public class SearchSuggestionSubsystem {

    static class SearchTrieNode {
        char data;
        List<String> list;
        SearchTrieNode[] children;

        SearchTrieNode(char data) {
            this.data = data;
            list = new ArrayList<>();
            children = new SearchTrieNode[26];
        }
    }

    static class SearchTrie {
        SearchTrieNode root;

        public SearchTrie(SearchTrieNode root) {
            this.root = root;
        }

        public void insert(String[] products) {
            for (String product : products) {
                SearchTrieNode curr = root;

                for (char c: product.toCharArray()) {
                    int index = c - 'a';

                    if (curr.children[index] == null) {
                        curr.children[index] = new SearchTrieNode(c);
                    }

                    curr = curr.children[index];

                    curr.list.add(product);
                    Collections.sort(curr.list);

                    if (curr.list.size() > 3) {
                        curr.list.remove(curr.list.size() -1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        SearchTrieNode stn = new SearchTrieNode(' ');

        SearchTrie st = new SearchTrie(stn);

        st.insert(new String[] {"mobile","mouse","moneypot","monitor","mousepad"});

        System.out.println(stn);

        SearchSuggestionSubsystem sss = new SearchSuggestionSubsystem();
        System.out.println(sss.suggestedProducts(new String[] {"mobile","mouse","moneypot","monitor","mousepad"}, "mouse"));
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        SearchTrieNode st = new SearchTrieNode(' ');

        if (products == null || products.length == 0) {
            return Arrays.asList();
        }

        for (String product: products) {
            SearchTrieNode curr = st;
            for (char c : product.toCharArray()) {

                int index = c - 'a';
                SearchTrieNode next = curr.children[index];
                if (next == null) {
                    next = new SearchTrieNode(c);
                }

                curr.children[index] = next;
                next.list.add(product);
                Collections.sort(next.list);
                next.data = c;

                if (next.list.size() > 3) {
                    next.list.remove(next.list.size() -1);
                }

                curr = next;
            }
        }

        List<List<String>> result = new ArrayList<>();
        SearchTrieNode curr = st;

        for (char c: searchWord.toCharArray()) {
            int index = c - 'a';

            curr = curr.children[index];

            if (curr != null) {
                result.add(curr.list);
            } else {
                result.add(new ArrayList<>());
            }
        }
        return result;
    }
}


