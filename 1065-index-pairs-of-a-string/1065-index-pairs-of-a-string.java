class Solution {

    private final class Node {
        boolean isEnd = false;
        Node[] children = new Node[26];
    }

    public int[][] indexPairs(String text, String[] words) {
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

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            Node cur = root;

            for (int j = i; j < text.length(); j++) {
                int c = text.charAt(j) - 'a';
                if (cur.children[c] == null) break;
                
                cur = cur.children[c];
                if (cur.isEnd) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        int[][] res = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            List<Integer> next = result.get(i);
            res[i][0] = next.get(0);
            res[i][1] = next.get(1);
        }

        return res;
    }
}