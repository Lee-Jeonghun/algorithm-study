/**
 * Copyright 2017 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.Scanner;

/**
 * @author JeongHun, Lee
 */
public class Main {
	private static final int MY_TURN = 1;
	private static final int YOUR_TURN = 2;
	private static int[] card;
	private static int[][][] dp;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCase = Integer.parseInt(scanner.nextLine().split(" ")[0]);
		for (int i = 0; i < testCase; i++) {
			int size = Integer.parseInt(scanner.nextLine().split(" ")[0]);
			card = new int[size];
			String[] strings = scanner.nextLine().split(" ");

			for (int j = 0; j < size; j++) {
				card[j] = Integer.parseInt(strings[j]);
			}
			dp = new int[size][size][2];
			for (int a = 0; a < size; a++) {
				for (int b = 0; b < size; b++) {
					for (int c = 0; c < 2; c++) {
						dp[a][b][c] = -1;
					}
				}
			}

			System.out.println(chooseCard(MY_TURN, 0, size - 1));
		}
	}

	public static int chooseCard(int turn, int left, int right) {
		if (dp[left][right][turn] != -1) {
			return dp[left][right][turn];
		}

		int result;

		if (left == right) {
			if (turn == MY_TURN) {
				result = card[left];
			} else {
				result = 0;
			}
			dp[left][right][turn] = result;
			return result;
		}

		if (turn == MY_TURN) {
			result = Math.max(chooseCard(YOUR_TURN, left + 1, right) + card[left], chooseCard(YOUR_TURN, left, right - 1) + card[right]);
		} else {
			result = Math.min(chooseCard(MY_TURN, left + 1, right), chooseCard(MY_TURN, left, right - 1));
		}

		dp[left][right][turn] = result;
		return result;
	}
}
