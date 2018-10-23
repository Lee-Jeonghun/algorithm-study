import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static int[] numArr;
	private static Node[] tree;
	private static int maxIndex;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] line = scanner.nextLine().split(" ");
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		numArr = new int[N];
		for (int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(scanner.nextLine());
		}

		int h = (int)Math.ceil(Math.log(N)) + 2;
		maxIndex = (int)Math.pow(2, h);

		tree = new Node[maxIndex];

		makeTree(1, 0, N - 1);

		for (int i = 0; i < M; i++) {
			String[] rangeLine = scanner.nextLine().split(" ");
			int start = Integer.parseInt(rangeLine[0]) - 1;
			int end = Integer.parseInt(rangeLine[1]) - 1;

			ArrayList<Node> rangeNode = getRangeNode(1, start, end);

			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for (Node node : rangeNode) {
				min = Math.min(min, node.getMin());
				max = Math.max(max, node.getMax());
			}

			System.out.println(min + " " + max);
		}

	}

	public static Node makeTree(int index, int start, int end) {
		if (start == end) {
			tree[index] = new Node(start, end, numArr[start], numArr[start]);
			return tree[index];
		}

		int mid = (start + end) / 2;
		Node leftNode = getNode(index * 2, start, mid);
		Node rightNode = getNode(index * 2 + 1, mid+1, end);

		if (leftNode == null) {
			tree[index] = null;
		} else if (rightNode == null) {
			tree[index] = new Node(leftNode.getStart(), leftNode.getEnd(), leftNode.getMin(), leftNode.getMax());
		} else {
			tree[index] = new Node(leftNode.getStart(), rightNode.getEnd(), Math.min(leftNode.getMin(), rightNode.getMin()), Math.max(leftNode.getMax(), rightNode.getMax()));
		}

		return tree[index];
	}

	public static Node getNode(int index, int start, int end) {
		if (index >= maxIndex) {
			return null;
		}
		return tree[index] == null ? makeTree(index, start, end) : tree[index];
	}

	public static ArrayList<Node> getRangeNode(int index, int start, int end) {
		ArrayList<Node> returnNode = new ArrayList<>();

		if (index >= maxIndex || tree[index] == null) {
			return returnNode;
		}

		if (tree[index].start < start || tree[index].end > end) {
			ArrayList<Node> leftRangeNode = getRangeNode(index * 2, start, end);
			ArrayList<Node> rightRangeNode = getRangeNode(index * 2 + 1, start, end);

			returnNode.addAll(leftRangeNode);
			returnNode.addAll(rightRangeNode);
		} else {
			returnNode.add(tree[index]);
		}

		return returnNode;
	}

	public static class Node {
		public int start;
		public int end;
		public int min;
		public int max;

		public Node(int start, int end, int min, int max) {
			this.start = start;
			this.end = end;
			this.min = min;
			this.max = max;
		}

		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}

		public int getMin() {
			return min;
		}

		public int getMax() {
			return max;
		}
	}
}
