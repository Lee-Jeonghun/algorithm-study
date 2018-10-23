/**
 * Copyright 2017 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author JeongHun, Lee
 */
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] line = scanner.nextLine().split(" ");
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		int maxIndex = (int)Math.pow(2, (int)Math.ceil(Math.log(N)) + 2);
		Node[] tree = new Node[maxIndex+1];

		int mid = maxIndex / 2;
		for (int i = 0; i < N; i++) {
			tree[mid + i] = new Node(i, i, Long.parseLong(scanner.nextLine()));
		}

		makeNode(tree, 1, 0, mid - 1);

		for (int i = 0; i < M; i++) {
			String[] rangeLine = scanner.nextLine().split(" ");
			int start = Integer.parseInt(rangeLine[0]) - 1;
			int end = Integer.parseInt(rangeLine[1]) - 1;

			ArrayList<Node> rangeNode = findNodes(tree, 1, start, end);

			long min = Long.MAX_VALUE;
			for (Node node : rangeNode) {
				min = Math.min(min, node.min);
			}

			System.out.println(min);
		}
	}

	public static ArrayList<Node> findNodes(Node[] tree, int index, int start, int end) {
		ArrayList<Node> returnNode = new ArrayList<>();

		if (index >= tree.length || tree[index] == null) {
			return returnNode;
		}

		if (tree[index].start < start || tree[index].end > end) {
			ArrayList<Node> leftRangeNode = findNodes(tree, index * 2, start, end);
			ArrayList<Node> rightRangeNode = findNodes(tree, index * 2 + 1, start, end);

			returnNode.addAll(leftRangeNode);
			returnNode.addAll(rightRangeNode);
		} else {
			returnNode.add(tree[index]);
		}

		return returnNode;
	}

	public static Node makeNode(Node[] tree, int index, int start, int end) {
		if (tree[index] != null || start == end) {
			return tree[index];
		}

		int mid = (start + end) / 2;
		Node leftNode = makeNode(tree, index * 2, start, mid);
		Node rightNode = makeNode(tree, index * 2 + 1, mid + 1, end);

		if (leftNode == null) {
			tree[index] = null;
		} else if (rightNode == null) {
			tree[index] = leftNode;
		} else {
			tree[index] = new Node(start, end, Math.min(leftNode.min, rightNode.min));
		}

		return tree[index];
	}

	public static class Node {
		public int start;
		public int end;
		public long min;

		public Node(int start, int end, long min) {
			this.start = start;
			this.end = end;
			this.min = min;
		}
	}
}
