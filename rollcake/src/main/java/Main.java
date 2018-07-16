/**
 * Copyright 2017 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.Scanner;

/**
 * @author JeongHun, Lee
 */
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int length = Integer.parseInt(scanner.nextLine());
		int num = Integer.parseInt(scanner.nextLine());
		Audience[] audiences = new Audience[num + 1];
		boolean[] rollCake = new boolean[length + 1];

		for (int i = 1; i <= num; i++) {
			String[] param = scanner.nextLine().split(" ");
			audiences[i] = new Audience(Integer.parseInt(param[0]), Integer.parseInt(param[1]));
		}

		int maxExpect = 0;
		int maxReal = 0;
		for (int index = 1; index < audiences.length; index++) {
			Audience audience = audiences[index];
			if (audience.getExpectLength() > audiences[maxExpect].getExpectLength()) {
				maxExpect = index;
			}

			int count = 0;
			for (int i = audience.getStart(); i <= audience.getEnd(); i++) {
				if (!rollCake[i]) {
					rollCake[i] = true;
					count++;
				}
			}

			audience.setReal(count);
			if (count > audiences[maxReal].getReal()) {
				maxReal = index;
			}
		}

		System.out.println(maxExpect);
		System.out.println(maxReal);
	}

	static class Audience {
		int start;
		int end;
		int real;

		public Audience(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}

		public int getExpectLength() {
			return end - start;
		}

		public int getReal() {
			return real;
		}

		public void setReal(int real) {
			this.real = real;
		}
	}
}
