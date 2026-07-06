class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = 0, bobSum = 0;
        for (int x : aliceSizes) aliceSum += x;
        for (int x : bobSizes) bobSum += x;

        Arrays.sort(bobSizes);
        
        for (int k : aliceSizes) {
            int lo = 0, hi = bobSizes.length - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                int find = k + (bobSum - aliceSum) / 2;
                if (bobSizes[mid] == find) return new int[]{
                    k, find,
                };
                else if (bobSizes[mid] < find) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return new int[]{};
    }
}