class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = Integer.MAX_VALUE;
        int[] best = new int[n];
        Arrays.fill(best, INF);
        
        int minLen = INF, sum = 0, left = 0, shortest = INF;
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {
                int curLen = right - left + 1;
                if (left > 0 && best[left - 1] != INF) {
                    minLen = Math.min(minLen, curLen + best[left - 1]);
                }

                shortest = Math.min(shortest, curLen);
            }
            best[right] = shortest;
        }

        return minLen == INF ? -1 : minLen;
    }
}