class MapSum {

    private final class Node {
        Node[] children = new Node[26];
        int value = 0;
    }

    private Map<String, Integer> sums;
    private Node root;
    
    public MapSum() {
        // sums = new HashMap<>();
        root = new Node();
    }
    
    public void insert(String key, int val) {
        Node cur = root;
        for (char c : key.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) cur.children[i] = new Node();
            cur = cur.children[i];
        }
        cur.value = val;
    }
    
    public int sum1(String prefix) {
        int total = 0;
        for (Map.Entry<String, Integer> entry : sums.entrySet()) {
            String key = entry.getKey();
            if (key.startsWith(prefix)) total += entry.getValue();
        }

        return total;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (char c : prefix.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) return 0;
            cur = cur.children[i];
        }

        return collect(cur);
    }

    private int collect(Node node) {
        int total = node.value;
        for (Node child : node.children) {
            if (child != null) total += collect(child);
        }
        return total;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */