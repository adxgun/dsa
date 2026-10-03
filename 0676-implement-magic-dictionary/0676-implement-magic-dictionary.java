class MagicDictionary {

    private final class Node {
        Node[] children = new Node[26];
        boolean isEnd = false;
    }

    private Node root;
    private String[] dictionary;    
    
    public MagicDictionary() {
        root = new Node();
    }
    
    public void buildDict(String[] dictionary) {
        this.dictionary = dictionary;
        
        for (String dict : dictionary) {
            Node cur = root;
            for (char c : dict.toCharArray()) {
                int i = c - 'a';
                if (cur.children[i] == null) cur.children[i] = new Node();
                cur = cur.children[i];
            }
            cur.isEnd = true;
        }
    }
    
    public boolean search(String searchWord) {
        return dfs(root, searchWord, 0, 0);
    }

    private boolean dfs(Node node, String w, int pos, int changes) {
        if (w.length() == pos) return node.isEnd && changes == 1;

        for (int i = 0; i < 26; i++) {
            Node child = node.children[i];
            if (child == null) continue;

            int cost = w.charAt(pos) - 'a' == i ? 0 : 1;
            if (cost + changes > 1) continue;
            if (dfs(child, w, pos + 1, cost + changes)) return true;
        }

        return false;
    }

    private boolean bf(String w) {
        for (String dict : dictionary) {
            if (isMagic(dict, w)) return true;
        }
        return false;
    }

    private boolean isMagic(String a, String b) {
        if (a.length() != b.length() || a.equals(b)) return false;
        
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 1) return false;
            }
        }
        return true;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */