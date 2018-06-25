/**
 * Copyright 2017 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author JeongHun, Lee
 */
public class Main {
	private int cowNum;
	private int houseSize;
	private int[] houses;
	private List<List<Integer>> cows;

	private void init() {
		Scanner scanner = new Scanner(System.in);
		cowNum = scanner.nextInt();
		houseSize = scanner.nextInt();

		houses = new int[houseSize + 1];
		cows = new ArrayList<>();

		for (int i = 0; i < houseSize + 1; i++) {
			houses[i] = -1;
		}

		for (int i = 0; i < cowNum; i++) {
			int num = scanner.nextInt();
			List<Integer> cow = new ArrayList<>();
			for (int j = 0; j < num; j++) {
				int houseNum = scanner.nextInt();
				cow.add(houseNum);
			}
			cows.add(cow);
		}
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.init();

		int count = 0;
		for (int i = 0; i < main.cowNum; i++) {
			if (main.isAvailable(i)) {
				count++;
			}
		}

		System.out.println(count);
	}

	private boolean isAvailable(int cowIndex) {
		Iterator cowIterator = cows.get(cowIndex).iterator();
		while (cowIterator.hasNext()) {
			Integer houseNum = (Integer)cowIterator.next();
			cowIterator.remove();
			if (houses[houseNum] == -1 || isAvailable(houses[houseNum])) {
				houses[houseNum] = cowIndex;
				return true;
			}
		}
		return false;
	}
}
