import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {
	private Solution solution = new Solution();

	@Test
	public void solution() {
		//given
		String[] input = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] expect = {"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."};

		//when
		String[] output = solution.solution(input);

		//then
		assertEquals(expect[0], output[0]);
		assertEquals(expect[1], output[1]);
		assertEquals(expect[2], output[2]);
		assertEquals(expect[3], output[3]);
	}
}