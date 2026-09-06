class Solution {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> track = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1);
        return result;
    }

    private void backtrack(int n, int k, int start) {
        if (track.size() == k) {
            result.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i <= n; i++) {
            track.addLast(i);
            backtrack(n, k, i + 1);
            track.removeLast();
        }
    }
}