public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int lo = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - lo > profit) {
                profit = prices[i] - lo;
            }
            if (prices[i] < lo) {
                lo = prices[i];
            }
        }

        return profit;
    }
}