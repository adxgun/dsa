class Solution {

    private final class Node {
        int passCount = 0;
        Node[] children = new Node[26];
    }

    public int[] sumPrefixScores(String[] words) {
        Node root = new Node();
        for (String w : words) {
            Node cur = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (cur.children[i] == null) cur.children[i] = new Node();
                cur = cur.children[i];
                cur.passCount++;
            }
        }

        int[] answer = new int[words.length];
        for (int idx = 0; idx < words.length; idx++) {
            Node cur = root;
            int total = 0;
            for (char c : words[idx].toCharArray()) {
                cur = cur.children[c - 'a'];
                total += cur.passCount;
            }
            
            answer[idx] = total;
        }

        return answer;
    }
}