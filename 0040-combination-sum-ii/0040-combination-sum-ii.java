
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(candidates);
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

            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidate > target) {
                break;
            }

            combs.add(candidate);
            backtrack(candidates, target - candidate, i + 1, combs, result);
            combs.remove(combs.size() - 1);
        }
    }
}
