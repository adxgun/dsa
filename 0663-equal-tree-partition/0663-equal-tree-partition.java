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
    
    private Set<Integer> seenSums = new HashSet<>();
    public boolean checkEqualTree(TreeNode root) {
        int total = subTreesums(root, true);
        
        if (total % 2 != 0) return false;
        return seenSums.contains(total / 2);
    }

    private int subTreesums(TreeNode root, boolean isRoot) {
        if (root == null) return 0;

        int sum = root.val + subTreesums(root.left, false) + subTreesums(root.right, false);
        if (!isRoot) seenSums.add(sum);
        return sum;
    }
}