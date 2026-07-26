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
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') return new NestedInteger(Integer.parseInt(s));

        Deque<NestedInteger> stack = new ArrayDeque<>();
        int startIndex = 0;
        boolean readingNum = false;
        NestedInteger current = null;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '[') {
                if (current != null) stack.push(current);
                current = new NestedInteger();
            } else if (c == ',' || c == ']') {
                if (readingNum) {
                    int num = Integer.parseInt(s.substring(startIndex, i));
                    current.add(new NestedInteger(num));
                    readingNum = false;
                }

                if (c == ']' && !stack.isEmpty()) {
                    NestedInteger parent = stack.pop();
                    parent.add(current);
                    current = parent;
                }
            } else {
                if (!readingNum) {
                    startIndex = i;
                    readingNum = true;
                }
            }
        }
        return current;
    }
}