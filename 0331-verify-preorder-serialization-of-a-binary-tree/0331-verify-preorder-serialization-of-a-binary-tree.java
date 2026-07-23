class Solution {
    public boolean isValidSerialization(String preorder) {
        int edge = 1;
        for (String node : preorder.split(",")) {
            if (node.equals("#")) {
                // null node consumes one edge
                edge -= 1;
                if (edge < 0) return false;
            } else {
                // non null node consumes one edge and add 2 edges
                edge -= 1;
                if (edge < 0) return false;
                edge += 2;
            }
        }

        return edge == 0;
    }
}