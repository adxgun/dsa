class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> track = new ArrayList<>();
    private int sum = 0;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start) {
        if (sum == target) {
            result.add(new ArrayList<>(track));
            return;
        }

        if (sum > target) return;

        for (int i = start; i < candidates.length; i++) {
            sum += candidates[i];
            track.addLast(candidates[i]);

            backtrack(candidates, target, i);

            sum -= candidates[i];
            track.removeLast();
        }
    }
}