/**
 * Copyright 2017 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JeongHun, Lee
 */
public class OrderUtils {
	private static final String DELIMITER = " -> ";

	public void preOrder(BinaryTree parent) {
		if (parent != null) {
			System.out.print(parent.getValue() + DELIMITER);
			preOrder(parent.getLeftChild());
			preOrder(parent.getRightChild());
		}
	}

	public void inOrder(BinaryTree parent) {
		if (parent != null) {
			inOrder(parent.getLeftChild());
			System.out.print(parent.getValue() + DELIMITER);
			inOrder(parent.getRightChild());
		}
	}

	public void postOrder(BinaryTree parent) {
		if (parent != null) {
			postOrder(parent.getLeftChild());
			postOrder(parent.getRightChild());
			System.out.print(parent.getValue() + DELIMITER);
		}
	}

	public void levelOrder(BinaryTree parent) {
		Queue<BinaryTree> queue = new LinkedList<>();
		queue.add(parent);

		while (!queue.isEmpty()) {
			BinaryTree binaryTree = queue.poll();

			if (binaryTree != null) {
				System.out.print(binaryTree.getValue() + DELIMITER);

				if (binaryTree.getLeftChild() != null) {
					queue.add(binaryTree.getLeftChild());
				}

				if (binaryTree.getRightChild() != null) {
					queue.add(binaryTree.getRightChild());
				}
			}
		}
	}
}
