class Solution {

    private final class Node {
        Node[] children = new Node[26];
    }

    public int countDistinct(String s) {
        int count = 0;

        Node root = new Node();
        for (int i = 0; i < s.length(); i++) {
            Node cur = root;

            for (int j = i; j < s.length(); j++) {
                int c = s.charAt(j) - 'a';
                if (cur.children[c] == null) {
                    cur.children[c] = new Node();
                    count++;
                }

                cur = cur.children[c];
            }
        }

        return count;
    }
}