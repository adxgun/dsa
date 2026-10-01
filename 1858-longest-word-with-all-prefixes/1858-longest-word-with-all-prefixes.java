class Solution {
    private final class Node {
        boolean isEnd = false;
        Node[] children = new Node[26];
    }

    public String longestWord(String[] words) {
        Node root = new Node();
        for (String w : words) {
            Node cur = root;

            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (cur.children[i] == null) cur.children[i] = new Node();
                cur = cur.children[i];
            }
            cur.isEnd = true;
        }

        String best = "";
        for (String w : words) {
            if (!containsAllPrefixes(root, w)) continue;

            boolean longer = w.length() > best.length();
            boolean lexiShorter = w.length() == best.length() && w.compareTo(best) < 0;
            if (longer || lexiShorter) best = w;
        }

        return best;
    }

    private boolean containsAllPrefixes(Node root, String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            cur = cur.children[i];
            if (!cur.isEnd) return false;
        }
        return true;
    }
}