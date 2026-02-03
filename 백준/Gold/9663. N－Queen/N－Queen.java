import java.io.*;

public class Main {
    public static int N = 0;
    public static boolean[] usedCol;
    public static boolean[] usedDownRightDiag;
    public static boolean[] usedDownLeftDiag;

    // 백트래킹 사용 N퀸
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        usedCol = new boolean[N];
        usedDownRightDiag =  new boolean[2 * N - 1];
        usedDownLeftDiag = new boolean[2 * N - 1];

        int count = search(0);
        System.out.println(count);
    }

    public static int search(int row) {
        if (row == N) return 1;
        int sum = 0;

        for (int col = 0; col < N; col++) {
            int downRightIdx = row - col + (N - 1);

            int downLeftIdx = row + col;

            if (usedCol[col] || usedDownRightDiag[downRightIdx] || usedDownLeftDiag[downLeftIdx]) {
                continue;
            }

            usedCol[col] = true;
            usedDownRightDiag[downRightIdx] = true;
            usedDownLeftDiag[downLeftIdx] = true;

            sum += search(row + 1);

            usedCol[col] = false;
            usedDownRightDiag[downRightIdx] = false;
            usedDownLeftDiag[downLeftIdx] = false;
        }

        return sum;
    }
}
