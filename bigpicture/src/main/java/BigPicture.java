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
public class BigPicture {
	private int userHeight;
	private int userWidth;
	private int masterHeight;
	private int masterWidth;
	private char[][] userPicture;
	private char[][] masterpiece;

	public int findPictureNum() {
		initValue();

		int count = 0;
		List<Picture> pictures = new ArrayList<>();

		for (int height = 0; height < masterHeight; height++) {
			for (int width = 0; width < masterWidth; width++) {
				if (height <= masterHeight - userHeight && width <= masterWidth - userWidth) {
					if (masterpiece[height][width] == userPicture[0][0]) {
						pictures.add(new Picture(width));
					}
				}

				Iterator<Picture> pictureIterator = pictures.iterator();
				while (pictureIterator.hasNext()){
					Picture picture = pictureIterator.next();
					if (width - picture.getStartWidthIndex() == picture.getCurrentWidth()) {
						if (masterpiece[height][width] == userPicture[picture.getCurrentHeight()][picture.getCurrentWidth()]) {
							if (picture.getCurrentWidth() == userWidth - 1 && picture.getCurrentHeight() == userHeight - 1) {
								count++;
								pictureIterator.remove();
								continue;
							}

							picture.plusCurrentWidth();

							if (picture.getCurrentWidth() >= userWidth) {
								picture.setCurrentWidth(0);
								picture.plusCurrentHeight();
							}
						} else {
							pictureIterator.remove();
						}
					}
				}
			}
		}

		return count;
	}

	private void initValue() {
		Scanner scanner = new Scanner(System.in);

		userHeight = scanner.nextInt();
		userWidth = scanner.nextInt();
		userPicture = new char[userHeight][userWidth];

		masterHeight = scanner.nextInt();
		masterWidth = scanner.nextInt();
		masterpiece = new char[masterHeight][masterWidth];
		scanner.nextLine();

		for (int i = 0; i < userHeight; i++) {
			String line = scanner.nextLine();
			char[] chars = line.toCharArray();

			for (int j = 0; j < userWidth; j++) {
				userPicture[i][j] = chars[j];
			}
		}

		for (int i = 0; i < masterHeight; i++) {
			String line = scanner.nextLine();
			char[] chars = line.toCharArray();

			for (int j = 0; j < masterWidth; j++) {
				masterpiece[i][j] = chars[j];
			}
		}

		scanner.close();
	}
}
