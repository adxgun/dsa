class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        if (arr.length == 0) {
            return false;
        }

        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        Set<Integer> seen = new HashSet<>();
        for (int x : freq.values()) {
            if (!seen.add(x)) {
                return false;
            }
        }
        return true;
    }
}