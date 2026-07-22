/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> flat = new ArrayList<>();
    private int index = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        flatten(nestedList);
    }

    private void flatten(List<NestedInteger> list) {
        for (NestedInteger ni : list) {
            if (ni.isInteger()) flat.add(ni.getInteger());
            else flatten(ni.getList());
        }
    }

    @Override
    public Integer next() {
        return flat.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < flat.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */