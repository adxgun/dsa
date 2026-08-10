/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private Map<Integer, TreeNode> parents = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        traverse(root, null);

        Queue<TreeNode> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(target);
        visited.add(target.val);

        List<Integer> res = new ArrayList<>();
        int distance = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                if (distance == k) {
                    res.add(cur.val);
                }

                TreeNode parent = parents.get(cur.val);
                if (parent != null && !visited.contains(parent.val)) {
                    visited.add(parent.val);
                    q.offer(parent);
                }

                if (cur.left != null && !visited.contains(cur.left.val)) {
                    visited.add(cur.left.val);
                    q.offer(cur.left);
                }

                if (cur.right != null && !visited.contains(cur.right.val)) {
                    visited.add(cur.right.val);
                    q.offer(cur.right);
                }
            }
            distance++;
        }
        return res;
    }

    private void traverse(TreeNode root, TreeNode parent) {
        if (root == null) return;

        parents.put(root.val, parent);
        traverse(root.left, root);
        traverse(root.right, root);
    }
}