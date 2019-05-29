import java.util.Scanner;

/**
 * @author JeongHun, Lee
 */
public class Main {
	private static double[] nums;
	private static int N;
	private static int K;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] line = scanner.nextLine().split(" ");
		N = Integer.parseInt(line[0]);
		K = Integer.parseInt(line[1]);

		nums = new double[N];
		line = scanner.nextLine().split(" ");
		for (int i = 0; i < N; i++) {
			nums[i] = Double.parseDouble(line[i]);
		}

		double min = Double.MAX_VALUE;
		for (; K <= N; K++) {
			for (int i = 0; i <= N - K; i++) {
				double m = getAvg(i);
				double standardDeviation = getStandardDeviation(i, m);

				min = Math.min(min, standardDeviation);
			}
		}

		System.out.println(min);
	}

	private static double getAvg(int start) {
		double sum = 0d;
		for (int i = 0; i < K; i++) {
			sum += nums[start + i];
		}

		return sum / K;
	}

	private static double getStandardDeviation(int start, double m) {
		double sum = 0d;
		for (int i = 0; i < K; i++) {
			sum += Math.pow((nums[start + i] - m), 2);
		}

		return Math.sqrt(sum / K);
	}
}
