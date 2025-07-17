package edu.nenu.array;

public class FindMaxProfitInArray {
	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		System.out.println(maxProfit(prices));
	}

	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int maxProfit = 0;
		// dp[i][0] 表示第i天不持有股票时的最大利润
		int[][] dp = new int[prices.length][2];
		int have = -prices[0];
		int notHave = 0;
		// dp[0][0] = 0;
		// dp[0][1] = -prices[0];
		for (int i = 1; i < prices.length; ++i) {
			have = Math.max(have, notHave - prices[i]);
			notHave = Math.max(notHave, have + prices[i]);
			// dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
			// dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
		}
		return Math.max(have, notHave);
	}

}
