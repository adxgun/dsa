class Solution {

    private final int[] prefix;
    private final int sum;
    private Random rand;

    public Solution(int[] w) {
        int running = 0;
        prefix = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            running += w[i];
            prefix[i] = running;
        }

        sum = running;
        rand = new Random();
    }
    
    public int pickIndex() {
        int target = rand.nextInt(sum);
        int lo = 0, hi = prefix.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (prefix[mid] <= target) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */