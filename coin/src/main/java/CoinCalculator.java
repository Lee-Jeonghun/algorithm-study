/**
 * Copyright 2017 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author JeongHun, Lee
 */
public class CoinCalculator {
	private int[] coins;

	public int getCoinNumByDC(int money) {
		return calculateByDC(money, 0);
	}

	private int calculateByDC(int money, int coinIndex) {
		int num = Integer.MAX_VALUE;
		for (int i = 0; i <= money / coins[coinIndex]; i++) {
			int remainder = money - coins[coinIndex] * i;

			if (remainder == 0) {
				return num > i ? i : num;
			}

			if (coinIndex + 1 < coins.length) {
				int nowNum = i + calculateByDC(remainder, coinIndex + 1);
				if (nowNum > 0 && num > nowNum) {
					num = nowNum;
				}
			}
		}
		return num;
	}

	public int getCoinNumByDP(int money) {
		int[] dp = new int[money + 1];
		for (int i = 1; i <= money; i++) {
			dp[i] = Integer.MAX_VALUE - 1;
		}

		dp[0] = 0;

		for (int i = 0; i <= money; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i < coins[j]) {
					break;
				}
				dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
			}
		}

		return dp[money];
	}

	public void setCoins(int[] coins) {
		this.coins = coins;
	}
}
