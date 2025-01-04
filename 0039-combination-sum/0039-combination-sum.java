class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> combs, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(combs));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];

            combs.add(candidate);
            backtrack(candidates, target - candidate, i, combs, result);
            combs.remove(combs.size() - 1);
        }
    }
}