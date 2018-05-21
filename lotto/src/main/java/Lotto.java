public class Lotto {
	private int K;
	private int[] S;
	private int[] print = new int[6];

	public void printLotto(int startIndex, int count) {
		if (count > 5) {
			print();
			return;
		}

		for (int i = startIndex; i < K + count - 5; i++) {
			print[count] = S[i];
			printLotto(i + 1,count + 1);
		}
	}

	private void print() {
		for (int i : print) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public void setS(int[] s) {
		S = s;
	}

	public void setK(int k) {
		K = k;
	}
}
