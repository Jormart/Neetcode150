// 309. Best Time to Buy and Sell Stock with Cooldown
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/

class Solution {
    // Dynamic programming approach using a 2D array to store the maximum profit
    // for each day and whether we are holding a stock or not.
    // The cooldown period is handled by considering the profit from the previous
    // day when we are not holding a stock
    // Time complexity: O(n), where n is the number of days.
    // Space complexity: O(n), for the dp array.

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0)
            return 0;
        int buy = -prices[0]; // Buy on day 0 before any transactions
        int sell = 0; // No stock on day 0
        int prevSell = 0; // Previous day's sell profit

        for (int i = 1; i < n; i++) {
            int temp = sell; // Store the previous day's sell profit
            sell = Math.max(sell, buy + prices[i]); // Sell or keep no stock
            buy = Math.max(buy, prevSell - prices[i]); // Buy or keep the stock
            prevSell = temp; // Update the previous day's sell profit
        }

        return sell; // Maximum profit at the end of the last day
    }

    // Example of using the optimized function
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = { 1, 2, 3, 0, 2 };
        System.out.println(solution.maxProfit(prices)); // Output: 3
    }
}