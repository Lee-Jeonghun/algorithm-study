/**
 * Copyright 2017 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author JeongHun, Lee
 */
public class Animal {
	boolean torch;
	boolean light;
	int range;
	int count;

	public Animal() {
		this.torch = false;
		this.light = false;
		this.count = 0;
	}

	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}

	public boolean isTorch() {
		return torch;
	}

	public void setTorch(boolean torch) {
		this.torch = torch;
	}

	public boolean isLight() {
		return light;
	}

	public void setLight(boolean light) {
		this.light = light;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void plusCount(){
		this.count++;
	}

	public void minusCount(){
		this.count--;
	}
}
