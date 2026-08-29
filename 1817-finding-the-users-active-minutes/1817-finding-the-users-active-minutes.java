class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> uams = new HashMap<>();
        for (int[] log : logs) {
            uams.computeIfAbsent(log[0], (v) -> new HashSet<>()).add(log[1]);
        }

        int[] answer = new int[k];
        for (Set<Integer> value : uams.values()) {
            int count = value.size();
            answer[count - 1] += 1;
        }

        return answer;
    }
}