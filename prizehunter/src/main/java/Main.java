import java.util.Scanner;

/**
 * @author JeongHun, Lee
 */
public class Main {
	private static int[] prize1 = {500, 300, 200, 50, 30, 10};
	private static int[] people1 = {1, 2, 3, 4, 5, 6};
	private static int[] prize2 = {512, 256, 128, 64, 32};
	private static int[] people2 = {1, 2, 4, 8, 16};

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = Integer.parseInt(scanner.nextLine());

		for (int i = 0; i < T; i++) {
			String[] line = scanner.nextLine().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);

			int prize = 0;
			if (a != 0) {
				prize += getPrize(prize1, people1, a);
			}

			if (b != 0) {
				prize += getPrize(prize2, people2, b);
			}

			System.out.println(prize * 10000);
		}
	}

	private static int getPrize(int[] prizeArray, int[] peopleArray, int rank){
		int num = 0;
		for (int j = 0; j < prizeArray.length; j++) {
			num += peopleArray[j];
			if (rank <= num) {
				return prizeArray[j];
			}
		}

		return 0;
	}
}
