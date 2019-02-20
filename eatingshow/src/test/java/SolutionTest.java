import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {
private Solution solution = new Solution();
	@Test
	public void solution1() {
		//given
		int[] food_times = {3, 1, 2};
		long k = 5;
		int expect = 1;

		//when
		int output = solution.solution(food_times, k);

		//then
		assertEquals(expect, output);
	}

	@Test
	public void solution2() {
		//given
		int[] food_times = {4, 7, 5};
		long k = 10;
		int expect = 2;

		//when
		int output = solution.solution(food_times, k);

		//then
		assertEquals(expect, output);
	}
}