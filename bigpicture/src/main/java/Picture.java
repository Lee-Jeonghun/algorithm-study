/**
 * Copyright 2017 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author JeongHun, Lee
 */
public class Picture {
	private int currentHeight;
	private int currentWidth;
	private int startWidthIndex;

	public Picture(int startWidthIndex) {
		this.currentHeight = 0;
		this.currentWidth = 0;
		this.startWidthIndex = startWidthIndex;
	}

	public int getCurrentHeight() {
		return currentHeight;
	}

	public void setCurrentHeight(int currentHeight) {
		this.currentHeight = currentHeight;
	}

	public void plusCurrentHeight(){
		this.currentHeight++;
	}

	public int getCurrentWidth() {
		return currentWidth;
	}

	public void setCurrentWidth(int currentWidth) {
		this.currentWidth = currentWidth;
	}

	public void plusCurrentWidth(){
		this.currentWidth++;
	}

	public int getStartWidthIndex() {
		return startWidthIndex;
	}

	public void setStartWidthIndex(int startWidthIndex) {
		this.startWidthIndex = startWidthIndex;
	}
}
