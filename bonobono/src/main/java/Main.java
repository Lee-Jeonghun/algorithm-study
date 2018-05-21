/**
 * Copyright 2017 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author JeongHun, Lee
 */
public class Main {
	public static void main(String[] args) {
		BonoBono bonoBono = new BonoBono();
		bonoBono.setN(9);
		bonoBono.setCave(new int[] {1, 2, 2, 1, 3, 1, 1, 2, 4});
		bonoBono.setAnimals(new Animal[9]);

		Animal[] animals = bonoBono.getAnimals();
		for (int i = 0; i < 9; i++) {
			animals[i] = new Animal();
		}

		System.out.println(bonoBono.getMaxAnimal());
	}
}
