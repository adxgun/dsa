class Solution {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private int sum = 0;
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(1, k, n);
        return result;
    }

    private void backtrack(int start, int k, int n) {
        if (path.size() == k && sum == n) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (sum > n) return;

        for (int i = start; i <= 9; i++) {
            sum += i;
            path.add(i);

            backtrack(i + 1, k, n);
            sum -= i;
            path.remove(path.size() - 1);
        }
    }
}