import java.util.Scanner;

/**
 * @author JeongHun, Lee
 */
public class Main {
	private static int[][] DP;
	private static int[][] FOREST;
	private static int N;
	private static int MAX;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = Integer.parseInt(scanner.nextLine());

		DP = new int[N][N];
		FOREST = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] line = scanner.nextLine().split(" ");

			for (int j = 0; j < N; j++) {
				FOREST[i][j] = Integer.parseInt(line[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				getMaxLife(i, j);
			}
		}


		System.out.println(MAX);
	}

	private static int getMaxLife(int y, int x) {
		if (DP[y][x] != 0) {
			return DP[y][x];
		}

		int maxLife = 0;
		int tempLife = 0;
		if (x - 1 >= 0 && FOREST[y][x - 1] > FOREST[y][x]) {
			tempLife = getMaxLife(y, x - 1);
			if (maxLife < tempLife) {
				maxLife = tempLife;
			}
		}

		if (x + 1 < N && FOREST[y][x + 1] > FOREST[y][x]) {
			tempLife = getMaxLife(y, x + 1);
			if (maxLife < tempLife) {
				maxLife = tempLife;
			}
		}

		if (y - 1 >= 0 && FOREST[y - 1][x] > FOREST[y][x]) {
			tempLife = getMaxLife(y - 1, x);
			if (maxLife < tempLife) {
				maxLife = tempLife;
			}
		}

		if (y + 1 < N && FOREST[y + 1][x] > FOREST[y][x]) {
			tempLife = getMaxLife(y + 1, x);
			if (maxLife < tempLife) {
				maxLife = tempLife;
			}
		}

		DP[y][x] = maxLife + 1;
		if (MAX < DP[y][x]) {
			MAX = DP[y][x];
		}
		return DP[y][x];
	}
}
