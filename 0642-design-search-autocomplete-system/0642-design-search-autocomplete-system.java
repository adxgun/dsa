class AutocompleteSystem {

    private final class Node {
        int hotDegree = 0;
        String word = "";
        Node[] children = new Node[27];
    }

    private StringBuilder sb = new StringBuilder();
    private Node root = new Node();
    private Node pos = root;
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            add(sentences[i], times[i]);
        }
    }

    private void add(String s, int hot) {
        Node cur = root;
        for (char c : s.toCharArray()) {
            int i = index(c);
            if (cur.children[i] == null) cur.children[i] = new Node();
            cur = cur.children[i];
        }
        cur.word = s;
        cur.hotDegree += hot;
    }
    
    public List<String> input(char c) {
        if (c == '#') {
            add(sb.toString(), 1);
            pos = root;
            sb.setLength(0);
            return Collections.emptyList();
        }

        sb.append(c);

        PriorityQueue<Node> heap = new PriorityQueue<>((a, b) -> {
            if (a.hotDegree != b.hotDegree) return Integer.compare(b.hotDegree, a.hotDegree);
            return a.word.compareTo(b.word);
        });
        
        if (pos != null) pos = pos.children[index(c)];
        if (pos == null) return Collections.emptyList();

        collect(pos, heap);
        List<String> result = new ArrayList();
        
        while (!heap.isEmpty() && result.size() < 3) result.add(heap.poll().word);
        return result;
    }

    private void collect(Node node, PriorityQueue<Node> heap) {
        if (node.hotDegree > 0) heap.offer(node);
        for (Node child : node.children) {
            if (child != null) collect(child, heap);
        }
    }

    private int index(char c) {
        return c == ' ' ? 26 : c - 'a';
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */