package com.sudhar.examples;

class Trie {
    Trie trie[] = new Trie[26];

    char data;

    boolean isLeaf;

    Trie(char data) {
        this.data = data;
    }

}

class TrieHelper {
    private Trie root;

    public TrieHelper() {
        root = new Trie(' ');
    }

    public void insert(final String word) {
        if (word == null || word.length() == 0) {
            // Add logging statement.
            return;
        }

        char[] chars = word.toCharArray();
        Trie curr = root;

        for (int i = 0; i < word.length(); i++) {
            int index = chars[i] - 'a';

            if (curr.trie[index] == null) {
                Trie temp = new Trie(chars[i]);

                curr.trie[index] = temp;
                curr = temp;
            } else {
                curr = curr.trie[index];
            }
        }

        curr.isLeaf = true;
    }

    public boolean search(final String word) {
        if (word == null || word.length() == 0) {
            return false;
        }

        char[] chars = word.toCharArray();
        Trie curr = root;

        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';

            Trie temp = curr.trie[index];
            if (temp == null) {
                return false;
            }

            curr = curr.trie[index];
        }
        return true;
    }
}

public class Tries {

    public static void main(final String[] args) {
        TrieHelper th = new TrieHelper();

        th.insert("sunday");

        System.out.println(th.search("sunday"));
        System.out.println(th.search("something"));
    }
}
