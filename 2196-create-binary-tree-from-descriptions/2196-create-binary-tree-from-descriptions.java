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
class Solution {
    public TreeNode createBinaryTree(int[][] desc) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] cur : desc) {
            int parentVal = cur[0], childVal = cur[1];
            boolean isLeft = cur[2] == 1;

            TreeNode parent = nodes.computeIfAbsent(parentVal, TreeNode::new);
            TreeNode child = nodes.computeIfAbsent(childVal, TreeNode::new);

            if (isLeft) parent.left = child;
            else parent.right = child;

            children.add(childVal);
        }

        for (int[] cur : desc) {
            int childVal = cur[0];
            if (!children.contains(childVal)) return nodes.get(childVal);
        }

        return null;
    }
}