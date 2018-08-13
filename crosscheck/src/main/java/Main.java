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
		int testCount = Integer.parseInt(scanner.nextLine());

		for (int i = 0; i < testCount; i++) {
			String[] line = scanner.nextLine().split(" ");
			Vector vector1 = new Vector(new Point(Integer.parseInt(line[2]), Integer.parseInt(line[3])), new Point(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
			Vector vector2 = new Vector(new Point(Integer.parseInt(line[6]), Integer.parseInt(line[7])), new Point(Integer.parseInt(line[4]), Integer.parseInt(line[5])));

			double result = vector1.x * vector2.y - vector1.y * vector2.x;
			if (result == 0) {
				if (calD(vector1) == calD(vector2)) {
					System.out.println("LINE");
				} else {
					System.out.println("NONE");
				}
			} else {
				Point matchPoint = getMatchPoint(vector1, vector2);
				System.out.println(String.format("POINT %.2f %.2f", matchPoint.x, matchPoint.y));
			}
		}
	}

	public static Point getMatchPoint(Vector vector1, Vector vector2) {
		double d1 = calD(vector1);
		double d2 = calD(vector2);

		if (vector1.x == 0) {
			return new Point(vector1.point1.x, vector2.y / vector2.x * vector1.point1.x + d2);
		} else if (vector1.y == 0) {
			return new Point(vector2.x / vector2.y * vector1.point1.y - d2, vector1.point1.y);
		} else if (vector2.x == 0) {
			return new Point(vector2.point1.x, vector1.y / vector1.x * vector2.point1.x + d1);
		} else if (vector2.y == 0) {
			return new Point(vector1.x / vector1.y * vector2.point1.y - d1, vector2.point1.y);
		}

		double x = (d2 - d1) / (vector1.y / vector1.x - vector2.y / vector2.x);
		double y = vector1.y / vector1.x * x + d1;

		return new Point(x, y);
	}

	private static double calD(Vector vector) {
		return vector.point1.y - vector.y / vector.x * vector.point1.x;
	}

	public static class Point {
		public double x;
		public double y;

		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	public static class Vector {
		public Point point1;
		public Point point2;
		public double x;
		public double y;

		public Vector(Point point1, Point point2) {
			this.point1 = point1;
			this.point2 = point2;
			this.x = point2.x - point1.x;
			this.y = point2.y - point1.y;
		}
	}
}
