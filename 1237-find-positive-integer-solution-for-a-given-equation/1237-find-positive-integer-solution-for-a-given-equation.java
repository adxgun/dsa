/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */

class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result = new ArrayList<>();
        int x = 1, y = 1000;   // constraints: 1 <= x, y <= 1000

        while (x <= 1000 && y >= 1) {
            int val = customfunction.f(x, y);
            if (val == z) {
                result.add(java.util.Arrays.asList(x, y));
                x++;               // found a pair; move both inward to seek the next
                y--;
            } else if (val < z) {
                x++;               // too small -> need a larger x
            } else {
                y--;               // too large -> need a smaller y
            }
        }
        return result;
    }
}