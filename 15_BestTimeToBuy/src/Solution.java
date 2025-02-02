class Solution {
    public int maxProfit(int[] prices) {
        // Base case
        int min = prices[0];
        int profit = 0;
        // Loop through the prices array
        for (int i = 1; i < prices.length; i++) {
            // If the current price is less than the minimum price so far
            if (prices[i] < min) {
                min = prices[i];
                // If the current price minus the minimum price is greater than the profit
            } else {
                profit = Math.max(profit, prices[i] - min);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(solution.maxProfit(prices));

        prices = new int[] { 7, 6, 4, 3, 1 };
        System.out.println(solution.maxProfit(prices));
    }
}