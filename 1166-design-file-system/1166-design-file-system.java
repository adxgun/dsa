class FileSystem {

    private final class Node {
        int value = -1;
        boolean exists = false;
        Node[] children = new Node[27];
    }

    private Node root;
    public FileSystem() {
        root = new Node();
    }
    
    public boolean createPath(String path, int value) {
        Node existing = walk(path);
        if (existing != null && existing.exists) return false;
        
        String parent = path.substring(0, path.lastIndexOf('/'));
        if (!parent.isEmpty()) {
            Node p = walk(parent);
            if (p == null || !p.exists) return false;
        }

        Node cur = root;
        for (char c : path.toCharArray()) {
            int i = index(c);
            if (cur.children[i] == null) cur.children[i] = new Node();
            cur = cur.children[i];
        }
        
        cur.value = value;
        cur.exists = true;
        return true;
    }
    
    public int get(String path) {
        Node node = walk(path);
        if (node == null || !node.exists) return -1;
        return node.value;
    }

    private Node walk(String path) {
        Node cur = root;
        for (char c : path.toCharArray()) {
            int i = index(c);
            if (cur.children[i] == null) return null;
            cur = cur.children[i];
        }
        return cur;
    }

    private int index(char c) {
        return c == '/' ? 26 : c - 'a';
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */