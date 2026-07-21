class Solution {
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        TreeNode cur = root;
        while (cur != null) {
            // update closest: strictly nearer wins; on a tie, the smaller value wins
            if (Math.abs(cur.val - target) < Math.abs(closest - target)
                || (Math.abs(cur.val - target) == Math.abs(closest - target) && cur.val < closest)) {
                closest = cur.val;
            }
            // BST guidance: go toward the side where closer values live
            cur = (target < cur.val) ? cur.left : cur.right;
        }
        return closest;
    }
}