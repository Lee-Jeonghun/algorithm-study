import java.util.Scanner;

/**
 * @author JeongHun, Lee
 */
public class Main {
	private static boolean[][] ladder;
	private static int N;
	private static int M;
	private static int H;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] line = scanner.nextLine().split(" ");

		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		H = Integer.parseInt(line[2]);

		ladder = new boolean[H + 1][N + 1];

		for (int i = 0; i < M; i++) {
			line = scanner.nextLine().split(" ");
			ladder[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = true;
		}

		if (isSuccess()) {
			System.out.println(0);
			return;
		}

		int count = 1;
		while (!fabricate(count, 0)) {
			count++;

			if(count > 3){
				System.out.println(-1);
				return;
			}
		}

		System.out.println(count);
	}

	private static boolean fabricate(int max, int now) {
		now++;

		for (int i = 1; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				if (ladder[i][j]
					|| (j - 1 > 0 && ladder[i][j - 1])
					|| (j + 1 < N && ladder[i][j + 1])) {
					continue;
				}

				ladder[i][j] = true;

				if (max > now) {
					if(fabricate(max, now)){
						return true;
					}
				} else {
					if (isSuccess()) {
						return true;
					}
				}

				ladder[i][j] = false;
			}
		}

		return false;
	}

	private static boolean isSuccess() {
		for (int i = 1; i <= N; i++) {
			if (move(1, i) != i) {
				return false;
			}
		}

		return true;
	}

	private static int move(int y, int x) {
		if (y > H) {
			return x;
		}

		if (ladder[y][x]) {
			return move(y + 1, x + 1);
		} else if (x - 1 >= 0 && ladder[y][x - 1]) {
			return move(y + 1, x - 1);
		} else {
			return move(y + 1, x);
		}
	}
}
