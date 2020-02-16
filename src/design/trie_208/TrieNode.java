package design.trie_208;

import java.util.Hashtable;

class TrieNode {

    private char key;
    boolean hasInfo = false;
    Hashtable<Character, TrieNode> children = new Hashtable<>();

    TrieNode() {
    }

    TrieNode(char key) {
        this.key = key;
    }
}
