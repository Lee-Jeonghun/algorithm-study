/**
 * Copyright 2017 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author JeongHun, Lee
 */
public class Triangle {
	private int[] triangle;
	private int[] dp;
	private int depth;

	public void setTriangle(int[] triangle) {
		this.triangle = triangle;
	}

	public void setDp(int[] dp) {
		this.dp = dp;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getMaxSum() {
		return getMax(triangle[0], 0, 1);
	}

	private int getMax(int currentSum, int index, int number) {
		if (number >= depth) {
			return currentSum;
		}

		int leftSum = 0;
		int rightSum = 0;
		int startIndex = (1 + number) * number / 2;
		number++;

		if (dp[startIndex + index] < currentSum + triangle[startIndex + index]) {
			dp[startIndex + index] = currentSum + triangle[startIndex + index];
			leftSum = getMax(dp[startIndex + index], index, number);
		}

		if (dp[startIndex + index + 1] < currentSum + triangle[startIndex + index + 1]) {
			dp[startIndex + index + 1] = currentSum + triangle[startIndex + index + 1];
			rightSum = getMax(dp[startIndex + index + 1], index + 1, number);
		}

		return leftSum > rightSum ? leftSum : rightSum;
	}
}
