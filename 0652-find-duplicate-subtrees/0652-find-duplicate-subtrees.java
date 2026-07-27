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

    private Map<Integer, Integer> treeCount = new HashMap<>();
    private Map<String, Integer> count = new HashMap<>();
    private List<TreeNode> result = new ArrayList<>();
    private Map<String, Integer> treeId = new HashMap<>();
    private int idCounter = 0;
    private static String NULL = "#";
    
    public List<TreeNode> findDuplicateSubtreesA(TreeNode root) {
        dfs(root);
        return result;    
    }

    private String dfs(TreeNode root) {
        if (root == null) return NULL;

        String left = dfs(root.left);
        String right = dfs(root.right);

        String triple = root.val + "," + left + "," + right;
        int c = count.merge(triple, 1, Integer::sum);

        if (c == 2) result.add(root);
        return triple;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        getId(root);
        return result;
    }

    private int getId(TreeNode root) {
        if (root == null) return 0;

        int left = getId(root.left);
        int right = getId(root.right);

        String triple = root.val + "," + left + "," + right;
        int id = treeId.computeIfAbsent(triple, k -> ++idCounter);
        int val = treeCount.merge(id, 1, Integer::sum);

        if (val == 2) result.add(root);
        return id;
    }
}