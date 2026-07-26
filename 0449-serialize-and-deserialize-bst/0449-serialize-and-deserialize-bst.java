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

    private String SEP = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        _encode(root, sb);
        return sb.toString();
    }

    private void _encode(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(SEP);
            return;
        }

        sb.append(root.val).append(SEP);
        _encode(root.left, sb);
        _encode(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        Deque<String> q = new ArrayDeque<>(Arrays.asList(data.split(SEP)));
        return _decode(q);
    }

    TreeNode _decode(Deque<String> queue) {
        if (queue.isEmpty() ) return null;
        
        String next = queue.poll();
        if (next.isEmpty()) return null;

        int val = Integer.parseInt(next);
        TreeNode root = new TreeNode(val);
        root.left = _decode(queue);
        root.right = _decode(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;