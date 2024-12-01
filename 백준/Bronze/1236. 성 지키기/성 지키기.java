import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        boolean[] rowGuard = new boolean[N];
        boolean[] colGuard = new boolean[M];

        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < M; j++) {
                if (input.charAt(j) == 'X') {
                    rowGuard[i] = true;
                    colGuard[j] = true;
                }
            }
        }

        int rowCount = 0, colCount = 0;
        for (int i = 0; i < N; i++) {
            if (!rowGuard[i]) rowCount++;
        }
        for (int j = 0; j < M; j++) {
            if (!colGuard[j]) colCount++;
        }

        System.out.println(Math.max(rowCount, colCount));
    }
}
