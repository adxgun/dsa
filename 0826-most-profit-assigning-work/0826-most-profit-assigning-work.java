class Solution {
    public int maxProfitAssignmentA(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;

        // pair jobs and sort by difficulty
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        java.util.Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // prefixMax[i] = best profit achievable among jobs[0..i] (running max)
        int[] prefixMax = new int[n];
        prefixMax[0] = jobs[0][1];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], jobs[i][1]);
        }

        int totalProfit = 0;
        for (int w : worker) {
            // find the last job with difficulty <= w
            int idx = upperBound(jobs, w) - 1;   // upperBound gives first job > w; -1 -> last <= w
            if (idx >= 0) {
                totalProfit += prefixMax[idx];   // best profit this worker can achieve
            }
        }
        return totalProfit;
    }

    // first index whose job difficulty is strictly greater than target
    private int upperBound(int[][] jobs, int target) {
        int lo = 0, hi = jobs.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (jobs[mid][0] <= target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        java.util.Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        java.util.Arrays.sort(worker);   // sort workers ascending

        int total = 0, best = 0, j = 0;
        for (int w : worker) {
            // advance through all jobs this worker can do, tracking the best profit unlocked
            while (j < n && jobs[j][0] <= w) {
                best = Math.max(best, jobs[j][1]);
                j++;
            }
            total += best;   // best is monotonic because workers are processed in ascending order
        }
        return total;
    }
}