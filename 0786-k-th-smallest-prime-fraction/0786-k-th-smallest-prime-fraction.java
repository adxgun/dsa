class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double lo = 0.0, hi = 1.0;

        while (true) {
            double mid = lo + (hi - lo) / 2;
            int count = 0, i = 0;
            int bestP = 0, bestQ = 1;    // best fraction <= mid: start at 0/1

            for (int j = 1; j < n; j++) {
                while (i < j && arr[i] <= mid * arr[j]) i++;
                count += i;
                // if there's a valid numerator, its largest fraction for this j is arr[i-1]/arr[j];
                // compare against current best via cross-multiplication (exact)
                if (i > 0 && (long) arr[i - 1] * bestQ > (long) bestP * arr[j]) {
                    bestP = arr[i - 1];
                    bestQ = arr[j];
                }
            }

            if (count == k) return new int[]{bestP, bestQ};
            else if (count < k) lo = mid;
            else hi = mid;
        }
    }
}