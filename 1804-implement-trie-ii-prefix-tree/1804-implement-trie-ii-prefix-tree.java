class Trie {

    private final class Node {
        int count = 0;
        int endCount = 0;
        Node[] children = new Node[26];
    }

    private Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node cur = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (cur.children[i] == null) {
                cur.children[i] = new Node();
            }
            
            cur = cur.children[i];
            cur.count++;
        }
        cur.endCount++;
    }
    
    public int countWordsEqualTo(String word) {
        Node node = walk(word);
        if (node == null) return 0;
        return node.endCount;
    }
    
    public int countWordsStartingWith(String prefix) {
        Node node = walk(prefix);
        if (node == null) return 0;
        return node.count;
    }
    
    public void erase(String word) {
        Node cur = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            Node next = cur.children[i];
            next.count--;
            if (next.count == 0) {
                cur.children[i] = null;
                return;
            }

            cur = next;
        }
        cur.endCount--;
    }

    private Node walk(String word) {
        Node cur = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (cur.children[i] == null) return null;

            cur = cur.children[i];
        }
        return cur;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */