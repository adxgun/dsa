class Solution {

    private final class Node {
        Node[] children = new Node[10]; // 0-9
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Node root = new Node();
        for (int x : arr1) {
            Node cur = root;
            for (char c : String.valueOf(x).toCharArray()) {
                int i = c - '0';
                if (cur.children[i] == null) cur.children[i] = new Node();
                cur = cur.children[i];
            }
        }

        int best = 0;
        for (int x : arr2) {
            Node cur = root;
            int depth = 0;
            for (char c : String.valueOf(x).toCharArray()) {
                int i = c - '0';
                cur = cur.children[i];
                if (cur == null) break;
                depth++;
            }

            best = Math.max(depth, best);
        }

        return best;
    }
}