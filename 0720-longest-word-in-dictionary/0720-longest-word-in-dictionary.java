class Solution {
    public String longestWord1(String[] w) {
        Arrays.sort(w);

        Set<String> buildable = new HashSet<>();
        buildable.add(""); // lets single letter count as buildable.
        String best = "";

        for (String s : w) {
            String prev = s.substring(0, s.length() - 1);
            if (buildable.contains(prev)) {
                buildable.add(s);

                if (s.length() > best.length()) best = s;
            }
        }

        return best;
    }

    private final class Node {
        String word = null;
        Node[] children = new Node[26];
    }

    private String best = "";
    public String longestWord(String[] words) {
        Node root = new Node();
        for (String w : words) {
            Node cur = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (cur.children[i] == null) cur.children[i] = new Node();
                cur = cur.children[i];
            }
            cur.word = w;
        }
        
        dfs(root);
        return best;
    }

    private void dfs(Node root) {
        if (root == null) return;

        for (Node node : root.children) {
            if (node != null && node.word != null) {
                if (node.word.length() > best.length()) best = node.word;
                dfs(node);
            }
        }
    }
}