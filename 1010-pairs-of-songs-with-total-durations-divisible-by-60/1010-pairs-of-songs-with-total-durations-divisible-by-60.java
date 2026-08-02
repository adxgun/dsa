class Solution {
    public int numPairsDivisibleBy60_A(int[] time) {
        int count = 0, n = time.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    count += (time[i] + time[j]) % 60 == 0 ? 1 : 0;
                }
            }
        }
        return count;
    }

    public int numPairsDivisibleBy60(int[] time) {
        int pairs = 0;
        int[] count = new int[60];

        for (int t : time) {
            int remainder = t % 60;
            int complement = (60 - remainder) % 60;
            pairs += count[complement];
            count[remainder]++;
        }
        return pairs;
    }
}