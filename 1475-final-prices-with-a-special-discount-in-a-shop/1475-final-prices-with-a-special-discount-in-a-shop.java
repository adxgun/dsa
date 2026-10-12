class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];

        for (int i = 0; i < prices.length; i++) {
            int j = i + 1;
            while (j < n) {
                if (prices[j] <= prices[i]) break;
                j++;
            }

            ans[i] = j >= n ? prices[i] : prices[i] - prices[j];
        }
        
        return ans;
    }
}