/**
 * Copyright 2017 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author JeongHun, Lee
 */
public class BinaryTree {
	private Object value;
	private BinaryTree leftChild;
	private BinaryTree rightChild;

	public BinaryTree(Object value) {
		this.value = value;
	}

	public BinaryTree(Object value, BinaryTree leftChild, BinaryTree rightChild) {
		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	public Object getValue() {
		return value.toString();
	}

	public void setValue(int value) {
		this.value = value;
	}

	public BinaryTree getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinaryTree leftChild) {
		this.leftChild = leftChild;
	}

	public BinaryTree getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinaryTree rightChild) {
		this.rightChild = rightChild;
	}
}
