import java.util.ArrayList;
import java.util.List;

/**
 * @author JeongHun, Lee
 */
public class Solution {
	public int[] solution(int N, int[] stages) {
		int[] userInStage = new int[N];
		int user = 0;
		for (int stage : stages) {
			if (stage > N) {
				user++;
			} else {
				userInStage[stage - 1]++;
			}
		}

		List<Stage> stageList = new ArrayList<>();

		for (int i = N - 1; i >= 0; i--) {
			user += userInStage[i];
			stageList.add(new Stage(i + 1, (double)userInStage[i] / user));
		}

		int[] answer = stageList.stream().sorted((o1, o2) -> {
			if (o1.failureRate > o2.failureRate) {
				return -1;
			} else if (o1.failureRate < o2.failureRate) {
				return 1;
			} else {
				return Integer.compare(o1.index, o2.index);
			}
		}).mapToInt(stage -> stage.index).toArray();

		return answer;
	}

	class Stage {
		public int index;
		public double failureRate;

		public Stage(int index, double failureRate) {
			this.index = index;
			this.failureRate = failureRate;
		}
	}
}
