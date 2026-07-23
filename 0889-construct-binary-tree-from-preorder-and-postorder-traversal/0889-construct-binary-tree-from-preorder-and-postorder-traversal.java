class Solution {
    private int preIdx = 0, postIdx = 0;
    private int[] preorder, postorder;
    private Map<Integer, Integer> postIndex = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.preorder = preorder;
        this.postorder = postorder;
        for (int i = 0; i < postorder.length; i++) postIndex.put(postorder[i], i);
        return build(0, postorder.length - 1);
    }

    // builds the subtree whose postorder occupies [postLeft, postRight]
    private TreeNode build(int postLeft, int postRight) {
        if (postLeft > postRight) return null;

        int rootVal = preorder[preIdx++];          // preorder gives roots front-to-back
        TreeNode root = new TreeNode(rootVal);

        if (postLeft == postRight) return root;     // single node → leaf, done

        // the NEXT preorder value is the left child; find where it ends in postorder
        int leftChildVal = preorder[preIdx];
        int leftEnd = postIndex.get(leftChildVal);  // last index of the left subtree in postorder

        root.left  = build(postLeft, leftEnd);          // left subtree's postorder range
        root.right = build(leftEnd + 1, postRight - 1); // right subtree's range (excl. the root itself)
        return root;
    }
}