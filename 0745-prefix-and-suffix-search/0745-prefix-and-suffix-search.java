class WordFilter {

    private final class Node {
        int index = -1;
        Node[] children = new Node[27];
    }

    private Node root = new Node();
    
    public WordFilter(String[] words) {
        for (int idx = 0; idx < words.length; idx++) {
            String word = words[idx];
            String key = word + "{" + word;

            for (int i = 0; i <= word.length(); i++) {
                Node cur = root;
                for (int j = i; j < key.length(); j++) {
                    int c = key.charAt(j) - 'a';
                    if (cur.children[c] == null) cur.children[c] = new Node();
                    cur = cur.children[c];
                    cur.index = idx;
                }
            }
        }
    }
    
    public int f(String pref, String suff) {
        String word = suff + "{" + pref;
        Node cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            cur = cur.children[i];
            if (cur == null) return -1;
        }
        return cur.index;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */