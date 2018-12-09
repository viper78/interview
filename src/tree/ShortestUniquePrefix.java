package tree;

import java.util.*;

public class ShortestUniquePrefix {

    public static void main(String[] args) {

        ShortestUniquePrefix shortestUniquePrefix = new ShortestUniquePrefix();
        List<String> input = Arrays.asList("SanFrancisco", "SanJose", "SanRamon");
        List<String> prefixes = shortestUniquePrefix.prefix(input);

        System.out.println(prefixes);
    }

    public List<String> prefix(List<String> a) {
        TrieNode root = new TrieNode();

        for (String s : a) {
            insert(root, s);
        }

        List<String> prefixes = new ArrayList<>();
        for (String s : a) {
            prefixes.add(findPrefix(root, s));
        }

        return prefixes;
    }

    void insert(TrieNode root, String s) {
        TrieNode current = root;

        for (Character ch : s.toCharArray()) {
            TrieNode node = current.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            node.count++;
            current = node;
        }
//        for (Character ch : s.toCharArray()) {
//            node = node.children.computeIfAbsent(ch, c -> new TrieNode());
//            node.count++;
//        }
    }

    String findPrefix(TrieNode root, String s) {
        TrieNode current = root;
        StringBuilder prefix = new StringBuilder();
        for (Character ch : s.toCharArray()) {
            TrieNode node = current.children.get(ch);
            if (node != null) {
                prefix.append(ch);
                if (node.count == 1) {
                    return prefix.toString();
                }
                current = node;
            } else {
                break;
            }
        }

        return prefix.toString();

    }

    class TrieNode {
        int count = 0;
        Map<Character, TrieNode> children = new HashMap<>();
    }
}
