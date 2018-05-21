/**
 * Copyright 2017 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author JeongHun, Lee
 */
public class Main {
	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		lotto.setK(8);
		lotto.setS(new int[] {1, 2, 3, 5, 8, 13, 21, 34});
		lotto.printLotto(0, 0);
	}
}
