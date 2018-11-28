/**
 * Copyright 2017 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author JeongHun, Lee
 */
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		List<Point> points = new ArrayList<>();
		Set<Point> scope = new TreeSet<>((p1, p2) -> {
			if (p1.y == p2.y) {
				return Integer.compare(p1.x, p2.x);
			} else {
				return p1.y < p2.y ? 1 : -1;
			}
		});

		for (int i = 0; i < n; i++) {
			String[] lines = scanner.nextLine().split(" ");
			points.add(new Point(Integer.parseInt(lines[0]), Integer.parseInt(lines[1])));
		}

		points.sort(Comparator.comparingInt(p -> p.x));

		scope.add(points.get(0));
		scope.add(points.get(1));
		int ans = distance(points.get(0), points.get(1));

		for (int i = 2; i < n; i++) {
			Point pivot = points.get(i);

			Iterator iterator = scope.iterator();
			while (iterator.hasNext()) {
				Point targetPoint = (Point)iterator.next();
				int x = targetPoint.x - pivot.x;
				if (x * x > ans) {
					iterator.remove();
				} else {
					break;
				}
			}

			int d = (int) Math.sqrt((double) ans) + 1;
			for (Point point : scope) {
				if (point.y > pivot.y + d || point.y < pivot.y - d) {
					continue;
				}

				int temp = distance(pivot, point);
				if (temp < ans) {
					ans = temp;
				}
			}

			scope.add(pivot);
		}

		System.out.println(ans);
	}

	public static int distance(Point p1, Point p2) {
		return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
	}

	static class Point {
		public int x;
		public int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
