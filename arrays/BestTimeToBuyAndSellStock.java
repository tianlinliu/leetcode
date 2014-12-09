public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        // optimization
        // time: 0(N) space: O(1)
        if (prices == null || prices.length == 0) return 0;

        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int p : prices) {
            min = Math.min(min, p);
            maxProfit = Math.max(maxProfit, p - min);
        }

        return maxProfit;
    }

    // dp
    // space complexity: O(N)
    public int maxProfit_dp(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        int[] profits = new int[prices.length]; // memoize the profit for each price
        profits[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            profits[i] = Math.max(profits[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return profits[profits.length - 1];
    }
}