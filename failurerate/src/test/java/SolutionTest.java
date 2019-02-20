import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {
	private Solution solution = new Solution();

	@Test
	public void solution() {
		//given
		int N1 = 5;
		int[] stages1 = {2, 1, 2, 6, 2, 4, 3, 3};
		int[] expect1 = {3,4,2,1,5};

		int N2 = 4;
		int[] stages2 = {4, 4, 4, 4, 4};
		int[] expect2 = {4,1,2,3};

		//when
		int[] output1 = solution.solution(N1, stages1);
		int[] output2 = solution.solution(N2, stages2);

		//then
		assertEquals(output1.length, expect1.length);
		for (int i = 0; i < expect1.length; i++) {
			assertEquals(output1[i], expect1[i]);
		}

		assertEquals(output2.length, expect2.length);
		for (int i = 0; i < expect2.length; i++) {
			assertEquals(output2[i], expect2[i]);
		}
	}
}