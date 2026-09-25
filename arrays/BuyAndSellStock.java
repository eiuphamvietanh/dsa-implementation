public class BuyAndSellStock {

    public int maxProfit(int[] prices) {

        int left = 0;
        int right = left + 1;

        int profit = 0;

        while (right < prices.length) {

            if (prices[right] > prices[left]) {
                profit = Math.max(profit, prices[right] - prices[left]);
            } else {
                left = right;
            }
            right++;
        }
        return profit;

    }

}
