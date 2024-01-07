package com.sudhar.examples;

public class LongestCommonPrefix {

    public static void main(final String[] args) {
        final LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[] {"flower","flow","flight"}));
    }

    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();

        for (String word: strs) {
            trie.insert(word);
        }

        TrieNode curr = trie.root;

        StringBuilder result = new StringBuilder("");
        while (!curr.isLeaf) {

            int index = 0;
            int count = 0;

            for (int i = 0; i < 26; i++) {
                if (curr.nodes[i] != null) {
                    index = i;

                    count++;
                }
            }

            if (count != 1) {
                return result.toString();
            }

            curr = curr.nodes[index];
            result.append(curr.value);

        }

        return result.toString();
    }

    class TrieNode {
        TrieNode[] nodes;
        char value;

        boolean isLeaf;

        TrieNode(char value) {
            this.value = value;
            nodes = new TrieNode[26];
        }
    }

    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode(' ');
        }

        public void insert(String word) {
            TrieNode curr = this.root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (curr.nodes[c - 'a'] != null) {
                    curr = curr.nodes[c - 'a'];
                } else {
                    curr.nodes[c - 'a'] = new TrieNode(c);
                    curr = curr.nodes[c - 'a'];
                }
            }
            curr.isLeaf = true;
        }
    }
}
