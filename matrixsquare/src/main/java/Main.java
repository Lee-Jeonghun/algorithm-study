/**
 * Copyright 2017 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author JeongHun, Lee
 */
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] param = scanner.nextLine().split(" ");

		int matrixSize = Integer.parseInt(param[0]);
		int[][] matrix = new int[matrixSize][matrixSize];

		long square = Long.parseLong(param[1]);
		char[] binaryChars = Long.toBinaryString(square).toCharArray();
		Queue<int[][]> matrixList = new LinkedList<>();

		for (int i = 0; i < matrixSize; i++) {
			String[] matrixValue = scanner.nextLine().split(" ");
			for (int j = 0; j < matrixSize; j++) {
				matrix[i][j] = Integer.parseInt(matrixValue[j]) % 1000;
			}
		}

		int[][] temp = matrix;
		if (binaryChars[binaryChars.length - 1] == '1') {
			matrixList.add(temp);
		}
		for (int i = binaryChars.length - 2; i >= 0; i--) {
			temp = matrixSquare(temp);
			if (binaryChars[i] == '1') {
				matrixList.add(temp);
			}
		}

		int[][] resultMatrix = null;
		while (!matrixList.isEmpty()) {
			if (resultMatrix == null) {
				resultMatrix = matrixList.poll();
				continue;
			}

			resultMatrix = matrixMultiply(resultMatrix, matrixList.poll());
		}

		if (resultMatrix != null) {
			printMatrix(resultMatrix);
		}
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j]);
				if (j != matrix.length - 1) {
					System.out.print(" ");
				}
			}
			if (i != matrix.length - 1) {
				System.out.println();
			}
		}
	}

	public static int[][] matrixMultiply(int[][] A, int[][] B) {
		int matrixSize = A.length;
		int[][] C = new int[matrixSize][matrixSize];

		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				C[i][j] = 0;
				for (int k = 0; k < matrixSize; k++) {
					C[i][j] += A[i][k] * B[k][j];
				}
				C[i][j] = C[i][j] % 1000;
			}
		}

		return C;
	}

	public static int[][] matrixSquare(int[][] matrix) {
		return matrixMultiply(matrix, matrix);
	}
}