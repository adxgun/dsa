/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return Arrays.asList();
        
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int sz = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                level.add(cur.val);

                for (Node node : cur.children) {
                    if (node != null) q.offer(node);
                }
            }
            res.add(level);
        }
        return res;
    }
}