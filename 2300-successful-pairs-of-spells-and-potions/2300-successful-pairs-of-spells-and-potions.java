class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, k = potions.length;
        int[] res = new int[n];
        Arrays.sort(potions);

        for (int i = 0; i < n; i++) {
            int lo = 0, hi = k - 1, answer = -1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if ((long) potions[mid] * spells[i] >= success) {
                    answer = mid;
                    hi = mid - 1;
                } else lo = mid + 1;
            }
            res[i] = answer == -1 ? 0 : k - answer;
        }
        return res;
    }
}