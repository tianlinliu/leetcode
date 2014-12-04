public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            int leftMax = max(prices, 0, i);
            int rightMax = max(prices, i + 1, prices.length - 1);
            if (leftMax + rightMax > max) {
                max = leftMax + rightMax;
            }
        }

        return max;
    }

    private int max(int[] prices, int start, int end) {
        int max = 0;
        int low = Integer.MAX_VALUE;
        for (int i = start + 1; i <= end; i++) {
            int profit = prices[i] - low;
            if (profit > max) {
                max = profit;
            }
            if (prices[i] < low) {
                low = prices[i];
            }
        }

        return max;
    }

    // DP
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        int len = prices.length;
        int[] left = new int[len]; // store the left max profit for i
        int[] right = new int[len];
        int leftMin = prices[0];
        int rightMax = prices[len - 1];
        for (int i = 1; i < len; i++) { // record left max profit
            if (prices[i] < leftMin) {
                leftMin = prices[i];
            }
            int leftProfit = prices[i] - leftMin;
            left[i] = Math.max(leftProfit, left[i - 1]);
        }

        for (int i = len - 2; i >= 0; i--) { // calculate the right max profit for i
            if (prices[i] > rightMax) {
                rightMax = prices[i];
            }
            int rightProfit = rightMax - prices[i];
            right[i] = Math.max(rightProfit, right[i + 1]);
        }

        int maxProfit = 0;
        for (int i = 0; i < len; i++) {
            maxProfit = Math.max(maxProfit, left[i] + right[i]);
        }

        return maxProfit;
    }
}