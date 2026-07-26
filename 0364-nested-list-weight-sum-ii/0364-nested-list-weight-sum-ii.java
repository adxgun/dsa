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

    public int depthSumInverse(List<NestedInteger> nestedList) {
        int max = maxDepth(nestedList);
        return dfs(nestedList, 1, max);
    }

    private int dfs(List<NestedInteger> list, int depth, int maxDepth) {
        int sum = 0;
        for (NestedInteger ni : list) {
            if (ni.isInteger()) {
                int weight = (maxDepth - depth + 1);
                sum += weight * ni.getInteger();
            }
            else sum += dfs(ni.getList(), depth + 1, maxDepth);
        }
        return sum;
    }

    int maxDepth(List<NestedInteger> nestedList) {
        int max = 1;
        for (NestedInteger ni : nestedList) {
            if (!ni.isInteger() && ni.getList().size() > 0) {
                max = Math.max(max, 1 + maxDepth(ni.getList()));
            }
        }
        return max;
    }
}