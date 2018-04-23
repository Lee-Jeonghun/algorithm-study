/**
 * Copyright 2017 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.Arrays;

/**
 * @author JeongHun, Lee
 */
public class MergeSort implements Sort {
	public int[] sort(int[] array) {
		int arrayLength = array.length;
		if (arrayLength <= 1) {
			return array;
		}

		int median = arrayLength / 2;

		int[] leftArray = Arrays.copyOfRange(array, 0, median);
		int[] rightArray = Arrays.copyOfRange(array, median, arrayLength);

		leftArray = sort(leftArray);
		rightArray = sort(rightArray);

		return merge(leftArray, rightArray, array);
	}

	public int[] merge(int[] leftArray, int[] rightArray, int[] array) {
		int leftArrayLength = leftArray.length;
		int rightArrayLength = rightArray.length;
		int leftIndex = 0;
		int rightIndex = 0;
		int index = 0;

		while (leftIndex < leftArrayLength && rightIndex < rightArrayLength) {
			if (leftArray[leftIndex] <= rightArray[rightIndex]) {
				array[index] = leftArray[leftIndex];
				leftIndex++;
			} else {
				array[index] = rightArray[rightIndex];
				rightIndex++;
			}
			index++;
		}

		while (leftIndex < leftArrayLength) {
			array[index] = leftArray[leftIndex];
			leftIndex++;
			index++;
		}

		while (rightIndex < rightArrayLength) {
			array[index] = rightArray[rightIndex];
			rightIndex++;
			index++;
		}

		return array;
	}
}
