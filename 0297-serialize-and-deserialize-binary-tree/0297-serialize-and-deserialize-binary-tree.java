/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    private StringBuilder sb = new StringBuilder();
    private static String NULL = "#";
    private static String SEP = ",";

    public String serialize(TreeNode root) {
        dfs(root);
        return sb.toString();
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        sb.append(root.val).append(SEP);
        dfs(root.left);
        dfs(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> nodes = new ArrayList<>();
        String[] ls = data.split(",");
        for (String s : ls) nodes.add(s);
        return _deserialize(nodes);
    }

    private TreeNode _deserialize(List<String> nodes) {
        if (nodes.isEmpty()) return null;

        String next = nodes.removeFirst();
        if (NULL.equals(next)) return null;
        
        int val = Integer.parseInt(next);
        TreeNode root = new TreeNode(val);
        root.left = _deserialize(nodes);
        root.right = _deserialize(nodes);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));