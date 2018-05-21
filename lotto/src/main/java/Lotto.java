public class Lotto {

    private int K;
    private int[] S;

    public void printLotto(int index) {
        if (index == 6) {
            System.out.println();
            return;
        }

        for (int i = index; i < S.length + index - 6; i++) {
            System.out.print(S[i]);
            printLotto(index + 1);
        }
    }

    public void setS(int[] s) {
        S = s;
    }

    public void setK(int k) {
        K = k;
    }
}
