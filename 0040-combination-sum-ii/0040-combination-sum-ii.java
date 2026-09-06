
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> track = new ArrayList<>();
    private int sum = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {    
        if (candidates.length == 0) return result;
        
        Arrays.sort(candidates);
        backtrack(candidates, target, 0);
        return result;
    }

    private void backtrack(
        int[] candidates, 
        int target, 
        int start) {

        if (sum == target) {
            result.add(new ArrayList<>(track));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            track.addLast(candidate);
            sum += candidate;
            
            backtrack(candidates, target, i + 1);
            
            track.removeLast();
            sum -= candidate;
        }
    }
}
