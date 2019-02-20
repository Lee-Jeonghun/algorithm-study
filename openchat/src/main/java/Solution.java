import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author JeongHun, Lee
 */
public class Solution {
	public String[] solution(String[] records) {
		List<Action> actions = new ArrayList<>();
		Map<String, String> nicknameMap = new HashMap<>();
		for (String record : records) {
			String[] split = record.split(" ");

			if (!"Leave".equals(split[0])) {
				nicknameMap.put(split[1], split[2]);
			}

			if (!"Change".equals(split[0])) {
				actions.add(new Action(split[0], split[1]));
			}
		}

		String[] answer = actions.stream().map(action -> {
			String str = nicknameMap.get(action.uid) + "님이 ";
			if ("Enter".equals(action.action)) {
				str += "들어왔습니다.";
			} else if ("Leave".equals(action.action)) {
				str += "나갔습니다.";
			}
			return str;
		}).collect(Collectors.toList()).toArray(new String[] {});

		return answer;
	}

	class Action {
		public String action;
		public String uid;

		public Action(String action, String uid) {
			this.action = action;
			this.uid = uid;
		}
	}
}
