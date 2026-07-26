/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {

    int maxDepth = 1, depth = 1;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        maxDepth(nestedList);
        System.out.println(maxDepth);
        return dfs(nestedList, 1);
    }

    private int dfs(List<NestedInteger> list, int depth) {
        int sum = 0;
        for (NestedInteger ni : list) {
            if (ni.isInteger()) {
                int weight = (maxDepth - depth + 1);
                sum += weight * ni.getInteger();
            }
            else sum += dfs(ni.getList(), depth + 1);
        }
        return sum;
    }

    void maxDepth(List<NestedInteger> nestedList) {
        for (NestedInteger ni : nestedList) {
            if (!ni.isInteger()) {
                depth++;
                maxDepth = Math.max(depth, maxDepth);
                maxDepth(ni.getList());
                depth--;
            }
        }
    }
}