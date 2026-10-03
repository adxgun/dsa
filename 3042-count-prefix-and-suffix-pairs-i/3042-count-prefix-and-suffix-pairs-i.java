class Solution {

    private final class Node {
        Node[] children = new Node[26];
    }

    public int countPrefixSuffixPairs(String[] words) {
        Node root = new Node();
        Node reverse = new Node();

        for (String w : words) {
            add(root, w);
            add(reverse, new StringBuilder(w).reverse().toString());
        }

        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {                
                String a = words[i], b = words[j];
                if (b.startsWith(a) && b.endsWith(a)) {
                    count++;
                }
            }
        }

        return count;
    }

    private void add(Node node, String word) {
        Node cur = node;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) cur.children[i] = new Node();
            cur = cur.children[i];
        }
    }
}