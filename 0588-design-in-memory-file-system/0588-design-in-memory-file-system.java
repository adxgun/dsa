class FileSystem {

    private final class Node {
        TreeMap<String, Node> children = new TreeMap<>();
        boolean isFile = false;
        StringBuilder content = new StringBuilder();
    }

    private final Node root = new Node();
    
    public FileSystem() {}
    
    public List<String> ls(String path) {
        String[] parts = split(path);
        Node node = walk(parts);
        if (node.isFile) return new ArrayList<>(Arrays.asList(parts[parts.length - 1]));
        
        System.out.println(Arrays.toString(parts));
        System.out.println(path + " " + node.children.keySet().size());
        System.out.println(node.children.keySet());
        return new ArrayList<>(node.children.keySet());
    }

    private Node walk(String[] parts) {
        Node cur = root;
        for (String p : parts) {
            cur = cur.children.computeIfAbsent(p, (k) -> new Node());
        }
        return cur;
    }
    
    public void mkdir(String path) {
        walk(split(path));
    }
    
    public void addContentToFile(String filePath, String content) {
        Node file = walk(split(filePath));
        file.isFile = true;
        file.content.append(content);
    }
    
    public String readContentFromFile(String filePath) {
        Node file = walk(split(filePath));
        return file != null ? file.content.toString() : null;
    }

    private String[] split(String path) {
        if (path.equals("/")) return new String[0];
        return path.substring(1).split("/");
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */