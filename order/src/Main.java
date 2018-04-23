/**
 * Copyright 2017 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author JeongHun, Lee
 */
public class Main {
	public static void main(String[] args) {
		BinaryTree tree7 = new BinaryTree("7", null, null);
		BinaryTree tree6 = new BinaryTree("6", null, null);
		BinaryTree tree5 = new BinaryTree("5", null, null);
		BinaryTree tree4 = new BinaryTree("4", null, null);
		BinaryTree tree3 = new BinaryTree("3", tree6, tree7);
		BinaryTree tree2 = new BinaryTree("2", tree4, tree5);
		BinaryTree tree1 = new BinaryTree("1", tree2, tree3);

		OrderUtils orderUtils = new OrderUtils();

		System.out.printf("\n 전위순회 : ");
		orderUtils.preOrder(tree1);

		System.out.printf("\n 중위순회 : ");
		orderUtils.inOrder(tree1);

		System.out.printf("\n 후위순회 : ");
		orderUtils.postOrder(tree1);

		System.out.printf("\n 레벨순회 : ");
		orderUtils.levelOrder(tree1);
	}
}
