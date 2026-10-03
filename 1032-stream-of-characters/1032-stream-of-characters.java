class StreamChecker {

    private final class Node {
        boolean isEnd = false;
        Node[] children = new Node[26];
    }

    private StringBuilder stream = new StringBuilder();
    private Node root = new Node();
    private int maxLen = 0;

    public StreamChecker(String[] words) {
        for (String w : words) {
            maxLen = Math.max(maxLen, w.length());
            Node cur = root;
            for (int i = w.length() - 1; i >= 0; i--) {
                int c = w.charAt(i) - 'a';
                if (cur.children[c] == null) cur.children[c] = new Node();
                cur = cur.children[c];
            }
            cur.isEnd = true;
        }
    }
    
    public boolean query(char letter) {
        stream.append(letter);

        if (stream.length() > maxLen) {
            stream.deleteCharAt(0);
        }

        Node cur = root;
        for (int k = stream.length() - 1; k >= 0; k--) {
            int i = stream.charAt(k) - 'a';
            cur = cur.children[i];
            if (cur == null) return false;
            if (cur.isEnd) return true;
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */