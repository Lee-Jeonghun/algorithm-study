import java.awt.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCase = Integer.parseInt(scanner.nextLine());
		Set<Point> pointSet = new HashSet<>();

		for (int i = 0; i < testCase; i++) {
			String[] strings = scanner.nextLine().split(" ");
			Point startPoint = new Point(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
			Direction direction = Direction.getDirection(Integer.parseInt(strings[2]));
			int generation = Integer.parseInt(strings[3]);

			DragonCurve dragonCurve = new DragonCurve(startPoint, direction, generation);
			pointSet.addAll(dragonCurve.pointSet);
		}

		int count = 0;
		for (Point point : pointSet) {
			if (pointSet.contains(new Point(point.x - 1, point.y - 1))) {
				if (pointSet.contains(new Point(point.x, point.y - 1))) {
					if (pointSet.contains(new Point(point.x - 1, point.y))) {
						count++;
					}
				}
			}
		}

		System.out.println(count);
	}

	public enum Direction {
		RIGHT(0), UP(1), LEFT(2), DOWN(3);

		private final int code;

		Direction(int code) {
			this.code = code;
		}

		public static Direction getDirection(int code) {
			for (Direction direction : values()) {
				if (direction.code == code) {
					return direction;
				}
			}

			return null;
		}

		public static Direction getNextDirection(Direction direction) {
			switch (direction) {
				case UP:
					return LEFT;
				case RIGHT:
					return UP;
				case DOWN:
					return RIGHT;
				case LEFT:
					return DOWN;
				default:
					return null;
			}
		}
	}

	public static class DragonCurve {
		public Point startPoint;
		public int generation;
		public Set<Point> pointSet;
		public Stack<Direction> directionStack;
		public Stack<Direction> newDirectionStack;

		public DragonCurve(Point startPoint, Direction direction, int generation) {
			this.startPoint = startPoint;
			this.generation = generation;

			this.pointSet = new HashSet<>();
			this.directionStack = new Stack<>();
			this.newDirectionStack = new Stack<>();

			newDirectionStack.push(direction);
			pointSet.add(startPoint);

			calculateGeneration();
		}

		public void calculateGeneration() {
			Point targetPoint = startPoint;
			directionStack.addAll(newDirectionStack);

			targetPoint = move(targetPoint, directionStack.pop());
			pointSet.add(targetPoint);

			for (int i = 1; i <= generation; i++) {
				directionStack.addAll(newDirectionStack);

				while (!directionStack.isEmpty()) {
					Direction direction = Direction.getNextDirection(directionStack.pop());
					newDirectionStack.push(direction);

					targetPoint = move(targetPoint, direction);
					pointSet.add(targetPoint);
				}
			}
		}

		private Point move(Point point, Direction direction) {
			switch (direction) {
				case UP:
					return new Point(point.x, point.y - 1);
				case RIGHT:
					return new Point(point.x + 1, point.y);
				case DOWN:
					return new Point(point.x, point.y + 1);
				case LEFT:
					return new Point(point.x - 1, point.y);
				default:
					return point;
			}
		}
	}
}
