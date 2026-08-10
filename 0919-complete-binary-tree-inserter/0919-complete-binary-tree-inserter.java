/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class CBTInserter {

    private Queue<TreeNode> q = new LinkedList<>();
    private TreeNode root;
    public CBTInserter(TreeNode root) {
        this.root = root;
        Queue<TreeNode> temp = new LinkedList<>();
        temp.offer(root);

        while (!temp.isEmpty()) {
            int sz = temp.size();
            while (sz > 0) {
                TreeNode cur = temp.poll();
                if (cur.left != null) temp.offer(cur.left);
                if (cur.right != null) temp.offer(cur.right);

                if (cur.left == null || cur.right == null) q.offer(cur);
                sz--;
            }
        }
    }
    
    public int insert(int val) {
        TreeNode cur = q.peek();
        TreeNode node = new TreeNode(val);
        if (cur.left == null) {
            cur.left = node;
        } else if (cur.right == null) {
            cur.right = node;
            q.poll();
        }

        q.offer(node);
        return cur.val;
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */