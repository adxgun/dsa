class Solution {

    private final class Node {
        boolean isEnd = false;
        Node[] children = new Node[27];
    }

    public List<String> removeSubfolders1(String[] folder) {
        Node root = new Node();
        for (String f : folder) {
            Node cur = root;
            for (char c : f.toCharArray()) {
                int i = index(c);
                if (cur.children[i] == null) cur.children[i] = new Node();
                cur = cur.children[i];
            }
            cur.isEnd = true;
        }

        List<String> result = new ArrayList<>();
        for (String f : folder) {
            if (!isSubfolder(root, f)) {
                result.add(f);
            }
        }

        return result;
    }

    private int index(char c) {
        return c == '/' ? 26 : c - 'a';
    }

    private boolean isSubfolder(Node root, String path) {
        Node cur = root;
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == '/' && i > 0 && cur.isEnd) {
                return true;
            }

            cur = cur.children[index(c)];
        }
        return false;
    }

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        for (String f : folder) {
            // Skip f if it's inside the last folder we kept
            if (result.isEmpty() || !f.startsWith(result.get(result.size() - 1) + "/")) {
                result.add(f);
            }
        }
        return result;
    }
}