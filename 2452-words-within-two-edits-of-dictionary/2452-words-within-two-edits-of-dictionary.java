class Solution {

    private final class Node {
        boolean isEnd = false;
        Node[] children = new Node[26];
    }

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        Node root = new Node();
        for (String w : dictionary) {
            Node cur = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (cur.children[i] == null) cur.children[i] = new Node();
                cur = cur.children[i];
            }
            cur.isEnd = true;
        }

        List<String> result = new ArrayList<>();
        for (String w : queries) {
            if (canMatch(root, w, 0, 0)) {
                result.add(w);
            }
        }

        return result;
    }

    private boolean canMatch(Node node, String w, int pos, int edits) {
        if (pos == w.length()) return node.isEnd;

        for (int i = 0; i < 26; i++) {
            Node child = node.children[i];
            if (child == null) continue;

            int cost = (i == w.charAt(pos) - 'a') ? 0 : 1;
            if (edits + cost > 2) continue;

            if (canMatch(child, w, pos + 1, edits + cost)) return true;
        }

        return false;
    }

    public List<String> twoEditWords1(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        for (String query : queries) {
            for (String dict : dictionary) {
                if (withinEditsDistance(query, dict)) {
                    result.add(query);
                    break;
                }
            }
        }
        return result;
    }

    private boolean withinEditsDistance(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;

            if (diff > 2) return false;
        }

        return true;
    }
}