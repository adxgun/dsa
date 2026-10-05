class WordDictionary {

    private final class Node {
        Node[] children = new Node[27];
        boolean isEnd = false;
    }

    private Node root = new Node();
    
    public WordDictionary() {}
    
    public void addWord(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) cur.children[i] = new Node();
            cur = cur.children[i];
        }
        cur.isEnd = true;
    }
    
    public boolean search(String word) {
        return match(root, word, 0);
    }

    private boolean match(Node node, String word, int pos) {
        if (word.length() == pos) return node.isEnd;

        int c = word.charAt(pos);
        if (c == '.') {
            for (Node child : node.children) {
                if (child != null && match(child, word, pos + 1)) return true;
            }
            return false;
        }

        Node child = node.children[c - 'a'];
        return child != null && match(child, word, pos + 1);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */