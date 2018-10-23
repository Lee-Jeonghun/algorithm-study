/**
 * Copyright 2017 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author JeongHun, Lee
 */
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] firstLine = scanner.nextLine().split(" ");
		int N = Integer.parseInt(firstLine[0]);
		int M = Integer.parseInt(firstLine[1]);
		int K = Integer.parseInt(firstLine[2]);
		long[] num = new long[N + 1];
		int maxIndex = (int)Math.pow(2, (int)Math.ceil(Math.log(N)) + 1);
		long[] tree = new long[maxIndex + 1];
		Arrays.fill(tree, 0L);

		for (int i = 1; i <= N; i++) {
			num[i] = Long.parseLong(scanner.nextLine());
			updateTree(tree, i, num[i]);
		}

		for (int i = 0; i < M + K; i++) {
			String[] line = scanner.nextLine().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			if (a == 1) {
				long c = Long.parseLong(line[2]);
				updateTree(tree, b, c - num[b]);
			} else {
				int c = Integer.parseInt(line[2]);
				System.out.println(sumSession(tree, c) - sumSession(tree, b - 1));
			}
		}
	}

	public static void updateTree(long[] tree, int index, long value) {
		while (index < tree.length) {
			tree[index] += value;
			index += (index & -index);
		}
	}

	public static long sumSession(long[] tree, int index) {
		long sum = 0L;
		while (index > 0) {
			sum += tree[index];
			index -= (index & -index);
		}

		return sum;
	}
}
