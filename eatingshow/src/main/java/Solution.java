import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author JeongHun, Lee
 */
public class Solution {
	public int solution(int[] food_times, long k) {
		int foodCount = food_times.length;
		int min = (int)(k / foodCount);
		int rest = (int)(k % foodCount);

		int startIndex = -1;
		for (int i = 0; i < foodCount; i++) {
			int num = food_times[i] - min;
			if (rest > 0) {
				num -= 1;
				rest--;
			}

			if (num > 0) {
				if(startIndex == -1 || i < startIndex){
					startIndex = i+1;
				}
				food_times[i] = num;
			} else {
				rest += Math.abs(num);
				food_times[i] = 0;
			}
		}

		if (startIndex != -1 && rest > 0) {
			startIndex = solution(food_times, rest);
		}

		return startIndex;
	}
}
