package task1;

import java.util.*;

public class Trie {
    public static void main(String[] args) {

    }

    private final Node root;
    public Trie() {
        root = new Node();
    }

    static class Node {
        private final Map<Character, Node> children;
        boolean isWordEnd;

        public Node() {
            children = new HashMap<>();
            isWordEnd = false;
        }
    }

    public void insert(String word) {
        Node currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Node node = currentNode.children.get(c);
            if(node == null) {
                node = new Node();
                currentNode.children.put(c, node);
            }
            currentNode = node;
        }
        currentNode.isWordEnd = true;
    }

    public boolean search(String word) {
        Node currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Node node = currentNode.children.get(c);
            if (node == null)
                return false;
            currentNode = node;
        }
        return currentNode.isWordEnd;
    }

    private List<String> searchHelper(String prefix, Node node) {
        List<String> result = new ArrayList<>();
        if (node.isWordEnd) {
            result.add(prefix);
        }
        for (Map.Entry<Character, Node> child : node.children.entrySet()) {
            List<String> parts = searchHelper(prefix + child.getKey(), child.getValue());
            result.addAll(parts);
        }
        return result;
    }

    public List<String> searchByPrefix(String prefix) {
        List<String> result = new ArrayList<>();
        Node currentNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            Node node = currentNode.children.get(c);
            if (node == null) {
                return result;
            }
            currentNode = node;
        }
        return searchHelper(prefix, currentNode);
    }

    public void delete(String word) {
        if (search(word)) {
            Node currentNode = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                Node node = currentNode.children.get(c);
                if (node.isWordEnd && i == word.length() - 1) {
                    node.isWordEnd = false;
                }
                currentNode = node;
            }
        }
    }
}
