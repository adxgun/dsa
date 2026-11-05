class Solution {
    public int largestAltitude(int[] gain) {
        if (gain.length == 0) {
            return 0;
        }

        int alt = gain[0] > 0 ? gain[0] : 0, n = gain.length;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                int sum = (gain[i - 1] + gain[i]);
                if (sum > alt) {
                    alt = sum;
                }
                gain[i] = sum;
            }
        }
        return alt;
    }
}