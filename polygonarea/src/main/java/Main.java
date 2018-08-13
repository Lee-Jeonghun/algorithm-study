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
		int count = Integer.parseInt(scanner.nextLine());

		Point[] points = new Point[count];
		for (int i = 0; i < count; i++) {
			String[] line = scanner.nextLine().split(" ");
			points[i] = new Point(Double.parseDouble(line[0]), Double.parseDouble(line[1]));
		}

		double area = 0;
		for (int i = 1; i < count - 1; i++) {
			area += ((points[i].x - points[0].x) * (points[i + 1].y - points[0].y) - (points[i].y - points[0].y) * (points[i + 1].x - points[0].x))/2;
		}

		System.out.println(String.format("%.1f", Math.abs(area)));
	}

	public static class Point {
		public double x;
		public double y;

		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
}
