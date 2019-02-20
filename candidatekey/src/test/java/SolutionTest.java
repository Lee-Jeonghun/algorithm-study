import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {
	private Solution solution = new Solution();

	@Test
	public void solution() {
		//given
		String[][] input = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};
		int expect = 2;

		//when
		int output = solution.solution(input);

		//then
		assertEquals(expect, output);
	}
}