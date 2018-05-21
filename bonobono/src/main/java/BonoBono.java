/**
 * Copyright 2017 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author JeongHun, Lee
 */
public class BonoBono {
	private static final boolean ON = true;
	private static final boolean OFF = false;

	private int N;
	private int[] cave;
	private Animal[] animals;
	private int maxCount;

	public int getMaxAnimal() {
		for (int i = 0; i < N; i++) {
			if (animals[i].isLight() == OFF && animals[i].isTorch() == OFF) {
				turnOn(i);
			}
		}
		return maxCount;
	}

	private void turnOn(int index) {
		int startIndex = index - (cave[index] - 1) < 0 ? 0 : index - (cave[index] - 1);
		int endIndex = index + (cave[index] - 1) >= N ? N - 1 : index + (cave[index] - 1);

		for (int i = startIndex; i <= endIndex; i++) {
			Animal target = animals[i];

			target.plusCount();
			if (target.isLight() == OFF) {
				target.setLight(ON);
			}

			if (target.isTorch() == ON) {
				turnOff(i, index);
			}
		}

		maxCount++;
		animals[index].setTorch(ON);
	}

	private void turnOff(int index, int preIndex) {
		if (isPossibilityTurnOff(index, preIndex)) {
			animals[index].setTorch(OFF);

			int startIndex = index - (cave[index] - 1) < 0 ? 0 : index - (cave[index] - 1);
			int endIndex = index + (cave[index] - 1) >= N ? N - 1 : index + (cave[index] - 1);

			for (int i = startIndex; i <= endIndex; i++) {
				Animal target = animals[i];
				target.minusCount();
			}

			maxCount--;
		}
	}

	private boolean isPossibilityTurnOff(int index, int preIndex) {
		int startIndex = index - (cave[index] - 1) < 0 ? 0 : index - (cave[index] - 1);
		int endIndex = preIndex - (cave[preIndex] - 1) < 0 ? 0 : preIndex - (cave[preIndex] - 1);

		for (int i = startIndex; i < endIndex; i++) {
			Animal target = animals[i];

			if (target.getCount() == 1) {
				return false;
			}

			if (target.isTorch() == ON) {
				turnOff(i, index);
			}
		}

		return true;
	}

	public void setN(int n) {
		N = n;
	}

	public void setCave(int[] cave) {
		this.cave = cave;
	}

	public void setAnimals(Animal[] animals) {
		this.animals = animals;
	}

	public Animal[] getAnimals() {
		return animals;
	}
}
