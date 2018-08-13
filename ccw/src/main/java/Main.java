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

		Point[] points = new Point[3];
		for (int i = 0; i < 3; i++) {
			String[] line = scanner.nextLine().split(" ");
			int x = Integer.parseInt(line[0]);
			int y = Integer.parseInt(line[1]);
			points[i] = new Point(x, y);
		}

		Vector[] vectors = new Vector[2];
		vectors[0] = new Vector(points[1].getX() - points[0].getX(), points[1].getY() - points[0].getY(), 0);
		vectors[1] = new Vector(points[2].getX() - points[1].getX(), points[2].getY() - points[1].getY(), 0);

		int result = vectors[0].getX() * vectors[1].getY() - vectors[0].getY() * vectors[1].getX();
		if (result < 0) {
			System.out.println("-1");
		} else if (result == 0) {
			System.out.println("0");
		} else {
			System.out.println("1");
		}
	}

	public static class Point {
		private int x;
		private int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
	}

	public static class Vector {
		private int x;
		private int y;
		private int z;

		public Vector(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public int getZ() {
			return z;
		}
	}
}
