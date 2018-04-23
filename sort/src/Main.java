/**
 * Copyright 2017 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.Arrays;
import java.util.Random;

/**
 * @author JeongHun, Lee
 */
public class Main {
	public static void main(String[] args) {
		Random random = new Random();
		int[] targetArray = random.ints(0, 10000).limit(20).toArray();
		System.out.println(Arrays.toString(new MergeSort().sort(targetArray)));
	}
}
