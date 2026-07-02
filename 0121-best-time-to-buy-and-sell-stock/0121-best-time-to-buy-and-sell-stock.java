class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;   // cheapest buy price seen so far
        int profit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;            // found a cheaper day to have bought
            } else if (price - minPrice > profit) {
                profit = price - minPrice;   // selling today beats our best so far
            }
        }
        return profit;
    }
}